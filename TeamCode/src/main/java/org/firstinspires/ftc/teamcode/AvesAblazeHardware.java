package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class AvesAblazeHardware {
    public DcMotor motor0;
    public DcMotor motor1;
    public DcMotor motor2;
    public DcMotor motor3;

    public ColorSensor floorColor;
    public DistanceSensor floorRange;

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

        floorColor = hardwareMap.get(ColorSensor.class, "floorColor");
        floorRange = hardwareMap.get(DistanceSensor.class, "floorRange");
    }
}
