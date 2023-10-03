import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private Score score;
    private int width;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    private int height;
    private Hero hero;
    private List<Walls> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    private List<Walls> createWalls() {
        List<Walls> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Walls(c, 0));
            walls.add(new Walls(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Walls(0, r));
            walls.add(new Walls(width - 1, r));
        }
        return walls;
    }
    private List<Coin> createCoins()
    {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            int x = 5,y=5;

            x = random.nextInt(width - 2) + 1;
            y = random.nextInt(height - 2) + 1;
            Coin c = new Coin(x,y);
            while(((x==hero.getPosition().getX()) && (y==hero.getPosition().getY())) || (coins.contains(c)))
            {
                x = random.nextInt(width - 2) + 1;
                y = random.nextInt(height - 2) + 1;
            }
            coins.add(new Coin(x,y));
        }
        return coins;
    }

    private List<Monster> createMonsters()
    {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            int x = 5,y=5;

            x = random.nextInt(width - 2) + 1;
            y = random.nextInt(height - 2) + 1;
            Coin c = new Coin(x,y);
            while(((x==hero.getPosition().getX()) && (y==hero.getPosition().getY())) || (monsters.contains(c)))
            {
                x = random.nextInt(width - 2) + 1;
                y = random.nextInt(height - 2) + 1;
            }
            monsters.add(new Monster(x,y));
        }
        return monsters;
    }
    public boolean canHeroMove(Position position) {
        int flag = 0;
        for(Walls wall: walls)
        {
            if (wall.getPosition().equals(position))
            {
                flag = 1;
                break;

            }

            /*
            if(wall.getPosition().getX() == position.getX() && wall.getPosition().getY() == position.getY())
            {
                flag = 1;
                break;
            }
             */

        }
        /*
        if((position.getX()>0) && (position.getY()>0) && (position.getX()<width-1) && (position.getY()<height-1))return true;
        return false;

         */
        return flag != 1;
    }
    public void moveHero(Position position) {
        if (canHeroMove(position))
        {
            hero.setPosition(position);
        }
        retrievecoins();
    }
    public void verifyMonsterCollisions()
    {
        for(Monster monster :monsters)
        {
            if(hero.getPosition().equals(monster.getPosition()))
            {
                score.setHealth(score.getHealth()-1);

            }
        }
    }
    private void moveMonster() {
        for(Monster monster: monsters)
        {
            Position p = monster.move();
            while(true)
            {

                if((p.getX()<width-1) && (p.getX()>0) && (p.getY()<height-1) && (p.getY()>0))
                {
                    break;
                }
                else
                {
                    p=monster.move();

                }
            }
            monster.setPosition(p);
        }
    }
    public void retrievecoins()
    {
        int flag = 0;
        int i =0 ;
        while(i<coins.size())
        {
            Coin coin = coins.get(i);
            if(coin.getPosition().equals(hero.getPosition()))
            {
                flag=1;
                break;
            }
            i++;
        }
        if(flag==1)
        {
            coins.remove(coins.get(i));
            score.setPoints(score.getPoints()+1);
        }
    }



    public void processKey(KeyStroke key) throws IOException {
        Position position1;
        switch(key.getKeyType())
        {
            case ArrowLeft:
                position1 = new Position(this.hero.getPosition().getX()-1,this.hero.getPosition().getY());
                moveHero(position1);
                verifyMonsterCollisions();
                moveMonster();
                verifyMonsterCollisions();
                checkHealth();
                break;
            case ArrowDown:
                position1 = new Position(this.hero.getPosition().getX(),this.hero.getPosition().getY()+1);
                moveHero(position1);
                verifyMonsterCollisions();
                moveMonster();
                verifyMonsterCollisions();
                checkHealth();
                break;
            case ArrowRight:
                position1 = new Position(this.hero.getPosition().getX()+1,this.hero.getPosition().getY());
                moveHero(position1);
                verifyMonsterCollisions();
                moveMonster();
                verifyMonsterCollisions();
                checkHealth();
                break;
            case ArrowUp:
                position1 = new Position(this.hero.getPosition().getX(),this.hero.getPosition().getY()-1);
                moveHero(position1);
                verifyMonsterCollisions();
                moveMonster();
                verifyMonsterCollisions();
                checkHealth();
                break;
            case Character:
                if(key.getCharacter()=='q')System.exit(0);
                break;


        }

        System.out.println(key);
    }

    private void checkHealth() {
        if(score.getHealth()==0)
        {

            System.out.println();
            System.exit(0);
        }
    }


    public Hero getHero() {
        return this.hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public List<Walls> getWalls() {
        return walls;
    }

    public void setWalls(List<Walls> walls) {
        this.walls = walls;
    }

    public Arena() {
        width=100;
        height=20;
        hero = new Hero();
        this.score= new Score();
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters=createMonsters();
    }



    public void endOfGame()
    {
        
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#330099")); graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(getWidth(), getWidth()), ' ');
        for (Walls wall : walls)
            wall.draw(graphics);
        for(Coin coin : coins)
        {
            coin.draw(graphics);
        }
        for(Monster monster: monsters)
        {
            monster.draw(graphics);
        }
        hero.draw(graphics);
        score.draw(graphics);
    }
}
