package com.ast;

import com.ast.expression.Expression;

public class EntryRef extends Expression {
	private String name;
	private Expression offset;
	private Expression environment;
	private String routine;
	private Expression indirectExpression;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Expression getOffset() {
		return offset;
	}

	public void setOffset(Expression offset) {
		this.offset = offset;
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

	public Expression getIndirectExpression() {
		return indirectExpression;
	}

	public void setIndirectExpression(Expression indirectExpression) {
		this.indirectExpression = indirectExpression;
	}
}
