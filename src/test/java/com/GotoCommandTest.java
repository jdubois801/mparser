package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Command;
import com.ast.GotoCommand;
import com.ast.Routine;

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
	}
}

