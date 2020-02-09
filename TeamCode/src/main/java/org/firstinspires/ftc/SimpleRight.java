package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous

public class SimpleRight extends AvesAblazeOpMode {

    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        
        boolean still = true;
        waitForStart();
        leftRight(0.25);
        sleep(750);
        stopMotors();
    }
}
