package com.ast;

public class Param extends AstNode {
	private String name;
	
	public Param(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
