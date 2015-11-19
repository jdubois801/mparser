package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.expression.ExtSyntaxConstant;

public class ExtSyntaxTest extends BaseTest {

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n QUIT foo &SQL(select 1 from dual)\r\n";
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
		assertEquals("select 1 from dual", econst.getText());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n &SQL(select 1 from dual)\r\n";
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
		assertEquals("select 1 from dual", econst.getText());
	}
	
	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n &SQL(select (s.name,sa.age) from dbo.students s join dbo.student_age sa on sa.sid=s.sid where (sa.age>12))\r\n";
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
		assertEquals("select (s.name,sa.age) from dbo.students s join dbo.student_age sa on sa.sid=s.sid where (sa.age>12)", econst.getText());
	}

}

