package com.github.keon3141.ludumdare33.gameloop;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.github.keon3141.ludumdare33.entity.Entity;
import com.github.keon3141.ludumdare33.entity.LevelSpawner;
import com.github.keon3141.ludumdare33.entity.UFO;
import com.github.keon3141.ludumdare33.gui.BG;
import com.github.keon3141.ludumdare33.gui.Button;
import com.github.keon3141.ludumdare33.gui.Crosshairs;
import com.github.keon3141.ludumdare33.gui.EndLevelScreen;
import com.github.keon3141.ludumdare33.gui.Healthbar;
import com.github.keon3141.ludumdare33.gui.Timer;
import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.PlayerDataStorage;

public class InGame extends BasicGameState {

	World w;
	public static Random rand;
	Input input;
	Button test;
	Healthbar health;
	Timer time;
	boolean over;
	Entity ufo;
	
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
		ufo  = new UFO(800,100);
		w.addEntity(ufo);
		w.getC().setTarget(ufo);
		
		w.addBG(new BG(AnimHelper.sky,0,w));
		w.addBG(new BG(AnimHelper.farhills,.25f,w));
		w.addBG(new BG(AnimHelper.hillsfront,.5f,w));
		w.addBG(new BG(AnimHelper.frontbuildings,1,w));
		
		w.addGui(new Crosshairs(0,0));
		
		w.addGui(new BG(AnimHelper.gamegui,0,w));
		
		test =new Button(0,0,AnimHelper.abortbutton);
		w.addGui(test);
		time = new Timer(800-128,0);
		w.addGui(time);
		health = new Healthbar(50,550, (UFO)ufo);
		w.addGui(health);
		
		
		
		w.addEntity(new LevelSpawner(w));
		
		
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame g)
	{
		container.setMouseGrabbed(true);
	}
	
	@Override
	public void leave(GameContainer container, StateBasedGame g)
	{
		container.setMouseGrabbed(false);
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
				freeMouse(container);
				container.setMouseGrabbed(false);
				w.addGui(new EndLevelScreen(2));
				PlayerDataStorage.humanCaptives += ((UFO)ufo).captives;
				PlayerDataStorage.totalCaptives += ((UFO)ufo).captives;
				over = true;
				w.setActive(false);
			}
			if(health.dead)
			{
				freeMouse(container);
				if(PlayerDataStorage.cargoWarp)
				{
					PlayerDataStorage.humanCaptives += ((UFO)ufo).captives;
					PlayerDataStorage.totalCaptives += ((UFO)ufo).captives;
					w.addGui(new EndLevelScreen(3));
				}else{
					w.addGui(new EndLevelScreen(1));
				}
				container.setMouseGrabbed(false);
				over = true;
				w.setActive(false);
			}if(time.out)
			{
				freeMouse(container);
				w.addGui(new EndLevelScreen(0));

				PlayerDataStorage.humanCaptives += ((UFO)ufo).captives;
				PlayerDataStorage.totalCaptives += ((UFO)ufo).captives;
				over = true;
				w.setActive(false);
			}
		}else{
			if(w.endRequested)
			{
				w.close();
				game.getState(2).init(container, game);
				game.enterState(2);
			}
		}
	}
	
	public void freeMouse(GameContainer gc)
	{
		int x = gc.getInput().getMouseX();
		int y = gc.getInput().getMouseY();
		gc.setMouseGrabbed(false);
		org.lwjgl.input.Mouse.setCursorPosition(x,600-y);
	}

}
