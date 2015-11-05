package com;

import org.junit.Test;

import java.io.StringReader;
//import com.SimpleNode;
import com.validation.RoutineValidator;
//import com.Node;

public class LockStatementTest {

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n L foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
//		SimpleNode node = parser.routine();
//		Node bodyNode = node.jjtGetChild(1);
//		System.err.println("o = " + bodyNode);
//		System.err.println("num children = " + bodyNode.jjtGetNumChildren());
//		Node nNode = bodyNode.jjtGetChild(0);
//		Node lNode = nNode.jjtGetChild(0);
//		Node llNode = lNode.jjtGetChild(0);
//		Node lbNode = llNode.jjtGetChild(0);
//		Node ccNode = lbNode.jjtGetChild(0);
//		Node cmNode = ccNode.jjtGetChild(0);
//		Node cmdNode = cmNode.jjtGetChild(0);
//		Node lockNode = cmdNode.jjtGetChild(0);
//		System.err.println("o2 = " + cmdNode);
//		System.err.println("o2 = " + cmdNode.getClass().getName());
		
		RoutineValidator.visit(parser.getParseResult());
	}

}

