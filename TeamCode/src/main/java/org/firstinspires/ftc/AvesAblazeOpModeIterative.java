package org.firstinspires.ftc;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;

public abstract class AvesAblazeOpModeIterative extends OpMode implements AvesAblazeInterface {
    AvesAblazeHardware robot = new AvesAblazeHardware();
    public int ticsToYAxis = 250;
    public int ticsToTape = 500;
    public void upDown(double power){
        robot.motor0.setPower(power);
        robot.motor1.setPower(power);
        robot.motor2.setPower(power);
        robot.motor3.setPower(power);
    }
    public static final String VUFORIA_KEY = "ASre9vb/////AAABmS9qcsdgiEiVmAClC8R25wUqiedmCZI33tlr4q8OswrB3Kg7FKhhuQsUv3Ams+kaXnsjj4VxJlgsopgZOhophhcKyw6VmXIFChkIzZmaqF/PcsDLExsXycCjm/Z/LWQEdcmuNKbSEgc1sTAwKyLvWn6TK+ne1fzboxjtTmkVqu/lBopmR3qI+dtd3mjYIBiLks9WW6tW9zS4aau7fJCNYaU1NPgXfvq1CRjhWxbX+KWSTUtYuFSFUBw2zI5PzIPHaxKrIwDKewo1bOZBUwbqzmm5h0d4skXo3OC0r+1AYrMG0HJrGRpkN9U6umTlYd5oWCqvgBSVxKkOGM1PhNY5cX+sqHpbILgP+QVOFblKSV9i";
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
    
    public void rotateAuto(double power){
        robot.motor0.setPower(-power);
        robot.motor1.setPower(power);
        robot.motor2.setPower(-power);
        robot.motor3.setPower(power);
    }

    public void polarDrive(double power, double theta, double rotation) {
        robot.motor0.setPower(power*Math.sin(theta+(Math.PI/4)));
        robot.motor1.setPower(power*Math.cos(theta+(Math.PI/4)));
        robot.motor2.setPower(power*Math.cos(theta+(Math.PI/4)));
        robot.motor3.setPower(power*Math.sin(theta+(Math.PI/4)));
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
        double value = 0.4;
        if(on){
            robot.leftIntake.setPower(-value);
            robot.rightIntake.setPower(value);
        }
        else{
            robot.leftIntake.setPower(0.5);
            robot.rightIntake.setPower(-0.5);
        }
    }
    
    public void specialIntake(boolean on){
        double value = 0.4;
        if(on){
            robot.leftIntake.setPower(-0.3);
            robot.rightIntake.setPower(0.2);
        }
        else{
            robot.leftIntake.setPower(0.5);
            robot.rightIntake.setPower(-0.5);
        }
    }

