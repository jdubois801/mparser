package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.command.QuitCommand;
import com.ast.expression.ExtSyntaxConstant;

public class ExtSyntaxTest extends BaseTest {

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n QUIT foo &SQL(.....)\r\n";
		Routine routine = parseAndValidate(src);
		
		assertNotNull(routine);
		assertEquals("TEST", routine.getName());
		assertNotNull(routine.getLineList());
		assertNotNull(routine.getLineList().getLineList());
		assertEquals(1, routine.getLineList().getLineList().size());
		assertTrue(routine.getLineList().getLineList().get(0) instanceof Line);
		Line line = (Line)routine.getLineList().getLineList().get(0);

		assertNotNull(line.getCommandList());
		assertNotNull(line.getCommandList().getCommandList());
		assertEquals(1, line.getCommandList().getCommandList().size());
		assertNotNull(line.getCommandList().getExtSyntax());

		assertTrue(line.getCommandList().getExtSyntax() instanceof ExtSyntaxConstant);
		ExtSyntaxConstant econst = (ExtSyntaxConstant)line.getCommandList().getExtSyntax();
		assertEquals("sql", econst.getText());  // TODO- get the real text
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n &SQL(.....)\r\n";
		Routine routine = parseAndValidate(src);
		
		assertNotNull(routine);
		assertEquals("TEST", routine.getName());
		assertNotNull(routine.getLineList());
		assertNotNull(routine.getLineList().getLineList());
		assertEquals(1, routine.getLineList().getLineList().size());
		assertTrue(routine.getLineList().getLineList().get(0) instanceof Line);
		Line line = (Line)routine.getLineList().getLineList().get(0);

		assertNotNull(line.getCommandList());
		assertNotNull(line.getCommandList().getCommandList());
		assertEquals(0, line.getCommandList().getCommandList().size());
		assertNotNull(line.getCommandList().getExtSyntax());
		
		assertTrue(line.getCommandList().getExtSyntax() instanceof ExtSyntaxConstant);
		ExtSyntaxConstant econst = (ExtSyntaxConstant)line.getCommandList().getExtSyntax();
		assertEquals("sql", econst.getText());  // TODO- get the real text
	}
}

