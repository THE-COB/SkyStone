package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous

public class SimpleLeft extends AvesAblazeOpMode {

    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        
        waitForStart();
        leftRight(-0.25);
        sleep(750);
        stopMotors();
    }
}