package com.validation;

import com.ast.IfCommand;

public class IfCommandValidator {

	public static void visit(IfCommand cmd) {
		// TODO - now what?
		
		if (cmd.getArgList() == null) {
			System.err.println("Error: If command arg list is null");
		}
		
		if (cmd.getLineList() == null) {
			System.err.println("Error: If command line list is null");
		}
	}
}
