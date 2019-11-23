package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

@TeleOp(name = "TestColorSensor", group = "a")
@Disabled
public class TestColorSensor extends LinearOpMode {

    private ColorSensor colorSensor = null;
    private DistanceSensor distanceSensor = null;

    @Override
    public void runOpMode() {
        colorSensor = hardwareMap.get(ColorSensor.class, "color-range");
        distanceSensor = hardwareMap.get(DistanceSensor.class, "color-range");

        telemetry.addData("initialized", "true");
        telemetry.update();

        waitForStart();
        while(opModeIsActive()){
            String vals = "";

            vals+=colorSensor.red()+",";
            vals+=colorSensor.green()+",";
            vals+=colorSensor.blue();
            telemetry.addData("RGB", vals);

            if(colorSensor.green() <= colorSensor.red()*0.6 && colorSensor.blue() <= colorSensor.red()*0.6){
                telemetry.addData("COLOR IS", "red");
            }
            else if(colorSensor.red() <= colorSensor.blue()*0.5 && colorSensor.green() <= colorSensor.blue()*0.8){
                telemetry.addData("COLOR IS", "blue");
            }
            else{
                telemetry.addData("COLOR IS", "gray");
            }
            telemetry.update();
        }

    }
}
