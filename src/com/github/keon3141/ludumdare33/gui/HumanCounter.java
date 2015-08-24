package com.github.keon3141.ludumdare33.gui;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.PlayerDataStorage;

public class HumanCounter extends GUIElement{

	int humans;
	public static Font awtFont2 = new Font("Times New Roman", Font.BOLD, 18);
	public static TrueTypeFont f = new TrueTypeFont(awtFont2, false);
	
	public HumanCounter(float x, float y) {
		super(x, y, AnimHelper.cannon);
		humans = PlayerDataStorage.humanCaptives;
	}
	
	public void update(float dt, World w)
	{
		humans = PlayerDataStorage.humanCaptives;
	}
	public void draw(Graphics g)
	{
		g.setFont(f);
		g.setColor(new Color(255,255,255));
		g.drawString("Humans: " + humans, this.getX(), getY());
	}

}
