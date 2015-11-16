package com.ast.command;

import com.ast.ArgList;

public class OpenCommand extends Command {
	private ArgList argList;

	public OpenCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public ArgList getArgList() {
		return argList;
	}
}

