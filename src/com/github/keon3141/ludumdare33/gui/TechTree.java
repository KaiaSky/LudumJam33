package com.github.keon3141.ludumdare33.gui;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

import com.github.keon3141.ludumdare33.gameloop.UpgradeScreen;
import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.PlayerDataStorage;
import com.github.keon3141.ludumdare33.helper.StringRenderHelper;

public class TechTree extends GUIElement{

	public HashMap<Integer, String> names;
	public HashMap<Integer, String> flavortext;
	
	public ArrayList<UpgradeButton> buttons;
	int currentActive = 0;
	
	public static Font awtFont = new Font("Times New Roman", Font.BOLD, 16);
	public static TrueTypeFont fontTitle = new TrueTypeFont(awtFont, false);

	public static Font awtFont2 = new Font("Times New Roman", Font.BOLD, 18);
	public static TrueTypeFont fontFlavor = new TrueTypeFont(awtFont2, false);
	
	Button purchase;
	
	
	public TechTree() {
		super(25, 25, AnimHelper.purchasebutton);
		this.rect.setWidth(750);
		this.rect.setHeight(450);
		purchase = new Button(600-128,350-32,AnimHelper.purchasebutton);
		addNames();
	}
	
	public void mousePressed(int x, int y)
	{
		for(int i =0; i < buttons.size(); i ++)
		{
			if(buttons.get(i).rect.contains(x, y))
			{
				buttons.get(i).active=true;
				buttons.get(currentActive).active=false;
				currentActive = i; // Do stuff here tomorrow.
				break;
			}
		}
		
	}
	
	public void draw(Graphics g)
	{
		for(int i =0; i < buttons.size(); i ++)
		{
			buttons.get(i).draw(g);
		}
		purchase.draw(g);
		g.setFont(fontFlavor);
		g.setColor(new Color(255,255,255));
		StringRenderHelper.renderMultilineString(g,flavortext.get(currentActive), 475, 100);
	}
	
	public void update(float dt, World w)
	{
		for(int i =0; i < buttons.size(); i ++)
		{
			buttons.get(i).update(dt,w);
		}
		purchase.update(dt,w);
		if(purchase.pollClicked())
		{
			buttons.get(currentActive).purchase();
		}
	}
	
	public void addUpgrade(int id)
	{
		switch (id)
		{
			case 0:
				PlayerDataStorage.thrustPower = 312f; break;
			case 1:
				PlayerDataStorage.thrustPower = 384f; break;
			case 2:
				PlayerDataStorage.thrustPower = 480f; break;
			case 3:
				PlayerDataStorage.tractorForce = 130; break;
			case 4:
				PlayerDataStorage.tractorForce = 170; break;
			case 5:
				PlayerDataStorage.tractorForce = 230; break;
			case 6:
				PlayerDataStorage.plasmaSpeed = 390; break;
			case 7:
				PlayerDataStorage.plasmaSpeed = 570; break;	
			case 8:
				PlayerDataStorage.plasmaDamage = 7; break;
			case 9:
				PlayerDataStorage.plasmaDamage = 9; break;
			case 10:
				PlayerDataStorage.hullIntegrity = 130; break;
			case 11:
				PlayerDataStorage.hullIntegrity = 170; break;
			case 12:
				PlayerDataStorage.hullIntegrity = 230; break;
			case 13:
				PlayerDataStorage.microsingularity = true;
				break;
			case 14:
				PlayerDataStorage.scareRadius = 1;
				break; //pheremone plasma
			case 15:
				PlayerDataStorage.mindcontrol = true;
				break;
			case 16:
				PlayerDataStorage.cargoWarp = true;
				break; //cargo warp
			case 17:
				PlayerDataStorage.wormhole = true;
				break;
			case 18:
				PlayerDataStorage.win = true;
				break; //stargate
			default:
				break;
		}
			
	}
	
