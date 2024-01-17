package lua.base.consola.luabase.util;

import java.util.Scanner;

public class InputReader {
    private final Scanner scanner = new Scanner(System.in);

    public String readLine() {
        return scanner.nextLine();
    }

    public int readInt() {
        return scanner.nextInt();
    }
}
