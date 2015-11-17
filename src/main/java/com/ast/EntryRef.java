package com.ast;

import com.ast.expression.Expression;

public class EntryRef extends Expression {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
