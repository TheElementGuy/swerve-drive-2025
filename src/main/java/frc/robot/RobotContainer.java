// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.command.TeleOpDriveCommand;
import frc.robot.subsystems.SwerveDriveSubsystem;

public class RobotContainer {

	private final SwerveDriveSubsystem driveTrain;
	private final TeleOpDriveCommand drive;
	private final XboxController controller;

	public RobotContainer() {
		this.driveTrain = new SwerveDriveSubsystem();
		controller = new XboxController(0);
		drive = new TeleOpDriveCommand(driveTrain, controller);
		driveTrain.setDefaultCommand(drive);
		configureBindings();
	}

	private void configureBindings() {
	}

	public Command getAutonomousCommand() {
		return null;
	}
}
