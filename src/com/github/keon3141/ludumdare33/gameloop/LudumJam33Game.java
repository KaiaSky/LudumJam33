package com.github.keon3141.ludumdare33.gameloop;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class LudumJam33Game extends StateBasedGame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int FPS = 60;
    public static final String VERSION = "0.0.1a",
    private static AppGameContainer app;

    public LudumJam33Game(String appName) {
        super(appName);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        //addState(new InGame());
    }

    @Override
    protected void preRenderState(GameContainer container, Graphics g)
            throws SlickException {
        super.preRenderState(container, g);
    }
    
    // Main Method
    public static void begin(String[] args) {
        try {
            app = new AppGameContainer(new LudumJam33Game(TITLE + " v" + VERSION));
            app.setDisplayMode(WIDTH, HEIGHT, false);
            app.setTargetFrameRate(FPS);
            app.setShowFPS(true);
            app.setForceExit(false);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public static AppGameContainer getAGContainer() {
        return app;
    }
}
