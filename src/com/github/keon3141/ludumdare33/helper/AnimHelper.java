package com.github.keon3141.ludumdare33.helper;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class AnimHelper {

	public static ArrayList<Animation> ufo;
	public static ArrayList<Animation> person;
	public static ArrayList<Animation> beam;
	public static ArrayList<Animation> plasma;
	public static ArrayList<Animation> explosion;
	public static ArrayList<Animation> abortbutton;
	public static ArrayList<Animation> crosshairs;
	public static ArrayList<Animation> timer;
	public static ArrayList<Animation> healthbar;
	
	public static void setupAnimations()
	{
		ufo = new ArrayList<Animation>();
		ufo.add(getAnimation("/res/img/test.png"));
		
		person = new ArrayList<Animation>();
		person.add(getAnimation("/res/img/human.png"));
		
		beam = new ArrayList<Animation>();
		beam.add(getAnimation("/res/img/tractorbeam.png"));
		
		plasma = new ArrayList<Animation>();
		plasma.add(getAnimation("/res/img/plasmabolt.png"));
		
		explosion = new ArrayList<Animation>();
		explosion.add(getAnimation("/res/img/explosion.png"));
		
		abortbutton = new ArrayList<Animation>();
		abortbutton.add(getAnimation("/res/img/gui/abortbutton/abortunpressed.png"));
		abortbutton.add(getAnimation("/res/img/gui/abortbutton/aborthovered.png"));
		abortbutton.add(getAnimation("/res/img/gui/abortbutton/abortpressed.png"));
		
		crosshairs = new ArrayList<Animation>();
		crosshairs.add(getAnimation("/res/img/crosshairs.png"));
		
		timer = new ArrayList<Animation>();
		timer.add(getAnimation("/res/img/gui/timer/timerbase.png"));
		
		healthbar = new ArrayList<Animation>();
		healthbar.add(getAnimation("/res/img/gui/healthbar/empty.png"));
		healthbar.add(getAnimation("/res/img/gui/healthbar/full.png"));
	}
	
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
