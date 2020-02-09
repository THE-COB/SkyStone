package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="SleepThenRight", group ="Concept")

public class SleepThenRight extends AvesAblazeOpMode {

    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        
        waitForStart();
        while(opModeIsActive()){
            sleep(5000);
            int origTiks = getMotorPosition(0);
            while ((getMotorPosition(0) > -1*(ticsToTape)-origTiks+200) && opModeIsActive()){
                leftRight(0.25);
                telemetry.addData("WhereAt", getMotorPosition(0));
                telemetry.addData("Compare",  -1*(ticsToTape)-origTiks+200);
            }
            stopMotors();
        }
    }
}
