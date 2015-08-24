package com.github.keon3141.ludumdare33.helper;

public class PlayerDataStorage {

	public static int humanCaptives = 100;
	public static int totalCaptives = 100;
	public static int metal = 0;
	public static float thrustPower = 240;
	public static float tractorForce = 100;
	public static float plasmaSpeed = 300;
	public static int plasmaDamage = 5;
	public static int hullIntegrity = 100;
	public static boolean[] upgradesBought = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
	
	public static float scareRadius = 128;
	public static boolean cargoWarp = false;
	public static boolean microsingularity = false;
	public static boolean mindcontrol = false;
	public static boolean wormhole = false;
	
	public static int level = 0;
	public static int[] levelTotals = {0,15,30,60,120,240,512,Integer.MAX_VALUE};
	
	public static void updateLevels()
	{
		for(int i = 0; i < levelTotals.length; i++)
		{
			if(levelTotals[i]>totalCaptives)
			{
				level = i-1;
				return;
			}
		}
	}
}
