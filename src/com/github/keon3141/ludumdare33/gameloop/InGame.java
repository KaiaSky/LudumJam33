package com.github.keon3141.ludumdare33.gameloop;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.github.keon3141.ludumdare33.entity.Entity;

public class InGame extends BasicGameState {

	Entity test;
	Entity test2;
	
	@Override
	public int getID() {
		return 1;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		Image[] img = {new Image("res/img/test.png")};
		test= new Entity(0,0,new Animation(img,1));
		test2= new Entity(100,50,new Animation(img,1));
		test.setDx(10);
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		test.draw(g);
		test2.draw(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		float dt = delta/1000.0f;
		test.update(dt);
		test2.update(dt);
	}

}
