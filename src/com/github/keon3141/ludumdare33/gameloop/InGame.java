package com.github.keon3141.ludumdare33.gameloop;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.github.keon3141.ludumdare33.entity.Entity;
import com.github.keon3141.ludumdare33.entity.Person;
import com.github.keon3141.ludumdare33.entity.UFO;
import com.github.keon3141.ludumdare33.gui.Crosshairs;

public class InGame extends BasicGameState {

	World w;
	public static Random rand;
	Input input;
	
	@Override
	public int getID() {
		return 1;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		input = container.getInput();
		rand = new Random();
		Image[] img = {new Image("res/img/test.png")};
		Animation anim = new Animation(img,1);
		
		Image[] humanimg = {new Image("res/img/human.png")};
		Animation humananim = new Animation(humanimg,1);
		
		Image[] crosshairs = {new Image("res/img/crosshairs.png")};
		Animation crosshairanim = new Animation(crosshairs,1);
		
		w = new World(1000,1000,input);
		Entity ufo  = new UFO(0,0,anim);
		w.addEntity(ufo);
		w.getC().setTarget(ufo);
		w.addGui(new Crosshairs(0,0,crosshairanim));
		for(int i = 0; i < 100; i++)
		{
			w.addEntity(new Person(rand.nextInt(800),500, humananim));
		}
		
		
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
