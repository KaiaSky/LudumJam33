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
	public static ArrayList<Animation> turret;
	public static ArrayList<Animation> cannon;
	public static ArrayList<Animation> purchasebutton;
	public static ArrayList<Animation> launchbutton;
	public static ArrayList<Animation> upgradebutton;
	
	public static ArrayList<Animation> upgradebg;
	
	public static void setupAnimations()
	{
		ufo = new ArrayList<Animation>();
		ufo.add(getAnimation("/res/img/entities/ufo/ufostationary.png"));
		ufo.add(getAnimation("/res/img/entities/ufo/uforight.png"));
		ufo.add(getAnimation("/res/img/entities/ufo/ufoleft.png"));
		
		person = new ArrayList<Animation>();
		person.add(getAnimation(new String[]{"/res/img/entities/person/blackwoman/right1.png","/res/img/entities/person/blackwoman/right2.png","/res/img/entities/person/blackwoman/right3.png","/res/img/entities/person/blackwoman/right4.png"},200));
		person.add(getAnimation(new String[]{"/res/img/entities/person/blackwoman/left1.png","/res/img/entities/person/blackwoman/left2.png","/res/img/entities/person/blackwoman/left3.png","/res/img/entities/person/blackwoman/left4.png"},200));
		person.add(getAnimation(new String[]{"/res/img/entities/person/blackwoman/right1.png","/res/img/entities/person/blackwoman/right2.png","/res/img/entities/person/blackwoman/right3.png","/res/img/entities/person/blackwoman/right4.png"},100));
		person.add(getAnimation(new String[]{"/res/img/entities/person/blackwoman/left1.png","/res/img/entities/person/blackwoman/left2.png","/res/img/entities/person/blackwoman/left3.png","/res/img/entities/person/blackwoman/left4.png"},100));
		person.add(getAnimation("/res/img/entities/person/blackwoman/rightair.png"));
		person.add(getAnimation("/res/img/entities/person/blackwoman/leftair.png"));
		
		person.add(getAnimation(new String[]{"/res/img/entities/person/blackman/right1.png","/res/img/entities/person/blackman/right2.png","/res/img/entities/person/blackman/right3.png","/res/img/entities/person/blackman/right4.png"},200));
		person.add(getAnimation(new String[]{"/res/img/entities/person/blackman/left1.png","/res/img/entities/person/blackman/left2.png","/res/img/entities/person/blackman/left3.png","/res/img/entities/person/blackman/left4.png"},200));
		person.add(getAnimation(new String[]{"/res/img/entities/person/blackman/right1.png","/res/img/entities/person/blackman/right2.png","/res/img/entities/person/blackman/right3.png","/res/img/entities/person/blackman/right4.png"},100));
		person.add(getAnimation(new String[]{"/res/img/entities/person/blackman/left1.png","/res/img/entities/person/blackman/left2.png","/res/img/entities/person/blackman/left3.png","/res/img/entities/person/blackman/left4.png"},100));
		person.add(getAnimation("/res/img/entities/person/blackman/rightair.png"));
		person.add(getAnimation("/res/img/entities/person/blackman/leftair.png"));
		
		person.add(getAnimation(new String[]{"/res/img/entities/person/whitewoman/right1.png","/res/img/entities/person/whitewoman/right2.png","/res/img/entities/person/whitewoman/right3.png","/res/img/entities/person/whitewoman/right4.png"},200));
		person.add(getAnimation(new String[]{"/res/img/entities/person/whitewoman/left1.png","/res/img/entities/person/whitewoman/left2.png","/res/img/entities/person/whitewoman/left3.png","/res/img/entities/person/whitewoman/left4.png"},200));
		person.add(getAnimation(new String[]{"/res/img/entities/person/whitewoman/right1.png","/res/img/entities/person/whitewoman/right2.png","/res/img/entities/person/whitewoman/right3.png","/res/img/entities/person/whitewoman/right4.png"},100));
		person.add(getAnimation(new String[]{"/res/img/entities/person/whitewoman/left1.png","/res/img/entities/person/whitewoman/left2.png","/res/img/entities/person/whitewoman/left3.png","/res/img/entities/person/whitewoman/left4.png"},100));
		person.add(getAnimation("/res/img/entities/person/whitewoman/rightair.png"));
		person.add(getAnimation("/res/img/entities/person/whitewoman/leftair.png"));
		
		person.add(getAnimation(new String[]{"/res/img/entities/person/whiteman/right1.png","/res/img/entities/person/whiteman/right2.png","/res/img/entities/person/whiteman/right3.png","/res/img/entities/person/whiteman/right4.png"},200));
		person.add(getAnimation(new String[]{"/res/img/entities/person/whiteman/left1.png","/res/img/entities/person/whiteman/left2.png","/res/img/entities/person/whiteman/left3.png","/res/img/entities/person/whiteman/left4.png"},200));
		person.add(getAnimation(new String[]{"/res/img/entities/person/whiteman/right1.png","/res/img/entities/person/whiteman/right2.png","/res/img/entities/person/whiteman/right3.png","/res/img/entities/person/whiteman/right4.png"},100));
		person.add(getAnimation(new String[]{"/res/img/entities/person/whiteman/left1.png","/res/img/entities/person/whiteman/left2.png","/res/img/entities/person/whiteman/left3.png","/res/img/entities/person/whiteman/left4.png"},100));
		person.add(getAnimation("/res/img/entities/person/whiteman/rightair.png"));
		person.add(getAnimation("/res/img/entities/person/whiteman/leftair.png"));
		
		beam = new ArrayList<Animation>();
		beam.add(getAnimation(new String[]{"/res/img/entities/tractorbeam/beam1.png","/res/img/entities/tractorbeam/beam2.png"},50));
		
		plasma = new ArrayList<Animation>();
		plasma.add(getAnimation(new String[]{"/res/img/entities/plasma/plasma1.png","/res/img/entities/plasma/plasma2.png","/res/img/entities/plasma/plasma3.png","/res/img/entities/plasma/plasma4.png"},50));
		
		explosion = new ArrayList<Animation>();
		explosion.add(getAnimation(new String[]{"/res/img/entities/explosion/1.png","/res/img/entities/explosion/2.png","/res/img/entities/explosion/3.png","/res/img/entities/explosion/4.png","/res/img/entities/explosion/5.png","/res/img/entities/explosion/6.png"},43));
		
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
		
		turret = new ArrayList<Animation>();
		turret.add(getAnimation("/res/img/entities/tank/turretR.png"));
		turret.add(getAnimation("/res/img/entities/tank/turretL.png"));
		
		cannon = new ArrayList<Animation>();
		cannon.add(getAnimation("/res/img/entities/tank/cannon.png"));

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
