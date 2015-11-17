package com.ast;

import com.ast.command.CommandList;

public class Line {
	private int indentation = 0;
	private CommandList commandList;

	public void setCommandList(CommandList commandList) {
		this.commandList = commandList;
	}

	public CommandList getCommandList() {
		return commandList;
	}

	public void setIndentation(int indentation) {
		this.indentation = indentation;
	}

	public int getIndentation() {
		return indentation;
	}
}

