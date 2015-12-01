package com.ast;

import com.ast.expression.Expression;

public class ReadArg extends Arg {

	private Expression destination;
	private boolean oneChar = false;
	private String literal;
	private String format;
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

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
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
