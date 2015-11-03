package com.ast;

public class XecuteCommand extends Command {
	private ArgList argList;

	public XecuteCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public ArgList getArgList() {
		return argList;
	}
}

