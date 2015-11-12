package com.post;

import com.ast.Routine;

public class RoutineProcessor {

	public static void visit(Routine routine) {
		if (routine == null) {
			System.err.println("Error: routine is null.");
		}
		
		if (routine.getLineList() != null &&
				routine.getLineList().getLineList() != null &&
				!routine.getLineList().getLineList().isEmpty()) {
			
			LineListProcessor.visit(routine.getLineList());
		}
	}
}
