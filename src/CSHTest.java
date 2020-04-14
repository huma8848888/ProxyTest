import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CSHTest {


    public static void main(String[] args) {

        //能不能在本地看见$Proxy.class主要就是这句，可以在自己的项目中加上这句话
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
