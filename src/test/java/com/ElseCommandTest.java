package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Command;
import com.ast.ElseCommand;
import com.ast.Routine;
import com.validation.RoutineValidator;

public class ElseCommandTest extends BaseTest {

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n E \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), ElseCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof ElseCommand);
		ElseCommand cc = (ElseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		System.err.println("cmd = " + cmd);
	}

}
