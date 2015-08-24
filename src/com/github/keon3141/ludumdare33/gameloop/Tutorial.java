package com.github.keon3141.ludumdare33.gameloop;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.github.keon3141.ludumdare33.gui.BG;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class Tutorial extends BasicGameState {

	public static Font awtFont = new Font("Times New Roman", Font.BOLD, 32);
	public static TrueTypeFont fontTitle = new TrueTypeFont(awtFont, false);
	
	World w;
	int page;
	BG tut;
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		w = new World(800,600,600, container.getInput());
		tut = new BG(AnimHelper.tutorial,0,w);
		w.addBG(tut);
		page = 0;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		w.draw(g);
		g.setFont(fontTitle);
		g.setColor(new Color(0,0,0));
		String s = "Click to continue: (" + (page+1)+ "/4)";
		g.drawString(s, 400-fontTitle.getWidth("Click to continue: (" + (page+1)+ "/4)")/2, 500);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		float dt = delta /1000.0f;
		w.update(dt);
		if(page==4)
		{
			game.enterState(1);
			return;
		}
		tut.setCurrentAnimation(page);
	}
	
	@Override
	public void keyPressed(int key, char c)
	{
		page ++;
	}
	
	@Override
	public void mousePressed(int key, int x, int y)
	{
		page ++;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 4;
	}

}
