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
	public static ArrayList<Animation> endscreen;
	public static ArrayList<Animation> tank;
	public static ArrayList<Animation> missile;
	public static ArrayList<Animation> purchasebutton;
	public static ArrayList<Animation> launchbutton;
	public static ArrayList<Animation> upgradebutton;
	
	public static ArrayList<Animation> upgradebg;
	
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
		
		endscreen = new ArrayList<Animation>();
		endscreen.add(getAnimation("/res/img/gui/endlevelscreens/time.png"));
		endscreen.add(getAnimation("/res/img/gui/endlevelscreens/shipdestroyed.png"));
		endscreen.add(getAnimation("/res/img/gui/endlevelscreens/abort.png"));
		
		tank = new ArrayList<Animation>();
		tank.add(getAnimation("/res/img/entities/tank/tankR.png"));
		tank.add(getAnimation("/res/img/entities/tank/tankL.png"));
		
		missile = new ArrayList<Animation>();
		missile.add(getAnimation(new String[]{"/res/img/entities/tank/missile1.png","/res/img/entities/tank/missile2.png"},100));

		purchasebutton = new ArrayList<Animation>();
		purchasebutton.add(getAnimation("/res/img/gui/upgradescreen/buybuttonunpressed.png"));
		purchasebutton.add(getAnimation("/res/img/gui/upgradescreen/buybuttonhovered.png"));
		purchasebutton.add(getAnimation("/res/img/gui/upgradescreen/buybuttonpressed.png"));
		
		launchbutton = new ArrayList<Animation>();
		launchbutton.add(getAnimation("/res/img/gui/upgradescreen/launchunpressed.png"));
		launchbutton.add(getAnimation("/res/img/gui/upgradescreen/launchhovered.png"));
		launchbutton.add(getAnimation("/res/img/gui/upgradescreen/launchpressed.png"));
		
		upgradebutton = new ArrayList<Animation>();
		upgradebutton.add(getAnimation("/res/img/gui/upgradescreen/buttonunpressed.png"));
		upgradebutton.add(getAnimation("/res/img/gui/upgradescreen/buttonhovered.png"));
		upgradebutton.add(getAnimation("/res/img/gui/upgradescreen/buttonpressed.png"));
		upgradebutton.add(getAnimation("/res/img/gui/upgradescreen/buttonowned.png"));
		upgradebutton.add(getAnimation("/res/img/gui/upgradescreen/buttoncantunlock.png"));
		
		upgradebg = new ArrayList<Animation>();
		upgradebg.add(getAnimation("/res/img/gui/upgradescreen/upgradescreenbg.png"));
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