	public void addNames()
	{
		buttons = new ArrayList<UpgradeButton>(18);
		names = new HashMap<Integer, String>();
		flavortext = new HashMap<Integer, String>();
		
		buttons.add(new UpgradeButton(25,50,0,this,5));
		buttons.add(new UpgradeButton(175,50,1,this,20,0));
		buttons.add(new UpgradeButton(325,50,2,this,50,1));
		
		buttons.add(new UpgradeButton(25,100,3,this,5));
		buttons.add(new UpgradeButton(175,100,4,this,20,3));
		buttons.add(new UpgradeButton(325,100,5,this,50,4));
		
		buttons.add(new UpgradeButton(25,150,6,this,10));
		buttons.add(new UpgradeButton(175,150,7,this,30,6));
		
		buttons.add(new UpgradeButton(25,200,8,this,20));
		buttons.add(new UpgradeButton(175,200,9,this,60,8));
		
		buttons.add(new UpgradeButton(25,250,10,this,5));
		buttons.add(new UpgradeButton(175,250,11,this,20,10));
		buttons.add(new UpgradeButton(325,250,12,this,40,11));
		
		buttons.add(new UpgradeButton(25,300,13,this,50));
		buttons.add(new UpgradeButton(175,300,14,this,50));
		buttons.add(new UpgradeButton(325,300,15,this,50));
		
		buttons.add(new UpgradeButton(25,350,16,this,30));
		buttons.add(new UpgradeButton(175,350,17,this,80,16));
		buttons.add(new UpgradeButton(325,350,18,this,200,17));
		
		names.put(0, "Propulsion I");
		names.put(1, "Propulsion II");
		names.put(2, "Propulsion III");
		names.put(3, "Tractor I");
		names.put(4, "Tractor II");
		names.put(5, "Tractor III");
		names.put(6, "Plasma Speed I");
		names.put(7, "Plasma Speed II");
		names.put(8, "Plasma Power I");
		names.put(9, "Plasma Power II");
		names.put(10, "Hull I");
		names.put(11, "Hull II");
		names.put(12, "Hull III");
		names.put(13, "Microsingularity");
		names.put(14, "Pheremone Plasma");
		names.put(15, "Hijack Minds");
		names.put(16, "Cargo Warp I");
		names.put(17, "Wormhole II");
		names.put(18, "Stargate III");
		
		flavortext.put(0, "Propulsion I: 5 Humans\nIt turns out that the Humans are a \nviable reactor fuel! Increases UFO \nthrust by 30%!");
		flavortext.put(1, "Propulsion II: 20 Humans\nBy bombarding the fual humans\nwith radiation, we can create \ndeuterium-enriched water in its \ncells. This should allow further \nspeed increase of 30%");
		flavortext.put(2, "Propulsion III: 50 Humans\nHuman genome can be modified to\nproduce even better fuel! Increase \nthrust by 40%!");
		flavortext.put(3, "Tractor I: 5 Humans\nAdding sound effects to the gravity \ntractor beam seems to speed \nhuman abduction by 30%");
		flavortext.put(4, "Tractor II: 20 Humans\nHumans cought in tractor beam\nare routed through a turbine to \nproduce power. The power is \nsupplied back to the beam for a \n40% increase in power.");
		flavortext.put(5, "Tractor III: 50 Humans\nFiring millions of nanoharpoons \ninto the hide of abducted humans \nallows a 60% increase in \nabduction speed.");
		flavortext.put(6, "Plasma Speed I: 10 Humans\nBy using elements of the human \nmouth's design, our plasma beams\ncan literally spit death. \n30% faster plasma shots.");
		flavortext.put(7, "Plasma Speed II: 30 Humans\nBy using a human sprinkler we can \nmodify the eddy currents in plasma\nbursts, allowing 60% faster bolts.");
		flavortext.put(8, "Plasma Power I: 20 Humans\nEjecting a horseshoe magnet with \nthe plasma bolt negates the \ndissapation allowing 40% more \ndamaging plasma shots.");
		flavortext.put(9, "Plasma Power II: 60 Humans\nChanging the color of the plasma \nfrom lime to chartruse allows a \nfurther increase in power of 40%.");
		flavortext.put(10, "Hull I: 5 Humans\nHuman skeletons are frail and \nweak, but when mixed with UFO \nalloys they create a product 30% \ntougher than previous alloys.");
		flavortext.put(11, "Hull II: 20 Humans\nStudies of human fiction have \nindicated that alien ships painted \nwith a smiling face are \n40% more resistant to attacks.");
		flavortext.put(12, "Hull III: 40 Humans\nHumans make good blast shields, \nand it's not like we've got a \nshortage of them. 50% more health \nby hanging human decoys outside.");
		flavortext.put(13, "Microsingularity: 50 Humans\nIf you stick too many humans in \nthe same space-warp holding cell \nthey create a singularity.\n\n...In dire situations we could \nweaponize this. \nE to activate.");
		flavortext.put(14, "Pheremone Plasma: 50 Humans\nAdding the chemicals found in the \nhuman substance \"Pizza\" negates \nthe panic caused by being the \ntarget of a alien attack. \n\nHumans no longer panic from \nbeing shot at.");
		flavortext.put(15, "Hijack Minds: 50 Humans\nOur infiltration teams have \nmanaged to control the television \nnetworks.\n\nWhen active all the humans will \nrun straight into our tractor beam. \nR to activate.");
		flavortext.put(16, "Cargo Warp I: 30 Humans\nThough the humans somehow \ndon't know it, they can control \ntime and space with their minds.\nWe can use this to teleport them \nto the mothership in case our \nship is destroyed while on mission.");
		flavortext.put(17, "Wormhole II: 80 Humans\nBy training enough humans, we \nshould be able to tear a tunnel \ndirectly from the surface of earth \nto the holding pen of our \nmothership, capturing anybody \nwho walks over it.\nT to activate.");
		flavortext.put(18, "Stargate III: 200 Humans\nWith enough humans, the universe \nis open to our conquest.\nTear a permanant hole through \nspace and time, and the \nfuture (and past) is yours.\n\nThis will win the game.");
	}

}
