package com.validation;

import com.ast.command.ElseCommand;

public class ElseCommandValidator {

	public static void visit(ElseCommand cmd) {
		// TODO - now what?
		
		if (cmd.getLineList() == null) {
			System.err.println("Error: Else command line list is null");
		}

	}
}
