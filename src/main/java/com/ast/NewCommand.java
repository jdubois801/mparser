package com.ast;

public class NewCommand extends Command {
	private ArgList argList;

	public NewCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}
	
	public ArgList getArgList() {
		return argList;
	}
}

