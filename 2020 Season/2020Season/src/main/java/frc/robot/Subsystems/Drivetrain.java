package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain implements ISubsystem{

    private DifferentialDrive _robotDrive;
    private CANSparkMax _leftMotor;
    private CANSparkMax _rightMotor;

    public static Drivetrain instance;

    public Drivetrain() {
        _leftMotor = new CANSparkMax(0, MotorType.kBrushless);
        _rightMotor = new CANSparkMax(1, MotorType.kBrushless);

        _robotDrive = new DifferentialDrive(_leftMotor, _rightMotor);
    }
    public static Drivetrain GetInstance()
    {
        if (instance == null)
        {
            instance = new Drivetrain();
        }
        return instance;
    }
    public void FunnyDrive(double throttle, double turn){
        _robotDrive.arcadeDrive(throttle, turn);
    }
    public void LogTelemetry()
    {
        SmartDashboard.putNumber("distance", 0);
    }
}