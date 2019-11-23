package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name = "test", group = "a" )
@Disabled
public class TestTeleOp extends LinearOpMode {

    private DcMotor motor0 = null;
    private Servo servo0 = null;

    private ColorSensor color = null;
    private DistanceSensor distance = null;

    @Override
    public void runOpMode() {
        telemetry.addData("test", "we started maybe");
        telemetry.update();
/*
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        servo0 = hardwareMap.get(Servo.class, "servo0");*/

        color = hardwareMap.get(ColorSensor.class, "color-range");
        distance = hardwareMap.get(DistanceSensor.class, "color-range");


/*        motor0.setDirection(DcMotor.Direction.FORWARD);
        servo0.setPosition(0);*/

        waitForStart();
        while (opModeIsActive()) {
            telemetry.addData("Red",color.red());
            telemetry.addData("Green",color.green());
            telemetry.addData("Blue", color.blue());
            telemetry.addData("Alpha", color.alpha());

            telemetry.addData("Distance(cm)", distance.getDistance(DistanceUnit.CM));

/*            motor0.setPower(gamepad1.left_stick_y);

            if(gamepad1.a){
                servo0.setPosition(0.5);
            }
            if(gamepad1.b){
                servo0.setPosition(1);
            }
            if(gamepad1.x){
                servo0.setPosition(0);
            }
            telemetry.addData("encoderVal", motor0.getCurrentPosition());
            telemetry.addData("servoVal", servo0.getPosition());*/
            telemetry.update();
        }
    }
}
