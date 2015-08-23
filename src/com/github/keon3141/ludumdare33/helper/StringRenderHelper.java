package com.github.keon3141.ludumdare33.helper;

import org.newdawn.slick.Graphics;

public class StringRenderHelper {

	public static void renderMultilineString(Graphics g, String s, float x, float y)
	{
		String lines[] = s.split("\\r?\\n");
		for(int i = 0; i < lines.length; i++)
		{
			g.drawString(lines[i], x, y+i*g.getFont().getLineHeight());
		}
	}
	
}
