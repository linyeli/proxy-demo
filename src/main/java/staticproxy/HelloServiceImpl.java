package staticproxy;

public class HelloServiceImpl implements HelloService{

    @Override
    public void sayHi() {
        System.out.println("Hello World");
    }
}
