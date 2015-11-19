package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.HangCommand;
import com.ast.expression.NumericConstant;

public class HangCommandTest extends BaseTest {

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n HANG 10\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HangCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HangCommand);
		HangCommand cc = (HangCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n H 10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HangCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HangCommand);
		HangCommand cc = (HangCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n H:0 10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HangCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HangCommand);
		HangCommand cc = (HangCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)cc.getPostCondition().getExpr();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof NumericConstant);
		nconst = (NumericConstant)arg0.getExpression();
		assertEquals("10", nconst.getValue());
	}
	
	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n H:0 10,20 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HangCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HangCommand);
		HangCommand cc = (HangCommand)cmd;
		assertNotNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("10", nconst.getValue());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		nconst = (NumericConstant)arg1.getExpression();
		assertEquals("20", nconst.getValue());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n H:0 10,@bar,@foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HangCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HangCommand);
		HangCommand cc = (HangCommand)cmd;
		assertNotNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(3, cc.getArgList().getArgList().size());
	}
	
}

