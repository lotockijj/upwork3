package upwork;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	private static final long serialVersionUID = 1L;
	
	public Circle(Color outlineColor, Color fillColor, Color backlColor, boolean isFilled, boolean isOutlined,
			boolean isBackColored) {
		super(outlineColor, fillColor, backlColor, isFilled, isOutlined, isBackColored);
	}

	@Override
	public void drawOutline(Graphics g) {
		g.drawOval(10, 10, 200, 200);
	}

	@Override
	public void drawFill(Graphics g) {
		g.fillOval(10, 10, 200, 200);	
	}
}
