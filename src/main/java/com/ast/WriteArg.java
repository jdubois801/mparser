package com.ast;

import com.ast.expression.Expression;

public class WriteArg extends Arg {
	private Expression source;
	private Expression format;
	private boolean oneChar = false;

	public Expression getSource() {
		return source;
	}

	public void setSource(Expression source) {
		this.source = source;
	}

	public Expression getFormat() {
		return format;
	}

	public void setFormat(Expression format) {
		this.format = format;
	}

	public boolean isOneChar() {
		return oneChar;
	}

	public void setOneChar(boolean oneChar) {
		this.oneChar = oneChar;
	}
}
