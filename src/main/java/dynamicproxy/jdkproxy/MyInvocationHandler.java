package dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target){
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin: " + target.getClass().getName() + "." + method.getName());
        System.out.println("proxy: " + proxy.getClass().getName());
        Object result = method.invoke(target,args);
        System.out.println("end: " + method.getName() );
        System.out.println("result: " + result);
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(),this);
    }
}
