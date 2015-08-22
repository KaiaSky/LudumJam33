package com.github.keon3141.ludumdare33.helper;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AnimHelper {

	public static Animation getAnimation(String str)
	{
		try {
			Image[] img = {new Image(str)};
			Animation anim = new Animation(img, 1);
			return anim;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Animation getAnimation(String[] str, int duration)
	{
		try {
			Image[] img = new Image[str.length];
			for(int i =0; i < str.length; i ++)
			{
				img[i] = new Image(str[i]);
			}
			Animation anim = new Animation(img, duration);
			return anim;
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
