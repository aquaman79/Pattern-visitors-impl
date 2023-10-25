package SimpleMap2.src;

import java.util.HashMap;
import java.util.Map;

public class AffectationInterpreter extends Visitor{
    Map<Variable,IntExpr> dictionnaire;

    public AffectationInterpreter() {
        this.dictionnaire = new HashMap<>();
    }




}
