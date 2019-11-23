package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "PlatformAutonomous", group = "a")
@Disabled
public class PlatformAutonomous extends AvesAblazeOpMode {

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        double y = 0;
        double z = 0;
        double n = 0;
        double m = 0;
        waitForStart();
        ElapsedTime runtime = new ElapsedTime();
        runtime.reset();
        while (opModeIsActive()) {
            while(opModeIsActive() && runtime.seconds()<3){
                polarDrive(0.5,Math.PI/4, 0);
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
