package Hack_NC_Game;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.*;
/**
 * Actual game.
 *
 * @author www.gametutorial.net
 */

public class Game {
private Avatar playerChar;
private Avatar enemyChar;
private ArrayList<Ball> balls;
private ArrayList<Bar> bars;
private double accel;
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

    }

    /**
     * Load game files - images, sounds, ...
     */
    private void LoadContent()
    {

    }


    /**
     * Restart game - reset some variables.
     */
    public void RestartGame()
    {

    }


    /**
     * Update game logic.
     *
     * @param gameTime gameTime of the game.
     * @param mousePosition current mouse position.
     */
    public void UpdateGame(long gameTime, long elaspedTime, Point mousePosition)
    {

        if (Canvas.keyboardKeyState(KeyEvent.VK_ESCAPE)){
          Framework.gamestate = PAUSE;
          return;
        }

          playerChar.Update;
          enemyChar.Update;
          for (int i=0;i<balls.size();i++)
          {
            balls.get(i).Update;
          }
          for (int i=0;i<bars.size();i++)
          {
            bars.get(i).Update;
          }

          for (int i=0;i<balls.size();i++)
          {
                Ball ball1=balls.get(i);
                Avatar avatar= playerChar;

                if (((avatar.getX()+avatar.getWidth())>(ball1.getX()-ball1.getWidth() || (avatar.getX()-avatar.getWidth())<(ball1.getX()+ball1.getWidth()) && ((avatar.getY()+avatar.getHeight())>(ball1.getY()-ball1.getHeight() || (avatar.getY()-avatar.getHeight())<(ball1.getY()+ball1.getHeight()))
                {
                     //BALL-AVATAR COLLISION
                     Framework.gameState = Framework.GameState.GAMEOVER;
                }

                avatar= enemyChar;

                if (((avatar.getX()+avatar.getWidth())>(ball1.getX()-ball1.getWidth() || (avatar.getX()-avatar.getWidth())<(ball1.getX()+ball1.getWidth()) && ((avatar.getY()+avatar.getHeight())>(ball1.getY()-ball1.getHeight() || (avatar.getY()-avatar.getHeight())<(ball1.getY()+ball1.getHeight()))
                {
                     //BALL-AVATAR COLLISION
                     this.RestartGame();
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
                     Bar bar=bars.get(j)
                     if (bar.getX()>(ball1.getX()-ball1.getWidth()&&bar.getX()<(ball1.getX()+ball1.getWidth()&& bar.getY()>(ball1.getY()-ball1.getHeight()&&bar.getY()<(ball1.getY()+ball1.getHeight())
                     {
                           //BAR-BALL COLLISION
                           ball1.setDirection((ball1.getDirection()+bar.getDirection())/2);
                           bars.remove(i);
                     }
               }
               for (int j=i+1;j<balls.size();j++)
              {
                    Ball ball2=balls.get(j)
                    if (((ball2.getX()+ball2.getWidth())>(ball1.getX()-ball1.getWidth() || (ball2.getX()-ball2.getWidth())<(ball1.getX()+ball1.getWidth()) && ((ball2.getY()+ball2.getHeight())>(ball1.getY()-ball1.getHeight() || (ball2.getY()-ball2.getHeight())<(ball1.getY()+ball1.getHeight()))
                    {
                          double ball1dir=ball2.getDirection();
                          double dall2dir=ball2.getDirection();
                          ball1.setDirection(atan2(((ball2.x-ball1.x),(ball2.y-ball1.y))+ball2dir)/2);
                          ball2.setDirection(atan2(((ball1.x-ball2.x),(ball1.y-ball2.y))+ball1dir)/2);
                          ball1.increaseSpeed(accel);
                          ball1.increaseSpeed(accel);
                          //BALL-BALL COLLISION

                    }
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
          playerCHar.Draw();
          enemyChar.Draw();
          for (int i=0; i< balls.size();i++)
          {
                balls.get(i).Draw();
          }
          for (int i=0; i< bars.size();i++)
          {
                bars.get(i).Draw();
          }

    }
}
