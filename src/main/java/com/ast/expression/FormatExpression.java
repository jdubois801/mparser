package com.ast.expression;

import com.ast.ArgList;

public class FormatExpression extends Expression {
	private String format;
	private ArgList argList;
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public ArgList getArgList() {
		return argList;
	}
	
	public void setArgList(ArgList argList) {
		this.argList = argList;
	}
}
