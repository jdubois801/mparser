package com.ast.command;

import com.ast.ArgList;

public class HangCommand extends Command {
	private ArgList argList = null;

	public ArgList getArgList() {
		return argList;
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}
	
}

