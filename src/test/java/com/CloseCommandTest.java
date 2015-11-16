package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.CloseCommand;
import com.ast.command.Command;

public class CloseCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n CLOSE foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n C foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n C:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n C foo:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n C foo:bar=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n C foo:(bar=0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n C foo:(devicekeyword:bar=0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n C @foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

}

