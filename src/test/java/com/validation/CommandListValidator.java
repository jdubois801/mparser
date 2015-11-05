package com.validation;

import com.ast.Command;
import com.ast.CommandList;

public class CommandListValidator {

	public static void visit(CommandList commandList) {
		if (commandList != null && commandList.getCommandList() != null) {
			for (Command cmd : commandList.getCommandList()) {
				if (cmd == null) {
					System.err.println("Error: command is null.");
				}
				else {
					CommandValidator.visit(cmd);
				}
			}
		}
	}
}
