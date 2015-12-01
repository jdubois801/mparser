package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.OpenCommand;
import com.ast.expression.BinaryExpression;
import com.ast.expression.Expression;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;

public class OpenCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n OPEN foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n O foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n O:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNotNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n O foo,1+2 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof OpenArg);
		OpenArg oarg1 = (OpenArg)arg1;
		assertNull(oarg1.getOpenArgs());
		assertNotNull(oarg1.getExpression());
		assertTrue(oarg1.getExpression() instanceof BinaryExpression);
		BinaryExpression be = (BinaryExpression)oarg1.getExpression();
		assertEquals("+", be.getOperator());
		assertNotNull(be.getLeftExpression());
		assertTrue(be.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)be.getLeftExpression();
		assertEquals("1", nconst.getValue());
		
		assertNotNull(be.getRightExpression());
		assertTrue(be.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)be.getRightExpression();
		assertEquals("2", nconst.getValue());
	}
	
	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n O foo:1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		assertNotNull(oarg0.getOpenParams());
		assertNull(oarg0.getOpenParams().getMnemonicSpaceList());
		assertNotNull(oarg0.getOpenParams().getTimeout());
		assertNull(oarg0.getOpenParams().getDeviceParamList());
		assertTrue(oarg0.getOpenParams().getTimeout() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)oarg0.getOpenParams().getTimeout();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n O @one,foo,@two \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(3, cc.getArgList().getArgList().size());
		
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)oarg0.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)ie.getValue();
		assertEquals("one", lve.getName());
		assertNull(lve.getArgList());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof OpenArg);
		OpenArg oarg1 = (OpenArg)arg1;
		assertNull(oarg1.getOpenArgs());
		assertNotNull(oarg1.getExpression());
		assertTrue(oarg1.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)oarg1.getExpression();
		assertEquals("foo", lve1.getName());
		assertNull(lve1.getArgList());
		
		Arg arg2 = cc.getArgList().getArgList().get(2);
		assertTrue(arg2 instanceof OpenArg);
		OpenArg oarg2 = (OpenArg)arg2;
		assertNull(oarg2.getOpenArgs());
		assertNotNull(oarg2.getExpression());
		assertTrue(oarg2.getExpression() instanceof IndirectExpression);
		IndirectExpression ie2 = (IndirectExpression)oarg2.getExpression();
		assertNull(ie2.getIndirectArgList());
		assertNotNull(ie2.getValue());
		assertTrue(ie2.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve2 = (LocalVariableExpression)ie2.getValue();
		assertEquals("two", lve2.getName());
		assertNull(lve2.getArgList());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n O foo:1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		assertNotNull(oarg0.getOpenParams());
		assertNull(oarg0.getOpenParams().getMnemonicSpaceList());
		assertNotNull(oarg0.getOpenParams().getTimeout());
		assertNull(oarg0.getOpenParams().getDeviceParamList());
		assertTrue(oarg0.getOpenParams().getTimeout() instanceof NumericConstant);
				
		NumericConstant nconst = (NumericConstant)oarg0.getOpenParams().getTimeout();
		assertEquals("1", nconst.getValue());
	}
	
	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n O foo:1:mnemonic \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		assertNotNull(oarg0.getOpenParams());
		assertNotNull(oarg0.getOpenParams().getMnemonicSpaceList());
		assertNotNull(oarg0.getOpenParams().getTimeout());
		assertNull(oarg0.getOpenParams().getDeviceParamList());

		assertTrue(oarg0.getOpenParams().getTimeout() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)oarg0.getOpenParams().getTimeout();
		assertEquals("1", nconst.getValue());
		
		assertNotNull(oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList());
		assertEquals(1, oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList().size());
		Expression ex = oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList().get(0);
		assertTrue(ex instanceof LocalVariableExpression);
		LocalVariableExpression lve0 = (LocalVariableExpression)ex;
		assertEquals("mnemonic", lve0.getName());
		assertNull(lve0.getArgList());
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n O foo:::mnemonic \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		assertNotNull(oarg0.getOpenParams());
		assertNotNull(oarg0.getOpenParams().getMnemonicSpaceList());
		assertNull(oarg0.getOpenParams().getTimeout());
		assertNull(oarg0.getOpenParams().getDeviceParamList());

		assertNotNull(oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList());
		assertEquals(1, oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList().size());
		Expression ex = oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList().get(0);
		assertTrue(ex instanceof LocalVariableExpression);
		LocalVariableExpression lve0 = (LocalVariableExpression)ex;
		assertEquals("mnemonic", lve0.getName());
		assertNull(lve0.getArgList());
	}

	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n O foo:a=b::mnemonic \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		assertNotNull(oarg0.getOpenParams());
		assertNotNull(oarg0.getOpenParams().getMnemonicSpaceList());
		assertNull(oarg0.getOpenParams().getTimeout());
		assertNotNull(oarg0.getOpenParams().getDeviceParamList());

		assertNotNull(oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList());
		assertEquals(1, oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList().size());
		Expression ex = oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList().get(0);
		assertTrue(ex instanceof LocalVariableExpression);
		LocalVariableExpression lve0 = (LocalVariableExpression)ex;
		assertEquals("mnemonic", lve0.getName());
		assertNull(lve0.getArgList());
	}

	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n O foo:a=b \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		assertNotNull(oarg0.getOpenParams());
		assertNull(oarg0.getOpenParams().getMnemonicSpaceList());
		assertNull(oarg0.getOpenParams().getTimeout());
		assertNotNull(oarg0.getOpenParams().getDeviceParamList());

	}

	@Test
	public void testEleven() throws Exception {

		String src = "TEST ;\r\n O foo:a=b 1\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		assertNotNull(oarg0.getOpenParams());
		assertNull(oarg0.getOpenParams().getMnemonicSpaceList());
		assertNotNull(oarg0.getOpenParams().getTimeout());
		assertNotNull(oarg0.getOpenParams().getDeviceParamList());

		assertTrue(oarg0.getOpenParams().getTimeout() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)oarg0.getOpenParams().getTimeout();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testTwelve() throws Exception {

		String src = "TEST ;\r\n O foo:a=b 1:mnemonic\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof OpenArg);
		OpenArg oarg0 = (OpenArg)arg0;
		assertNull(oarg0.getOpenArgs());
		assertNotNull(oarg0.getExpression());
		assertTrue(oarg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)oarg0.getExpression();
		assertEquals("foo", lve.getName());
		assertNull(lve.getArgList());
		
		assertNotNull(oarg0.getOpenParams());
		assertNotNull(oarg0.getOpenParams().getMnemonicSpaceList());
		assertNotNull(oarg0.getOpenParams().getTimeout());
		assertNotNull(oarg0.getOpenParams().getDeviceParamList());

		assertTrue(oarg0.getOpenParams().getTimeout() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)oarg0.getOpenParams().getTimeout();
		assertEquals("1", nconst.getValue());
		
		assertNotNull(oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList());
		assertEquals(1, oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList().size());
		Expression ex = oarg0.getOpenParams().getMnemonicSpaceList().getSpaceList().get(0);
		assertTrue(ex instanceof LocalVariableExpression);
		LocalVariableExpression lve0 = (LocalVariableExpression)ex;
		assertEquals("mnemonic", lve0.getName());
		assertNull(lve0.getArgList());
	}

}

