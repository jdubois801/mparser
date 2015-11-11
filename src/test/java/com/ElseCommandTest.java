package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Command;
import com.ast.ElseCommand;
import com.ast.Routine;

public class ElseCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n ELSE \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ElseCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof ElseCommand);
		ElseCommand cc = (ElseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n E \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ElseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ElseCommand);
		ElseCommand cc = (ElseCommand)cmd;
		assertNull(cc.getPostCondition());
	}
}
