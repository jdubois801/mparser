package com.validation;

import com.ast.Routine;

public class RoutineValidator {

	public static void visit(Routine routine) {
		if (routine == null) {
			System.err.println("Error: routine is null.");
		}
		
		if (routine.getName() == null || routine.getName().length() < 1) {
			System.err.println("Error: routine has no nanme.");
		}
		
		if (routine.getLineList() == null || routine.getLineList().getLineList() == null || routine.getLineList().getLineList().isEmpty()) {
			System.err.println("Error: routine has empty line list.");
		}
			
		LineListValidator.visit(routine.getLineList());
	}
}
