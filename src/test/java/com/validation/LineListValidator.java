package com.validation;

import com.ast.Line;
import com.ast.LineList;

public class LineListValidator {

	public static void visit(LineList lineList) {
		
		if (lineList.getLineList() != null) {
			
			for (Line line : lineList.getLineList()) {
				
				if (line == null) {
					System.err.println("Error: line is null.");
				}
				else {
					LineValidator.visit(line);
				}
			}
		}
	}
}
