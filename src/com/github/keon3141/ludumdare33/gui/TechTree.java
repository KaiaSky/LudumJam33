package com.github.keon3141.ludumdare33.gui;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;

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
		g.setColor(new Color(0,0,0));
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
				break; //microsingularity
			case 14:
				break; //pheremone plasma
			case 15:
				break; // Hijack minds
			case 16:
				break; //cargo warp
			case 17:
				break; //wormhole
			case 18:
				break; //stargate
			default:
				break;
		}
		System.out.println(PlayerDataStorage.thrustPower);
			
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
		
		flavortext.put(0, "Propulsion I:\nIt turns out that the Humans are a \nviable reactor fuel! Increases UFO \nthrust by 30%!");
		flavortext.put(1, "Propulsion II:\nBy bombarding the live fuel source with\nradiation, we can create \ndeuterium-enriched water in its cells.\nThis should allow further speed increase \nof 30%");
		flavortext.put(2, "Propulsion III:\nHuman genome can be modified to\nproduce even better fuel! Increase \nthrust by 40%!");
		flavortext.put(3, "Tractor I:\nAdding sound effects to the gravity \ntractor beam seems to speed human \nabduction by 30%");
		flavortext.put(4, "Tractor II:\nHumans cought in tractor beam are \nrouted through a turbine to produce \npower. The power is supplied back to \nthe beam for a 40% increase in power.");
		flavortext.put(5, "Tractor III\nFiring millions of nanoharpoons into the \nhide of abducted humans allows a 60% \nincrease in abduction speed.");
		flavortext.put(6, "Plasma Speed I:\nBy using elements of the human mouth's \ndesign, our plasma beams can literally \nspit death. 30% faster plasma shots.");
		flavortext.put(7, "Plasma Speed II:\nBy using a human sprinkler we can \nmodify the eddy currents in plasma\nbursts, allowing 60% faster bolts.");
		flavortext.put(8, "Plasma Power I:\nEjecting a horseshoe magnet with the \nplasma bolt negates the atmospheric \ndissapation allowing 40% more \ndamaging plasma shots.");
		flavortext.put(9, "Plasma Power II:\nChanging the color of the plasma from \nlime-green to a more chartruse color \nallows a further increase in power of 40%.");
		flavortext.put(10, "Hull I:\nHuman skeletons are frail and weak,\nbut when mixed with UFO alloys\nthey create a product 30% tougher than \nanything we've seen before.");
		flavortext.put(11, "Hull II:\nStudies of human fiction have indicated \nthat alien ships painted with a smiling \nface are 40% more resistant to attacks.");
		flavortext.put(12, "Hull III:\nHumans make good blast shields, and \nit's not like we've got a shortage of \nthem. 50% more health from hanging \nhuman decoys outside.");
		flavortext.put(13, "Microsingularity:\nIf you stick too many humans in the \nsame space-warp holding cell they create \na singularity.\n\n...In dire situations we could \nweaponize this.");
		flavortext.put(14, "Pheremone Plasma:\nAdding the chemicals found in the \nhuman substance \"Pizza\" negates the \npanic caused by being the target of a alien \nattack. Humans no longer panic from \nbeing shot at.");
		flavortext.put(15, "Hijack Minds:\nOur infiltration teams have managed to \ncontrol the television networks.\nFor a signifigant cost, we could \nmind control all the humans into\nrunning straight into our tractor beam.");
		flavortext.put(16, "Cargo Warp I:\nThough the humans somehow don't \nknow it, they can control time and space \nwith their minds. We can use this to \nteleport them to the mothership in case our \nship is destroyed while on mission.");
		flavortext.put(17, "Wormhole II:\nBy training enough humans, we should \nbe able to tear a tunnel directly from \nthe surface of earth to the holding pen \nof our mothership, capturing \nanybody who walks over it.");
		flavortext.put(18, "Stargate III:\nWith enough humans, the universe is \nopen to our conquest.\nTear a permanant hole through \nspace and time, and the \nfuture (and past) is yours.\n\nThis will win the game.");
	}

}
