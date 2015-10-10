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
                }

                avatar= enemyChar;

                if (((avatar.getX()+avatar.getWidth())>(ball1.getX()-ball1.getWidth() || (avatar.getX()-avatar.getWidth())<(ball1.getX()+ball1.getWidth()) && ((avatar.getY()+avatar.getHeight())>(ball1.getY()-ball1.getHeight() || (avatar.getY()-avatar.getHeight())<(ball1.getY()+ball1.getHeight()))
                {
                     //BALL-AVATAR COLLISION
                }

                for (int j=0;j<bars.size();j++)
               {
                     Bar bar=bar.get(j)
                     if (bar.getX()>(ball1.getX()-ball1.getWidth()&&bar.getX()<(ball1.getX()+ball1.getWidth()&& bar.getY()>(ball1.getY()-ball1.getHeight()&&bar.getY()<(ball1.getY()+ball1.getHeight())
                     {
                           //BAR-BALL COLLISION
                     }
               }
               for (int j=0;j<bars.size();j++)
              {
                    Ball ball2=ball.get(j)
                    if (((ball2.getX()+ball2.getWidth())>(ball1.getX()-ball1.getWidth() || (ball2.getX()-ball2.getWidth())<(ball1.getX()+ball1.getWidth()) && ((ball2.getY()+ball2.getHeight())>(ball1.getY()-ball1.getHeight() || (ball2.getY()-ball2.getHeight())<(ball1.getY()+ball1.getHeight()))
                    {
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

    }
}
