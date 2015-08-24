package com.github.keon3141.ludumdare33.gameloop;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.github.keon3141.ludumdare33.gui.BG;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class StartScreen extends BasicGameState {

	World w;
	boolean next = false;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		w = new World(800,600,600, container.getInput());
		w.addBG(new BG(AnimHelper.titlescreen,0,w));
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		w.draw(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		float dt = delta /1000.0f;
		w.update(dt);
		if(next)
		{
			game.enterState(1);
		}
	}
	
	@Override
	public void keyPressed(int key, char c)
	{
		next = true;
	}
	
	@Override
	public void mousePressed(int key, int x, int y)
	{
		next = true;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
