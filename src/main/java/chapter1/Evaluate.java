package chapter1;

import edu.princeton.cs.algs4.Stack;

public class Evaluate {

    /**
     * 使用dijkstra双栈法计算术表达式
     * @param exp 算术表达式
     * @return 计算结果
     */
    public static double evaluate(String[] exp){
        if(exp == null || exp.length == 0) {
            return 0L;
        }
        Stack<Double> val = new Stack<>();
        Stack<String> ops = new Stack<>();
        for (int i = 0; i < exp.length; i++){
            String str = exp[i];
            //
            if(str.equals("(")) ;
            else if(str.equals("+")) ops.push(str);
            else if(str.equals("-")) ops.push(str);
            else if(str.equals("*")) ops.push(str);
            else if(str.equals("/")) ops.push(str);
            else if(str.equals("sqrt")) ops.push(str);
            else if(str.equals(")")){
                double v = val.pop();
                String op = ops.pop();
                if(op.equals("+")) v = val.pop() + v;
                else if(op.equals("-")) v = val.pop() - v;
                else if(op.equals("*")) v = val.pop() * v;
                else if(op.equals("/")) v = val.pop() / v;
                else v = Math.sqrt(v);
                val.push(v);
            }else{
                val.push(Double.valueOf(str));
            }
        }
        return val.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate(args));
    }
}
