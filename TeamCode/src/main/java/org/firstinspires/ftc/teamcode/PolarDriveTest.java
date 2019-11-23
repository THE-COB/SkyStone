package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp (name = "PolarDriveTest", group = "a")
@Disabled
public class PolarDriveTest extends AvesAblazeOpMode {

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        waitForStart();
        ElapsedTime runtime = new ElapsedTime();
        runtime.reset();
        while (opModeIsActive()) {
            if (gamepad1.a){
                polarDrive(0.5,Math.PI/4,0);
            }
            else {
                stopMotors();
            }
            /*while(getMotorPosition(0) < y){
                upDown(0.5);
            }
            stopMotors();
            while(getMotorPosition(0) < z){
                leftRight(-0.5);
            }
            stopMotors();
            while(getMotorPosition(0) < n){
                upDown(-0.5);
            }
            stopMotors();
            while(getMotorPosition(0) < m){
                leftRight(0.5);
            }
            stopMotors();*/
        }
    }
}

