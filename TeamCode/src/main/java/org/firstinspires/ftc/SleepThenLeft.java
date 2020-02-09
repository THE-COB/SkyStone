package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous(name="SleepThenLeft", group ="Concept")
public class SleepThenLeft extends AvesAblazeOpMode {

    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        
        waitForStart();
        while(opModeIsActive()){
            sleep(5000);
            int origTiks = 0;
            while (getMotorPosition(0) < ticsToTape + origTiks){
                leftRight(-0.25);
            }
            stopMotors();
        }
    }
}