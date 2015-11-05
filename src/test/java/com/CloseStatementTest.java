package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Command;
import com.ast.CloseCommand;
import com.ast.Routine;
import com.validation.RoutineValidator;

public class CloseStatementTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n CLOSE foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), CloseCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n C foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), CloseCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n C:0 foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), CloseCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
}

