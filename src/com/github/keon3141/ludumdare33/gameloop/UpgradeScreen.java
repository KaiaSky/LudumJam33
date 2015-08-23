package com.github.keon3141.ludumdare33.gameloop;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.github.keon3141.ludumdare33.gui.Button;
import com.github.keon3141.ludumdare33.gui.TechTree;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class UpgradeScreen extends BasicGameState{

	Button launchinvasion;
	
	Input input;
	World w;
	TechTree tt;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		input = container.getInput();
		w = new World(800,600,600,input);
		launchinvasion = new Button(400-128,550-32,AnimHelper.launchbutton);
		tt = new TechTree();
		w.addGui(tt);
		w.addGui(launchinvasion);
	}

	@Override
	public void mousePressed(int button, int x, int y)
	{
		if(button == input.MOUSE_LEFT_BUTTON)
		{
			tt.mousePressed(x, y);
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
		if(launchinvasion.pollClicked())
		{
			game.getState(1).init(container, game);
			game.enterState(1);
		}
	}

	@Override
	public int getID() {
		return 2;
	}
	
	

}
