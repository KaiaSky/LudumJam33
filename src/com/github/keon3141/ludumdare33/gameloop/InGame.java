package com.github.keon3141.ludumdare33.gameloop;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.github.keon3141.ludumdare33.entity.Entity;
import com.github.keon3141.ludumdare33.entity.Person;
import com.github.keon3141.ludumdare33.entity.Tank;
import com.github.keon3141.ludumdare33.entity.UFO;
import com.github.keon3141.ludumdare33.gui.Button;
import com.github.keon3141.ludumdare33.gui.Crosshairs;
import com.github.keon3141.ludumdare33.gui.EndLevelScreen;
import com.github.keon3141.ludumdare33.gui.Healthbar;
import com.github.keon3141.ludumdare33.gui.Timer;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class InGame extends BasicGameState {

	World w;
	public static Random rand;
	Input input;
	Button test;
	Healthbar health;
	Timer time;
	boolean over;
	
	@Override
	public int getID() {
		return 1;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		input = container.getInput();
		rand = new Random();
		over = false;
		w = new World(1600,800,500,input);
		Entity ufo  = new UFO(0,0);
		w.addEntity(ufo);
		w.getC().setTarget(ufo);
		w.addGui(new Crosshairs(0,0));
		test =new Button(0,0,AnimHelper.abortbutton);
		w.addGui(test);
		time = new Timer(800-128,0);
		w.addGui(time);
		health = new Healthbar(50,550, (UFO)ufo);
		w.addGui(health);
		for(int i = 0; i < 10; i++)
		{
			w.addEntity(new Person(rand.nextInt(800),450));
		}
		w.addEntity(new Tank(rand.nextInt(800),500));
		
		
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
		if(!over)
		{
			if(test.pollClicked())
			{
				w.addGui(new EndLevelScreen(2));
				over = true;
				w.setActive(false);
			}
			if(health.dead)
			{
				w.addGui(new EndLevelScreen(1));
				over = true;
				w.setActive(false);
			}if(time.out)
			{
				w.addGui(new EndLevelScreen(0));
				over = true;
				w.setActive(false);
			}
		}else{
			if(w.endRequested)
			{
				game.getState(2).init(container, game);
				game.enterState(2);
			}
		}
	}

}
