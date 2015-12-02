package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.SetCommand;
import com.ast.expression.FunctionExpression;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;
import com.ast.expression.StructuredSystemVariableExpression;

public class SetCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n SET foo=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg1 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg1 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg1;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)sla.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n S foo=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg1 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg1 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg1;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)sla.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n S:0 foo=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNotNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg1 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg1 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg1;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)sla.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}
	
	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n S foo=0,@bar,x=y \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(3, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg01 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg01 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg01;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)sla.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof SetArg);
		SetArg sarg1 = (SetArg)arg1;
		assertNotNull(sarg1.getExpression());
		assertNull(sarg1.getLeft());
		assertTrue(sarg1.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)sarg1.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)ie.getValue();
		assertNull(lve1.getArgList());
		assertEquals("bar", lve1.getName());
		
		Arg arg2 = cc.getArgList().getArgList().get(2);
		assertTrue(arg2 instanceof SetArg);
		SetArg sarg2 = (SetArg)arg2;
		assertNull(sarg2.getExpression());
		assertNotNull(sarg2.getLeft());
		assertNotNull(sarg2.getLeft().getArgList());
		assertEquals(1, sarg2.getLeft().getArgList().size());
		Arg arg21 = sarg2.getLeft().getArgList().get(0);
		assertTrue(arg21 instanceof SetLeftArg);
		SetLeftArg sla2 = (SetLeftArg)arg21;
		assertNull(sla2.getRestricted());
		assertNotNull(sla2.getExpression());
		assertTrue(sla2.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve2 = (LocalVariableExpression)sla2.getExpression();
		assertNull(lve2.getArgList());
		assertEquals("x", lve2.getName());
		
		assertNotNull(sarg2.getRight());
		assertTrue(sarg2.getRight() instanceof LocalVariableExpression);
		LocalVariableExpression lve22 = (LocalVariableExpression)sarg2.getRight();
		assertNull(lve22.getArgList());
		assertEquals("y", lve22.getName());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n S (foo,bar)=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(2, sarg0.getLeft().getArgList().size());
		Arg arg1 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg1 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg1;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)sla.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		Arg arg2 = sarg0.getLeft().getArgList().get(1);
		assertTrue(arg2 instanceof SetLeftArg);
		SetLeftArg sla2 = (SetLeftArg)arg2;
		assertNull(sla2.getRestricted());
		assertNotNull(sla2.getExpression());
		assertTrue(sla2.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve2 = (LocalVariableExpression)sla2.getExpression();
		assertNull(lve2.getArgList());
		assertEquals("bar", lve2.getName());

		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}
	
	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n S $X=0,$Y=1,$K=2,$KEY=3,$D=4,$DEVICE=5 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(6, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg01 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg01 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg01;
		assertNotNull(sla.getRestricted());
		assertNull(sla.getExpression());
		assertEquals("$X", sla.getRestricted());
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof SetArg);
		SetArg sarg1 = (SetArg)arg1;
		assertNull(sarg1.getExpression());
		assertNotNull(sarg1.getLeft());
		assertNotNull(sarg1.getLeft().getArgList());
		assertEquals(1, sarg1.getLeft().getArgList().size());
		Arg arg11 = sarg1.getLeft().getArgList().get(0);
		assertTrue(arg11 instanceof SetLeftArg);
		SetLeftArg sla1 = (SetLeftArg)arg11;
		assertNotNull(sla1.getRestricted());
		assertNull(sla1.getExpression());
		assertEquals("$Y", sla1.getRestricted());
		assertNotNull(sarg1.getRight());
		assertTrue(sarg1.getRight() instanceof NumericConstant);
		NumericConstant nconst1 = (NumericConstant)sarg1.getRight();
		assertEquals("1", nconst1.getValue());
		
		Arg arg2 = cc.getArgList().getArgList().get(2);
		assertTrue(arg2 instanceof SetArg);
		SetArg sarg2 = (SetArg)arg2;
		assertNull(sarg2.getExpression());
		assertNotNull(sarg2.getLeft());
		assertNotNull(sarg2.getLeft().getArgList());
		assertEquals(1, sarg2.getLeft().getArgList().size());
		Arg arg21 = sarg2.getLeft().getArgList().get(0);
		assertTrue(arg21 instanceof SetLeftArg);
		SetLeftArg sla2 = (SetLeftArg)arg21;
		assertNotNull(sla2.getRestricted());
		assertNull(sla2.getExpression());
		assertEquals("$KEY", sla2.getRestricted());
		assertNotNull(sarg2.getRight());
		assertTrue(sarg2.getRight() instanceof NumericConstant);
		NumericConstant nconst2 = (NumericConstant)sarg2.getRight();
		assertEquals("2", nconst2.getValue());
		
		Arg arg3 = cc.getArgList().getArgList().get(3);
		assertTrue(arg3 instanceof SetArg);
		SetArg sarg3 = (SetArg)arg3;
		assertNull(sarg3.getExpression());
		assertNotNull(sarg3.getLeft());
		assertNotNull(sarg3.getLeft().getArgList());
		assertEquals(1, sarg3.getLeft().getArgList().size());
		Arg arg31 = sarg3.getLeft().getArgList().get(0);
		assertTrue(arg31 instanceof SetLeftArg);
		SetLeftArg sla3 = (SetLeftArg)arg31;
		assertNotNull(sla3.getRestricted());
		assertNull(sla3.getExpression());
		assertEquals("$KEY", sla3.getRestricted());
		assertNotNull(sarg3.getRight());
		assertTrue(sarg3.getRight() instanceof NumericConstant);
		NumericConstant nconst3 = (NumericConstant)sarg3.getRight();
		assertEquals("3", nconst3.getValue());
		
		Arg arg4 = cc.getArgList().getArgList().get(4);
		assertTrue(arg4 instanceof SetArg);
		SetArg sarg4 = (SetArg)arg4;
		assertNull(sarg4.getExpression());
		assertNotNull(sarg4.getLeft());
		assertNotNull(sarg4.getLeft().getArgList());
		assertEquals(1, sarg4.getLeft().getArgList().size());
		Arg arg41 = sarg4.getLeft().getArgList().get(0);
		assertTrue(arg41 instanceof SetLeftArg);
		SetLeftArg sla4 = (SetLeftArg)arg41;
		assertNotNull(sla4.getRestricted());
		assertNull(sla4.getExpression());
		assertEquals("$DEVICE", sla4.getRestricted());
		assertNotNull(sarg4.getRight());
		assertTrue(sarg4.getRight() instanceof NumericConstant);
		NumericConstant nconst4 = (NumericConstant)sarg4.getRight();
		assertEquals("4", nconst4.getValue());
		
		Arg arg5 = cc.getArgList().getArgList().get(5);
		assertTrue(arg5 instanceof SetArg);
		SetArg sarg5 = (SetArg)arg5;
		assertNull(sarg5.getExpression());
		assertNotNull(sarg5.getLeft());
		assertNotNull(sarg5.getLeft().getArgList());
		assertEquals(1, sarg5.getLeft().getArgList().size());
		Arg arg51 = sarg5.getLeft().getArgList().get(0);
		assertTrue(arg51 instanceof SetLeftArg);
		SetLeftArg sla5 = (SetLeftArg)arg51;
		assertNotNull(sla5.getRestricted());
		assertNull(sla5.getExpression());
		assertEquals("$DEVICE", sla5.getRestricted());
		assertNotNull(sarg5.getRight());
		assertTrue(sarg5.getRight() instanceof NumericConstant);
		NumericConstant nconst5 = (NumericConstant)sarg5.getRight();
		assertEquals("5", nconst5.getValue());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n S $P(foo,1)=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg01 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg01 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg01;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof FunctionExpression);
		FunctionExpression fe = (FunctionExpression)sla.getExpression();
		assertEquals("$PIECE", fe.getName());
		assertNotNull(fe.getArgList());
		assertNotNull(fe.getArgList().getArgList());
		assertEquals(2, fe.getArgList().getArgList().size());
		Arg arg02 = fe.getArgList().getArgList().get(0);
		assertNotNull(arg02.getExpression());
		assertTrue(arg02.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg02.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		Arg arg03 = fe.getArgList().getArgList().get(1);
		assertNotNull(arg03.getExpression());
		assertTrue(arg03.getExpression() instanceof NumericConstant);
		NumericConstant nconst03 = (NumericConstant)arg03.getExpression();
		assertEquals("1", nconst03.getValue());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n S $P(foo,1,2)=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg01 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg01 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg01;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof FunctionExpression);
		FunctionExpression fe = (FunctionExpression)sla.getExpression();
		assertEquals("$PIECE", fe.getName());
		assertNotNull(fe.getArgList());
		assertNotNull(fe.getArgList().getArgList());
		assertEquals(3, fe.getArgList().getArgList().size());
		Arg arg02 = fe.getArgList().getArgList().get(0);
		assertNotNull(arg02.getExpression());
		assertTrue(arg02.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg02.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		Arg arg03 = fe.getArgList().getArgList().get(1);
		assertNotNull(arg03.getExpression());
		assertTrue(arg03.getExpression() instanceof NumericConstant);
		NumericConstant nconst03 = (NumericConstant)arg03.getExpression();
		assertEquals("1", nconst03.getValue());
		
		Arg arg04 = fe.getArgList().getArgList().get(2);
		assertNotNull(arg04.getExpression());
		assertTrue(arg04.getExpression() instanceof NumericConstant);
		NumericConstant nconst04 = (NumericConstant)arg04.getExpression();
		assertEquals("2", nconst04.getValue());

		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n S $P(foo,1,2,3)=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg01 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg01 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg01;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof FunctionExpression);
		FunctionExpression fe = (FunctionExpression)sla.getExpression();
		assertEquals("$PIECE", fe.getName());
		assertNotNull(fe.getArgList());
		assertNotNull(fe.getArgList().getArgList());
		assertEquals(4, fe.getArgList().getArgList().size());
		Arg arg02 = fe.getArgList().getArgList().get(0);
		assertNotNull(arg02.getExpression());
		assertTrue(arg02.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg02.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		Arg arg03 = fe.getArgList().getArgList().get(1);
		assertNotNull(arg03.getExpression());
		assertTrue(arg03.getExpression() instanceof NumericConstant);
		NumericConstant nconst03 = (NumericConstant)arg03.getExpression();
		assertEquals("1", nconst03.getValue());
		
		Arg arg04 = fe.getArgList().getArgList().get(2);
		assertNotNull(arg04.getExpression());
		assertTrue(arg04.getExpression() instanceof NumericConstant);
		NumericConstant nconst04 = (NumericConstant)arg04.getExpression();
		assertEquals("2", nconst04.getValue());

		Arg arg05 = fe.getArgList().getArgList().get(3);
		assertNotNull(arg05.getExpression());
		assertTrue(arg05.getExpression() instanceof NumericConstant);
		NumericConstant nconst05 = (NumericConstant)arg05.getExpression();
		assertEquals("3", nconst05.getValue());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n S $PIECE(foo,1,2,3)=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg01 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg01 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg01;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof FunctionExpression);
		FunctionExpression fe = (FunctionExpression)sla.getExpression();
		assertEquals("$PIECE", fe.getName());
		assertNotNull(fe.getArgList());
		assertNotNull(fe.getArgList().getArgList());
		assertEquals(4, fe.getArgList().getArgList().size());
		Arg arg02 = fe.getArgList().getArgList().get(0);
		assertNotNull(arg02.getExpression());
		assertTrue(arg02.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg02.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		Arg arg03 = fe.getArgList().getArgList().get(1);
		assertNotNull(arg03.getExpression());
		assertTrue(arg03.getExpression() instanceof NumericConstant);
		NumericConstant nconst03 = (NumericConstant)arg03.getExpression();
		assertEquals("1", nconst03.getValue());
		
		Arg arg04 = fe.getArgList().getArgList().get(2);
		assertNotNull(arg04.getExpression());
		assertTrue(arg04.getExpression() instanceof NumericConstant);
		NumericConstant nconst04 = (NumericConstant)arg04.getExpression();
		assertEquals("2", nconst04.getValue());

		Arg arg05 = fe.getArgList().getArgList().get(3);
		assertNotNull(arg05.getExpression());
		assertTrue(arg05.getExpression() instanceof NumericConstant);
		NumericConstant nconst05 = (NumericConstant)arg05.getExpression();
		assertEquals("3", nconst05.getValue());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n S $E(foo,1)=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg01 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg01 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg01;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof FunctionExpression);
		FunctionExpression fe = (FunctionExpression)sla.getExpression();
		assertEquals("$EXTRACT", fe.getName());
		assertNotNull(fe.getArgList());
		assertNotNull(fe.getArgList().getArgList());
		assertEquals(2, fe.getArgList().getArgList().size());
		Arg arg02 = fe.getArgList().getArgList().get(0);
		assertNotNull(arg02.getExpression());
		assertTrue(arg02.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg02.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		Arg arg03 = fe.getArgList().getArgList().get(1);
		assertNotNull(arg03.getExpression());
		assertTrue(arg03.getExpression() instanceof NumericConstant);
		NumericConstant nconst03 = (NumericConstant)arg03.getExpression();
		assertEquals("1", nconst03.getValue());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testEleven() throws Exception {

		String src = "TEST ;\r\n S $E(foo,1,2)=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg01 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg01 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg01;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof FunctionExpression);
		FunctionExpression fe = (FunctionExpression)sla.getExpression();
		assertEquals("$EXTRACT", fe.getName());
		assertNotNull(fe.getArgList());
		assertNotNull(fe.getArgList().getArgList());
		assertEquals(3, fe.getArgList().getArgList().size());
		Arg arg02 = fe.getArgList().getArgList().get(0);
		assertNotNull(arg02.getExpression());
		assertTrue(arg02.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg02.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		Arg arg03 = fe.getArgList().getArgList().get(1);
		assertNotNull(arg03.getExpression());
		assertTrue(arg03.getExpression() instanceof NumericConstant);
		NumericConstant nconst03 = (NumericConstant)arg03.getExpression();
		assertEquals("1", nconst03.getValue());
		
		Arg arg04 = fe.getArgList().getArgList().get(2);
		assertNotNull(arg04.getExpression());
		assertTrue(arg04.getExpression() instanceof NumericConstant);
		NumericConstant nconst04 = (NumericConstant)arg04.getExpression();
		assertEquals("2", nconst04.getValue());

		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testTwelve() throws Exception {

		String src = "TEST ;\r\n S $EXTRACT(foo,1,2)=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg01 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg01 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg01;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof FunctionExpression);
		FunctionExpression fe = (FunctionExpression)sla.getExpression();
		assertEquals("$EXTRACT", fe.getName());
		assertNotNull(fe.getArgList());
		assertNotNull(fe.getArgList().getArgList());
		assertEquals(3, fe.getArgList().getArgList().size());
		Arg arg02 = fe.getArgList().getArgList().get(0);
		assertNotNull(arg02.getExpression());
		assertTrue(arg02.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)arg02.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		Arg arg03 = fe.getArgList().getArgList().get(1);
		assertNotNull(arg03.getExpression());
		assertTrue(arg03.getExpression() instanceof NumericConstant);
		NumericConstant nconst03 = (NumericConstant)arg03.getExpression();
		assertEquals("1", nconst03.getValue());
		
		Arg arg04 = fe.getArgList().getArgList().get(2);
		assertNotNull(arg04.getExpression());
		assertTrue(arg04.getExpression() instanceof NumericConstant);
		NumericConstant nconst04 = (NumericConstant)arg04.getExpression();
		assertEquals("2", nconst04.getValue());

		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}
	
	@Test
	public void testThirteen() throws Exception {

		String src = "TEST ;\r\n S $EC=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg1 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg1 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg1;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssve = (StructuredSystemVariableExpression)sla.getExpression();
		assertNull(ssve.getArgList());
		assertEquals("$ECODE", ssve.getName());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFourteen() throws Exception {

		String src = "TEST ;\r\n S $ECODE=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg1 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg1 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg1;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssve = (StructuredSystemVariableExpression)sla.getExpression();
		assertNull(ssve.getArgList());
		assertEquals("$ECODE", ssve.getName());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFifteen() throws Exception {

		String src = "TEST ;\r\n S $ET=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg1 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg1 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg1;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssve = (StructuredSystemVariableExpression)sla.getExpression();
		assertNull(ssve.getArgList());
		assertEquals("$ETRAP", ssve.getName());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSixteen() throws Exception {

		String src = "TEST ;\r\n S $ETRAP=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof SetArg);
		SetArg sarg0 = (SetArg)arg0;
		assertNull(sarg0.getExpression());
		assertNotNull(sarg0.getLeft());
		assertNotNull(sarg0.getLeft().getArgList());
		assertEquals(1, sarg0.getLeft().getArgList().size());
		Arg arg1 = sarg0.getLeft().getArgList().get(0);
		assertTrue(arg1 instanceof SetLeftArg);
		SetLeftArg sla = (SetLeftArg)arg1;
		assertNull(sla.getRestricted());
		assertNotNull(sla.getExpression());
		assertTrue(sla.getExpression() instanceof StructuredSystemVariableExpression);
		StructuredSystemVariableExpression ssve = (StructuredSystemVariableExpression)sla.getExpression();
		assertNull(ssve.getArgList());
		assertEquals("$ETRAP", ssve.getName());
		
		assertNotNull(sarg0.getRight());
		assertTrue(sarg0.getRight() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)sarg0.getRight();
		assertEquals("0", nconst.getValue());
	}
	
	@Test
	public void testSeventeen() throws Exception {

		String src = "TEST ;\r\n S @H=$S(@H<S:'Q,Q:N)_@H \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		assertNotNull(cc.getArgList());
	}
	
	@Test
	public void testEighteen() throws Exception {

		String src = "TEST ;\r\n F  S F(A,H('L))=C(H(W[(W/S))) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		assertNotNull(cc.getArgList());
	}

	@Test
	public void testNineteen() throws Exception {

		String src = "TEST ;\r\n S H(N?.E)=$O(C(H('$G(N)))) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, SetCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof SetCommand);
		SetCommand cc = (SetCommand)cmd;
		assertNull(cc.getPostCondition());
		assertNotNull(cc.getArgList());
	}
	
}

