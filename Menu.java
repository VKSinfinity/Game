package com.tutorial.main;

import java.awt.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by user on 09/02/2017.
 */
public class Menu extends MouseAdapter {

	private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    public Menu(Game game, Handler handler){
        this.game = game;
        this.hud = hud;
        this.handler = handler;

    }

    @Override
    public void mousePressed(MouseEvent e){
       int mx = e.getX();
       int my = e.getY();
        // play button
       if (game.gameState == Game.STATE.Menu) {
           if (mouseOver(mx, my, 210, 150, 200, 64)) {
               game.gameState = Game.STATE.Game;
               handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
               handler.clearEnemys();
               handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
           }

           if (mouseOver(mx, my, 210, 350, 200, 64)) {
               System.exit(1);

           }
           if (mouseOver(mx, my, 210, 250, 200, 64)) {
               game.gameState = Game.STATE.Help;

           }
       }
        if(game.gameState == Game.STATE.Help) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
                return;

            }
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
    	if(mx > x && mx < x + width){
    		if(my > y && my < y + height){
    			return true;
    		}else return false;
    	}else return false;
    }

    public void tick(){

    }

    public void render(Graphics g){
        if(game.gameState == Game.STATE.Menu ) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Wave", 240, 70);

            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 270, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 270, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 270, 390);
        }else if(game.gameState == Game.STATE.Help){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 70);

            g.setFont(fnt3);
            g.setColor(Color.white);
            g.drawString("Use WASD keys to move the player and dodge enemies", 50, 200);

            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 270, 390);
        }else if(game.gameState == Game.STATE.End){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 240, 70);

            g.setFont(fnt3);
            g.setColor(Color.white);
            g.drawString("You lost with a score of: " + hud.getScore(), 50, 200);

            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Try Again", 270, 390);
        }
    }

}
