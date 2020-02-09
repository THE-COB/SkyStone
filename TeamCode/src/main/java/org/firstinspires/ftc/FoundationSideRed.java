package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous

public class FoundationSideRed extends AvesAblazeOpMode {

    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        telemetry.addData("calibrated", false);
        telemetry.update();
        calibrate();
        telemetry.addData("calibrated", true);
        telemetry.update();
        waitForStart();
        
        upDown(-0.1);
        sleep(100);
        leftRight(0.25);
        sleep(600);
        upDown(-0.35);
        sleep(500);
        stopMotors();
        foundationClamp(false);
        sleep(750);
        upDown(0.7);
        sleep(550);
        stopMotors();
        telemetry.addData("angle", getAngle());
        telemetry.update();
        rotate(0.5);
        sleep(1500);
        stopMotors();
        upDown(-0.5);
        sleep(500);
        stopMotors();
        foundationClamp(true);
        sleep(750);
        upDown(0.25);
        sleep(900);
        stopMotors();
        while (opModeIsActive()) {
            telemetry.addData("Angle", getAngle());
            telemetry.update();
        }
        /*if(getAngle()>180){
            rotateAuto(0.15);
            sleep(500);
        }
        stopMotors();
        while(getAngle()<80){
            rotateAuto(0.15);
        }
        stopMotors();
        upDown(-0.25);
        sleep(500);
        upDown(0.8);
        sleep(100);
        stopMotors();
        leftRight(-0.25);
        sleep(2000);
        stopMotors();
        */
        /*upDown(.5);
        sleep(750);
        stopMotors();
        */
        /*upDown(0.25);
        sleep(250);
        stopMotors();
        foundationClamp(false);
        */
        
    }
}
