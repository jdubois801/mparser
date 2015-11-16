package com.ast.command;

import com.ast.ArgList;

public class LockCommand extends Command {
	private ArgList argList;

	public LockCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public ArgList getArgList() {
		return argList;
	}

	public String toString() {
		return "LockCommand";
	}
}

