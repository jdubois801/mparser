package com.ast;

import com.ast.expression.Expression;

public class LabelRef extends Expression {
	public String name;
	public Expression environment;
	public String routine;
	public ArgList argList;
	
	public static LabelRef from(EntryRef entryRef) {
		LabelRef result = new LabelRef();
		result.setName(entryRef.getName());
		result.setEnvironment(entryRef.getEnvironment());
		result.setRoutine(entryRef.getRoutine());
		
		return result;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Expression getEnvironment() {
		return environment;
	}
	
	public void setEnvironment(Expression environment) {
		this.environment = environment;
	}
	
	public String getRoutine() {
		return routine;
	}
	
	public void setRoutine(String routine) {
		this.routine = routine;
	}

	public ArgList getArgList() {
		return argList;
	}

	public void setArgList(ArgList argList) {
		this.argList = argList;
	}
}
