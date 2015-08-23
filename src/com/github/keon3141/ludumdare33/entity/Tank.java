package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;

import com.github.keon3141.ludumdare33.gameloop.InGame;
import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;

public class Tank extends Entity implements GoodGuys{

	float weaponcooldown = 3;
	float currentCooldown = 3;
	float targetingDistance = 500;
	boolean readytofire = true;
	boolean hasInit = false;
	boolean direction;
	float directionTime;
	float speed = 0;
	Entity target;
	ArrayList<Animation> turret;
	int turretanimation;
	float angle;
	
	public Tank(float x, float y) {
		super(x, y, AnimHelper.tank);
		health = 7;
		maxhealth = 7;
		direction = InGame.rand.nextBoolean();
		directionTime = InGame.rand.nextInt(300)/10.0f;
		turret = AnimHelper.turret;
		turretanimation = 0;
		angle = 45;
	}
	
	public void draw(Graphics g)
	{
		g.pushTransform();
		if(direction)
		{
			g.rotate(this.rect.getX()+30, this.rect.getY()+30, (float) Math.toDegrees(angle)+180);
			g.drawAnimation(turret.get(turretanimation), this.rect.getX()+30, this.rect.getY()+30);
		}
		else
		{
			g.rotate(this.rect.getX()+90, this.rect.getY()+30, (float) Math.toDegrees(angle));
			g.drawAnimation(turret.get(turretanimation), this.rect.getX()+30, this.rect.getY()+30);
		}
		g.popTransform();
		super.draw(g);
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		if(!hasInit)
		{
			ArrayList<Entity> el = w.getEntityList();
			for (int i = 0; i < el.size(); i++)
			{
				if(el.get(i) instanceof UFO)
				{
					target = el.get(i);
					break;
				}
			}
			hasInit = true;
		}
		
		if(direction)
		{
			this.currentanimation = 0;
			this.dx = speed;
		}
		else
		{
			this.currentanimation = 1;
			this.dx = -speed;
		}
		directionTime-=dt;
		if(directionTime<0)
		{
			direction=!direction;
			directionTime = InGame.rand.nextInt(300)/10.0f;
		}
		angle = (float) Math.atan2(this.getRect().getCenterY()-target.getRect().getCenterY(), this.getRect().getCenterX()-target.getRect().getCenterX());
		if(readytofire )
		{
			float dist = (float) (Math.pow((this.getRect().getCenterX()-target.getRect().getCenterX()),2) +  Math.pow((this.getRect().getCenterY()-target.getRect().getCenterY()),2));
			if(targetingDistance*targetingDistance>dist)
			{
				if(direction)
				{
					w.addEntity(new Missile(this.getRect().getX()+33,this.getRect().getY()+30, angle),0);
				}
				else{
					w.addEntity(new Missile(this.getRect().getX()+87,this.getRect().getY()+30, angle),0);
				}
				readytofire = false;
			}
		}else{
			currentCooldown -= dt;
			if(currentCooldown < 0)
			{
				currentCooldown = weaponcooldown;
				readytofire = true;
			}
		}
		
		if(this.getRect().getMinX() < 0 || this.getRect().getMaxX() > w.width)
		{
			direction = !direction;
			dx = -dx;
		}
	}

}
