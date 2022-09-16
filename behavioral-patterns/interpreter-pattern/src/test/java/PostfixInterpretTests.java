import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PostfixInterpretTests {

    @Test
    public void test1() {
        String expression = "123*+";
        PostfixExpression result = PostfixParser.parse(expression);
        Assertions.assertEquals(7, result.interpret());
    }

    @Test
    public void test2() {
        String expression = "46*3/";
        PostfixExpression result = PostfixParser.parse(expression);
        Assertions.assertEquals(8, result.interpret());
    }

    @Test
    public void test3_expects_arithmetic_exception() {
        String expression = "22-4/";
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> PostfixParser.parse(expression).interpret());
    }
}