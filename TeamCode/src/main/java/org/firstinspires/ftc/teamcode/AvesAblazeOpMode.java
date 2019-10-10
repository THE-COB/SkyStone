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
        robot.motor0.setPower(power);
        robot.motor1.setPower(-power);
        robot.motor2.setPower(-power);
        robot.motor3.setPower(power);
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
        if(robot.floorColor.green() <= robot.floorColor.red()*0.6 && robot.floorColor.blue() <= robot.floorColor.red()*0.6){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isBlue(){
        if(robot.floorColor.red() <= robot.floorColor.blue()*0.5 && robot.floorColor.green() <= robot.floorColor.blue()*0.8){
            return true;
        }
        else{
            return false;
        }
    }

}
