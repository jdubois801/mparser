package com.ast;

import com.ast.expression.Expression;

public class SetArg extends Arg {
	private ArgList left;
	private Expression right;
	
	public ArgList getLeft() {
		return left;
	}
	
	public void setLeft(ArgList left) {
		this.left = left;
	}
	
	public Expression getRight() {
		return right;
	}
	
	public void setRight(Expression right) {
		this.right = right;
	}
}
