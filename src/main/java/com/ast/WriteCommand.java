package com.ast;

public class WriteCommand extends Command {
	private ArgList argList;

	public WriteCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public ArgList getArgList() {
		return argList;
	}
}

