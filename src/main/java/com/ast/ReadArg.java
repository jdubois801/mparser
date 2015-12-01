package com.ast;

import com.ast.expression.Expression;

public class ReadArg extends Arg {

	private Expression destination;
	private boolean oneChar = false;
	private String literal;
	private Expression format;
	private Expression readCount;
	private Expression timeout;

	public Expression getDestination() {
		return destination;
	}

	public void setDestination(Expression destination) {
		this.destination = destination;
	}

	public String getLiteral() {
		return literal;
	}

	public void setLiteral(String literal) {
		this.literal = literal;
	}

	public Expression getFormat() {
		return format;
	}

	public void setFormat(Expression format) {
		this.format = format;
	}

	public Expression getReadCount() {
		return readCount;
	}

	public void setReadCount(Expression readCount) {
		this.readCount = readCount;
	}

	public Expression getTimeout() {
		return timeout;
	}

	public void setTimeout(Expression timeout) {
		this.timeout = timeout;
	}

	public boolean isOneChar() {
		return oneChar;
	}

	public void setOneChar(boolean oneChar) {
		this.oneChar = oneChar;
	}
	
}
