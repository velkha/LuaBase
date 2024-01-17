package lua.base.consola.luabase.Runners;

import lua.base.consola.luabase.enums.commands.CommandOption;
import lua.base.consola.luabase.enums.commands.ICommandEnum;
import lua.base.consola.luabase.service.MenuService;
import lua.base.consola.luabase.util.EnumUtil;
import lua.base.consola.luabase.util.InputReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Profile("default")
@Order(2)
public class ConsoleRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        InputReader scanner = new InputReader();
        boolean exit = false;

        while (!exit) {
            menuService.displayMenu();
            String input = scanner.readLine();

            try {
                CommandOption option = EnumUtil.fromKey(CommandOption.class, input);
                exit = menuService.handleOption(option);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid option, please try again.");
            } catch (IOException e) {
                System.out.println("Error during secondary process exec");
                System.out.println(e);
            }
        }
    }
    private final MenuService menuService;

    @Autowired
    public ConsoleRunner(MenuService menuService) {
        this.menuService = menuService;
    }
}
