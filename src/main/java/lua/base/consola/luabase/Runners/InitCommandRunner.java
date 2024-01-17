package lua.base.consola.luabase.Runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class InitCommandRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Inicializando Procedimientos");
    }
}
