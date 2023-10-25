package SimpleMap2.src;

abstract public class Expr {
	public abstract void accept(Visitor v);
	Expr valeur( ) { return null; }
}
