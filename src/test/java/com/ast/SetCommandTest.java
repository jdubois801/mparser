package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.SetCommand;

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
	}
}

