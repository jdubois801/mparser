package com.ast.command;

import java.util.List;

import com.ast.expression.Expression;

import java.util.ArrayList;
import java.util.Collection;

public class CommandList {
	private List<Command> commandList = new ArrayList<>();
	private Expression extSyntax = null;

	public List<Command> getCommandList() {
		return commandList;
	}

	public void add(Command cmd) {
		if (cmd != null) {
			commandList.add(cmd);
		}
	}

	public void addAll(Collection<Command> commandCollection) {
		if (commandCollection != null) {
			commandList.addAll(commandCollection);
		}
	}

	public Expression getExtSyntax() {
		return extSyntax;
	}

	public void setExtSyntax(Expression extSyntax) {
		this.extSyntax = extSyntax;
	}

}
