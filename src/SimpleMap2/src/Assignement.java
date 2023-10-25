package SimpleMap2.src;

import java.util.HashMap;
import java.util.Map;

public class Assignement extends Statement{
    Variable left ;
    Expr right;
    public  Assignement(Variable left, Expr right){
       this.left=left;
       this.right= right;
    }

    public Variable getLeft() {
        return left;
    }

    public void setLeft(Variable left) {
        this.left = left;
    }

    public Expr getRight() {
        return right;
    }

    public void setRight(Expr right) {
        this.right = right;
    }

    @Override
    public void accept(Visitor v) {
        v.visitAssignement(this);
    }
}
