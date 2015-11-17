package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.NewCommand;

public class NewCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n NEW foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n N foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n N:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n N @one,foo,@two \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n N foo,bar,%1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n N (foo,bar),(%1,%2),%3 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
	}
}

