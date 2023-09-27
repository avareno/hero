import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game
{
    private static Screen screen;
    private int x = 10;
    private int y = 10;
    private void draw() throws IOException{
        screen.clear();
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }
    private void processKey(KeyStroke key) throws IOException {


        switch(key.getKeyType())
        {
            case ArrowLeft:
                x--;
                draw();
                break;
            case ArrowDown:
                y++;
                draw();
                break;
            case ArrowRight:
                x++;
                draw();
                break;
            case ArrowUp:
                y--;
                draw();
                break;
        }
        System.out.println(key);
    }
    public void run() throws IOException {
        draw();
        KeyStroke key = screen.readInput();
        processKey(key);
    }




    Game()
    {
        try {

            TerminalSize terminalSize = new TerminalSize(40, 800);
            DefaultTerminalFactory terminalFactory = new
                    DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
