package frc.robot;

public class Constants {

    public static int[] drivePowPorts = {
        //drive ports (FL, FR, BL. BR)
        11, 13, 15, 17
    };
    public static int[] driveSteerPorts = {
        //steering module ports (FL, FR, BL. BR)
        12, 14, 16, 18
    };
    public static int[] canCoderPorts = {
        //(FL, FR, BL. BR)
        1, 2, 3, 4
    };
    public static double tkp = 0.5; public static double tki = 0.5; public static double tkd = 0.5;
    public static double dkp = 0.5; public static double dki = 0.5; public static double dkd = 0.5;

    //bot dimensions
    public static double l = 21,
            w = 21,
            r = Math.sqrt((l * l) + (w * w));

    //controller deadspace
    public static double deadspace = 0.05;
}
