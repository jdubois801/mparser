package com.ast;

public class SetCommand extends Command {
	private ArgList argList;

	public SetCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public ArgList getArgList() {
		return argList;
	}
}

