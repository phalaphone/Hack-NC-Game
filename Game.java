package Hack_NC_Game;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import Hack_NC_Game.Framework.GameState;

import java.math.*;
/**
 * Actual game.
 *
 * @author www.gametutorial.net
 */

public class Game {
private Avatar playerChar;
private Random rand;
private ArrayList<Ball> balls;
private ArrayList<Bar> bars;

private BufferedImage background;
private BufferedImage pausescreen;

private double accel;
private long timeBetweenBalls;
private long timeBetweenBars;
private long lastTimeBalls;
private long lastTimeBars;

    public Game()
    {
        Framework.gameState = Framework.GameState.GAME_CONTENT_LOADING;

        Thread threadForInitGame = new Thread() {
            @Override
            public void run(){
                // Sets variables and objects for the game.
                Initialize();
                // Load game files (images, sounds, ...)
                LoadContent();

                Framework.gameState = Framework.GameState.PLAYING;
            }
        };
        threadForInitGame.start();
    }


   /**
     * Set variables and objects for the game.
     */
    private void Initialize()
    {
          rand= new Random();
          playerChar= new Avatar((int)Math.floor(rand.nextDouble()*Framework.frameWidth),
        		  (int)Math.floor(rand.nextDouble()*Framework.frameHeight),
        		  Framework.frameWidth,Framework.frameHeight, false);

          balls=new ArrayList<Ball>();
          bars= new ArrayList<Bar>();
          turrets= new ArrayList<Turret>();
          turrets.add(new Turret((int) 0.1*Framework.frameWidth,(int) 0.3*Framework.frameWidth));
          turrets.add(new Turret((int) 0.9*Framework.frameWidth,(int) 0.3*Framework.frameWidth));
          turrets.add(new Turret((int) 0.5*Framework.frameWidth, (int) 0.7*Framework.frameWidth));
          accel=1.2;
          timeBetweenBalls=Framework.secInNanosec / 3;
          timeBetweenBars=0;
          lastTimeBalls=0;
          lastTimeBars=0;
    }

