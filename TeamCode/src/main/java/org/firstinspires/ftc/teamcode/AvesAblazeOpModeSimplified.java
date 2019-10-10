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
     * Rotates the robot in place
     * @param power is a value from -1 to 1, positive is clockwise, negative is couter-clockwise
     */
    void rotate(double power);

    /**
     * Returns the encoder position of a motor by number
     * @param num the motor number on the drivetrain [0,3]
     * @return encoder position
     */
    int getMotorPosition(int num);

    /**
     * Stops motors lol
     */
    void stopMotors();

    /**
     * Detects if the color sensor is over the red tape
     */
    boolean isRed();

    /**
     * Detects if the color sensor is over the blue tape
     */
    boolean isBlue();

}
