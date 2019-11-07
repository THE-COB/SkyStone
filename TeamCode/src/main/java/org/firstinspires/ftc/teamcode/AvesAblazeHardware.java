package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class AvesAblazeHardware {
    public DcMotor motor0;
    public DcMotor motor1;
    public DcMotor motor2;
    public DcMotor motor3;

    public Servo foundation;
    public Servo claw;

    public ColorSensor floorColor;
    public DistanceSensor floorRange;

    public DcMotor leftIntake;
    public DcMotor rightIntake;

    BNO055IMU imu;

    HardwareMap hardwareMap;
    public void init(HardwareMap ahwMap){
        hardwareMap = ahwMap;

        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");

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

        imu = hardwareMap.get(BNO055IMU.class, "imu");

        claw = hardwareMap.get(Servo.class, "claw");

        leftIntake = hardwareMap.get(DcMotor.class, "leftIntake");
        rightIntake = hardwareMap.get(DcMotor.class, "rightIntake");
        leftIntake.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
