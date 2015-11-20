package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.JobCommand;
import com.ast.expression.NumericConstant;

public class JobCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n JOB ^foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof JobArg);
		JobArg jarg0 = (JobArg)arg0;
		assertNull(jarg0.getJobParams());
		assertNotNull(jarg0.getExpression());
		assertTrue(jarg0.getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)jarg0.getExpression();
		assertNull(eref.getName());
		assertNull(eref.getOffset());
		assertNull(eref.getEnvironment());
		assertEquals("foo",eref.getRoutine());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n J ^foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n J:0 ^foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n J ^foo,^bar,^grok \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(3, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof JobArg);
		JobArg jarg0 = (JobArg)arg0;
		assertNull(jarg0.getJobParams());
		assertNotNull(jarg0.getExpression());
		assertTrue(jarg0.getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)jarg0.getExpression();
		assertNull(eref.getName());
		assertNull(eref.getOffset());
		assertNull(eref.getEnvironment());
		assertEquals("foo",eref.getRoutine());

		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof JobArg);
		JobArg jarg1 = (JobArg)arg1;
		assertNull(jarg1.getJobParams());
		assertNotNull(jarg1.getExpression());
		assertTrue(jarg1.getExpression() instanceof EntryRef);
		eref = (EntryRef)jarg1.getExpression();
		assertNull(eref.getName());
		assertNull(eref.getOffset());
		assertNull(eref.getEnvironment());
		assertEquals("bar",eref.getRoutine());

		Arg arg2 = cc.getArgList().getArgList().get(2);
		assertTrue(arg2 instanceof JobArg);
		JobArg jarg2 = (JobArg)arg2;
		assertNull(jarg2.getJobParams());
		assertNotNull(jarg2.getExpression());
		assertTrue(jarg2.getExpression() instanceof EntryRef);
		eref = (EntryRef)jarg2.getExpression();
		assertNull(eref.getName());
		assertNull(eref.getOffset());
		assertNull(eref.getEnvironment());
		assertEquals("grok",eref.getRoutine());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n J ^routine:10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof JobArg);
		JobArg jarg0 = (JobArg)arg0;
		assertNotNull(jarg0.getExpression());
		assertTrue(jarg0.getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)jarg0.getExpression();
		assertNull(eref.getName());
		assertNull(eref.getOffset());
		assertNull(eref.getEnvironment());
		assertEquals("routine",eref.getRoutine());
	
		assertNotNull(jarg0.getJobParams());
		assertNull(jarg0.getJobParams().getProcessParams());
		assertNotNull(jarg0.getJobParams().getTimeout());
		assertTrue(jarg0.getJobParams().getTimeout() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)jarg0.getJobParams().getTimeout();
		assertEquals("10", nconst.getValue());
	}
	
	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n J ^routine:10 20 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof JobArg);
		JobArg jarg0 = (JobArg)arg0;
		assertNotNull(jarg0.getExpression());
		assertTrue(jarg0.getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)jarg0.getExpression();
		assertNull(eref.getName());
		assertNull(eref.getOffset());
		assertNull(eref.getEnvironment());
		assertEquals("routine",eref.getRoutine());
	
		assertNotNull(jarg0.getJobParams());
		assertNotNull(jarg0.getJobParams().getTimeout());
		assertTrue(jarg0.getJobParams().getTimeout() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)jarg0.getJobParams().getTimeout();
		assertEquals("20", nconst.getValue());

		assertNotNull(jarg0.getJobParams().getProcessParams());
		assertNotNull(jarg0.getJobParams().getProcessParams().getArgList());
		assertEquals(1, jarg0.getJobParams().getProcessParams().getArgList().size());
		Arg arg1 = jarg0.getJobParams().getProcessParams().getArgList().get(0);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		nconst = (NumericConstant)arg1.getExpression();
		assertEquals("10", nconst.getValue());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n J ^routine:(10) 20 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof JobArg);
		JobArg jarg0 = (JobArg)arg0;
		assertNotNull(jarg0.getExpression());
		assertTrue(jarg0.getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)jarg0.getExpression();
		assertNull(eref.getName());
		assertNull(eref.getOffset());
		assertNull(eref.getEnvironment());
		assertEquals("routine",eref.getRoutine());
	
		assertNotNull(jarg0.getJobParams());
		assertNotNull(jarg0.getJobParams().getTimeout());
		assertTrue(jarg0.getJobParams().getTimeout() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)jarg0.getJobParams().getTimeout();
		assertEquals("20", nconst.getValue());

		assertNotNull(jarg0.getJobParams().getProcessParams());
		assertNotNull(jarg0.getJobParams().getProcessParams().getArgList());
		assertEquals(1, jarg0.getJobParams().getProcessParams().getArgList().size());
		Arg arg1 = jarg0.getJobParams().getProcessParams().getArgList().get(0);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		nconst = (NumericConstant)arg1.getExpression();
		assertEquals("10", nconst.getValue());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n J ^routine:(10) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof JobArg);
		JobArg jarg0 = (JobArg)arg0;
		assertNotNull(jarg0.getExpression());
		assertTrue(jarg0.getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)jarg0.getExpression();
		assertNull(eref.getName());
		assertNull(eref.getOffset());
		assertNull(eref.getEnvironment());
		assertEquals("routine",eref.getRoutine());
	
		assertNotNull(jarg0.getJobParams());
		assertNull(jarg0.getJobParams().getTimeout());

		assertNotNull(jarg0.getJobParams().getProcessParams());
		assertNotNull(jarg0.getJobParams().getProcessParams().getArgList());
		assertEquals(1, jarg0.getJobParams().getProcessParams().getArgList().size());
		Arg arg1 = jarg0.getJobParams().getProcessParams().getArgList().get(0);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("10", nconst.getValue());
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n J ^routine:(10:20) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof JobArg);
		JobArg jarg0 = (JobArg)arg0;
		assertNotNull(jarg0.getExpression());
		assertTrue(jarg0.getExpression() instanceof EntryRef);
		EntryRef eref = (EntryRef)jarg0.getExpression();
		assertNull(eref.getName());
		assertNull(eref.getOffset());
		assertNull(eref.getEnvironment());
		assertEquals("routine",eref.getRoutine());
	
		assertNotNull(jarg0.getJobParams());
		assertNull(jarg0.getJobParams().getTimeout());

		assertNotNull(jarg0.getJobParams().getProcessParams());
		assertNotNull(jarg0.getJobParams().getProcessParams().getArgList());
		assertEquals(2, jarg0.getJobParams().getProcessParams().getArgList().size());
		Arg arg1 = jarg0.getJobParams().getProcessParams().getArgList().get(0);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("10", nconst.getValue());
		
		Arg arg2 = jarg0.getJobParams().getProcessParams().getArgList().get(1);
		assertNotNull(arg2.getExpression());
		assertTrue(arg2.getExpression() instanceof NumericConstant);
		nconst = (NumericConstant)arg2.getExpression();
		assertEquals("20", nconst.getValue());
	}

}

