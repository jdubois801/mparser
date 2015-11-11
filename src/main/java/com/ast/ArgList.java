package com.ast;

import java.util.List;
import java.util.ArrayList;

public class ArgList extends AstNode {
	private List<Arg> argList = new ArrayList<>();
	private String liveArg;
	
	public List<Arg> getArgList() {
		return argList;
	}

	public void add(Arg arg) {
		argList.add(arg);
	}

	public String getLiveArg() {
		return liveArg;
	}

	public void setLiveArg(String liveArg) {
		this.liveArg = liveArg;
	}
}

