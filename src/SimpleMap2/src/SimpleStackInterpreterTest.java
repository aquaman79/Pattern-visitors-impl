package SimpleMap2.src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleStackInterpreterTest {

	@Test
	void test() {
		Expr e1 = new IntExpr(9);
		SimpleStackInterpreter interpreter = new SimpleStackInterpreter();
		e1.accept(interpreter);
		assertTrue(interpreter.result() instanceof IntExpr);
		IntExpr ie = (IntExpr) interpreter.result();
		assertTrue(ie.getVal() == 9);
		Expr e2 = new IntExpr(2);
		Expr mult1 = new MultExpr(e1,e2);
		mult1.accept(interpreter);
		assertTrue(interpreter.result() instanceof IntExpr);
		ie = (IntExpr) interpreter.result();
		assertTrue(ie.getVal() == 18);
		Expr plus1 = new PlusExpr(e1,e2);
		plus1.accept(interpreter);
		assertTrue(interpreter.result() instanceof IntExpr);
		ie = (IntExpr) interpreter.result();
		assertTrue(ie.getVal() == 11);
		// ((9*2) + (9+2))
		Expr mult2 = new MultExpr(mult1,plus1);
		mult2.accept(interpreter);
		assertTrue(interpreter.result() instanceof IntExpr);
		ie = (IntExpr) interpreter.result();
		assertTrue(ie.getVal() == 198);

		// a = 3+ 4
		System.out.println("test de addition");
		Variable variable = new Variable("a");
		PlusExpr plusExpr = new PlusExpr(new IntExpr(3),new IntExpr(4));
		Assignement assignement = new Assignement(variable,plusExpr);
		assignement.accept(interpreter);
		Println println = new Println(variable,plusExpr);
		println.accept(interpreter);
		ie = (IntExpr) interpreter.result();
		assertTrue(ie.getVal() == 7);



		System.out.println("test de multiplication");
		variable = new Variable("b");
		MultExpr multExpr = new MultExpr(new IntExpr(3),new IntExpr(4));
		assignement = new Assignement(variable,multExpr);
		assignement.accept(interpreter);
		println = new Println(variable,multExpr);
		println.accept(interpreter);






	}

}
