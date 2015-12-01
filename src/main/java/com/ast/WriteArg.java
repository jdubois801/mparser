package com.ast;

import com.ast.expression.Expression;

public class WriteArg extends Arg {
	private Expression source;
	private String format;
	private boolean oneChar = false;

	public Expression getSource() {
		return source;
	}

	public void setSource(Expression source) {
		this.source = source;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public boolean isOneChar() {
		return oneChar;
	}

	public void setOneChar(boolean oneChar) {
		this.oneChar = oneChar;
	}
}
