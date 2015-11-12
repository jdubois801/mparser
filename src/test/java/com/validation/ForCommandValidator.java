package com.validation;

import com.ast.ForCommand;

public class ForCommandValidator {

	public static void visit(ForCommand cmd) {
		// TODO - now what?
		
		if (cmd.getLineList() == null) {
			System.err.println("Error: For command line list is null");
		}

	}
}
