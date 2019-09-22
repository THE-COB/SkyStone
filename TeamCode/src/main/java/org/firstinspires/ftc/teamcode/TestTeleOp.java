package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "test", group = "a" )
public class TestTeleOp extends LinearOpMode {

    private DcMotor motor0 = null;
    private Servo servo0 = null;

    @Override
    public void runOpMode() {
        telemetry.addData("test", "we started maybe");
        telemetry.update();

        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        servo0 = hardwareMap.get(Servo.class, "servo0");

        motor0.setDirection(DcMotor.Direction.FORWARD);
        servo0.setPosition(0);

        waitForStart();
        while (opModeIsActive()) {
            motor0.setPower(gamepad1.left_stick_y);

            if(gamepad1.a){
                servo0.setPosition(0.5);
            }
            if(gamepad1.b){
                servo0.setPosition(1);
            }
            if(gamepad1.x){
                servo0.setPosition(0);
            }
            telemetry.addData("encoderVal", motor0.getCurrentPosition());
            telemetry.addData("servoVal", servo0.getPosition());
            telemetry.update();
        }
    }
}
