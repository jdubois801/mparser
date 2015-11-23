package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.LockCommand;
import com.ast.expression.GlobalVariableExpression;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;

public class LockCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n LOCK foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n L foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));

		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n L foo,bar \r\n";
		Routine routine = parseAndValidate(src); 
		
		Command cmd = findFirstCommand(routine, LockCommand.class); 
		
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(2, lc.getArgList().getArgList().size());
		
		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lve.getName());
		
		Arg arg1 = lc.getArgList().getArgList().get(1);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof LocalVariableExpression);
		lve = (LocalVariableExpression)arg1.getExpression();
		assertEquals("bar", lve.getName());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n L:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n L +foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the +/- modifier?
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n L -foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the +/- modifier?
	}
	
	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n L (foo,bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof LockArg);
		LockArg earg = (LockArg)arg0;
		assertNull(earg.getExpression());
		assertNotNull(earg.getArgList());
		assertNotNull(earg.getArgList().getArgList());
		assertEquals(2, earg.getArgList().getArgList().size());
		
		Arg arg1 = earg.getArgList().getArgList().get(0);
		assertNotNull(arg1.getExpression());
		assertTrue(arg1.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg1.getExpression();
		assertEquals("foo", lve.getName());
		
		Arg arg2 = earg.getArgList().getArgList().get(1);
		assertNotNull(arg2.getExpression());
		assertTrue(arg2.getExpression() instanceof LocalVariableExpression);
		lve = (LocalVariableExpression)arg2.getExpression();
		assertEquals("bar", lve.getName());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n L foo 10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the timeout?
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n L ^|env|foo(bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n L |env|foo(bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n L ^foo(bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testEleven() throws Exception {

		String src = "TEST ;\r\n L |env|foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testTwelve() throws Exception {

		String src = "TEST ;\r\n L ^foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testThirteen() throws Exception {

		String src = "TEST ;\r\n L |env|foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testFourteen() throws Exception {

		String src = "TEST ;\r\n L @foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof LockArg);
		LockArg larg0 = (LockArg)arg0;
		assertNotNull(larg0.getExpression());
		assertNull(larg0.getTimeout());
		assertNull(larg0.getArgList());
		assertNull(larg0.getAppend());
		
		assertTrue(larg0.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)larg0.getExpression();
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)ie.getValue();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}
	
	@Test
	public void testFifteen() throws Exception {

		String src = "TEST ;\r\n LOCK \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(0, lc.getArgList().getArgList().size());
	}
	
	@Test
	public void testSixteen() throws Exception {

		String src = "TEST ;\r\n LOCK\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(0, lc.getArgList().getArgList().size());
	}

	@Test
	public void testSeventeen() throws Exception {

		String src = "TEST ;\r\n L ()\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof LockArg);
		LockArg larg0 = (LockArg)arg0;
		assertNull(larg0.getAppend());
		assertNull(larg0.getExpression());
		assertNull(larg0.getTimeout());
	}
	
	@Test
	public void testEighteen() throws Exception {

		String src = "TEST ;\r\n L (),()\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(2, lc.getArgList().getArgList().size());
		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof LockArg);
		LockArg larg0 = (LockArg)arg0;
		assertNull(larg0.getAppend());
		assertNull(larg0.getExpression());
		assertNull(larg0.getTimeout());

		Arg arg1 = lc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof LockArg);
		LockArg larg1 = (LockArg)arg1;
		assertNull(larg1.getAppend());
		assertNull(larg1.getExpression());
		assertNull(larg1.getTimeout());

	}

	@Test
	public void testNineteen() throws Exception {

		String src = "TEST ;\r\n L (foo) 1\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof LockArg);
		LockArg larg0 = (LockArg)arg0;
		assertNull(larg0.getExpression());
		assertNotNull(larg0.getTimeout());
	}

	@Test
	public void testTwenty() throws Exception {

		String src = "TEST ;\r\n L +()\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof LockArg);
		LockArg larg0 = (LockArg)arg0;
		assertEquals("+", larg0.getAppend());
		assertNull(larg0.getExpression());
		assertNull(larg0.getTimeout());
	}
	
	@Test
	public void testTwentyOne() throws Exception {

		String src = "TEST ;\r\n L -()\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof LockArg);
		LockArg larg0 = (LockArg)arg0;
		assertEquals("-", larg0.getAppend());
		assertNull(larg0.getExpression());
		assertNull(larg0.getTimeout());
	}

	@Test
	public void testTwentyTwo() throws Exception {

		String src = "TEST ;\r\n L +() 1\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof LockArg);
		LockArg larg0 = (LockArg)arg0;
		assertEquals("+", larg0.getAppend());
		assertNull(larg0.getExpression());
		assertNotNull(larg0.getTimeout());
		assertTrue(larg0.getTimeout() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)larg0.getTimeout();
		assertEquals("1", nconst.getValue());
	}
	
	@Test
	public void testTwentyThree() throws Exception {

		String src = "TEST ;\r\n L -() 1\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof LockArg);
		LockArg larg0 = (LockArg)arg0;
		assertEquals("-", larg0.getAppend());
		assertNull(larg0.getExpression());
		assertNotNull(larg0.getTimeout());
		assertTrue(larg0.getTimeout() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)larg0.getTimeout();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testTwentyFour() throws Exception {

		String src = "TEST ;\r\n L ^foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));

		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof GlobalVariableExpression);
		GlobalVariableExpression gve = (GlobalVariableExpression)arg0.getExpression();
		assertEquals("foo", gve.getName());
		assertNull(gve.getEnvironment());
	}

	@Test
	public void testTwentyFive() throws Exception {

		String src = "TEST ;\r\n L ^|environment|foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));

		Arg arg0 = lc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof GlobalVariableExpression);
		GlobalVariableExpression gve = (GlobalVariableExpression)arg0.getExpression();
		assertEquals("foo", gve.getName());
		assertNotNull(gve.getEnvironment());
		assertTrue(gve.getEnvironment() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)gve.getEnvironment();
		assertEquals("environment", lve.getName());
		assertNull(lve.getArgList());
	}
}


