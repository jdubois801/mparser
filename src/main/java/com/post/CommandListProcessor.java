package com.post;

import java.util.List;

import com.ast.command.Command;
import com.ast.command.CommandList;

public class CommandListProcessor {

	public static void visit(CommandList commandList) {
		if (commandList != null && commandList.getCommandList() != null) {
			for (Command cmd : commandList.getCommandList()) {
				if (cmd == null) {
					System.err.println("Error: command is null.");
				}
				else {
					//CommandValidator.visit(cmd);
				}
			}
		}
	}
	
	public static Command last(CommandList list) {
		
		Command result = null;
		
		if (list != null) {
			List<Command> cmdList = list.getCommandList();
			
			if (cmdList != null && !cmdList.isEmpty()) {
				int lastIndex = cmdList.size()-1;
				result = cmdList.get(lastIndex);
			}
		}
		
		return result;
	}
	
	public static Command first(CommandList list, Class<?> clz) {
		
		Command result = null;
		
		if (list != null) {
			List<Command> cmdList = list.getCommandList();
			
			for (Command cmd : cmdList) {
				if (clz.isAssignableFrom(cmd.getClass())) {
					result = cmd;
					break;
				}
			}
		}
		
		return result;
	}
}
