package SimpleMap2.src;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

// Principe : 
// Pour un calcul les arguments sont récupérés dans la pile
//	- par pour un +, les opg et opd sont dépilé
// Quand le calcul est effectué, on empile le résultat
// Le parcous se fait en profondeur à gauche d'abord
// Le résultat courant est toujours en tête de pile
// A la fin du calcul d'une expression complete, la pile ne contient qu'un seul element, le résultat
//
// en entrée j'ai l'entier 9, le résultat est 9
// - le résultat du calcul pour une expression unaire est l'expression unaire elle-même
// en j'ai 2 * 3

public class SimpleStackInterpreter extends Visitor {
	Stack<Expr> stk;
	Map<Variable,IntExpr> dictionnaire ;


	public SimpleStackInterpreter () {
		stk = new Stack<Expr>();
		this.dictionnaire = new LinkedHashMap<>();
	}
	
	public void visitIntExpr(IntExpr intExpr) {
		stk.push(intExpr);
	}

	public void visitMultExpr(MultExpr multExpr) {
		Expr eg = multExpr.getOpg();
		Expr ed = multExpr.getOpd();
		eg.accept(this);
		ed.accept(this);
		IntExpr ied = (IntExpr) stk.pop();
		IntExpr ieg = (IntExpr) stk.pop();
		stk.push(new IntExpr(ied.getVal() * ieg.getVal()));
	}

	public void visitPlusExpr(PlusExpr plusExpr) {
		Expr eg = plusExpr.getOpg();
		Expr ed = plusExpr.getOpd();
		eg.accept(this);
		ed.accept(this);
		IntExpr ied = (IntExpr) stk.pop();
		IntExpr ieg = (IntExpr) stk.pop();
		stk.push(new IntExpr(ied.getVal() + ieg.getVal()));
	}

	public Expr result() {
		return stk.peek();
	}

	public void visitAssignement(Assignement assignement){
		assignement.getRight().accept(this);
		IntExpr intExpr = (IntExpr) stk.pop();
		dictionnaire.put(assignement.getLeft(), intExpr);
		stk.push(intExpr);
	}

	public void visitPrintln(Println println){
		Variable key = println.getVariable();
		System.out.println(dictionnaire.get(key).getVal());
	}

}
