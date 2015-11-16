package com.ast.expression;

import com.ast.ArgList;

public class GlobalVariableExpression extends Expression {
	private String name;
	private String environmentName;
	private ArgList argList;
	
	public GlobalVariableExpression() {}
	
	public GlobalVariableExpression(String name, ArgList argList) {
		this.name = name;
		this.argList = argList;
	}

	public GlobalVariableExpression(LocalVariableExpression lvn) {
		this.name = lvn.getName();
		this.argList = lvn.getArgList();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArgList getArgList() {
		return argList;
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}

	public String getEnvironmentName() {
		return environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}
	
}
