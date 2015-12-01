package com.ast;

import com.ast.command.PostCondition;
import com.ast.expression.Expression;

public class XArg extends Arg {
	private PostCondition postCondition;

	public PostCondition getPostCondition() {
		return postCondition;
	}

	public void setPostCondition(PostCondition postCondition) {
		this.postCondition = postCondition;
	}
}
