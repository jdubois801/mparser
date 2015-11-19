package com.ast;

import com.ast.expression.Expression;

public class ExternRef extends Expression {

	private String packageName;
	private String routine;
	private String label;
	private ArgList argList;
	
	public String getPackageName() {
		return packageName;
	}
	
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public String getRoutine() {
		return routine;
	}
	
	public void setRoutine(String routine) {
		this.routine = routine;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public ArgList getArgList() {
		return argList;
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}
}
