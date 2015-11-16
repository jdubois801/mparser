package com;

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

public class StructuredSystemVariableExpressionTest extends BaseTest {

	@Test
	public void testThirtyTwo() throws Exception {

		String src = "TEST ;\r\n Q:(^$C(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$CHARACTER", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}
	
	@Test
	public void testThirtyThree() throws Exception {

		String src = "TEST ;\r\n Q:(^$CHARACTER(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$CHARACTER", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testThirtyFour() throws Exception {

		String src = "TEST ;\r\n Q:(^$D(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$DEVICE", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testThirtyFive() throws Exception {

		String src = "TEST ;\r\n Q:(^$DEVICE(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$DEVICE", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testThirtySix() throws Exception {

		String src = "TEST ;\r\n Q:(^$G(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$GLOBAL", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testThirtySeven() throws Exception {

		String src = "TEST ;\r\n Q:(^$GLOBAL(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$GLOBAL", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testThirtyEight() throws Exception {

		String src = "TEST ;\r\n Q:(^$J(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$JOB", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testThirtyNine() throws Exception {

		String src = "TEST ;\r\n Q:(^$JOB(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$JOB", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testForty() throws Exception {

		String src = "TEST ;\r\n Q:(^$L(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$LOCK", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortyOne() throws Exception {

		String src = "TEST ;\r\n Q:(^$LOCK(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$LOCK", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortyTwo() throws Exception {

		String src = "TEST ;\r\n Q:(^$R(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$ROUTINE", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortyThree() throws Exception {

		String src = "TEST ;\r\n Q:(^$ROUTINE(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$ROUTINE", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortyFour() throws Exception {

		String src = "TEST ;\r\n Q:(^$S(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$SYSTEM", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortyFive() throws Exception {

		String src = "TEST ;\r\n Q:(^$SYSTEM(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("$SYSTEM", ssvn.getName());
		assertNotNull(ssvn.getArgList());
		assertNotNull(ssvn.getArgList().getArgList());
		assertEquals(1, ssvn.getArgList().getArgList().size());

		Arg arg0 = ssvn.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}


}
