package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.DoCommand;
import com.ast.expression.ActualNameExpression;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;
import com.ast.expression.StringConstant;

public class DoCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n DO foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof EntryRef);
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
		assertNull(lvexpr.getEnvironment());
		assertNull(lvexpr.getOffset());
		assertNull(lvexpr.getRoutine());
		assertNull(lvexpr.getIndirectExpression());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n D foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n D:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n D foo:1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ConditionalArg);
		ConditionalArg carg = (ConditionalArg)arg0;
		
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof EntryRef);
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
		
		assertNotNull(carg.getCondition());
		assertTrue(carg.getCondition() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)carg.getCondition();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n D foo,bar,grok \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(3, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof EntryRef);
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1.getExpression() instanceof EntryRef);
		lvexpr = (EntryRef)arg1.getExpression();
		assertEquals("bar", lvexpr.getName());

		Arg arg2 = cc.getArgList().getArgList().get(2);
		assertTrue(arg2.getExpression() instanceof EntryRef);
		lvexpr = (EntryRef)arg2.getExpression();
		assertEquals("grok", lvexpr.getName());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n D label^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof EntryRef);
		
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertEquals("label", lvexpr.getName());
		assertNull(lvexpr.getEnvironment());
		assertEquals("routine", lvexpr.getRoutine());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n D label+2^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof EntryRef);
		
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertEquals("label", lvexpr.getName());
		assertNull(lvexpr.getEnvironment());
		assertEquals("routine", lvexpr.getRoutine());
		assertEquals("2", lvexpr.getOffset());
	}

	@Test
	public void testSixtyOne() throws Exception {

		String src = "TEST ;\r\n D label^|environment|routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof EntryRef);
		
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertEquals("label", lvexpr.getName());
		//assertEquals("environment", lvexpr.getEnvironment());
		assertEquals("routine", lvexpr.getRoutine());
		assertNull(lvexpr.getOffset());
	}

	@Test
	public void testSixtyTwo() throws Exception {

		String src = "TEST ;\r\n D label+2^|environment|routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof EntryRef);
		
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertEquals("label", lvexpr.getName());
		//assertEquals("environment", lvexpr.getEnvironment());
		assertEquals("routine", lvexpr.getRoutine());
		assertEquals("2", lvexpr.getOffset());
	}

	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n D ^@foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof EntryRef);
		
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertNull(lvexpr.getName());
		assertNull(lvexpr.getEnvironment());
		assertNull(lvexpr.getRoutine());
		assertNull(lvexpr.getOffset());
		assertNotNull(lvexpr.getIndirectExpression());
		assertTrue(lvexpr.getIndirectExpression() instanceof IndirectExpression);
		IndirectExpression iexpr = (IndirectExpression)lvexpr.getIndirectExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr2 = (LocalVariableExpression)iexpr.getValue();
		assertEquals("foo", lvexpr2.getName());
	}

	@Test
	public void testSixtyThree() throws Exception {

		String src = "TEST ;\r\n D label+2^@foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof EntryRef);
		
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertEquals("label", lvexpr.getName());
		assertNull(lvexpr.getEnvironment());
		assertNull(lvexpr.getRoutine());
		assertEquals("2", lvexpr.getOffset());
		
		assertNotNull(lvexpr.getIndirectExpression());
		assertTrue(lvexpr.getIndirectExpression() instanceof IndirectExpression);
		IndirectExpression iexpr = (IndirectExpression)lvexpr.getIndirectExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr2 = (LocalVariableExpression)iexpr.getValue();
		assertEquals("foo", lvexpr2.getName());
	}
	
	@Test
	public void testSixtyFour() throws Exception {

		String src = "TEST ;\r\n D label^@foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof EntryRef);
		
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertEquals("label", lvexpr.getName());
		assertNull(lvexpr.getEnvironment());
		assertNull(lvexpr.getRoutine());
		assertNull(lvexpr.getOffset());
		
		assertNotNull(lvexpr.getIndirectExpression());
		assertTrue(lvexpr.getIndirectExpression() instanceof IndirectExpression);
		IndirectExpression iexpr = (IndirectExpression)lvexpr.getIndirectExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr2 = (LocalVariableExpression)iexpr.getValue();
		assertEquals("foo", lvexpr2.getName());
	}
	
	@Test
	public void testEleven() throws Exception {

		String src = "TEST ;\r\n D &foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertNull(xref.getPackageName());
		assertNull(xref.getRoutine());
		assertNull(xref.getArgList());
	}

	@Test
	public void testTwelve() throws Exception {

		String src = "TEST ;\r\n D &package.foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertNull(xref.getRoutine());
		assertNull(xref.getArgList());
	}
	
	@Test
	public void testThirteen() throws Exception {

		String src = "TEST ;\r\n D &foo^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertNull(xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNull(xref.getArgList());
	}

	@Test
	public void testFourteen() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNull(xref.getArgList());
	}

	@Test
	public void testFifteen() throws Exception {

		String src = "TEST ;\r\n D &foo() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertNull(xref.getPackageName());
		assertNull( xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(0, xref.getArgList().getArgList().size());
	}

	@Test
	public void testSixteen() throws Exception {

		String src = "TEST ;\r\n D &package.foo() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertNull( xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(0, xref.getArgList().getArgList().size());
	}
	
	@Test
	public void testSeventeen() throws Exception {

		String src = "TEST ;\r\n D &foo^routine() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertNull(xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(0, xref.getArgList().getArgList().size());
	}

	@Test
	public void testEighteen() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(0, xref.getArgList().getArgList().size());
	}

	@Test
	public void testNineteen() throws Exception {

		String src = "TEST ;\r\n D &foo(0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertNull(xref.getPackageName());
		assertNull( xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(1, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testTwenty() throws Exception {

		String src = "TEST ;\r\n D &package.foo(0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertNull( xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(1, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("0", nconst.getValue());
	}
	
	@Test
	public void testTwentyOne() throws Exception {

		String src = "TEST ;\r\n D &foo^routine(0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertNull( xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(1, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testTwentyTwo() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine(0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(1, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testTwentyThree() throws Exception {

		String src = "TEST ;\r\n D &foo(0,.name) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertNull(xref.getPackageName());
		assertNull(xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(2, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("0", nconst.getValue());

		arg1 = xref.getArgList().getArgList().get(1);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof ActualNameExpression);
		ActualNameExpression ane = (ActualNameExpression)arg1.getExpression();
		assertEquals("name", ane.getName());
	}

	@Test
	public void testTwentyFour() throws Exception {

		String src = "TEST ;\r\n D &package.foo(0,.name) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertNull(xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(2, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("0", nconst.getValue());

		arg1 = xref.getArgList().getArgList().get(1);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof ActualNameExpression);
		ActualNameExpression ane = (ActualNameExpression)arg1.getExpression();
		assertEquals("name", ane.getName());
	}
	
	@Test
	public void testTwentyFive() throws Exception {

		String src = "TEST ;\r\n D &foo^routine(0,.name) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertNull(xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(2, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("0", nconst.getValue());

		arg1 = xref.getArgList().getArgList().get(1);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof ActualNameExpression);
		ActualNameExpression ane = (ActualNameExpression)arg1.getExpression();
		assertEquals("name", ane.getName());
	}

	@Test
	public void testTwentySix() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine(0,.name) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(2, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("0", nconst.getValue());

		arg1 = xref.getArgList().getArgList().get(1);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof ActualNameExpression);
		ActualNameExpression ane = (ActualNameExpression)arg1.getExpression();
		assertEquals("name", ane.getName());
		assertNull(ane.getIndirectExpression());
	}

	@Test
	public void testSixtySix() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine(0,.@name) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(2, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("0", nconst.getValue());

		arg1 = xref.getArgList().getArgList().get(1);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof ActualNameExpression);
		ActualNameExpression ane = (ActualNameExpression)arg1.getExpression();
		assertNull(ane.getName());
		assertNotNull(ane.getIndirectExpression());
		IndirectExpression iexpr = ane.getIndirectExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)iexpr.getValue();
		assertEquals("name", lvexpr.getName());
	}
	
	@Test
	public void testTwentySeven() throws Exception {

		String src = "TEST ;\r\n D &foo(@bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertNull(xref.getPackageName());
		assertNull( xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(1, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof IndirectExpression);
		IndirectExpression iexpr = (IndirectExpression)arg1.getExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)iexpr.getValue();
		assertEquals("bar", lvexpr.getName());
	}

	@Test
	public void testTwentyEight() throws Exception {

		String src = "TEST ;\r\n D &package.foo(@bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertNull( xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(1, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof IndirectExpression);
		IndirectExpression iexpr = (IndirectExpression)arg1.getExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)iexpr.getValue();
		assertEquals("bar", lvexpr.getName());
	}
	
	@Test
	public void testTwentyNine() throws Exception {

		String src = "TEST ;\r\n D &foo^routine(@bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertNull(xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(1, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof IndirectExpression);
		IndirectExpression iexpr = (IndirectExpression)arg1.getExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)iexpr.getValue();
		assertEquals("bar", lvexpr.getName());
	}

	@Test
	public void testThirty() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine(@bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof ExternRef);
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(1, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof IndirectExpression);
		IndirectExpression iexpr = (IndirectExpression)arg1.getExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)iexpr.getValue();
		assertEquals("bar", lvexpr.getName());
	}
	
	@Test
	public void testThirtyOne() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine(@bar):0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ConditionalArg);
		ConditionalArg carg = (ConditionalArg)arg0;
		
		assertNotNull(carg.getCondition());
		assertTrue(carg.getCondition() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)carg.getCondition();
		assertEquals("0", nconst.getValue());
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(1, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof IndirectExpression);
		IndirectExpression iexpr = (IndirectExpression)arg1.getExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)iexpr.getValue();
		assertEquals("bar", lvexpr.getName());
	}

	@Test
	public void testThirtyTwo() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine(@bar):0,&package.foo^routine(@bar):1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ConditionalArg);
		ConditionalArg carg = (ConditionalArg)arg0;
		
		assertNotNull(carg.getCondition());
		assertTrue(carg.getCondition() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)carg.getCondition();
		assertEquals("0", nconst.getValue());
		
		ExternRef xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(1, xref.getArgList().getArgList().size());
		Arg arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof IndirectExpression);
		IndirectExpression iexpr = (IndirectExpression)arg1.getExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)iexpr.getValue();
		assertEquals("bar", lvexpr.getName());
		
		
		arg0 = cc.getArgList().getArgList().get(1);
		assertTrue(arg0 instanceof ConditionalArg);
		carg = (ConditionalArg)arg0;
		
		assertNotNull(carg.getCondition());
		assertTrue(carg.getCondition() instanceof NumericConstant);
		nconst = (NumericConstant)carg.getCondition();
		assertEquals("1", nconst.getValue());
		
		xref = (ExternRef)arg0.getExpression();
		assertEquals("foo", xref.getLabel());
		assertEquals("package", xref.getPackageName());
		assertEquals("routine", xref.getRoutine());
		assertNotNull(xref.getArgList());
		assertNotNull(xref.getArgList().getArgList());
		assertEquals(1, xref.getArgList().getArgList().size());
		arg1 = xref.getArgList().getArgList().get(0);
		assertNotNull(arg1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof IndirectExpression);
		iexpr = (IndirectExpression)arg1.getExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		lvexpr = (LocalVariableExpression)iexpr.getValue();
		assertEquals("bar", lvexpr.getName());
	}
	
	@Test
	public void testFifty() throws Exception {

		String src = "TEST ;\r\n D ^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof EntryRef);
		
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertNull(lvexpr.getName());
		assertNull(lvexpr.getEnvironment());
		assertEquals("routine", lvexpr.getRoutine());
		assertNull(lvexpr.getOffset());
		assertNull(lvexpr.getIndirectExpression());
	}

	@Test
	public void testFiftyOne() throws Exception {

		String src = "TEST ;\r\n D ^|env|routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof EntryRef);
		
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertNull(lvexpr.getName());
		//assertEquals("env", lvexpr.getEnvironment());
		assertEquals("routine", lvexpr.getRoutine());
		assertNull(lvexpr.getOffset());
		assertNull(lvexpr.getIndirectExpression());
	}

	@Test
	public void testFiftyTwo() throws Exception {

		String src = "TEST ;\r\n D ^@routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0.getExpression() instanceof EntryRef);
		
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		assertNull(lvexpr.getName());
		assertNull(lvexpr.getEnvironment());
		assertNull(lvexpr.getRoutine());
		assertNull(lvexpr.getOffset());
		assertNotNull(lvexpr.getIndirectExpression());
		assertTrue(lvexpr.getIndirectExpression() instanceof IndirectExpression);
		IndirectExpression iexpr = (IndirectExpression)lvexpr.getIndirectExpression();
		assertNotNull(iexpr.getValue());
		assertTrue(iexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr2 = (LocalVariableExpression)iexpr.getValue();
		assertEquals("routine", lvexpr2.getName());
	}

	@Test
	public void testFiftyThree() throws Exception {

		String src = "TEST ;\r\n D ^routine:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFiftyFour() throws Exception {

		String src = "TEST ;\r\n D ^|env|routine:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFiftyFive() throws Exception {

		String src = "TEST ;\r\n D ^@routine:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testSeventy() throws Exception {

		String src = "TEST ;\r\n D label() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LabelRef);
		LabelRef lvexpr = (LabelRef)arg0.getExpression();
		assertEquals("label", lvexpr.getName());
		assertNull(lvexpr.getEnvironment());
		assertNull(lvexpr.getRoutine());
	}

	@Test
	public void testSeventyOne() throws Exception {

		String src = "TEST ;\r\n D label^routine() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LabelRef);
		LabelRef lvexpr = (LabelRef)arg0.getExpression();
		assertEquals("label", lvexpr.getName());
		assertNull(lvexpr.getEnvironment());
		assertEquals("routine", lvexpr.getRoutine());
	}

	@Test
	public void testSeventyTwo() throws Exception {

		String src = "TEST ;\r\n D label^|environment|routine() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LabelRef);
		LabelRef lvexpr = (LabelRef)arg0.getExpression();
		assertEquals("label", lvexpr.getName());
		//assertEquals("environment", lvexpr.getEnvironment());
		assertEquals("routine", lvexpr.getRoutine());
	}

	@Test
	public void testSeventyThree() throws Exception {

		String src = "TEST ;\r\n D ^routine() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LabelRef);
		LabelRef lvexpr = (LabelRef)arg0.getExpression();
		assertNull(lvexpr.getName());
		assertNull(lvexpr.getEnvironment());
		assertEquals("routine", lvexpr.getRoutine());
	}

	@Test
	public void testSeventyFour() throws Exception {

		String src = "TEST ;\r\n D ^|environment|routine() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LabelRef);
		LabelRef lvexpr = (LabelRef)arg0.getExpression();
		assertNull(lvexpr.getName());
		//assertEquals("environment", lvexpr.getEnvironment());
		assertEquals("routine", lvexpr.getRoutine());
	}
}

