package dynamicproxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import staticproxy.HelloServiceImpl;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    // real object
    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    public Object getProxy(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        // set parent class
        enhancer.setSuperclass(clazz);
        // set class loader
        enhancer.setClassLoader(clazz.getClassLoader());
        // set method interceptor
        enhancer.setCallback(this);
        // create subClass object by ASM
        return enhancer.create();
    }

    /**
     * @param obj proxy object
     * @param method intercepted method
     * @param args arguments for intercepted method
     * @param proxy use to call the original method of real object
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before proxy");
        System.out.println("method proxy: " + proxy);
        System.out.println("proxy super name: " + proxy.getSignature());
        System.out.println("proxy get declared method start : ----");
        for(Method m : proxy.getClass().getDeclaredMethods()){
            System.out.println("** proxy method ** " + m.toGenericString());
        }
        System.out.println("proxy get declared method end : ----");
        System.out.println(obj.getClass().getSuperclass());
        System.out.println(target.getClass().getSuperclass());
        // call method of parent class by proxy class
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("after proxy");
        System.out.println("result : " + result);
        return result;
    }
}
