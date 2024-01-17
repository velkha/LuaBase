package lua.base.consola.luabase.visual.listeners;

import lua.base.consola.luabase.visual.controllers.ConsoleController;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

@Component
public class BaseConsoleListener extends ConsoleListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField source = (JTextField) e.getSource();
        String userInput = source.getText();
        source.setText("");
        this.getConsoleController().processUserInput(userInput);
    }
    public BaseConsoleListener(ConsoleController consoleController) {
        super(consoleController);
    }

}
