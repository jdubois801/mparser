package com.ast.command;

import com.ast.AstNode;

public class Command extends AstNode {
	private PostCondition postCondition;


	public PostCondition getPostCondition() {
		return postCondition;
	}

	public void setPostCondition(PostCondition postCondition) {
		this.postCondition = postCondition;
	}
}

