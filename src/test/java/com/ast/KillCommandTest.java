package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.KillCommand;
import com.ast.expression.LocalVariableExpression;

public class KillCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n KILL foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n K foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n K\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNull(cc.getArgList());
	}
	
	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n K \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNull(cc.getArgList());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n K:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n K:0 foo,bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n K:0 foo,(bar,grok) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n K:0 (foo,two),(bar,grok) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n K:0 (foo,two),@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
	
	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n K:0 (@foo,@two),@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

}

