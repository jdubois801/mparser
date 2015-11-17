package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.command.QuitCommand;

public class FormalLineTest extends BaseTest {

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\nlabel QUIT foo \r\n";
		Routine routine = parseAndValidate(src);
		
		assertNotNull(routine);
		assertEquals("TEST", routine.getName());
		assertNotNull(routine.getLineList());
		assertNotNull(routine.getLineList().getLineList());
		assertEquals(1, routine.getLineList().getLineList().size());
		assertTrue(routine.getLineList().getLineList().get(0) instanceof LabelLine);
		LabelLine lLine = (LabelLine)routine.getLineList().getLineList().get(0);
		assertEquals("label", lLine.getLabel());
		
		assertNotNull(lLine.getCommandList());
		assertNotNull(lLine.getCommandList().getCommandList());
		assertEquals(1, lLine.getCommandList().getCommandList().size());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\nlabel() QUIT foo \r\n";
		Routine routine = parseAndValidate(src);
		
		assertNotNull(routine);
		assertEquals("TEST", routine.getName());
		assertNotNull(routine.getLineList());
		assertNotNull(routine.getLineList().getLineList());
		assertEquals(1, routine.getLineList().getLineList().size());
		assertTrue(routine.getLineList().getLineList().get(0) instanceof FormalLine);
		FormalLine fLine = (FormalLine)routine.getLineList().getLineList().get(0);
		assertEquals("label", fLine.getLabel());
		
		assertNotNull(fLine.getCommandList());
		assertNotNull(fLine.getCommandList().getCommandList());
		assertEquals(1, fLine.getCommandList().getCommandList().size());
		assertTrue(fLine.getCommandList().getCommandList().get(0) instanceof QuitCommand);
		
		assertNotNull(fLine.getParamList());
		assertNotNull(fLine.getParamList().getParamList());
		assertEquals(0, fLine.getParamList().getParamList().size());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\nlabel(bar) QUIT foo \r\n";
		Routine routine = parseAndValidate(src);
		
		assertNotNull(routine);
		assertEquals("TEST", routine.getName());
		assertNotNull(routine.getLineList());
		assertNotNull(routine.getLineList().getLineList());
		assertEquals(1, routine.getLineList().getLineList().size());

		assertTrue(routine.getLineList().getLineList().get(0) instanceof FormalLine);
		FormalLine fLine = (FormalLine)routine.getLineList().getLineList().get(0);
		assertEquals("label", fLine.getLabel());
		
		assertNotNull(fLine.getCommandList());
		assertNotNull(fLine.getCommandList().getCommandList());
		assertEquals(1, fLine.getCommandList().getCommandList().size());
		assertTrue(fLine.getCommandList().getCommandList().get(0) instanceof QuitCommand);

		assertNotNull(fLine.getParamList());
		assertNotNull(fLine.getParamList().getParamList());
		assertEquals(1, fLine.getParamList().getParamList().size());
		
		Param param = fLine.getParamList().getParamList().get(0);
		assertEquals("bar", param.getName());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\nlabel(bar,next) QUIT foo \r\n";
		Routine routine = parseAndValidate(src);
		
		assertNotNull(routine);
		assertEquals("TEST", routine.getName());
		assertNotNull(routine.getLineList());
		assertNotNull(routine.getLineList().getLineList());
		assertEquals(1, routine.getLineList().getLineList().size());

		assertTrue(routine.getLineList().getLineList().get(0) instanceof FormalLine);
		FormalLine fLine = (FormalLine)routine.getLineList().getLineList().get(0);
		assertEquals("label", fLine.getLabel());
		
		assertNotNull(fLine.getCommandList());
		assertNotNull(fLine.getCommandList().getCommandList());
		assertEquals(1, fLine.getCommandList().getCommandList().size());
		assertTrue(fLine.getCommandList().getCommandList().get(0) instanceof QuitCommand);

		assertNotNull(fLine.getParamList());
		assertNotNull(fLine.getParamList().getParamList());
		assertEquals(2, fLine.getParamList().getParamList().size());
		
		Param param = fLine.getParamList().getParamList().get(0);
		assertEquals("bar", param.getName());
		
		param = fLine.getParamList().getParamList().get(1);
		assertEquals("next", param.getName());
	}
}

