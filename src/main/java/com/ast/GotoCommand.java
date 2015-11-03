package com.ast;

public class GotoCommand extends Command {
	private ArgList argList;

	public GotoCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}
	
	public ArgList getArgList() {
		return argList;
	}
}

