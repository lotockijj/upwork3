package upwork;
import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape{
	private static final long serialVersionUID = 1L;

	public Square(Color outlineColor, Color fillColor, Color backlColor, boolean isFilled, boolean isOutlined,
			boolean isBackColored) {
		super(outlineColor, fillColor, backlColor, isFilled, isOutlined, isBackColored);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawOutline(Graphics g) {
		g.drawRect(10, 10, 200, 200);	
	}

	@Override
	public void drawFill(Graphics g) {
		g.fillRect(10, 10, 200, 200);
	}
}
