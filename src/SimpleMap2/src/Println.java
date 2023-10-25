package SimpleMap2.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Println extends Statement {
    List<Expr> exprList;

    public Println( List<Expr> exprList) {
       this.exprList =  exprList;
        for(int i = 0 ; i < this.exprList.size();i++)
        {
            exprList.get(i).accept(v);
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitPrintln(this);
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }
}
