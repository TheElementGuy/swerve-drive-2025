package frc.robot.command;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SwerveDriveSubsystem;

public class TeleOpDriveCommand extends Command {

	private final SwerveDriveSubsystem swerveDrive;
	private final XboxController controller;

	public TeleOpDriveCommand(SwerveDriveSubsystem driveTrain, XboxController controller) {
		this.controller = controller;
		swerveDrive = driveTrain;
	}

	@Override
	public void execute() {
		swerveDrive.basicDriveCommand(controller.getLeftX(), controller.getLeftY(), controller.getRightX());
	}

}
