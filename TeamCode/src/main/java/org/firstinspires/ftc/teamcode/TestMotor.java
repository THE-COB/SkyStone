package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name="test motor", group = "a")
@Disabled
public class TestMotor extends LinearOpMode {

    private DcMotor motor0 = null;

    @Override
    public void runOpMode() {
        telemetry.addData("test", "we started maybe");
        telemetry.update();

        motor0 = hardwareMap.get(DcMotor.class, "motor0");

        motor0.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        while(opModeIsActive()){
            motor0.setPower(1);

            telemetry.addData("encoderVal", motor0.getCurrentPosition());
            telemetry.update();
        }
    }
}
