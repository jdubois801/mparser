package com.ast;

import java.util.ArrayList;
import java.util.List;

import com.ast.expression.Expression;

public class MnemonicSpaceList {
	private List<Expression> spaceList = new ArrayList<>();

	public List<Expression> getSpaceList() {
		return spaceList;
	}

	public void setSpaceList(List<Expression> spaceList) {
		this.spaceList = spaceList;
	}
	
	public void add(Expression expr)
	{
		this.spaceList.add(expr);
	}
}
