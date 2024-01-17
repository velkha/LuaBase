package lua.base.consola.luabase;

import lua.base.consola.luabase.service.SecondaryProcessService;
import lua.base.consola.luabase.util.InputReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

public class LuaSecondaryApp {
    public static void main(String[] args) {
        System.out.println("Testing Secondary process:");
        System.setProperty("spring.profiles.active", "secondary");
        try{
            SpringApplication app = new SpringApplication(LuaSecondaryApp.class);
            ConfigurableApplicationContext context = SpringApplication.run(LuaSecondaryApp.class, args);
            SecondaryProcessService myCustomBean = context.getBean(SecondaryProcessService.class);
            myCustomBean.init();
        }catch (Exception e){
            e.printStackTrace();
            new InputReader().readLine();
        }

        new InputReader().readLine();
    }
}