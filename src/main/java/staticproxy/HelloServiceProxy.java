package staticproxy;

public class HelloServiceProxy implements HelloService{
    private HelloService service;

    public HelloServiceProxy(HelloService service) {
        this.service = service;
    }

    @Override
    public void sayHi() {
        System.out.println("proxy start");
        service.sayHi();
        System.out.println("proxy end");
    }

}
