package lua.base.consola.luabase.service;

import lua.base.consola.luabase.enums.commands.CommandOption;
import lua.base.consola.luabase.visual.controllers.BaseConsoleController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MenuService {
    public void displayMenu() {
        for (CommandOption option : CommandOption.values()) {
            System.out.println(option);
        }
        System.out.print("Enter your choice: ");
    }


    public boolean handleOption(CommandOption option) throws IOException {
        boolean exit=false;
        switch (option) {
            case OPTION_ONE:
                /*String command = "cmd /c start java -cp target/classes lua.base.consola.luabase.LuaSecondaryApp --server.port=8081";
                Runtime.getRuntime().exec(command);*/
                this.launchBaseConsole();
                break;
            case OPTION_TWO:
                secondaryProcessService.init();
                break;
            case EXIT:
                exit=true;
                break;
        }
        return exit;
    }

    private void launchBaseConsole() {
        /*BaseConsoleListener consoleListener = new BaseConsoleListener();
        consoleController = new BaseConsoleController(consoleListener);*/
        consoleController.launchConsole();

    }


    public SecondaryProcessService secondaryProcessService;
    private final BaseConsoleController consoleController;

    @Autowired
    public MenuService (SecondaryProcessService secondaryProcessService, BaseConsoleController consoleController){
        this.secondaryProcessService = secondaryProcessService;
        this.consoleController = consoleController;
    }
}
