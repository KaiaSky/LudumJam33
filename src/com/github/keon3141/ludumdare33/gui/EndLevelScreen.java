package com.github.keon3141.ludumdare33.gui;

import java.util.ArrayList;

import org.newdawn.slick.Animation;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class EndLevelScreen extends GUIElement{

	boolean next = false;
	boolean stationary = false;
	float dy = 1000;
	public EndLevelScreen(int endscreenType) {
		super(100,-400, AnimHelper.endscreen);
		this.currentanimation = endscreenType;
	}
	
	public void pauseUpdate(float dt, World w)
	{
		this.setY(this.getY()+dy*dt);
		if(this.getY()<100)
		{
			dy = 2*(200-this.getY());
		}
		else{dy=0;stationary=true;}
		if(stationary&&w.input.isMouseButtonDown(w.input.MOUSE_LEFT_BUTTON))
		{
			w.endRequested = true;
		}
	}
	
	

}
