package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;

/**
 * A world with some bodies.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;
    private static final int width = 800;
    private static final int height = 600;
    private JFrame frame;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private UserView view;
    public static SoundClip gameMusic;
    public static SoundClip bossMusic;
    private int level;
    private RickController controller;
    private DarylController controllerP2;
    private ControlPanel controlpanel;

    /**
     * Initialise a new Game.
     */
    public Game() {

        /**
         * make the world
         */
        level = 1;
        world = new Level1();
        view = new MyView(world, this, width, height);
        world.populate(this);

        // make a view
        frame = new JFrame("The Other Side");

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1); 
        // display the view in a frame
        // final JFrame frame = new JFrame("Event handling");
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        controlpanel = new ControlPanel(this);
        frame.add(controlpanel, BorderLayout.SOUTH);

        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));

        controller = new RickController(world.getPlayer1());
        controllerP2 = new DarylController(world.getPlayer2());
        frame.addKeyListener(controller);
        frame.addKeyListener(controllerP2);

        // uncomment to make the view track the bird
        //world.addStepListener(new Tracker(view, world.getPlayer()));
        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);
        // start!
        try {
            // Open an audio input stream
            gameMusic = new SoundClip("data/The Walking Dead Theme.mp3");
            gameMusic.loop();  // Set it to continous playback (looping)
            bossMusic = new SoundClip("data/EasyStreet.mp3");
        } catch // ousside. how bout dah
                (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

        world.start();
    }

    public GameLevel getWorld() {
        return world;
    }

    /**
     * The player in the current level.
     */
    public Rick getPlayer1() {
        return world.getPlayer1();
    }

    public Daryl getPlayer2() {
        return world.getPlayer2();
    }

    /**
     * Is the current level of the game finished?
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * Advance to the next level of the game.
     */
    public void goNextLevel() {
        world.stop();
        if (level == 5) {
            System.exit(0);
        } else if (level == 4) {
            level++;
            gameMusic.stop();
            bossMusic.play();
            bossMusic.loop();
            // get a new world
            world = new Level5();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer1());
            controllerP2.setBody(world.getPlayer2());

            // show the new world in the view
            view.setWorld(world);

            world.start();
        } else if (level == 3) {
            level++;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer1());
            controllerP2.setBody(world.getPlayer2());

            // show the new world in the view
            view.setWorld(world);

            world.start();
        } else if (level == 2) {
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer1());
            controllerP2.setBody(world.getPlayer2());

            // show the new world in the view
            view.setWorld(world);

            world.start();

        } else {

            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer1());
            controllerP2.setBody(world.getPlayer2());
            // show the new world in the view
            view.setWorld(world);

            world.start();
        }
    }
    /**
     * Run the game.
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
    }

    public JFrame getFrame() {
        return frame;
    }
}
