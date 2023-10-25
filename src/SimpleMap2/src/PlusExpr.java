package SimpleMap2.src;

public class PlusExpr extends BinExpr {

	public PlusExpr(Expr opg, Expr opd) {
		super(opg, opd);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPlusExpr(this);
	}

}
