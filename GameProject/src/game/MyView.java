/*
 * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import static java.awt.Color.CYAN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author kimbe
 */
    public class MyView extends UserView {
    
    private Game game;
     int BlueKeyCount = 0;
    
    private Image background;
    
    
    public MyView( World world, Game game ,int width, int height){
        super(world, width, height);
        this.background = new ImageIcon("data/background.jpg").getImage();
        this.game = game;
    }
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
        //System.out.println("paintBackground");
    }
@Override
    protected void paintForeground(Graphics2D g) {
        //int fontSize = 18;
        g.setColor(CYAN);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Blue Key Count: " + game.getPlayer2().getBKeyCount(), 14, 14);
        g.drawString(" Daryl health Count: "+ game.getPlayer2().getLives() ,600,14);
        
        g.setColor(RED);
        g.drawString("Red Key Count: "+ game.getPlayer1().getRKeyCount() ,14,30);
        g.drawString(" Rick health Count: "+ game.getPlayer1().getLives() ,600,30);  
        
         
    }
   
}

