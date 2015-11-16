package com.ast.command;

import com.ast.ArgList;

public class ReadCommand extends Command {
	private ArgList argList;

	public ReadCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public ArgList getArgList() {
		return argList;
	}
}

