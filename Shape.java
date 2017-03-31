package upwork;
import javax.swing.*;
import java.awt.*;

public abstract class Shape extends JPanel {
	private static final long serialVersionUID = 1L;

	private Color outlineColor;
	private Color fillColor;
	private Color backColor;
	private boolean isFilled;
	private boolean isOutlined;
	private boolean isBackColored;


	public Shape(Color outlineColor, Color fillColor, Color backlColor, boolean isFilled, boolean isOutlined,
			boolean isBackColored) {
		super();
		this.outlineColor = outlineColor;
		this.fillColor = fillColor;
		this.backColor = backlColor;
		this.isFilled = isFilled;
		this.isOutlined = isOutlined;
		this.isBackColored = isBackColored;
	}

	public Color getOutlineColor() {
		return outlineColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(10.0f));

		if (isOutlined) {
			g.setColor(outlineColor);
			drawOutline(g);
		}
		if (isFilled) {
			g.setColor(fillColor);
			drawFill(g);
		}
		if (isBackColored) {
			//g.setColor(backColor);
			this.setBackground(backColor);
		}
	}



	@Override
	public String toString() {
		return " " +this.getClass() + "\noutlineColor=" + outlineColor + "\n fillColor=" + fillColor + "\n backColor=" + backColor
				+ "\n isFilled=" + isFilled + "\n isOutlined=" + isOutlined + "\n isBackColored=" + isBackColored;
	}

	public abstract void drawOutline(Graphics g);
	public abstract void drawFill(Graphics g);
}
