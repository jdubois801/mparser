package com.validation;

import com.ast.Line;

public class LineValidator {

	public static void visit(Line line) {
		if (line.getCommandList() == null) {
			System.err.println("Error: line command list is null.");
		}
		else {
			CommandListValidator.visit(line.getCommandList());
		}
	}
}
