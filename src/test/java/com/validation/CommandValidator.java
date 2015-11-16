package com.validation;

import com.ast.*;
import com.ast.command.BreakCommand;
import com.ast.command.CloseCommand;
import com.ast.command.Command;
import com.ast.command.DoCommand;
import com.ast.command.ElseCommand;
import com.ast.command.ForCommand;
import com.ast.command.GotoCommand;
import com.ast.command.HaltCommand;
import com.ast.command.HangCommand;
import com.ast.command.IfCommand;
import com.ast.command.JobCommand;
import com.ast.command.KillCommand;
import com.ast.command.LockCommand;
import com.ast.command.MergeCommand;
import com.ast.command.NewCommand;
import com.ast.command.OpenCommand;
import com.ast.command.QuitCommand;
import com.ast.command.ReadCommand;
import com.ast.command.SetCommand;
import com.ast.command.UseCommand;
import com.ast.command.ViewCommand;
import com.ast.command.WriteCommand;
import com.ast.command.XecuteCommand;

public class CommandValidator {

	public static void visit(Command cmd) {
		//System.err.println("CommandValidator.visit cmd = " + cmd);
		
		if (cmd instanceof BreakCommand) {
			BreakCommandValidator.visit((BreakCommand)cmd);
		}
		if (cmd instanceof CloseCommand) {
			CloseCommandValidator.visit((CloseCommand)cmd);
		}
		if (cmd instanceof DoCommand) {
			DoCommandValidator.visit((DoCommand)cmd);
		}
		if (cmd instanceof ElseCommand) {
			ElseCommandValidator.visit((ElseCommand)cmd);
		}
		if (cmd instanceof ForCommand) {
			ForCommandValidator.visit((ForCommand)cmd);
		}
		if (cmd instanceof GotoCommand) {
			GotoCommandValidator.visit((GotoCommand)cmd);
		}
		if (cmd instanceof HaltCommand) {
			HaltCommandValidator.visit((HaltCommand)cmd);
		}
		if (cmd instanceof HangCommand) {
			HangCommandValidator.visit((HangCommand)cmd);
		}
		if (cmd instanceof IfCommand) {
			IfCommandValidator.visit((IfCommand)cmd);
		}
		if (cmd instanceof JobCommand) {
			JobCommandValidator.visit((JobCommand)cmd);
		}
		if (cmd instanceof KillCommand) {
			KillCommandValidator.visit((KillCommand)cmd);
		}
		if (cmd instanceof LockCommand) {
			LockCommandValidator.visit((LockCommand)cmd);
		}
		if (cmd instanceof MergeCommand) {
			MergeCommandValidator.visit((MergeCommand)cmd);
		}
		if (cmd instanceof NewCommand) {
			NewCommandValidator.visit((NewCommand)cmd);
		}
		if (cmd instanceof OpenCommand) {
			OpenCommandValidator.visit((OpenCommand)cmd);
		}
		if (cmd instanceof QuitCommand) {
			QuitCommandValidator.visit((QuitCommand)cmd);
		}
		if (cmd instanceof ReadCommand) {
			ReadCommandValidator.visit((ReadCommand)cmd);
		}
		if (cmd instanceof SetCommand) {
			SetCommandValidator.visit((SetCommand)cmd);
		}
		if (cmd instanceof UseCommand) {
			UseCommandValidator.visit((UseCommand)cmd);
		}
		if (cmd instanceof ViewCommand) {
			ViewCommandValidator.visit((ViewCommand)cmd);
		}
		if (cmd instanceof WriteCommand) {
			WriteCommandValidator.visit((WriteCommand)cmd);
		}
		if (cmd instanceof XecuteCommand) {
			XecuteCommandValidator.visit((XecuteCommand)cmd);
		}
	}
}
