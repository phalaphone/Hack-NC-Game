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
