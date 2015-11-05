package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Command;
import com.ast.LockCommand;
import com.ast.Routine;
//import com.SimpleNode;
import com.validation.RoutineValidator;
//import com.Node;

public class LockStatementTest extends BaseTest {

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
		
		Command cmd = findFirstCommand(parser.getParseResult(), LockCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		System.err.println("cmd = " + cmd);
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n L foo,bar \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		List<Command> cmdList = findAllCommands(parser.getParseResult(), LockCommand.class); 
		assertNotNull(cmdList);
		assertEquals(1, cmdList.size());
		
		for (Command cmd : cmdList) {
			System.err.println("cmd = " + cmd);
			
			assertTrue(cmd instanceof LockCommand);
			LockCommand lc = (LockCommand)cmd;
			assertNotNull(lc.getArgList());
			assertNull(lc.getPostCondition());
			
			assertNotNull(lc.getArgList());
			assertNotNull(lc.getArgList().getArgList());
			assertEquals(2, lc.getArgList().getArgList().size());
		}
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n L:0 foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), LockCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		System.err.println("cmd = " + cmd);
	}
}


