package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="new color test", group = "a")
@Disabled
public class NewColorTest extends AvesAblazeOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("Red", robot.floorColor.red());
            telemetry.addData("Blue", robot.floorColor.blue());
            telemetry.addData("Green", robot.floorColor.green());
            telemetry.update();
        }
    }
}
