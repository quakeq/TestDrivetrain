package frc.subsystems.swervetrain;


import static frc.robot.Constants.*;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Angle;

public class ModuleIOTalon {
    private final TalonFX driveMotor;
    private final TalonFX steerMotor;
    private final CANcoder encSteer;

    public ModuleIOTalon(int moduleID) {
        switch(moduleID){
            //init FL module
            case 0 -> {
                this.driveMotor = new TalonFX(drivePowPorts[0]);
                this.steerMotor = new TalonFX(driveSteerPorts[0]);
                this.encSteer = new CANcoder(canCoderPorts[0]);
            }
            //init FR module
            case 1 -> {
                this.driveMotor = new TalonFX(drivePowPorts[1]);
                this.steerMotor = new TalonFX(driveSteerPorts[1]);
                this.encSteer = new CANcoder(canCoderPorts[1]);
            }
            //init BL module
            case 2 -> {
                this.driveMotor = new TalonFX(drivePowPorts[2]);
                this.steerMotor = new TalonFX(driveSteerPorts[2]);
                this.encSteer = new CANcoder(canCoderPorts[2]);
            }
            //init BR module
            case 3 -> {
                this.driveMotor = new TalonFX(drivePowPorts[3]);
                this.steerMotor = new TalonFX(driveSteerPorts[3]);
                this.encSteer = new CANcoder(canCoderPorts[3]);
            }
            default -> throw new IllegalArgumentException("invalid");
        }
    }
    //headingVal is in radians
    public void setHeading(double headingVal){
        this.steerMotor.setPosition(headingVal/2 * Math.PI);
    }
    public void setDrivePow(double powVal){
        this.driveMotor.set(powVal);
    }



    public double getHeading(){
        return this.encSteer.getPosition().getValueAsDouble();
    }
    public void setEncoder(double set){
        this.encSteer.setPosition(set);
    }
    public void resetSteerEnc(){
        this.encSteer.setPosition(0);
    }

    public void disable(){
        this.steerMotor.disable();
        this.driveMotor.disable();
    }



}
