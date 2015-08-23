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
import com.github.keon3141.ludumdare33.gui.Button;
import com.github.keon3141.ludumdare33.gui.Crosshairs;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class InGame extends BasicGameState {

	World w;
	public static Random rand;
	Input input;
	Button test;
	
	@Override
	public int getID() {
		return 1;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		input = container.getInput();
		rand = new Random();
		AnimHelper.setupAnimations();
		
		w = new World(1600,800,500,input);
		Entity ufo  = new UFO(0,0);
		w.addEntity(ufo);
		w.getC().setTarget(ufo);
		w.addGui(new Crosshairs(0,0));
		test =new Button(0,0,AnimHelper.abortbutton);
		w.addGui(test);
		for(int i = 0; i < 100; i++)
		{
			w.addEntity(new Person(rand.nextInt(800),450));
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
		if(test.pollClicked())
		{
			System.out.println("yep");
		}
		
	}

}
