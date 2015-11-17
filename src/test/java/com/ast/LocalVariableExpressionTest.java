package com.ast;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ast.Arg;
import com.ast.ArgList;
import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.QuitCommand;
import com.ast.expression.*;


public class LocalVariableExpressionTest extends BaseTest {

	@Test
	public void testFourteen() throws Exception {

		String src = "TEST ;\r\n Q:bar foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", lvn.getName());
		assertNull(lvn.getArgList());
	}
	
	@Test
	public void testFifteen() throws Exception {

		String src = "TEST ;\r\n Q:'bar foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());

		assertTrue(cc.getPostCondition().getExpr() instanceof UnaryExpression);
		UnaryExpression uexpr = (UnaryExpression)cc.getPostCondition().getExpr();
		assertEquals("'", uexpr.getOperator());
		
		assertTrue(uexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)uexpr.getValue();
		assertEquals("bar", lvn.getName());
		assertNull(lvn.getArgList());
	}

	@Test
	public void testSixteen() throws Exception {

		String src = "TEST ;\r\n Q:-bar foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());

		assertTrue(cc.getPostCondition().getExpr() instanceof UnaryExpression);
		UnaryExpression uexpr = (UnaryExpression)cc.getPostCondition().getExpr();
		assertEquals("-", uexpr.getOperator());
		
		assertTrue(uexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)uexpr.getValue();
		assertEquals("bar", lvn.getName());
		assertNull(lvn.getArgList());
	}

	@Test
	public void testSeventeen() throws Exception {

		String src = "TEST ;\r\n Q:+bar foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());

		assertTrue(cc.getPostCondition().getExpr() instanceof UnaryExpression);
		UnaryExpression uexpr = (UnaryExpression)cc.getPostCondition().getExpr();
		assertEquals("+", uexpr.getOperator());
		
		assertTrue(uexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)uexpr.getValue();
		assertEquals("bar", lvn.getName());
		assertNull(lvn.getArgList());
	}

	@Test
	public void testEighteen() throws Exception {

		String src = "TEST ;\r\n Q:(bar) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", lvn.getName());
		assertNull(lvn.getArgList());
	}

	@Test
	public void testNineteen() throws Exception {

		String src = "TEST ;\r\n Q:bar() foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", lvn.getName());
		assertNotNull(lvn.getArgList());
		assertNotNull(lvn.getArgList().getArgList());
		assertEquals(0, lvn.getArgList().getArgList().size());
	}

	@Test
	public void testTwenty() throws Exception {

		String src = "TEST ;\r\n Q:bar(0) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", lvn.getName());
		assertNotNull(lvn.getArgList());
		ArgList argList = lvn.getArgList();
		assertNotNull(argList.getArgList());
		assertEquals(1, argList.getArgList().size());
		Arg arg0 = argList.getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());	
	}



}
