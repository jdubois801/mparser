package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.CloseCommand;
import com.ast.Command;
import com.ast.ViewCommand;
import com.ast.Routine;
import com.validation.RoutineValidator;

public class ViewCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n VIEW \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ViewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ViewCommand);
		ViewCommand cc = (ViewCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n V \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ViewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ViewCommand);
		ViewCommand cc = (ViewCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n V:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ViewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ViewCommand);
		ViewCommand cc = (ViewCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
}

