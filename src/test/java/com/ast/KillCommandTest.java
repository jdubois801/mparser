package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.KillCommand;
import com.ast.expression.GlobalVariableExpression;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;

public class KillCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n KILL foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n K foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
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

		String src = "TEST ;\r\n K\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNull(cc.getArgList());
	}
	
	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n K \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNull(cc.getArgList());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n K:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
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
	public void testFive() throws Exception {

		String src = "TEST ;\r\n K:0 foo,bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n K:0 foo,(bar,grok) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof ExclusiveArg);
		assertNull(arg1.getExpression());
		ExclusiveArg earg1 = (ExclusiveArg)arg1;
		assertNotNull(earg1.getArgList());
		assertNotNull(earg1.getArgList().getArgList());
		assertEquals(2, earg1.getArgList().getArgList().size());
		
		Arg arg2 = earg1.getArgList().getArgList().get(0);
		assertTrue(arg2.getExpression() instanceof LocalVariableExpression);
		lve = (LocalVariableExpression)arg2.getExpression();
		assertEquals("bar", lve.getName());
		assertNull(lve.getArgList());

		Arg arg3 = earg1.getArgList().getArgList().get(1);
		assertTrue(arg3.getExpression() instanceof LocalVariableExpression);
		lve = (LocalVariableExpression)arg3.getExpression();
		assertEquals("grok", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n K:0 (foo,two),(bar,grok) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n K:0 (foo,two),@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ExclusiveArg);
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)arg1.getExpression();
		LocalVariableExpression lve = (LocalVariableExpression)ie.getValue();
		assertEquals("bar", lve.getName());
		assertNull(lve.getArgList());
	}
	
	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n K:0 (@foo,@two),@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n K ^foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof GlobalVariableExpression);
		GlobalVariableExpression gve = (GlobalVariableExpression)arg0.getExpression();
		assertEquals("foo", gve.getName());
		assertNull(gve.getArgList());
		assertNull(gve.getEnvironment());
	}

	@Test
	public void testEleven() throws Exception {

		String src = "TEST ;\r\n K ^|env|foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof GlobalVariableExpression);
		GlobalVariableExpression gve = (GlobalVariableExpression)arg0.getExpression();
		assertEquals("foo", gve.getName());
		assertNull(gve.getArgList());
		assertNotNull(gve.getEnvironment());
		assertTrue(gve.getEnvironment() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)gve.getEnvironment();
		assertEquals("env", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testTwelve() throws Exception {

		String src = "TEST ;\r\n K ^(1) \r\n";  // naked reference
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof GlobalVariableExpression);
		GlobalVariableExpression gve = (GlobalVariableExpression)arg0.getExpression();
		assertNull(gve.getName());
		assertNull(gve.getEnvironment());
		assertNotNull(gve.getArgList());
		assertNotNull(gve.getArgList().getArgList());
		assertEquals(1, gve.getArgList().getArgList().size());

		Arg arg1 = gve.getArgList().getArgList().get(0);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("1", nconst.getValue());
	}
	
	@Test
	public void testThirteen() throws Exception {

		String src = "TEST ;\r\n K @foo \r\n";  // naked reference
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof IndirectExpression);
		IndirectExpression gve = (IndirectExpression)arg0.getExpression();
		assertNull(gve.getIndirectArgList());
		assertNotNull(gve.getValue());
		assertTrue(gve.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)gve.getValue();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}
	
	@Test
	public void testFourteen() throws Exception {

		String src = "TEST ;\r\n K @foo@(1) \r\n";  // naked reference
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, KillCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof KillCommand);
		KillCommand cc = (KillCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof IndirectExpression);
		IndirectExpression gve = (IndirectExpression)arg0.getExpression();
		assertNotNull(gve.getValue());
		assertTrue(gve.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)gve.getValue();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		assertNotNull(gve.getIndirectArgList());
		assertNotNull(gve.getIndirectArgList().getArgList());
		assertEquals(1, gve.getIndirectArgList().getArgList().size());
		Arg arg1 = gve.getIndirectArgList().getArgList().get(0);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)arg1.getExpression();
		assertEquals("1", nconst.getValue());
	}

}

