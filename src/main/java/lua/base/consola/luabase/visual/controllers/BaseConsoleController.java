package lua.base.consola.luabase.visual.controllers;

import lua.base.consola.luabase.util.resources.GenericResources;
import lua.base.consola.luabase.visual.listeners.BaseConsoleListener;
import lua.base.consola.luabase.visual.listeners.ConsoleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BaseConsoleController extends ConsoleController {


    public BaseConsoleController() {
        super();
    }

    @Override
    String generateMenu() {
        String rtrStr;
        try {
            rtrStr= GenericResources.getMenu("menu.base");
        } catch (IOException e) {
            rtrStr=e.getMessage();
        }
        return rtrStr;

    }
    @Override
    ConsoleListener generateListener() {
        return new BaseConsoleListener(this);
    }
}
