package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.XecuteCommand;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;

public class XecuteCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n XECUTE foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, XecuteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof XecuteCommand);
		XecuteCommand cc = (XecuteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof XArg);
		XArg xarg = (XArg)arg;
		assertNull(xarg.getPostCondition());
		assertNotNull(xarg.getExpression());
		assertTrue(xarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)xarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n X foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, XecuteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof XecuteCommand);
		XecuteCommand cc = (XecuteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof XArg);
		XArg xarg = (XArg)arg;
		assertNull(xarg.getPostCondition());
		assertNotNull(xarg.getExpression());
		assertTrue(xarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)xarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n X:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, XecuteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof XecuteCommand);
		XecuteCommand cc = (XecuteCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)cc.getPostCondition().getExpr();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof XArg);
		XArg xarg = (XArg)arg;
		assertNull(xarg.getPostCondition());
		assertNotNull(xarg.getExpression());
		assertTrue(xarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)xarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n X foo,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, XecuteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof XecuteCommand);
		XecuteCommand cc = (XecuteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof XArg);
		XArg xarg = (XArg)arg;
		assertNull(xarg.getPostCondition());
		assertNotNull(xarg.getExpression());
		assertTrue(xarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)xarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof XArg);
		XArg xarg1 = (XArg)arg1;
		assertNull(xarg1.getPostCondition());
		assertNotNull(xarg1.getExpression());
		assertTrue(xarg1.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)xarg1.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)ie.getValue();
		assertNull(lve1.getArgList());
		assertEquals("bar", lve1.getName());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n X foo:0,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, XecuteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof XecuteCommand);
		XecuteCommand cc = (XecuteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof XArg);
		XArg xarg = (XArg)arg;
		assertNotNull(xarg.getPostCondition());
		assertNotNull(xarg.getPostCondition().getExpr());
		assertTrue(xarg.getPostCondition().getExpr() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)xarg.getPostCondition().getExpr();
		assertEquals("0", nconst.getValue());
				
		assertNotNull(xarg.getExpression());
		assertTrue(xarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)xarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof XArg);
		XArg xarg1 = (XArg)arg1;
		assertNull(xarg1.getPostCondition());
		assertNotNull(xarg1.getExpression());
		assertTrue(xarg1.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)xarg1.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)ie.getValue();
		assertNull(lve1.getArgList());
		assertEquals("bar", lve1.getName());
	}
}

