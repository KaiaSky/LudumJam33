package com.github.keon3141.ludumdare33.gui;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Input;

import com.github.keon3141.ludumdare33.gameloop.World;

public class Button extends GUIElement{

	public boolean hovered = false;
	public boolean clicked = false;
	public boolean clicking = false;
	public float clickedTime = 1f;
	public float currentTime = 1f;
	
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
			if(in.isMouseButtonDown(in.MOUSE_LEFT_BUTTON) && ! clicking)
			{
				clicked = true;
			}
		}
		else{hovered = false;}
		
		if(clicked)
		{
			clicking = true;
		}
		if(clicking)
		{
			currentTime -= dt;
			this.setCurrentAnimation(2);
		}
		if(currentTime < 0)
		{
			clicking = false;
			currentTime = clickedTime;
		}
		if(hovered && !clicking)
		{
			this.setCurrentAnimation(1);
		}else if (! hovered && ! clicking)
		{
			this.setCurrentAnimation(0);
		}
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
