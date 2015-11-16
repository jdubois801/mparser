package com.validation;

import com.ast.command.LockCommand;

public class LockCommandValidator {

	public static void visit(LockCommand cmd) {
		if (cmd.getArgList() == null) {
			System.err.println("Error: lock command arg list is null.");
		}
		if (cmd.getArgList().getArgList() == null || cmd.getArgList().getArgList().isEmpty()) {
			System.err.println("Error: lock command arg list is empty.");
		}
		
		// TODO- no what?
	}
}
