package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Foundation Test", group = "a")
public class FoundationTest extends AvesAblazeOpMode {

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        robot.foundation.setPosition(0.7);

        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.a){
                robot.foundation.setPosition(0.9);
            }
            if(gamepad1.b){
                robot.foundation.setPosition(0.7);
            }
            if(gamepad1.dpad_up){
                upDown(0.25);
            }
            else if(gamepad1.dpad_down){
                upDown(-0.25);
            }
            else{
                stopMotors();
            }
        }
    }
}
