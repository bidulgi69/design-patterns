import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

interface IMethods {

    void authenticatedCall();
    void call();
}

class MethodsImpl implements IMethods {

    @Override
    public void authenticatedCall() {
        System.out.println("Authenticated call...");
    }

    @Override
    public void call() {
        System.out.println("Non-authenticated call...");
    }
}

//  authenticated method 는 사용할 수 없도록
class NonAuthenticatedHandler implements InvocationHandler {
    private final IMethods methods;

    public NonAuthenticatedHandler(IMethods methods) {
        this.methods = methods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.getName().startsWith("authenticated")) {
            return method.invoke(methods, args);
        } else throw new Throwable("Access Denied.");
    }
}