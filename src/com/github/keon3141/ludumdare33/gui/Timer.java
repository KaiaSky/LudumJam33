package com.github.keon3141.ludumdare33.gui;


import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class Timer extends GUIElement{

	float initialTime = 30;
	float currentTime;
	boolean out = false;
	Font awtFont = new Font("Times New Roman", Font.BOLD, 72);
	TrueTypeFont font = new TrueTypeFont(awtFont, false);
	
	public Timer(float x, float y) {
		super(x, y, AnimHelper.timer);
		currentTime = initialTime;
	}
	
	public Timer(float x, float y, float initialTime) {
		super(x, y, AnimHelper.timer);
		this.initialTime = initialTime;
		currentTime = this.initialTime;
	}
	
	public void update(float dt, World w)
	{
		
		if (currentTime <= 0)
		{
			out = true;
			currentTime = 0;
		}else{currentTime-=dt;}
	}
	
	public void draw(Graphics g)
	{
		super.draw(g);
		g.setColor(new Color(100,140,255));
		g.fillArc(getX()+4, getY()+4, rect.getWidth()-7, rect.getHeight()-7, 270+360.0f*(1-(currentTime/initialTime)),270+360);
		g.setColor(new Color(0,0,0));
		g.setFont(font);
		g.drawString(""+(int)currentTime, getX()+this.rect.getWidth()/2-font.getWidth(""+(int)currentTime)/2, getY()+this.rect.getHeight()/2-font.getHeight(""+(int)currentTime)/2);
	}

}
