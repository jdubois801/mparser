package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.KillCommand;

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
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n K:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n K:0 foo,bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n K:0 foo,(bar,grok) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n K:0 (foo,two),(bar,grok) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n K:0 (foo,two),@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
	
	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n K:0 (@foo,@two),@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

}

