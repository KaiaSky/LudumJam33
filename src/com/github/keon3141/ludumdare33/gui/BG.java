package com.github.keon3141.ludumdare33.gui;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

import com.github.keon3141.ludumdare33.gameloop.World;

public class BG extends GUIElement{

	float paralax;
	World parent;
	
	public BG( ArrayList<Animation> animations, float paralaxfactor, World parent) {
		super(0, 0, animations);
		paralax = paralaxfactor;
		this.parent = parent;
	}
	
	public void draw(Graphics g)
	{
		g.pushTransform();
		g.translate(-parent.getC().getX()*paralax, -parent.getC().getY()*paralax);
		super.draw(g);
		g.popTransform();
		
	}

}
