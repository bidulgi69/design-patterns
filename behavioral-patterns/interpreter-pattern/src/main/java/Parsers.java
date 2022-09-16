import java.util.Stack;

class PostfixParser {

    public static PostfixExpression parse(String expression) {
        Stack<PostfixExpression> expressions = new Stack<>();
        for (char c : expression.toCharArray()){
            expressions.push(
                    convert(c, expressions)
            );
        }
        //  return the calculated value.
        return expressions.pop();
    }

    private static PostfixExpression convert(char c, Stack<PostfixExpression> stack) {
        switch (c) {
            case '+':
                return new PlusExpression(stack.pop(), stack.pop());
            case '-':
                return new MinusExpression(stack.pop(), stack.pop());
            case '*':
                return new MultiplyExpression(stack.pop(), stack.pop());
            case '/':
                return new DivideExpression(stack.pop(), stack.pop());
            default:
                return new VariableExpression(c - '0');
        }
    }
}