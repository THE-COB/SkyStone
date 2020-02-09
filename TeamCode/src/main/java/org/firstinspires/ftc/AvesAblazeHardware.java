package org.firstinspires.ftc;

import com.qualcomm.hardware.bosch.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import java.util.ArrayList;
import java.util.List;

public class AvesAblazeHardware {
    
    public BNO055IMU imu1;
    public BNO055IMU imu;
    
    public DcMotor motor0;
    public DcMotor motor1;
    public DcMotor motor2;
    public DcMotor motor3;

    public Servo foundation;

    public ColorSensor floorColor;
    public DistanceSensor floorRange;

    public DcMotor leftIntake;
    public DcMotor rightIntake;
    
    int startingAngle = 0;
    Orientation angles;
    

    /**public static final float mmPerInch = 25.4f;
    public static final float mmFTCFieldWidth = (12*6) * mmPerInch; // the width of the FTC field (from the center point to the outer panels)
    public static final float mmTargetHeight = (6) * mmPerInch;
    double correction;
    // the height of the center of the target image above the floor
    VuforiaTrackables targetsRoverRuckus;
    List<VuforiaTrackable> allTrackables;
    VuforiaTrackable currentTrackable;
    // Select which camera you want use. The FRONT camera is the one on the same side as the screen.
    // Valid choices are: BACK or FRONT
    public static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;
    
    public OpenGLMatrix lastLocation = null;
    public boolean targetVisible = false;
    
    public Orientation rotation;
    public VectorF translation;
    Orientation angles;
    */

    HardwareMap hardwareMap;
    public void init(HardwareMap ahwMap){
        hardwareMap = ahwMap;
        
        imu1 = hardwareMap.get(BNO055IMU.class, "imu 1");
        imu = hardwareMap.get(BNO055IMU.class, "imu");

        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        
        motor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        
        motor0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        
        motor0.setDirection(DcMotor.Direction.FORWARD);
        motor2.setDirection(DcMotor.Direction.FORWARD);

        motor1.setDirection(DcMotor.Direction.REVERSE);
        motor3.setDirection(DcMotor.Direction.REVERSE);

        motor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        foundation = hardwareMap.get(Servo.class, "foundation");

        floorColor = hardwareMap.get(ColorSensor.class, "floorColor");
        floorRange = hardwareMap.get(DistanceSensor.class, "floorColor");


        leftIntake = hardwareMap.get(DcMotor.class, "leftIntake");
        rightIntake = hardwareMap.get(DcMotor.class, "rightIntake");
        
        leftIntake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightIntake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        rightIntake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftIntake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        
    }
}