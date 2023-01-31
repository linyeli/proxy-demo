import dynamicproxy.cglibproxy.CglibProxy;
import dynamicproxy.jdkproxy.MyInvocationHandler;
import staticproxy.HelloService;
import staticproxy.HelloServiceImpl;
import staticproxy.HelloServiceProxy;

public class Main {
    public static void main(String[] args) {
/*
        //static proxy
       HelloService service = new HelloServiceImpl();
       HelloServiceProxy proxy = new HelloServiceProxy(service);
       proxy.sayHi();
*/
///*
        // jdk dynamic proxy
        HelloService service = new HelloServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        HelloService proxy = (HelloService)handler.getProxy();
        proxy.sayHi();
//*/

/*
        // cglib dynamic proxy
        CglibProxy  proxy = new CglibProxy(new HelloServiceImpl());
        HelloServiceImpl service = (HelloServiceImpl) proxy.getProxy(HelloServiceImpl.class);
        service.sayHi();
*/
    }

}