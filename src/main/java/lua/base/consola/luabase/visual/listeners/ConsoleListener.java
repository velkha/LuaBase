package lua.base.consola.luabase.visual.listeners;

import lua.base.consola.luabase.visual.controllers.ConsoleController;
import lua.base.consola.luabase.visual.frames.ConsoleFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public abstract class ConsoleListener implements ActionListener, WindowListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField source = (JTextField) e.getSource();
        String userInput = source.getText();
        source.setText("");

        consoleController.processUserInput(userInput);
    }
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Cerrando consola base");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("1consola base cerrada");
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }


    public ConsoleController getConsoleController() {
        return consoleController;
    }
    private ConsoleController consoleController;

    public ConsoleListener(ConsoleController consoleController) {
        this.consoleController = consoleController;
    }
}
