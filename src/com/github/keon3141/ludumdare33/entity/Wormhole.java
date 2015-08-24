package com.github.keon3141.ludumdare33.entity;

import java.util.ArrayList;

import com.github.keon3141.ludumdare33.gameloop.World;
import com.github.keon3141.ludumdare33.helper.AnimHelper;
import com.github.keon3141.ludumdare33.helper.PlayerDataStorage;
import com.github.keon3141.ludumdare33.helper.RectangleHelper;
import com.github.keon3141.ludumdare33.helper.SoundHelper;

public class Wormhole extends Entity {

	boolean onGround = false;
	float time = 5f;
	
	public Wormhole(float x, float y) {
		super(x, y, AnimHelper.wormhole);
		this.rect.setCenterX(x);
		SoundHelper.wormhole.loop();
	}
	
	public void update(float dt, World w)
	{
		super.update(dt, w);
		time -= dt;
		if(time <=0)
		{
			this.die();
			SoundHelper.wormhole.stop();
		}
		
		if(!onGround)
		{
			dy += 200*dt;
			if(this.getRect().getMaxY()>w.getFloorLevel())
			{
				onGround = true;
				this.dy=0;
				this.getRect().setY(w.getFloorLevel()-this.getRect().getHeight());
			}
		}else
		{
			ArrayList<Entity> el = w.getEntityList();
			for (int i = 0; i < el.size(); i++)
			{
				if(el.get(i) instanceof Person)
				{
					Person p = (Person)el.get(i);
					if(Math.abs(p.rect.getCenterX()-this.rect.getCenterX())<5 && p.onGround)
					{
						System.out.println('b');
						p.die();
						PlayerDataStorage.humanCaptives ++;
					}
				}
			}
		}
	}

}
