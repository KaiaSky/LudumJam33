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

	World w;
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
		
		w = new World(1000,1000);
		
		test= new Entity(0,0,new Animation(img,1));
		test2= new Entity(100,50,new Animation(img,1));
		test.setDx(10);
		w.addEntity(test);
		w.addEntity(test2);
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		w.draw(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		float dt = delta/1000.0f;
		w.update(dt);
	}

}
