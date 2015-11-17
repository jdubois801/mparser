package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.DoCommand;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;

public class DoCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n DO foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof EntryRef);
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n D foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n D:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n D foo:1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ConditionalArg);
		ConditionalArg carg = (ConditionalArg)arg0;
		
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof EntryRef);
		EntryRef lvexpr = (EntryRef)arg0.getExpression();
		
		assertNotNull(carg.getCondition());
		assertTrue(carg.getCondition() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)carg.getCondition();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n D foo,bar,grok \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n D label^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n D label+2^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n D @foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testEleven() throws Exception {

		String src = "TEST ;\r\n D &foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwelve() throws Exception {

		String src = "TEST ;\r\n D &package.foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testThirteen() throws Exception {

		String src = "TEST ;\r\n D &foo^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFourteen() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFifteen() throws Exception {

		String src = "TEST ;\r\n D &foo() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testSixteen() throws Exception {

		String src = "TEST ;\r\n D &package.foo() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testSeventeen() throws Exception {

		String src = "TEST ;\r\n D &foo^routine() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testEighteen() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testNineteen() throws Exception {

		String src = "TEST ;\r\n D &foo(0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwenty() throws Exception {

		String src = "TEST ;\r\n D &package.foo(0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testTwentyOne() throws Exception {

		String src = "TEST ;\r\n D &foo^routine(0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwentyTwo() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine(0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwentyThree() throws Exception {

		String src = "TEST ;\r\n D &foo(0,.name) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwentyFour() throws Exception {

		String src = "TEST ;\r\n D &package.foo(0,.name) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testTwentyFive() throws Exception {

		String src = "TEST ;\r\n D &foo^routine(0,.name) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwentySix() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine(0,.name) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwentySeven() throws Exception {

		String src = "TEST ;\r\n D &foo(@bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwentyEight() throws Exception {

		String src = "TEST ;\r\n D &package.foo(@bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testTwentyNine() throws Exception {

		String src = "TEST ;\r\n D &foo^routine(@bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testThirty() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine(@bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testThirtyOne() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine(@bar):0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testThirtyTwo() throws Exception {

		String src = "TEST ;\r\n D &package.foo^routine(@bar):0,&package.foo^routine(@bar):1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testFifty() throws Exception {

		String src = "TEST ;\r\n D ^routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFiftyOne() throws Exception {

		String src = "TEST ;\r\n D ^|env|routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFiftyTwo() throws Exception {

		String src = "TEST ;\r\n D ^@routine \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFiftyThree() throws Exception {

		String src = "TEST ;\r\n D ^routine:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFiftyFour() throws Exception {

		String src = "TEST ;\r\n D ^|env|routine:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFiftyFive() throws Exception {

		String src = "TEST ;\r\n D ^@routine:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, DoCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof DoCommand);
		DoCommand cc = (DoCommand)cmd;
		assertNull(cc.getPostCondition());
	}


//	@Test
//	public void testSixty() throws Exception {
//
//		String src = "TEST ;\r\n D label() \r\n";
//		Routine routine = parseAndValidate(src); 
//		Command cmd = findFirstCommand(routine, DoCommand.class);
//
//		assertNotNull(cmd);
//		assertTrue(cmd instanceof DoCommand);
//		DoCommand cc = (DoCommand)cmd;
//		assertNull(cc.getPostCondition());
//	}
//
//	@Test
//	public void testSixtyOne() throws Exception {
//
//		String src = "TEST ;\r\n D label^routine() \r\n";
//		Routine routine = parseAndValidate(src); 
//		Command cmd = findFirstCommand(routine, DoCommand.class);
//
//		assertNotNull(cmd);
//		assertTrue(cmd instanceof DoCommand);
//		DoCommand cc = (DoCommand)cmd;
//		assertNull(cc.getPostCondition());
//	}
//
//	@Test
//	public void testSixtyTwo() throws Exception {
//
//		String src = "TEST ;\r\n D label^|environment|routine() \r\n";
//		Routine routine = parseAndValidate(src); 
//		Command cmd = findFirstCommand(routine, DoCommand.class);
//
//		assertNotNull(cmd);
//		assertTrue(cmd instanceof DoCommand);
//		DoCommand cc = (DoCommand)cmd;
//		assertNull(cc.getPostCondition());
//	}
}

