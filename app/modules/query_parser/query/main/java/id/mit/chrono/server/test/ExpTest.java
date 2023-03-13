package id.mit.chrono.server.test;

import com.udojava.evalex.Expression;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ExpTest {

    public static void main(String[] args){

//        BigDecimal result = null;
//
//        Expression expression = new Expression("1+1/3");
//        result = expression.eval();
//        expression.setPrecision(2);
//        result = expression.eval();
//
//        result = new Expression("(3.4 + -4.1)/2").eval();
//
//        result = new Expression("SQRT(a^2 + b^2").with("a","2.4").and("b","9.253").eval();
//
//        BigDecimal a = new BigDecimal("2.4");
//        BigDecimal b = new BigDecimal("9.235");
//        result = new Expression("SQRT(a^2 + b^2").with("a",a).and("b",b).eval();
//
//        result = new Expression("2.4/PI").setPrecision(128).setRoundingMode(RoundingMode.UP).eval();
//
//        result = new Expression("random() > 0.5").eval();
//
//        result = new Expression("not(x<7 || sqrt(max(x,9,3,min(4,3))) <= 3))").with("x","22.9").eval();
//
//        result = new Expression("log10(100)").eval();

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String foo = "val=1537;(val>= 1537 && val<=1738) || [1887,1912,1937,1962,1987,2012,2037,2062,2087].indexOf(val) > -1";

        try {
            System.out.println(engine.eval(foo));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
