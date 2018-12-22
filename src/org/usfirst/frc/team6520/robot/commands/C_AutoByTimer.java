package org.usfirst.frc.team6520.robot.commands;

import org.usfirst.frc.team6520.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class C_AutoByTimer extends Command {

	double seconds;
	double initTime = Timer.getFPGATimestamp();
	
    public C_AutoByTimer(double seconds) {
    	this.seconds = seconds;
    }
    public C_AutoByTimer(double time, boolean example){
    	seconds = time;
    }
    protected void initialize() {
    }
    protected void execute() {
    	while ((Timer.getFPGATimestamp() - initTime) < seconds) {
			RobotMap.ss_Drivebase.driveGyro();
			Timer.delay(0.02);
		}
    }
    protected boolean isFinished() {
        return true;
    }
    protected void end() {
    	RobotMap.ss_Drivebase.stop();
    }
    protected void interrupted() {
    	RobotMap.ss_Drivebase.stop();
    }
}
