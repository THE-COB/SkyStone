package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

@TeleOp(name = "IMUPositioning", group = "a")
public class IMUPositioning extends LinearOpMode {

    BNO055IMU imu;

    // State used for updating telemetry
    Orientation angles;
    Acceleration accel;
    Velocity vel;
    Position pos;

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        // Retrieve and initialize the IMU. We expect the IMU to be attached to an I2C port
        // on a Core Device Interface Module, configured to be a sensor of type "AdaFruit IMU",
        // and named "imu".
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        waitForStart();
        runtime.reset();
        imu.startAccelerationIntegration(new Position(), new Velocity(), 100);

        Acceleration oldAccel = imu.getAcceleration();
        Velocity oldVel = new Velocity();
        vel = new Velocity();
        pos = new Position();

        double t0 = runtime.seconds();
        while(opModeIsActive()){
            double newTime = runtime.seconds();
            accel = imu.getAcceleration();
            if(Math.abs(accel.xAccel)<0.05 || Math.abs(accel.yAccel)<0.05){
                accel.xAccel = 0;
                accel.yAccel = 0;

                vel.xVeloc = 0;
                vel.yVeloc = 0;
            }
            double dt = newTime-t0;
            double dvX = dt*(accel.xAccel+oldAccel.xAccel)*.5;
            double dvY = dt*(accel.yAccel+oldAccel.yAccel)*.5;

            vel.xVeloc+=dvX;
            vel.yVeloc+=dvY;

            double dxX = dt*(vel.xVeloc+oldVel.xVeloc)*.5;
            double dxY = dt*(vel.yVeloc+oldVel.yVeloc)*.5;

            pos.x+=dxX;
            pos.y+=dxY;

            oldVel = vel;
            oldAccel = accel;
            t0 = runtime.seconds();

            telemetry.addData("t0", t0);
            telemetry.addData("newtime", newTime);
            telemetry.addData("Accel", imu.getAcceleration());
            telemetry.addData("Veloc", vel);
            telemetry.addData("Pos", pos);
            telemetry.update();
        }
    }
}