    public void stopIntake(){
        robot.leftIntake.setPower(0);
        robot.rightIntake.setPower(0);
    }
    
   
    public void driveByTics (int numTics, boolean isForward, double power){
        int origPos = getMotorPosition(0);
        if(isForward){
            if(power<0){
                while(getMotorPosition(0) >= origPos-numTics){
                    upDown(power);
                    telemetry.addData("Condition", Math.abs(getMotorPosition(0)-(origPos+numTics)));
                    telemetry.update();
                }
                
                while (Math.abs(getMotorPosition(0)-(origPos-numTics)) >= 15){
                    upDown(.05);
                    telemetry.addData("TrynaFix", true);
                    telemetry.update();
                }
            
                stopMotors();
            }
            else{
                while(getMotorPosition(0) <= origPos+numTics){
                    upDown(power);
                    telemetry.addData("Condition", Math.abs(getMotorPosition(0)-(origPos+numTics)));
                    telemetry.addData("pos",getMotorPosition(0));
                    telemetry.addData("fin",origPos+numTics);
                    telemetry.addData("test",Math.abs(getMotorPosition(0)-(origPos+numTics)));
                    telemetry.update();
                    
                }
                
                while (Math.abs(getMotorPosition(0)-(origPos+numTics)) >= 15){
                    telemetry.addData("TrynaFix", true);
                    telemetry.update();
                    upDown(-.05);
                }    
                
                
                stopMotors();
            }
            
        }
        else{
            if (power < 0){
                while (getMotorPosition(0) <= origPos + numTics){
                    leftRight(power);
                    telemetry.addData("Condition", Math.abs(getMotorPosition(0)-(origPos+numTics)));
                    telemetry.addData("Position", getMotorPosition(0));
                    telemetry.update();
                }
                
                while(Math.abs(getMotorPosition(0)-(origPos+numTics)) >= 15){
                    leftRight(0.09);
                    telemetry.addData("TrynaFix", true);
                    telemetry.update();
                }
                
                stopMotors();
            }
            else {
                while (getMotorPosition(0) >= origPos - numTics){
                    leftRight(power);
                    telemetry.addData("Condition", Math.abs(getMotorPosition(0)-(origPos+numTics)));
                    telemetry.addData("Position", getMotorPosition(0));
                    telemetry.update();
                }
                
                while(Math.abs(getMotorPosition(0)-(origPos-numTics)) >= 15){
                    telemetry.addData("TrynaFix", true);
                    telemetry.update();
                    leftRight(-0.09);
                }
                
                stopMotors();
            }
        }
        
        stopMotors();
    }
    
    public void calibrate() {
        BNO055IMU.Parameters imuParameters;
        imuParameters = new BNO055IMU.Parameters();
        imuParameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        imuParameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        imuParameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        imuParameters.loggingEnabled = true;
        imuParameters.loggingTag = "IMU";
        imuParameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        robot.imu1.initialize(imuParameters);
        robot.imu.initialize(imuParameters);
        
    }
    public int getAngle(){
        if(robot.imu1.isGyroCalibrated()){
            robot.angles=robot.imu1.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            double currentAngle=robot.angles.firstAngle;
            int finalAngle= robot.startingAngle+(int)Math.round(currentAngle);
            if(finalAngle<0){
                return 360+finalAngle;
            }
            return finalAngle;
        
        }
        else{
            return 10000;
        }
       /** else if(resetCoordinates()){
            double oldAngle = robot.rotation.thirdAngle;
            double posAngle = oldAngle;
            int finalAngle;
            if (oldAngle < 0) posAngle = 360 - Math.abs(oldAngle);
                if((int) (Math.round(posAngle)) - 45 < 0){
                    finalAngle = 360-(int)Math.round(posAngle);
                }
            else{
                finalAngle = (int) (Math.round(posAngle)) - 45;
            }
            return finalAngle;
        }
        else{
            return 10000;
        }
        */
    }
    
