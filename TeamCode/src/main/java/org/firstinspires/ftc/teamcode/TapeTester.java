package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "TapeTester", group = "a")
public class TapeTester extends AvesAblazeOpMode {

    @Override
    public void runOpMode() {

        waitForStart();
        while(opModeIsActive()){
            if(!isRed() && !isBlue()){
                upDown(0.5);
                telemetry.addData("Color", "gray");
            }
            else if(isRed()){
                telemetry.addData("Color", "red");
            }
            else if(isBlue()){
                telemetry.addData("Color", "blue");
            }
            telemetry.update();
        }
    }
}
