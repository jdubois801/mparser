package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.GotoCommand;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;

public class GotoCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n GOTO foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, GotoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n G foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, GotoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n G:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, GotoCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)cc.getPostCondition().getExpr();
		assertEquals("0", nconst.getValue());
	}
	
	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n G:0 foo:1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, GotoCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n G @bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, GotoCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof IndirectExpression);
		IndirectExpression iref = (IndirectExpression)arg0.getExpression();
		assertNotNull(iref.getValue());
		assertTrue(iref.getValue()instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)iref.getValue();
		assertEquals("bar", lvexpr.getName());
	}
	
	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n G ^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, GotoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)arg0.getExpression();
		assertNull(eref.getName());
		assertEquals("routine", eref.getRoutine());
	}
	
	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n G label^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, GotoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)arg0.getExpression();
		assertEquals("label", eref.getName());
		assertEquals("routine", eref.getRoutine());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n G label+2^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, GotoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)arg0.getExpression();
		assertEquals("label", eref.getName());
		assertEquals("2", eref.getOffset());
		assertEquals("routine", eref.getRoutine());
	}
	
	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n G label+2^|environment|routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, GotoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)arg0.getExpression();
		assertEquals("label", eref.getName());
		assertEquals("2", eref.getOffset());
//		assertEquals("environment", eref.getEnvironment());
		assertEquals("routine", eref.getRoutine());
	}
	
	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n G ^routine:0,^bar:1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, GotoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ConditionalArg);
		assertNotNull(((ConditionalArg)arg0).getCondition());
		assertTrue(((ConditionalArg)arg0).getCondition() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)((ConditionalArg)arg0).getCondition();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(((ConditionalArg)arg0).getExpression());
		assertTrue(((ConditionalArg)arg0).getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)((ConditionalArg)arg0).getExpression();
		assertNull(eref.getName());
		assertEquals("routine", eref.getRoutine());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof ConditionalArg);
		assertNotNull(((ConditionalArg)arg1).getCondition());
		assertTrue(((ConditionalArg)arg1).getCondition() instanceof NumericConstant);
		nconst = (NumericConstant)((ConditionalArg)arg1).getCondition();
		assertEquals("1", nconst.getValue());
		
		assertNotNull(((ConditionalArg)arg1).getExpression());
		assertTrue(((ConditionalArg)arg1).getExpression() instanceof EntryRef);
		eref = (EntryRef)((ConditionalArg)arg1).getExpression();
		assertNull(eref.getName());
		assertEquals("bar", eref.getRoutine());
	}
}

