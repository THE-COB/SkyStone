package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp

public class MovementTester extends AvesAblazeOpMode {
    @Override
    public void runOpMode(){
        robot.init(hardwareMap);
        calibrate();
        
        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("angle", getAngle());
            telemetry.update();
            if(gamepad1.a){
                driveByTics(-50,false,-0.25);
                telemetry.addData("pos",getMotorPosition(0));
                telemetry.update();
            }
            if(gamepad1.b){
                driveByTics(-75,false,-0.25);
                telemetry.addData("pos",getMotorPosition(0));
                telemetry.update();
            }
            if(gamepad1.x){
                driveByTics(-100,false,-0.25);
                telemetry.addData("pos",getMotorPosition(0));
                telemetry.update();
            }
            if(gamepad1.y){
                driveByTics(-200,false,-0.25);
                telemetry.addData("pos",getMotorPosition(0));
                telemetry.update();
            }
            if(gamepad1.left_bumper){
                driveByTics(-400,false,-0.25);
                telemetry.addData("pos",getMotorPosition(0));
                telemetry.update();
            }
        }
    }
    // todo: write your code here
}