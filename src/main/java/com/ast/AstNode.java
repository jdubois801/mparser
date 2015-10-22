package com.ast;

import java.util.List;
import com.SimpleNode;

public class AstNode extends SimpleNode {

	protected AstNode parent;
	protected List<AstNode> children;

	public AstNode() {
		super(0);
	}

	public AstNode(int i) {
		super(i);
	}
}

