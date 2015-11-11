package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Command;
import com.ast.Routine;
import com.ast.UseCommand;

public class UseCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n USE foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n U foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n U:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
	
	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n U foo,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n U foo:1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n U foo:1:2 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n U foo:(1:2:3) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n U foo:(1:2:3):mnemonicspace \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
	}
}

