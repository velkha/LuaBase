package lua.base.consola.luabase.command;

import lua.base.consola.luabase.enums.commands.CommandOption;
import lua.base.consola.luabase.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandHandler {

    public void handleCommand(CommandOption commandOption) {
        switch (commandOption) {
            case OPTION_ONE:
                //exampleService.performActionOne();
                break;
            case OPTION_TWO:
                //exampleService.performActionTwo();
                break;
            // other cases
        }

    }

    private final ExampleService exampleService;

    @Autowired
    public CommandHandler(ExampleService exampleService) {
        this.exampleService = exampleService;
    }
}
