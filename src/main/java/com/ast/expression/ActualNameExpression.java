package com.ast.expression;

public class ActualNameExpression extends Expression {
	private String name;
	private IndirectExpression indirectExpression;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public IndirectExpression getIndirectExpression() {
		return indirectExpression;
	}
	
	public void setIndirectExpression(IndirectExpression indirectExpression) {
		this.indirectExpression = indirectExpression;
	}
}
