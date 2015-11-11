package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Command;
import com.ast.HaltCommand;
import com.ast.Routine;

public class HaltCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n HALT \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HaltCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HaltCommand);
		HaltCommand cc = (HaltCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n H \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HaltCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HaltCommand);
		HaltCommand cc = (HaltCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n H:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HaltCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HaltCommand);
		HaltCommand cc = (HaltCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
}

