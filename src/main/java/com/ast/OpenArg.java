package com.ast;

public class OpenArg extends Arg {
	private ArgList openArgs;
	private OpenParam openParams;

	public ArgList getOpenArgs() {
		return openArgs;
	}

	public void setOpenArgs(ArgList openArgs) {
		this.openArgs = openArgs;
	}

	public OpenParam getOpenParams() {
		return openParams;
	}

	public void setOpenParams(OpenParam openParams) {
		this.openParams = openParams;
	}

}
