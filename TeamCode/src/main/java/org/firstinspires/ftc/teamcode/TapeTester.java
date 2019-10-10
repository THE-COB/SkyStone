package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "TapeTester", group = "a")
public class TapeTester extends AvesAblazeOpMode {

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        waitForStart();
        while(opModeIsActive()){
            if(!isRed() && !isBlue()){
                upDown(0.25);
                telemetry.addData("Color", "gray");
                telemetry.addData("motor0", getMotorPosition(0));
                telemetry.addData("motor1", getMotorPosition(1));
                telemetry.addData("motor2", getMotorPosition(2));
                telemetry.addData("motor3", getMotorPosition(3));

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
