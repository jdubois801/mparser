package com.ast;

public class MergeCommand extends Command {
	private ArgList argList;

	public MergeCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public ArgList getArgList() {
		return argList;
	}
}

