package com.github.keon3141.ludumdare33.gui;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;

import com.github.keon3141.ludumdare33.gameloop.World;

public class Button extends GUIElement{

	public boolean hovered = false;
	public boolean clicked = true;
	
	public Button(float x, float y, ArrayList<Animation> animations) {
		super(x, y, animations);
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		Input in = w.input;
		if(this.rect.contains(in.getMouseX(), in.getMouseY()))
		{
			hovered = true;
			if(in.isMousePressed(in.MOUSE_LEFT_BUTTON))
			{
				clicked = true;
			}
		}
		else{hovered = false;}
	}
	
	public boolean pollClicked()
	{
		if(clicked)
		{
			clicked = false;
			return true;
		}
		return false;
	}

}
