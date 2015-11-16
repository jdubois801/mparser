package com.ast.command;

import com.ast.ArgList;
import com.ast.LineList;

public class IfCommand extends Command {
	private ArgList argList;
	private LineList lineList;
	
	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public ArgList getArgList() {
		return argList;
	}

	public LineList getLineList() {
		return lineList;
	}

	public void setLineList(LineList lineList) {
		this.lineList = lineList;
	}
	
}

