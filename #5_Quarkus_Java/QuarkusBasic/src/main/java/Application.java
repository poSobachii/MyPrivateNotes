//import io.quarkus.runtime.Quarkus;
//import io.quarkus.runtime.QuarkusApplication;
//import io.quarkus.runtime.annotations.QuarkusMain;
//import org.eclipse.microprofile.config.inject.ConfigProperty;
//import org.gradle.internal.concurrent.ManagedExecutor;
//
//import javax.inject.Inject;
//
//@QuarkusMain
//public class Application implements QuarkusApplication {
//
//    @Inject
//    ManagedExecutor managedExecutor;
//
//    @ConfigProperty(name = "hostname")
//    String hostname;
//
//    public static void main(String[] args) {
//        Quarkus.run(Application.class, args);
//    }
//
//    @Override
//    public int run(String... args) throws Exception {
//        System.out.println("HOSTNAME :" + hostname);
//        System.out.println("INJECTOR: " + managedExecutor);
//        return 0;
//    }
//}