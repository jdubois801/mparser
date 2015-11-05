package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Command;
import com.ast.MergeCommand;
import com.ast.Routine;
import com.validation.RoutineValidator;

public class MergeCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n MERGE foo=bar \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), MergeCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof MergeCommand);
		MergeCommand cc = (MergeCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n M foo=bar \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), MergeCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof MergeCommand);
		MergeCommand cc = (MergeCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n M:0 foo=bar \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), MergeCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof MergeCommand);
		MergeCommand cc = (MergeCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
}

