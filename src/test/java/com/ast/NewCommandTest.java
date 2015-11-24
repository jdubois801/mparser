package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.NewCommand;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.StructuredSystemVariableExpression;

public class NewCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n NEW foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n N foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n N:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n N @one,foo,@two \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(3, cc.getArgList().getArgList().size());

		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)arg0.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve0 = (LocalVariableExpression)ie.getValue();
		assertEquals("one", lve0.getName());
		assertNull(lve0.getArgList());

		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg1.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		Arg arg2 = cc.getArgList().getArgList().get(2);
		assertNotNull(arg2.getExpression());
		assertTrue(arg2.getExpression() instanceof IndirectExpression);
		IndirectExpression ie2 = (IndirectExpression)arg2.getExpression();
		assertNull(ie2.getIndirectArgList());
		assertNotNull(ie2.getValue());
		assertTrue(ie2.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve2 = (LocalVariableExpression)ie2.getValue();
		assertEquals("two", lve2.getName());
		assertNull(lve2.getArgList());

	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n N foo,bar,%1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(3, cc.getArgList().getArgList().size());

		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)arg1.getExpression();
		assertEquals("bar", lve1.getName());
		assertNull(lve1.getArgList());

		Arg arg2 = cc.getArgList().getArgList().get(2);
		assertNotNull(arg2.getExpression());
		assertTrue(arg2.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve2 = (LocalVariableExpression)arg2.getExpression();
		assertEquals("%1", lve2.getName());
		assertNull(lve2.getArgList());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n N (foo,bar),(%1,%2),%3 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(3, cc.getArgList().getArgList().size());

		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ExclusiveArg);
		ExclusiveArg earg0 = (ExclusiveArg)arg0;
		assertNull(earg0.getExpression());
		assertNotNull(earg0.getArgList());
		assertNotNull(earg0.getArgList().getArgList());
		assertEquals(2, earg0.getArgList().getArgList().size());
		
		Arg arg00 = earg0.getArgList().getArgList().get(0);
		assertNotNull(arg00.getExpression());
		assertTrue(arg00.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve00 = (LocalVariableExpression)arg00.getExpression();
		assertEquals("foo", lve00.getName());
		assertNull(lve00.getArgList());
		
		Arg arg01 = earg0.getArgList().getArgList().get(1);
		assertNotNull(arg01.getExpression());
		assertTrue(arg01.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve01 = (LocalVariableExpression)arg01.getExpression();
		assertEquals("bar", lve01.getName());
		assertNull(lve01.getArgList());

		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof ExclusiveArg);
		ExclusiveArg earg1 = (ExclusiveArg)arg1;
		assertNull(earg1.getExpression());
		assertNotNull(earg1.getArgList());
		assertNotNull(earg1.getArgList().getArgList());
		assertEquals(2, earg1.getArgList().getArgList().size());
		
		Arg arg10 = earg1.getArgList().getArgList().get(0);
		assertNotNull(arg10.getExpression());
		assertTrue(arg10.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve10 = (LocalVariableExpression)arg10.getExpression();
		assertEquals("%1", lve10.getName());
		assertNull(lve10.getArgList());

		Arg arg11 = earg1.getArgList().getArgList().get(1);
		assertNotNull(arg11.getExpression());
		assertTrue(arg11.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve11 = (LocalVariableExpression)arg11.getExpression();
		assertEquals("%2", lve11.getName());
		assertNull(lve11.getArgList());
		
		Arg arg2 = cc.getArgList().getArgList().get(2);
		assertNotNull(arg2.getExpression());
		assertTrue(arg2.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve2 = (LocalVariableExpression)arg2.getExpression();
		assertEquals("%3", lve2.getName());
		assertNull(lve2.getArgList());	
	}
	
	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n NEW\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNull(cc.getArgList());
	}
	
	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n NEW $ET\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)arg0.getExpression();
		assertEquals("$ETRAP", ssvn.getName());
		assertNull(ssvn.getArgList());
	}
	
	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n NEW $ETRAP\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)arg0.getExpression();
		assertEquals("$ETRAP", ssvn.getName());
		assertNull(ssvn.getArgList());
	}

	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n NEW $ES\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)arg0.getExpression();
		assertEquals("$ESTACK", ssvn.getName());
		assertNull(ssvn.getArgList());
	}
	
	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n NEW $ESTACK\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, NewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssvn = (StructuredSystemVariableExpression)arg0.getExpression();
		assertEquals("$ESTACK", ssvn.getName());
		assertNull(ssvn.getArgList());
	}

}

