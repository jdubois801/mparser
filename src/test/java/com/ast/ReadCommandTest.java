package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.ReadCommand;
import com.ast.command.WriteCommand;
import com.ast.expression.FormatExpression;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;

public class ReadCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n READ foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n R foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg0;
		assertNull(rarg.getExpression());
		assertNotNull(rarg.getDestination());
		assertTrue(rarg.getDestination() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)rarg.getDestination();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n R:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)cc.getPostCondition().getExpr();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg0;
		assertNull(rarg.getExpression());
		assertNotNull(rarg.getDestination());
		assertTrue(rarg.getDestination() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)rarg.getDestination();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n R \"boo\",foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg0;
		assertNull(rarg.getExpression());
		assertNull(rarg.getDestination());
		assertNull(rarg.getFormat());
		assertEquals("boo", rarg.getLiteral());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof ReadArg);
		ReadArg rarg1 = (ReadArg)arg1;
		assertNull(rarg1.getExpression());
		assertNotNull(rarg1.getDestination());
		assertNull(rarg1.getLiteral());
		assertNull(rarg1.getFormat());
		assertTrue(rarg1.getDestination() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)rarg1.getDestination();
		assertEquals("foo", lve1.getName());
		assertNull(lve1.getArgList());

	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n R foo#10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg0;
		assertNull(rarg.getExpression());
		assertNotNull(rarg.getDestination());
		assertTrue(rarg.getDestination() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)rarg.getDestination();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		assertNotNull(rarg.getReadCount());
		assertTrue(rarg.getReadCount() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)rarg.getReadCount();
		assertEquals("10", nconst.getValue());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n R foo 10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg0;
		assertNull(rarg.getExpression());
		assertNotNull(rarg.getDestination());
		assertTrue(rarg.getDestination() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)rarg.getDestination();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		assertFalse(rarg.isOneChar());

		assertNotNull(rarg.getTimeout());
		assertTrue(rarg.getTimeout() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)rarg.getTimeout();
		assertEquals("10", nconst.getValue());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n R foo#10 11 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg0;
		assertNull(rarg.getExpression());
		assertNotNull(rarg.getDestination());
		assertTrue(rarg.getDestination() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)rarg.getDestination();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		assertNotNull(rarg.getReadCount());
		assertTrue(rarg.getReadCount() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)rarg.getReadCount();
		assertEquals("10", nconst.getValue());
		
		assertNotNull(rarg.getTimeout());
		assertTrue(rarg.getTimeout() instanceof NumericConstant);
		NumericConstant nconst1 = (NumericConstant)rarg.getTimeout();
		assertEquals("11", nconst1.getValue());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n R *foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg0;
		assertNull(rarg.getExpression());
		assertNull(rarg.getTimeout());
		assertNull(rarg.getFormat());
		assertNotNull(rarg.getDestination());
		assertTrue(rarg.getDestination() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)rarg.getDestination();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		assertTrue(rarg.isOneChar());
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n R *foo 10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg0;
		assertNull(rarg.getExpression());
		assertNull(rarg.getFormat());
		assertNotNull(rarg.getDestination());
		assertTrue(rarg.getDestination() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)rarg.getDestination();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		assertTrue(rarg.isOneChar());

		assertNotNull(rarg.getTimeout());
		assertTrue(rarg.getTimeout() instanceof NumericConstant);
		NumericConstant nconst1 = (NumericConstant)rarg.getTimeout();
		assertEquals("10", nconst1.getValue());
	}

	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n R @foo,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg0;
		assertNotNull(rarg.getExpression());
		assertNull(rarg.getFormat());
		assertNull(rarg.getDestination());
		assertNull(rarg.getLiteral());
		assertNull(rarg.getReadCount());
		assertFalse(rarg.isOneChar());
		
		assertTrue(rarg.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)rarg.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)ie.getValue();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof ReadArg);
		ReadArg rarg1 = (ReadArg)arg1;
		assertNotNull(rarg1.getExpression());
		assertNull(rarg1.getFormat());
		assertNull(rarg1.getDestination());
		assertNull(rarg1.getLiteral());
		assertNull(rarg1.getReadCount());
		assertFalse(rarg1.isOneChar());
		
		assertTrue(rarg1.getExpression() instanceof IndirectExpression);
		IndirectExpression ie1 = (IndirectExpression)rarg1.getExpression();
		assertNull(ie1.getIndirectArgList());
		assertNotNull(ie1.getValue());
		assertTrue(ie1.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)ie1.getValue();
		assertNull(lve1.getArgList());
		assertEquals("bar", lve1.getName());
	}
	
	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n R !!##??,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg0;
		assertNull(rarg.getExpression());
		assertNotNull(rarg.getFormat());
		assertNull(rarg.getDestination());
		assertNull(rarg.getLiteral());
		assertNull(rarg.getReadCount());
		assertFalse(rarg.isOneChar());
		
		assertTrue(rarg.getFormat() instanceof FormatExpression);
		FormatExpression fe = (FormatExpression)rarg.getFormat();
		assertEquals("!!##??", fe.getFormat());
		assertNull(fe.getArgList());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof ReadArg);
		ReadArg rarg1 = (ReadArg)arg1;
		assertNotNull(rarg1.getExpression());
		assertNull(rarg1.getFormat());
		assertNull(rarg1.getDestination());
		assertNull(rarg1.getLiteral());
		assertNull(rarg1.getReadCount());
		assertFalse(rarg1.isOneChar());
		
		assertTrue(rarg1.getExpression() instanceof IndirectExpression);
		IndirectExpression ie1 = (IndirectExpression)rarg1.getExpression();
		assertNull(ie1.getIndirectArgList());
		assertNotNull(ie1.getValue());
		assertTrue(ie1.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)ie1.getValue();
		assertNull(lve1.getArgList());
		assertEquals("bar", lve1.getName());
	}

	@Test
	public void testEleven() throws Exception {

		String src = "TEST ;\r\n R ?10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg;
		assertNotNull(rarg.getFormat());
		assertNull(rarg.getExpression());
		assertFalse(rarg.isOneChar());
		assertNull(rarg.getDestination());
		assertTrue(rarg.getFormat() instanceof FormatExpression);
		FormatExpression fe = (FormatExpression)rarg.getFormat();
		assertEquals("?10", fe.getFormat());
		assertNull(fe.getArgList());

	}
	
	@Test
	public void testTwelve() throws Exception {

		String src = "TEST ;\r\n R ??10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg;
		assertNotNull(rarg.getFormat());
		assertNull(rarg.getExpression());
		assertFalse(rarg.isOneChar());
		assertNull(rarg.getDestination());
		assertTrue(rarg.getFormat() instanceof FormatExpression);
		FormatExpression fe = (FormatExpression)rarg.getFormat();
		assertEquals("??10", fe.getFormat());
		assertNull(fe.getArgList());

	}

	@Test
	public void testThirteen() throws Exception {

		String src = "TEST ;\r\n R /SGR() \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof ReadArg);
		ReadArg rarg = (ReadArg)arg;
		assertNotNull(rarg.getFormat());
		assertNull(rarg.getExpression());
		assertFalse(rarg.isOneChar());
		assertNull(rarg.getDestination());
		assertTrue(rarg.getFormat() instanceof FormatExpression);
		FormatExpression fe = (FormatExpression)rarg.getFormat();
		assertEquals("/SGR", fe.getFormat());
		assertNull(fe.getArgList());
	}

}

