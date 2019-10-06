package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class AvesAblazeOpMode extends LinearOpMode implements AvesAblazeOpModeSimplified {

    public void upDown(double power){
        robot.motor0.setPower(power);
        robot.motor1.setPower(power);
        robot.motor2.setPower(power);
        robot.motor3.setPower(power);
    }

    public void leftRight(double power){
        robot.motor0.setPower(-power);
        robot.motor1.setPower(-power);
        robot.motor2.setPower(power);
        robot.motor3.setPower(power);
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
