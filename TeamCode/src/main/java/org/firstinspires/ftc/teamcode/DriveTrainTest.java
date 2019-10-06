package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Test Motors", group = "a")
public class DriveTrainTest extends LinearOpMode {

    private DcMotor motor0 = null;
    private DcMotor motor1 = null;
    private DcMotor motor2 = null;
    private DcMotor motor3 = null;

    @Override
    public void runOpMode() {



        waitForStart();
        while (opModeIsActive()){
            if(gamepad1.dpad_up){
                motor0.setPower(0.5);
                motor1.setPower(0.5);
                motor2.setPower(0.5);
                motor3.setPower(0.5);
            }
            else if(gamepad1.dpad_down){
                motor0.setPower(-0.5);
                motor1.setPower(-0.5);
                motor2.setPower(-0.5);
                motor3.setPower(-0.5);
            }
            else if(gamepad1.dpad_left){
                motor0.setPower(0.5);
                motor1.setPower(0.5);
                motor2.setPower(-0.5);
                motor3.setPower(-0.5);
            }
            else if(gamepad1.dpad_right){
                motor0.setPower(-0.5);
                motor1.setPower(-0.5);
                motor2.setPower(0.5);
                motor3.setPower(0.5);
            }
            else{
                motor0.setPower(0);
                motor1.setPower(0);
                motor2.setPower(0);
                motor3.setPower(0);
            }

        }
    }
}
