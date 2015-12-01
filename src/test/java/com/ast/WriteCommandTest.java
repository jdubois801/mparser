package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.WriteCommand;
import com.ast.expression.FormatExpression;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;

public class WriteCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n WRITE foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof WriteArg);
		WriteArg warg = (WriteArg)arg;
		assertNull(warg.getFormat());
		assertNull(warg.getExpression());
		assertFalse(warg.isOneChar());
		assertNotNull(warg.getSource());
		assertTrue(warg.getSource() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)warg.getSource();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n W foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof WriteArg);
		WriteArg warg = (WriteArg)arg;
		assertNull(warg.getFormat());
		assertNull(warg.getExpression());
		assertFalse(warg.isOneChar());
		assertNotNull(warg.getSource());
		assertTrue(warg.getSource() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)warg.getSource();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n W:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)cc.getPostCondition().getExpr();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof WriteArg);
		WriteArg warg = (WriteArg)arg;
		assertNull(warg.getFormat());
		assertNull(warg.getExpression());
		assertFalse(warg.isOneChar());
		assertNotNull(warg.getSource());
		assertTrue(warg.getSource() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)warg.getSource();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n W foo,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof WriteArg);
		WriteArg warg = (WriteArg)arg;
		assertNull(warg.getFormat());
		assertNull(warg.getExpression());
		assertFalse(warg.isOneChar());
		assertNotNull(warg.getSource());
		assertTrue(warg.getSource() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)warg.getSource();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof WriteArg);
		WriteArg warg1 = (WriteArg)arg1;
		assertNull(warg1.getFormat());
		assertNotNull(warg1.getExpression());
		assertFalse(warg1.isOneChar());
		assertNull(warg1.getSource());
		
		assertTrue(warg1.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)warg1.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)ie.getValue();
		assertNull(lve1.getArgList());
		assertEquals("bar", lve1.getName());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n W !!##??,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof WriteArg);
		WriteArg warg = (WriteArg)arg;
		assertNotNull(warg.getFormat());
		assertNull(warg.getExpression());
		assertFalse(warg.isOneChar());
		assertNull(warg.getSource());
		assertTrue(warg.getFormat() instanceof FormatExpression);
		FormatExpression fe = (FormatExpression)warg.getFormat();
		assertEquals("!!##??", fe.getFormat());
		assertNull(fe.getArgList());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof WriteArg);
		WriteArg warg1 = (WriteArg)arg1;
		assertNull(warg1.getFormat());
		assertNotNull(warg1.getExpression());
		assertFalse(warg1.isOneChar());
		assertNull(warg1.getSource());
		
		assertTrue(warg1.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)warg1.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)ie.getValue();
		assertNull(lve1.getArgList());
		assertEquals("bar", lve1.getName());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n W *foo,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof WriteArg);
		WriteArg warg = (WriteArg)arg;
		assertNull(warg.getFormat());
		assertNull(warg.getExpression());
		assertTrue(warg.isOneChar());
		assertNotNull(warg.getSource());
		assertTrue(warg.getSource() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)warg.getSource();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof WriteArg);
		WriteArg warg1 = (WriteArg)arg1;
		assertNull(warg1.getFormat());
		assertNotNull(warg1.getExpression());
		assertFalse(warg1.isOneChar());
		assertNull(warg1.getSource());
		
		assertTrue(warg1.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)warg1.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)ie.getValue();
		assertNull(lve1.getArgList());
		assertEquals("bar", lve1.getName());
	}
	
	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n W ?10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof WriteArg);
		WriteArg warg = (WriteArg)arg;
		assertNotNull(warg.getFormat());
		assertNull(warg.getExpression());
		assertFalse(warg.isOneChar());
		assertNull(warg.getSource());
		assertTrue(warg.getFormat() instanceof FormatExpression);
		FormatExpression fe = (FormatExpression)warg.getFormat();
		assertEquals("?10", fe.getFormat());
		assertNull(fe.getArgList());
	}
	
	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n W ??10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof WriteArg);
		WriteArg warg = (WriteArg)arg;
		assertNotNull(warg.getFormat());
		assertNull(warg.getExpression());
		assertFalse(warg.isOneChar());
		assertNull(warg.getSource());
		assertTrue(warg.getFormat() instanceof FormatExpression);
		FormatExpression fe = (FormatExpression)warg.getFormat();
		assertEquals("??10", fe.getFormat());
		assertNull(fe.getArgList());

	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n W /SGR() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof WriteArg);
		WriteArg warg = (WriteArg)arg;
		assertNotNull(warg.getFormat());
		assertNull(warg.getExpression());
		assertFalse(warg.isOneChar());
		assertNull(warg.getSource());
		assertTrue(warg.getFormat() instanceof FormatExpression);
		FormatExpression fe = (FormatExpression)warg.getFormat();
		assertEquals("/SGR", fe.getFormat());
		assertNull(fe.getArgList());

	}
	
	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n W /SGR(12) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof WriteArg);
		WriteArg warg = (WriteArg)arg;
		assertNotNull(warg.getFormat());
		assertNull(warg.getExpression());
		assertFalse(warg.isOneChar());
		assertNull(warg.getSource());
		assertTrue(warg.getFormat() instanceof FormatExpression);
		FormatExpression fe = (FormatExpression)warg.getFormat();
		assertEquals("/SGR", fe.getFormat());
		assertNotNull(fe.getArgList());
		assertNotNull(fe.getArgList().getArgList());
		assertEquals(1, fe.getArgList().getArgList().size());
		Arg arg0 = fe.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("12", nconst.getValue());
	}
}