    /**
     * Load game files - images, sounds, ...
     */
    private void LoadContent()
    {
    	playerChar.LoadContent();
        try
        {
            URL backgroundImgUrl = this.getClass().getResource("/Hack_NC_Game/resources/images/background.jpg");
            background = ImageIO.read(backgroundImgUrl);
        }
        catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * Restart game - reset some variables.
     */
    public void RestartGame()
    {

          rand= new Random();
          playerChar= new Avatar((int)0.5*Framework.frameWidth,
        		  (int)0.2*Framework.frameHeight,
        		  Framework.frameWidth,Framework.frameHeight, false);

          balls=new ArrayList<Ball>();
          bars= new ArrayList<Bar>();
          turrets= new ArrayList<Turret>();
          turrets.add(new Turret((int) 0.1*Framework.frameWidth,(int) 0.3*Framework.frameWidth));
          turrets.add(new Turret((int) 0.9*Framework.frameWidth,(int) 0.3*Framework.frameWidth));
          turrets.add(new Turret((int) 0.5*Framework.frameWidth, (int) 0.7*Framework.frameWidth));
          accel=1.2;
          timeBetweenBalls=Framework.secInNanosec / 3;
          timeBetweenBars=0;
          lastTimeBalls=0;
          lastTimeBars=0;
          Framework.gameState = Framework.GameState.PLAYING;

    }


    /**
     * Update game logic.
     *
     * @param gameTime gameTime of the game.
     * @param mousePosition current mouse position.
     */
    public void UpdateGame(long gameTime, long elaspedTime, Point mousePosition)
    {

    	System.out.println("Meme entered");
          playerChar.Update();

          for (int i=0;i<balls.size();i++)
          {
            balls.get(i).Update();
          }
          for (int i=0;i<bars.size();i++)
          {
            bars.get(i).Update();
          }

          for (int i=0;i<balls.size();i++)
          {
                Ball ball1=balls.get(i);
                Avatar avatar= playerChar;

                if (((avatar.getX()+avatar.getWidth())>(ball1.getX()-ball1.getWidth()) || (avatar.getX()-avatar.getWidth())<(ball1.getX()+ball1.getWidth())) && (((avatar.getY()+avatar.getHeight())>(ball1.getY()-ball1.getHeight()) || (avatar.getY()-avatar.getHeight())<(ball1.getY()+ball1.getHeight()))))
                {
                     //BALL-AVATAR COLLISION
                     Framework.gameState = Framework.GameState.GAMEOVER;
                }


                if (ball1.getX()+ball1.getWidth()>Framework.frameWidth|| ball1.getX()-ball1.getWidth()<0)
                {
                      ball1.setDirection(180-ball1.getDirection());
                }
                if (ball1.getX()+ball1.getWidth()>Framework.frameWidth|| ball1.getX()-ball1.getWidth()<0)
                {
                      ball1.setDirection(-1*ball1.getDirection());
                }
                for (int j=0;j<bars.size();j++)
               {
                     Bar bar=bars.get(j);
                     if (bar.getX()>(ball1.getX()-ball1.getWidth())&&bar.getX()<(ball1.getX()+ball1.getWidth())&& bar.getY()>(ball1.getY()-ball1.getHeight())&&bar.getY()<(ball1.getY()+ball1.getHeight()))
                     {
                           //BAR-BALL COLLISION
                           ball1.setDirection((ball1.getDirection()+bar.getDirection())/2);
                           bars.remove(i);
                     }
               }
               for (int j=i+1;j<balls.size();j++)
              {
                    Ball ball2=balls.get(j);
                    if (((ball2.getX()+ball2.getWidth())>(ball1.getX()-ball1.getWidth()) || (ball2.getX()-ball2.getWidth())<(ball1.getX()+ball1.getWidth())) && (((ball2.getY()+ball2.getHeight())>(ball1.getY()-ball1.getHeight()) || (ball2.getY()-ball2.getHeight())<(ball1.getY()+ball1.getHeight()))))
                    {
                          double ball1dir=ball2.getDirection();
                          double ball2dir=ball2.getDirection();
                          ball1.setDirection(Math.atan(((ball2.getX()-ball1.getX())/(ball2.getY()-ball1.getY()))+ball2dir)/2);
                          ball2.setDirection( Math.atan(((ball1.getX()-ball2.getX())/(ball1.getY()-ball2.getY()))+ball1dir)/2);
                          ball1.increaseSpeed(accel);
                          ball1.increaseSpeed(accel);
                          //BALL-BALL COLLISION

                    }
              }
          }
          if(Canvas.mouseButtonState(MouseEvent.BUTTON1))
          {

              if(System.nanoTime() - lastTimeBalls >= timeBetweenBars)
              {
                    Bar bar=new Bar((int) playerChar.getX(),(int) playerChar.getY(),(int) mousePosition.getX(),(int) mousePosition.getY());
                    bars.add(bar);

                  lastTimeBars = System.nanoTime();
              }
          }
    }

    /**
     * Draw the game to the screen.
     *
     * @param g2d Graphics2D
     * @param mousePosition current mouse position.
     */
    public void Draw(Graphics2D g2d, Point mousePosition)
    {
    	g2d.drawImage(background, 0, 0, Framework.frameWidth, Framework.frameHeight, null);
          playerChar.Draw(g2d);
          for (int i=0; i< balls.size();i++)
          {
               balls.get(i).Draw(g2d);
          }
          for (int i=0; i< bars.size();i++)
          {
               bars.get(i).Draw(g2d);
          }
    }

    public void DrawPause(Graphics2D g2d, Point mousePosition){



        g2d.drawString("ENTER: Restart", Framework.frameWidth / 2 - 100, Framework.frameHeight / 3 + 70);
        g2d.drawString("ESC:   End Game", Framework.frameWidth / 2 - 100, Framework.frameHeight / 3);
        g2d.drawString("SPACE: Resume ", Framework.frameWidth / 2 - 100, Framework.frameHeight / 3 + 20);
    }
}
