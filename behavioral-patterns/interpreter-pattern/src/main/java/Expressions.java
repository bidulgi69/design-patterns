interface PostfixExpression {
    int interpret();
}

class VariableExpression implements PostfixExpression {

    private final int variable;

    public VariableExpression(int variable) {
        this.variable = variable;
    }

    @Override
    public int interpret() {
        return variable;
    }
}

class PlusExpression implements PostfixExpression {

    private final PostfixExpression left;
    private final PostfixExpression right;

    public PlusExpression(PostfixExpression left, PostfixExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

class MinusExpression implements PostfixExpression {

    private final PostfixExpression left;
    private final PostfixExpression right;

    public MinusExpression(PostfixExpression left, PostfixExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

class MultiplyExpression implements PostfixExpression {

    private final PostfixExpression left;
    private final PostfixExpression right;

    public MultiplyExpression(PostfixExpression left, PostfixExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}

class DivideExpression implements PostfixExpression {

    private final PostfixExpression left;
    private final PostfixExpression right;

    public DivideExpression(PostfixExpression left, PostfixExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() throws ArithmeticException {
        return right.interpret() / left.interpret();
    }
}