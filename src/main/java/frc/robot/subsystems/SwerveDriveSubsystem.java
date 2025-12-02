package frc.robot.subsystems;

import java.io.File;
import java.lang.reflect.Field;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import swervelib.SwerveDrive;
import swervelib.math.SwerveMath;
import swervelib.parser.SwerveParser;

public class SwerveDriveSubsystem extends SubsystemBase {
    
	private final File moduleFiles = new File(Filesystem.getDeployDirectory(), "swerve");
	private final SwerveDrive swerveDrive;

	//maximum velocity
	public final double DRIVE_SCALE_FACTOR = 0.8;

	public SwerveDriveSubsystem() {
		try {
			swerveDrive = new SwerveParser(moduleFiles).createSwerveDrive(5);
		} catch (Exception e) {
			throw new RuntimeException("No files dummy.");
		}
	}
	
	public Command basicDriveCommand(double translationX, double translationY, double angularVelocity) {
		return run(() -> {
			Translation2d scaledInput = SwerveMath.scaleTranslation(new Translation2d(translationX, translationY), DRIVE_SCALE_FACTOR);
			driveFieldOriented(swerveDrive.swerveController.getRawTargetSpeeds(scaledInput.getX(), scaledInput.getY(), angularVelocity));
		});
	}

	public void driveFieldOriented(ChassisSpeeds velocities) {
		swerveDrive.driveFieldOriented(velocities);
	}

	public SwerveDrive getDrive() {
		return swerveDrive;
	}

}
