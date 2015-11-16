package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.MergeCommand;

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
	}

}

