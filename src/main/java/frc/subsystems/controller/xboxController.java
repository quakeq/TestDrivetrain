package frc.subsystems.controller;

import edu.wpi.first.wpilibj.Joystick;

public class xboxController extends Joystick {

    public xboxController(int port) {
        super(port);
    }

    public double LgetXaxis(){
        return getRawAxis(0);
    }
    public double LgetYaxis(){
        return getRawAxis(1);
    }
    public double RgetXaxis(){
        return getRawAxis(4);
    }
    public double RgetYaxis(){
        return getRawAxis(5);
    }
    public double LgetDirection(){
        return getDirectionRadians();
    }
}
