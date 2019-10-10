package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "TeloOp0", group = "a")
public class TeleOp0 extends AvesAblazeOpMode {

    @Override
    public void runOpMode() {
        robot.init(hardwareMap);

        waitForStart();
        while(opModeIsActive()){
            double moveY = Range.clip(-gamepad1.left_stick_y, -1, 1);
            double moveX = Range.clip(-gamepad1.left_stick_x, -1, 1);

            if(gamepad1.dpad_up){
                upDown(0.5);
            }
            else if(gamepad1.dpad_down){
                upDown(-0.5);
            }
            else if(gamepad1.dpad_left){
                leftRight(-0.5);
            }
            else if(gamepad1.dpad_right){
                leftRight(0.5);
            }
            else if(Math.abs(moveY) > 0.25){
                upDown(moveY);
            }
            else if(Math.abs(moveX) > 0.25){
                leftRight(moveX);
            }
            else{
                stopMotors();
            }
        }

    }
}
