package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp(name="cont", group="a")

public class Cont extends AvesAblazeOpMode {
    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        calibrate();
        waitForStart();
        while(opModeIsActive()){
            double moveY = Range.clip(-gamepad1.left_stick_y, -1,1);
            double moveX = Range.clip(-gamepad1.left_stick_x, -1,1);
            double moveYL = Range.clip(-gamepad2.left_stick_y, -1,1);
            double moveYR = Range.clip(-gamepad2.right_stick_y, -1,1);
            
            telemetry.addData("motor0 position", robot.motor0.getCurrentPosition());
            telemetry.addData("motor1 position", robot.motor1.getCurrentPosition());
            telemetry.addData("motor2 position", robot.motor2.getCurrentPosition());
            telemetry.addData("motor3 position", robot.motor3.getCurrentPosition());
            telemetry.addData("angle", getAngle());
            telemetry.update();
            
            if(gamepad1.a){
                setIntake(true);
            }
            else if(gamepad1.b){
                setIntake(false);
            }
            else if(gamepad1.x){
                specialIntake(true);
            }
            else if(gamepad1.y){
                specialIntake(false);
            }
            else if(Math.abs(moveYL) > 0.1 || Math.abs(moveYR) > 0.1){
                robot.leftIntake.setPower(moveYL); //TESY
                robot.rightIntake.setPower(-moveYR);
            }
            else{
                stopIntake();
            }
            
            if(Math.abs(moveY) > 0.1){
                upDown(moveY*0.9);
            }
            else if(Math.abs(moveX) > 0.1){
                leftRight(moveX*.9);
            }
            else if(Math.abs(gamepad1.right_stick_x) > 0){
                rotate(gamepad1.right_stick_x*0.8);
            }
            else{
                stopMotors();
            }
            
            if(gamepad1.right_bumper || gamepad2.right_bumper){
                foundationClamp(false);
            }
            if(gamepad1.left_bumper || gamepad2.left_bumper){
                foundationClamp(true);
            }
            
            if(gamepad1.dpad_up){
                upDown(0.05); // TESTING VAL
            }
            if(gamepad1.dpad_down){
                upDown(-0.05); //TESTING VAL
            }
            if(gamepad1.dpad_left){
                leftRight(-0.2);
            }
            if (gamepad1.dpad_right){
                leftRight(0.2);
            }
            
        }
    }
    
    // todo: write your code here
}
