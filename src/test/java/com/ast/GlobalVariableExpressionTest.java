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

public class GlobalVariableExpressionTest extends BaseTest {

	@Test
	public void testTwentyOne() throws Exception {

		String src = "TEST ;\r\n Q:^bar foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof GlobalVariableExpression);
		GlobalVariableExpression gvn = (GlobalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", gvn.getName());
		assertNull(gvn.getArgList());
	}
	
	@Test
	public void testTwentyTwo() throws Exception {

		String src = "TEST ;\r\n Q:'^bar foo \r\n";
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
		
		assertTrue(uexpr.getValue() instanceof GlobalVariableExpression);
		GlobalVariableExpression gvn = (GlobalVariableExpression)uexpr.getValue();
		assertEquals("bar", gvn.getName());
		assertNull(gvn.getArgList());
	}

	@Test
	public void testTwentyThree() throws Exception {

		String src = "TEST ;\r\n Q:-^bar foo \r\n";
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
		
		assertTrue(uexpr.getValue() instanceof GlobalVariableExpression);
		GlobalVariableExpression gvn = (GlobalVariableExpression)uexpr.getValue();
		assertEquals("bar", gvn.getName());
		assertNull(gvn.getArgList());
	}

	@Test
	public void testTwentyFour() throws Exception {

		String src = "TEST ;\r\n Q:+^bar foo \r\n";
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
		
		assertTrue(uexpr.getValue() instanceof GlobalVariableExpression);
		GlobalVariableExpression gvn = (GlobalVariableExpression)uexpr.getValue();
		assertEquals("bar", gvn.getName());
		assertNull(gvn.getArgList());
	}

	@Test
	public void testTwentyFive() throws Exception {

		String src = "TEST ;\r\n Q:(^bar) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof GlobalVariableExpression);
		GlobalVariableExpression gvn = (GlobalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", gvn.getName());
		assertNull(gvn.getArgList());
	}
	
	@Test
	public void testTwentySix() throws Exception {

		String src = "TEST ;\r\n Q:(^bar()) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof GlobalVariableExpression);
		GlobalVariableExpression gvn = (GlobalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", gvn.getName());
		assertNotNull(gvn.getArgList());
		assertNotNull(gvn.getArgList().getArgList());
		assertEquals(0, gvn.getArgList().getArgList().size());
	}

	@Test
	public void testTwentySeven() throws Exception {

		String src = "TEST ;\r\n Q:(^bar(0)) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof GlobalVariableExpression);
		GlobalVariableExpression gvn = (GlobalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", gvn.getName());
		assertNotNull(gvn.getArgList());
		assertNotNull(gvn.getArgList().getArgList());
		assertEquals(1, gvn.getArgList().getArgList().size());
		Arg arg0 = gvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testTwentyEight() throws Exception {

		String src = "TEST ;\r\n Q:(^|environment|bar(0)) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof GlobalVariableExpression);
		GlobalVariableExpression gvn = (GlobalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", gvn.getName());
		assertNotNull(gvn.getArgList());
		assertNotNull(gvn.getArgList().getArgList());
		assertEquals(1, gvn.getArgList().getArgList().size());
		Arg arg0 = gvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(gvn.getEnvironment());
		assertTrue(gvn.getEnvironment() instanceof LocalVariableExpression);
		LocalVariableExpression lve2 = (LocalVariableExpression)gvn.getEnvironment();
		assertEquals("environment", lve2.getName());
	}

	@Test
	public void testTwentyNine() throws Exception {

		String src = "TEST ;\r\n Q:(^|environment|bar) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof GlobalVariableExpression);
		GlobalVariableExpression gvn = (GlobalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", gvn.getName());
		assertNull(gvn.getArgList());

		assertNotNull(gvn.getEnvironment());
		assertTrue(gvn.getEnvironment() instanceof LocalVariableExpression);
		LocalVariableExpression lve2 = (LocalVariableExpression)gvn.getEnvironment();
		assertEquals("environment", lve2.getName());
	}

	@Test
	public void testThirty() throws Exception {

		String src = "TEST ;\r\n Q:(^()) foo \r\n";  // a naked reference
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof GlobalVariableExpression);
		GlobalVariableExpression gvn = (GlobalVariableExpression)cc.getPostCondition().getExpr();
		assertNull(gvn.getName());
		assertNotNull(gvn.getArgList());
		assertNotNull(gvn.getArgList().getArgList());
		assertEquals(0, gvn.getArgList().getArgList().size());
	}

	@Test
	public void testThirtyOne() throws Exception {

		String src = "TEST ;\r\n Q:(^(0)) foo \r\n";  // a naked reference
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof GlobalVariableExpression);
		GlobalVariableExpression gvn = (GlobalVariableExpression)cc.getPostCondition().getExpr();
		assertNull(gvn.getName());
		assertNotNull(gvn.getArgList());
		assertNotNull(gvn.getArgList().getArgList());
		assertEquals(1, gvn.getArgList().getArgList().size());

		Arg arg0 = gvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testThirtyTwo() throws Exception {

		String src = "TEST ;\r\n Q:(@foo@(1)) foo \r\n";  // a weird indirection
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof IndirectExpression);
		IndirectExpression gvn = (IndirectExpression)cc.getPostCondition().getExpr();
		assertNotNull(gvn.getValue());
		assertTrue(gvn.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)gvn.getValue();
		assertEquals("foo", lve.getName());
		assertNotNull(gvn.getIndirectArgList());
		assertNotNull(gvn.getIndirectArgList().getArgList());
		assertEquals(1, gvn.getIndirectArgList().getArgList().size());
		Arg arg0 = gvn.getIndirectArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("1", nconst.getValue());
	}
}
