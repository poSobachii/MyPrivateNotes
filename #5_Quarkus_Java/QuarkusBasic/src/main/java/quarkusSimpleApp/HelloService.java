package quarkusSimpleApp;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {
    public String politeHello(String name){
        return "Hello " + name;
    }
}
