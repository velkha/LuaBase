package lua.base.consola.luabase.visual.frames;

import lua.base.consola.luabase.visual.controllers.BaseConsoleController;
import lua.base.consola.luabase.visual.controllers.ConsoleController;
import lua.base.consola.luabase.visual.frames.extracomponents.CustomScrollBarUI;
import lua.base.consola.luabase.visual.listeners.BaseConsoleListener;
import lua.base.consola.luabase.visual.listeners.ConsoleListener;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class ConsoleFrame extends JFrame {

    public ConsoleFrame(ConsoleController consoleController) {
        this.consoleController=consoleController;
        consoleListener=consoleController.getListener();

        setTitle("Console-like Frame");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = generateTxtArea();
        inputField = generateTxtField();
        scrollPanel = generateScrollBar();

        inputField.addActionListener(consoleListener);
        this.addWindowListener(consoleListener);

        add(scrollPanel, BorderLayout.CENTER);
        add(inputField, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE );
    }

    private JScrollPane generateScrollBar (){
        JScrollPane scrollPanel = new JScrollPane(textArea);
        scrollPanel.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPanel.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
        return scrollPanel;
    }
    private JTextField generateTxtField (){
        JTextField inputField = new JTextField();
        inputField.setBackground(Color.BLACK); // Set background color to black
        inputField.setForeground(Color.WHITE); // Set font color to white
        inputField.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Optional: Set a monospaced font
        return inputField;
    }
    private JTextArea generateTxtArea (){
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK); // Set background color to black
        textArea.setForeground(Color.WHITE); // Set font color to white
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12)); // Optional: Set a monospaced font
        return textArea;
    }

    public void processUserInput(String userInput) {
        textArea.append("User Input: " + userInput + "\n");
    }

    public void appendTextln(String text) {
        textArea.append(text + "\n");
    }
    public void appendText(String text) {
        textArea.append(text);
    }
    public void blockInput(boolean blocked){
        inputField.setEditable(!blocked);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConsoleFrame frame = new ConsoleFrame(new BaseConsoleController());
                frame.setVisible(true);
            }
        });
    }


    private JTextArea textArea;
    private JTextField inputField;
    private ConsoleListener consoleListener;
    private ConsoleController consoleController;
    private JScrollPane scrollPanel;
}