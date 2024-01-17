package lua.base.consola.luabase.visual.controllers;

import lua.base.consola.luabase.visual.frames.ConsoleFrame;
import lua.base.consola.luabase.visual.listeners.ConsoleListener;

import javax.swing.*;

public abstract class ConsoleController {



    public void print(String text){
        consoleFrame.appendText(text);
    }
    public void println(String text){
        consoleFrame.appendTextln(text);
    }
    public void processUserInput(String userInput) {
        consoleFrame.processUserInput(userInput);
    }
    public void launchConsole(){
        SwingUtilities.invokeLater(() -> {
            consoleFrame.setVisible(true);
            this.println(this.generateMenu());
        });
    }

    public ConsoleListener getListener() {
        return consoleListener;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
    abstract String generateMenu();
    abstract ConsoleListener generateListener();
    protected ConsoleListener consoleListener;
    protected ConsoleFrame consoleFrame;
    private String menu;
    public ConsoleController() {
        this.consoleListener = this.generateListener();
        consoleFrame = new ConsoleFrame(this);
    }


}
