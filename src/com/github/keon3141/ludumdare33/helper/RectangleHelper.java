package com.github.keon3141.ludumdare33.helper;

import org.newdawn.slick.geom.Rectangle;

public class RectangleHelper {
	/*
	 * We use this because slick2d is a miserable pile of crap that can't be bothered to do contains right. Screw you slick2d.
	 * 
	 */
	public static boolean contains(Rectangle a, Rectangle b) {
	      float ax = a.getX();
	      float ay = a.getY();
	      float aw = a.getWidth();
	      float ah = a.getHeight();

	      float bx = b.getX();
	      float by = b.getY();
	      float bw = b.getWidth();
	      float bh = b.getHeight();

	      return ax < bx && (bx + bw) < (ax + aw) &&
	            ay < by && (by + bh) < (ay + ah);
	   }
}
