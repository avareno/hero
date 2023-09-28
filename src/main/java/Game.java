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
    static Screen screen;
    private Hero hero = new Hero();
    private void draw() throws IOException{
        screen.clear();
        Arena.draw(screen);
        screen.refresh();
    }
    private void processKey(KeyStroke key) throws IOException {

        Arena.processKey(key);
    }
    public void run() throws IOException {

        KeyStroke key;
        key = screen.readInput();
        while(key.getCharacter()!='q') {
            draw();
            key = screen.readInput();
            processKey(key);
        }
        screen.close();
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
