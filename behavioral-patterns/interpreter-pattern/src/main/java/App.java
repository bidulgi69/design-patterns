public class App {

    public static void main(String[] args) {
        String expression1 = "123+*";
        PostfixExpression result = PostfixParser.parse(expression1);
        System.out.printf("Result of expression1(%s): %d\n", expression1, result.interpret());
    }

}