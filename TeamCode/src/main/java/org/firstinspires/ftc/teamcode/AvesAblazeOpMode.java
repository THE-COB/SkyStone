package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class AvesAblazeOpMode extends LinearOpMode implements AvesAblazeOpModeSimplified {
    AvesAblazeHardware robot = new AvesAblazeHardware();

    public void upDown(double power){
        robot.motor0.setPower(power);
        robot.motor1.setPower(power);
        robot.motor2.setPower(power);
        robot.motor3.setPower(power);
    }

    public void leftRight(double power){
        robot.motor0.setPower(-power);
        robot.motor1.setPower(power);
        robot.motor2.setPower(power);
        robot.motor3.setPower(-power);
    }

    public void stopMotors() {
        robot.motor0.setPower(0);
        robot.motor1.setPower(0);
        robot.motor2.setPower(0);
        robot.motor3.setPower(0);
    }

    public void rotate(double power) {
        robot.motor0.setPower(power);
        robot.motor1.setPower(-power);
        robot.motor2.setPower(power);
        robot.motor3.setPower(-power);
    }

    public void polarDrive(double power, double theta, double rotation) {
        robot.motor0.setPower(power*Math.sin(theta+(Math.PI/4))+rotation);
        robot.motor1.setPower(power*Math.cos(theta+(Math.PI/4))-rotation);
        robot.motor2.setPower(power*Math.cos(theta+(Math.PI/4))+rotation);
        robot.motor3.setPower(power*Math.sin(theta+(Math.PI/4))-rotation);
    }

    public int getMotorPosition(int num){
        switch (num){
            case 0: return robot.motor0.getCurrentPosition();
            case 1: return robot.motor1.getCurrentPosition();
            case 2: return robot.motor2.getCurrentPosition();
            case 3: return robot.motor3.getCurrentPosition();
            default: return 0;
        }
    }

    public boolean isRed(){
     //   if (robot.floorColor.green() <= robot.floorColor.red() * 0.5 && robot.floorColor.blue() <= robot.floorColor.red() * 0.5) {
            return (robot.floorColor.red() >= 75);
    //    }
    //    else{
    //        return false;
    //    }
    }

    public boolean isBlue(){
    //    return (robot.floorColor.red() <= robot.floorColor.blue() * 0.5 && robot.floorColor.green() <= robot.floorColor.blue() * 0.7);
        return (robot.floorColor.blue() >= 50);
    }

    public void foundationClamp(boolean open){
        if(open){
            robot.foundation.setPosition(0.02);
        }
        if(!open){
            robot.foundation.setPosition(0.5);
        }
    }

    public void setIntake(boolean on){
        if(on){
            robot.leftIntake.setPower(-1);
            robot.rightIntake.setPower(1);
        }
        else{
            robot.leftIntake.setPower(1);
            robot.rightIntake.setPower(-1);
        }
    }

    public void stopIntake(){
        robot.leftIntake.setPower(0);
        robot.rightIntake.setPower(0);
    }


    public double getLiftPosition(){
        return robot.lift.getCurrentPosition();
    }

    public void openClaw(){
        robot.claw.setPosition(0.2);
    }

    public void closeClaw(){
        robot.claw.setPosition(0.8);
    }

    public void runLift(double power){
        robot.lift.setPower(power);
    }
}
