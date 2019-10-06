package org.firstinspires.ftc.teamcode;

public interface AvesAblazeOpModeSimplified {


    AvesAblazeHardware robot = new AvesAblazeHardware();

    /**
     * Drives the robot forward or backwards
     * @param power is a value from -1 to 1 (sign indicating direction) for how fast the robot should drive
     */
    void upDown(double power);

    /**
     * Drives the robot left or right
     * @param power is a value from -1 to 1 (sign indicating direction) for how fast
     * negative is left, positive is right
     */
    void leftRight(double power);

    /**
     * Detects if the color sensor is over the red tape
     */
    boolean isRed();

    /**
     * Detects if the color sensor is over the blue tape
     */
    boolean isBlue();

}
