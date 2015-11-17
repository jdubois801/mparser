package com.ast;

import java.util.List;
import java.util.ArrayList;

public class ParamList extends AstNode {
	private List<Param> paramList = new ArrayList<>();
	
	public List<Param> getParamList() {
		return paramList;
	}

	public void add(Param param) {
		paramList.add(param);
	}

}

