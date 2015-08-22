package com.github.keon3141.ludumdare33.gameloop;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.github.keon3141.ludumdare33.entity.Entity;
import com.github.keon3141.ludumdare33.entity.UFO;

public class InGame extends BasicGameState {

	World w;
	
	Input input;
	
	@Override
	public int getID() {
		return 1;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		input = container.getInput();
		
		Image[] img = {new Image("res/img/test.png")};
		
		w = new World(1000,1000);
		
		w.addEntity(new UFO(new Animation(img,1),0,0,input));
		
		
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
