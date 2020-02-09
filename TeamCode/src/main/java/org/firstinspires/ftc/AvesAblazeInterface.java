package org.firstinspires.ftc;


public interface AvesAblazeInterface {
    AvesAblazeHardware robot = new AvesAblazeHardware();
    /** 
     * Drives robot forwards and backwards, 
     * @param is value from -1 tp 1 (positive being forward, negative being backwards)
     */
    void upDown(double power);
    
    /**
     * Drives robot left or right
     * @param is value from -1 tp 1 (positive being left, negative being right)
     */
    void leftRight(double power);
    
    /**
     * Sets all motor powers to 0
     */
    void stopMotors();
    
    /**
     * Rotates the robot in place 
     * @param is value from -1 to 1 (positive being clockwise, negative being counter clockwise)
     */
    void rotate(double power);
    
    /**
     * All directional strafing
     */ 
    void polarDrive(double power, double theta, double rotation);
    
    /**
     * returns encoder position of selected motor 
     * @param num is motor num (0,1,2,3)
     */
    int getMotorPosition(int num);
    
    /**
     * returns true if over red, false if not
     */
    boolean isRed();
    
    /**
     * Returns true if over blue, false if not
     */
    boolean isBlue();
    
    /**
     * Lowers or lifts foundation clamp
     * @param open if false lift clamp, if true lowers clamp
     */
    void foundationClamp(boolean open);
    
    /**
     * Determines direction intake wheels spin 
     * if true spin inward (intake block), if false spin outward (spit out block)
     */
    void setIntake(boolean on);
    
    /**
     * Stops intake wheels from spinning
     */
    void stopIntake();
    
    /**
     * Drives robot based on tics 
     * @param numTics, num of tics you want robot to move
     * @param isForward, true moves robot forwards or backwards, false moves robot left or right
     * @param power, from -1 to 1 power value robot moves
     */
    void driveByTics(int numTics, boolean isForward, double power);
    
    /**
     * I dunno
     */
    public void calibrate();
    
    /**
     * I dunno
     */
    public int getAngle();
}