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
     * All directional strafing
     * @param power double from 0-1 for how much power the motors should have
     * @param theta angle to drive at in radians from -pi,pi
     * @param rotation double from 0,1 for how much power you want to change direction robot faces
     */
    void polarDrive(double power, double theta, double rotation);

    /**
     * Returns the encoder position of a motor by number
     * @param num the motor number on the drivetrain [0,3]
     * @return encoder position
     */
    int getMotorPosition(int num);

    /**
     * Opens or closes the foundation servo for moving the foundation
     * @param open true if you want to clamp the foundation (out) and false if you want to unclamp (in)
     */
    void foundationClamp(boolean open);

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

    /**
     * method to turn on the intake wheels
     * @param on for turning on intake or off
     */
    void setIntake(boolean on);

    /**
     * method that stops the intake
     */
    void stopIntake();

    /**
     * Gets encoder position of lift motor
     * @return double of the encoder value of the lift motor
     */
    double getLiftPosition();

    /**
     * Opens claw
     */
    void openClaw();

    /**
     * Close claw
     */
    void closeClaw();

    /**
     * Moves lift based off power
     * @param power what do you think
     */
    void runLift(double power);

}
