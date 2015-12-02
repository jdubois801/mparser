package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.MergeCommand;
import com.ast.expression.GlobalVariableExpression;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;
import com.ast.expression.StructuredSystemVariableExpression;

public class MergeCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n MERGE foo=bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, MergeCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof MergeCommand);
		MergeCommand cc = (MergeCommand)cmd;
		assertNull(cc.getPostCondition());
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof MergeArg);
		MergeArg marg0 = (MergeArg)arg0;
		assertNotNull(marg0.getDestExpression());
		assertTrue(marg0.getDestExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)marg0.getDestExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		assertNotNull(marg0.getExpression());
		assertTrue(marg0.getExpression() instanceof LocalVariableExpression);
		lve = (LocalVariableExpression)marg0.getExpression();
		assertEquals("bar", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n M foo=bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, MergeCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof MergeCommand);
		MergeCommand cc = (MergeCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof MergeArg);
		MergeArg marg0 = (MergeArg)arg0;
		assertNotNull(marg0.getDestExpression());
		assertTrue(marg0.getDestExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)marg0.getDestExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		assertNotNull(marg0.getExpression());
		assertTrue(marg0.getExpression() instanceof LocalVariableExpression);
		lve = (LocalVariableExpression)marg0.getExpression();
		assertEquals("bar", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n M:0 foo=bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, MergeCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof MergeCommand);
		MergeCommand cc = (MergeCommand)cmd;
		assertNotNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof MergeArg);
		MergeArg marg0 = (MergeArg)arg0;
		assertNotNull(marg0.getDestExpression());
		assertTrue(marg0.getDestExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)marg0.getDestExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		assertNotNull(marg0.getExpression());
		assertTrue(marg0.getExpression() instanceof LocalVariableExpression);
		lve = (LocalVariableExpression)marg0.getExpression();
		assertEquals("bar", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n M @one,foo=bar,@two \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, MergeCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof MergeCommand);
		MergeCommand cc = (MergeCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(3, cc.getArgList().getArgList().size());
		
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof MergeArg);
		MergeArg marg0 = (MergeArg)arg0;
		assertNull(marg0.getDestExpression());
		assertNotNull(marg0.getExpression());
		assertTrue(marg0.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)marg0.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve0 = (LocalVariableExpression)ie.getValue();
		assertNull(lve0.getArgList());
		assertEquals("one", lve0.getName());

		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof MergeArg);
		MergeArg marg1 = (MergeArg)arg1;
		assertNotNull(marg1.getDestExpression());
		assertTrue(marg1.getDestExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)marg1.getDestExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		assertNotNull(marg1.getExpression());
		assertTrue(marg1.getExpression() instanceof LocalVariableExpression);
		lve = (LocalVariableExpression)marg1.getExpression();
		assertEquals("bar", lve.getName());
		assertNull(lve.getArgList());
		
		Arg arg2 = cc.getArgList().getArgList().get(2);
		assertTrue(arg2 instanceof MergeArg);
		MergeArg marg2 = (MergeArg)arg2;
		assertNull(marg2.getDestExpression());
		assertNotNull(marg2.getExpression());
		assertTrue(marg2.getExpression() instanceof IndirectExpression);
		ie = (IndirectExpression)marg2.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve2 = (LocalVariableExpression)ie.getValue();
		assertNull(lve2.getArgList());
		assertEquals("two", lve2.getName());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n M foo=bar,one=two \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, MergeCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof MergeCommand);
		MergeCommand cc = (MergeCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof MergeArg);
		MergeArg marg0 = (MergeArg)arg0;
		assertNotNull(marg0.getDestExpression());
		assertTrue(marg0.getDestExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)marg0.getDestExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		assertNotNull(marg0.getExpression());
		assertTrue(marg0.getExpression() instanceof LocalVariableExpression);
		lve = (LocalVariableExpression)marg0.getExpression();
		assertEquals("bar", lve.getName());
		assertNull(lve.getArgList());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof MergeArg);
		MergeArg marg1 = (MergeArg)arg1;
		assertNotNull(marg1.getDestExpression());
		assertTrue(marg1.getDestExpression() instanceof LocalVariableExpression);
		lve = (LocalVariableExpression)marg1.getDestExpression();
		assertEquals("one", lve.getName());
		assertNull(lve.getArgList());
		assertNotNull(marg1.getExpression());
		assertTrue(marg1.getExpression() instanceof LocalVariableExpression);
		lve = (LocalVariableExpression)marg1.getExpression();
		assertEquals("two", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n M ^$S(1:3)=^bar(0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, MergeCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof MergeCommand);
		MergeCommand cc = (MergeCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof MergeArg);
		MergeArg marg0 = (MergeArg)arg0;
		assertNotNull(marg0.getDestExpression());
		assertTrue(marg0.getDestExpression() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssve = (StructuredSystemVariableExpression)marg0.getDestExpression();
		assertEquals("$SYSTEM", ssve.getName());
		assertNotNull(ssve.getArgList());
		assertNotNull(ssve.getArgList().getArgList());
		assertEquals(1, ssve.getArgList().getArgList().size());
		Arg arg1 = ssve.getArgList().getArgList().get(0);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("1", nconst.getValue());
		
		assertNotNull(marg0.getExpression());
		assertTrue(marg0.getExpression() instanceof GlobalVariableExpression);
		GlobalVariableExpression gve = (GlobalVariableExpression)marg0.getExpression();
		assertEquals("bar", gve.getName());
		assertNotNull(gve.getArgList());
		assertNotNull(gve.getArgList().getArgList());
		assertEquals(1, gve.getArgList().getArgList().size());
		Arg arg2 = gve.getArgList().getArgList().get(0);
		assertNotNull(arg2.getExpression());
		assertTrue(arg2.getExpression() instanceof NumericConstant);
		nconst = (NumericConstant)arg2.getExpression();
		assertEquals("0", nconst.getValue());
	}
}

