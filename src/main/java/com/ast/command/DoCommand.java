package com.ast.command;

import com.ast.ArgList;

public class DoCommand extends Command {
	private ArgList argList;

	public DoCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public ArgList getArgList() {
		return argList;
	}

}

