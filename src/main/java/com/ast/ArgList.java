package com.ast;

import java.util.List;
import java.util.ArrayList;

public class ArgList extends AstNode {
	private List<Arg> argList = new ArrayList<>();

	public List<Arg> getArgList() {
		return argList;
	}
}