    private int getQuadrant(int startingAngle){
        int quadrant = 1;
        if(startingAngle>90 && startingAngle<180){
            quadrant = 2;
        }
        else if(startingAngle>180 && startingAngle<270){
            quadrant = 3;
        }
        else if(startingAngle > 270){
            quadrant = 4;
        }
        return quadrant;
    }
    
/*    public void rotateToAngle(int finalAngle){``
        telemetry.addData("final angle", finalAngle);
        telemetry.update();
        int startingAngle = getAngle();
        int initQuad = getQuadrant(startingAngle);
        int finalQuad = getQuadrant(finalAngle);
        if ((Math.abs(finalQuad-initQuad) == 1) || (Math.abs(finalQuad-initQuad) == 3)){ //If statement for if not diagonal
            if ((finalQuad > initQuad) && (Math.abs(finalQuad-initQuad) != 3)) { // Determine which direction to move
                while (getAngle() < finalAngle) {
                    rotate(.15); // To move counterclockwise
                    telemetry.addData("Current Angle", getAngle());
                    telemetry.addData("final Angle", finalAngle);
                    telemetry.addData("Rotate Clockwise", (finalQuad - initQuad));
                    telemetry.update();
                }
            }
            else if ((finalQuad < initQuad) && (Math.abs(finalQuad-initQuad) != 3)) {
                while (getAngle() < finalAngle) {
                    rotate(-.15); // To move clockwise
                    telemetry.addData("Current Angle", getAngle());
                    telemetry.addData("final Angle", finalAngle);
                    telemetry.addData("Rotate Counter Clockwise", (finalQuad - initQuad));
                    telemetry.update();
                }
            }
            else if ((finalQuad-initQuad) == 3) {
                while ((getAngle() > 0) || (getAngle() > finalAngle)){
                    rotate(-.15);//from quad 1 to 4 use a while or
                    telemetry.addData("Current Angle", getAngle());
                    telemetry.addData("final Angle", finalAngle);
                    telemetry.addData("Rotate Clockwise", (finalQuad - initQuad));
                    telemetry.update();
                }
            }
            else if ((finalQuad-initQuad) == -3) {
                while((getAngle() < 360) || (getAngle() < finalAngle)){
                    rotate(.15);//from quad 4 to 1
                    telemetry.addData("Current Angle", getAngle());
                    telemetry.addData("final Angle", finalAngle);
                    telemetry.addData("Rotate Counter Clockwise", (finalQuad - initQuad));
                    telemetry.update();
                }
            }
        }
        if (Math.abs(finalQuad-initQuad) == 2) { // 2 away always is diagonal so this is move diagonal
            if (finalQuad == 1){ //Need check distance from quadrant to see which direction
                if ((90 - finalAngle) > 45){
                    while (getAngle() > finalAngle){
                        rotate(-.15);
                        telemetry.addData("Current Angle", getAngle());
                        telemetry.addData("final Angle", finalAngle);
                        telemetry.addData("Rotate Clockwise", finalQuad);
                        telemetry.update();
                    }
                }
                else{
                    while ((getAngle() < 360) || getAngle() < finalAngle){
                        rotate(.15);
                        telemetry.addData("Current Angle", getAngle());
                        telemetry.addData("final Angle", finalAngle);
                        telemetry.addData("Rotate CounterClockwise", finalQuad);
                        telemetry.update();
                    }
                }
            }
            if (finalQuad == 2){
                if ((180 - finalAngle) > 45){
                    while (getAngle() > finalAngle){
                        rotate(-.15);
                        telemetry.addData("Current Angle", getAngle());
                        telemetry.addData("final Angle", finalAngle);
                        telemetry.addData("Rotate Clockwise", finalQuad);
                        telemetry.update();
                    }
                }
                else{
                    while ((getAngle() < 360) || getAngle() < finalAngle){
                        rotate(.15);
                        telemetry.addData("Current Angle", getAngle());
                        telemetry.addData("final Angle", finalAngle);
                        telemetry.addData("Rotate Counter Clockwise", finalQuad);
                        telemetry.update();
                    }
                }
            }
            if (finalQuad == 3){
                if ((270 - finalAngle) > 45){
                    while ((getAngle() > 0) || (getAngle() > finalAngle)){
                        rotate(-.15);
                        telemetry.addData("Current Angle", getAngle());
                        telemetry.addData("final Angle", finalAngle);
                        telemetry.addData("Rotate Clockwise", finalQuad);
                        telemetry.update();
                    }
                }
                else{
                    while (getAngle() < finalAngle){
                        rotate(.15);
                        telemetry.addData("Current Angle", getAngle());
                        telemetry.addData("final Angle", finalAngle);
                        telemetry.addData("Rotate Counter Clockwise", finalQuad);
                        telemetry.update();
                    }
                }
            }
            if (finalQuad == 4){
                if ((360 - finalAngle) > 45){
                    while ((getAngle() > 0) || (getAngle() > finalAngle)){
                        rotate(-.15);
                        telemetry.addData("Current Angle", getAngle());
                        telemetry.addData("final Angle", finalAngle);
                        telemetry.addData("Rotate Clockwise", finalQuad);
                        telemetry.update();
                    }
                }
                else{
                    while (getAngle() < finalAngle){
                        rotate(.15);
                        telemetry.addData("Current Angle", getAngle());
                        telemetry.addData("final Angle", finalAngle);
                        telemetry.addData("Rotate Counter Clockwise", finalQuad);
                        telemetry.update();
                    }
                }
            }
        }


    }
*/

