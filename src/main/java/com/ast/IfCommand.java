package com.ast;

public class IfCommand extends Command {
	private ArgList argList;

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public ArgList getArgList() {
		return argList;
	}
}

