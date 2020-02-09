package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous

public class LessSimpleRight extends AvesAblazeOpMode{
    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        
        waitForStart();
        while(opModeIsActive()){
            upDown(0.25);
            sleep(500);
            leftRight(0.25);
            sleep(500);
            stopMotors();
            break;
        }
    }
}

