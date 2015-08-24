package com.github.keon3141.ludumdare33.helper;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class SoundHelper {

	public static Sound plasmaimpact; 
	public static Sound plasmashot; 
	public static Sound[] screams;
	public static Sound tankcannon;
	public static Sound tractorbeam;
	public static Sound ufo;
	
	public static void loadSounds()
	{
		try {
			plasmaimpact = new Sound("/res/sfx/plasmaimpact.ogg");
			plasmashot = new Sound("/res/sfx/plasmashot.ogg");
			screams = new Sound[10];
			for(int i = 0; i < 10; i+=2)
			{
				screams[i] = new Sound("/res/sfx/scream1.ogg");
				screams[i+1] = new Sound("/res/sfx/scream2.ogg");
			}
			
			tankcannon = new Sound("/res/sfx/tankcannon.ogg");
			tractorbeam = new Sound("/res/sfx/tractorbeam.ogg");
			ufo = new Sound("/res/sfx/ufo.ogg");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static Sound getScream()
	{
		for(int i = 0; i < 10; i++)
		{
			if(!screams[i].playing())
			{
				return screams[i];
			}
		}
		return screams[0];
	}
}