    /*public void rotateToAngle(int finalAngle){
        int initAngle = getAngle();
        int oppositeAngle = 180+initAngle;
        if(oppositeAngle > 359){
            oppositeAngle = initAngle-180;
        }
        boolean isClockwise = false;
        if(oppositeAngle > initAngle){
            if(finalAngle > oppositeAngle || finalAngle < initAngle){
                isClockwise = true;
            }
        }
        else{
            if (finalAngle > oppositeAngle && finalAngle < initAngle){
                isClockwise = true;
            }
        }
        if(!isClockwise){
            if(oppositeAngle < initAngle){
                while ((getAngle() < 359) || (getAngle() < finalAngle)){
                    rotate(.15);
                    telemetry.addData("Current Angle", getAngle());
                    telemetry.addData("Final Angle", finalAngle);
                    telemetry.update();
                }
                telemetry.addData("stopping", true);
                stopMotors();
                return;
            }
            else{
                while (getAngle() < finalAngle){
                    rotate(.15);
                    telemetry.addData("Current Angle", getAngle());
                    telemetry.addData("Final Angle", finalAngle);
                    telemetry.update();
                }
                telemetry.addData("stopping", true);
                stopMotors();
                return;
            }
        }
        else{
            if (oppositeAngle < initAngle){
                while (getAngle() > finalAngle){
                    rotate(-.15);
                    telemetry.addData("Current Angle", getAngle());
                    telemetry.addData("Final Angle", finalAngle);
                    telemetry.update();
                }
                telemetry.addData("stopping", true);
                stopMotors();
                return;
            }
            else{
                while ((getAngle() > 0) || (getAngle() > finalAngle)){
                    rotate(-.15);
                    telemetry.addData("Current Angle", getAngle());
                    telemetry.addData("Final Angle", finalAngle);
                    telemetry.update();
                }
                telemetry.addData("stopping", true);
                stopMotors();
                return;
            }
        }
        
        
    }
    */
    public void rotateToAngle(int finalAngle, boolean isClockwise){
        if(isClockwise){
            if(finalAngle < getAngle()){
                int diff = getAngle()- finalAngle;
                while(getAngle() >= (finalAngle)){
                    telemetry.addData("angle 1", getAngle());
                    telemetry.update();
                    rotate(.1);
                    if (getAngle() - finalAngle > diff){
                        break;
                    }
                }
                
                /*while (getAngle() > finalAngle){
                    rotate(.05);
                }
                */
                stopMotors();
            }
            else{
                while(getAngle() >= (finalAngle) || getAngle() < 180){
                    telemetry.addData("angle 2", getAngle());
                    telemetry.update();
                    rotate(0.1);
                }
                /*while(getAngle() > finalAngle){
                    rotate(0.05);
                }
                */
                stopMotors();
            }
            
            while(Math.abs(getAngle()-finalAngle) > 5){
                rotate(-0.05);
            }
            stopMotors();
        } else{
            if(finalAngle > getAngle()){
                int diff2 = finalAngle- getAngle();
                while(getAngle() <= (finalAngle)){
                    telemetry.addData("angle 3", getAngle());
                    telemetry.update();
                    rotate(-0.1);
                    if(finalAngle - getAngle() > diff2){
                        break;
                    }
                }
                /*while(finalAngle > getAngle()){
                    rotate(-.05);
                } 
                */
                stopMotors();
            }
            else{
                while(getAngle() <= (finalAngle) || getAngle() >= 180){
                    telemetry.addData("angle 4", getAngle());
                    telemetry.update();
                    rotate(-0.1);
                }
                /*while(getAngle() < finalAngle){
                    rotate(-0.05);
                }
                */
                stopMotors();
            }
            while(Math.abs(getAngle()-finalAngle) > 5){
                rotate(0.05);
            }
            stopMotors();
        }
    }
}
