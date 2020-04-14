import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CSHTest {


    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        human human = new Tom();
        human human1 = (human) Proxy.newProxyInstance(human.getClass().getClassLoader(), human.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return method.invoke(human, null);
            }
        });
        human1.run();
        System.out.println("$Proxy0.class全名: "+Proxy.getProxyClass(human.class.getClassLoader(), human.class));


    }
}
