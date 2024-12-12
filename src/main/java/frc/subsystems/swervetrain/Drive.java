package frc.subsystems.swervetrain;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.XboxController;

import static frc.robot.Constants.*;


public class Drive {
    private ModuleIOTalon frontR, frontL, backR, backL;


    public Drive() {
        this.frontL = new ModuleIOTalon(0);
        this.frontR = new ModuleIOTalon(1);
        this.backL = new ModuleIOTalon(2);
        this.backR = new ModuleIOTalon(3);
    }

    public void setPow(double fl, double fr, double bl, double br){
        frontL.setDrivePow(fl);
        frontR.setDrivePow(fr);
        backL.setDrivePow(bl);
        backR.setDrivePow(br);
    }
    public void setHeading(double fl, double fr, double bl, double br){
        frontL.setHeading(fl);
        frontR.setHeading(fr);
        backL.setHeading(bl);
        backR.setHeading(br);
    }

    public void swerveDrive(double x, double y, double rot){
        double a = x - (rot*l/2);
        double b = x + (rot*l/2);
        double c = y - (rot*w/2);
        double d = y + (rot*w/2);

        double fl = Math.sqrt((b*b) + (d*d));
        double fr = Math.sqrt((b*b) + (c*c));
        double bl = Math.sqrt((a*a) + (d*d));
        double br = Math.sqrt((a*a) + (c*c));

        if (fl > 1 || fr > 1 || bl > 1 || br > 1){
            double max = Math.max(Math.max(fl, fr), Math.max(bl, br));
            fl /= max; fr /= max; bl /= max; br /= max;
        }

        setPow(fl, fr, bl, br);

        double flS = Math.atan2(b,d)*180/Math.PI;
        double frS = Math.atan2(b,c)*180/Math.PI;
        double blS = Math.atan2(a,d)*180/Math.PI;
        double brS = Math.atan2(a,c)*180/Math.PI;

        setHeading(flS, frS, blS, brS);
    }

    public void manualDrive(double aX, double aY, double aRot){
        boolean active = aX > deadspace || aX < -deadspace ||
                         aY > deadspace || aY < -deadspace ||
                         aRot > deadspace || aRot < -deadspace;

        if (active){
            swerveDrive(aX, aY, aRot);
        }
    }

    public void disable(boolean button){
        this.frontL.disable();
        this.frontR.disable();
        this.backL.disable();
        this.backR.disable();
    }

}
