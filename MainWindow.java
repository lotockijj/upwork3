package upwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow("Shapes").createAndShowGUI();
			}
		});
	}

	public MainWindow(String name) {
		super(name);
	}

	private void createAndShowGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addComponentsToPane();

		pack();

		setVisible(true);

		addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent m) {

			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				repaint();
			}
		});
	}

	public void addComponentsToPane() {
		setLayout(new GridLayout(6, 1));

		JPanel firstRow = new JPanel();

		firstRow.add(new JLabel("Name: "));

		JTextField textField = new JTextField(JTextField.RIGHT);

		textField.setColumns(20);

		firstRow.add(textField);

		add(firstRow);

		JPanel secondRow = new JPanel();

		secondRow.add(new JLabel("What shape to draw?"));

		JRadioButton rectangle = new JRadioButton("Rectangle", true);
		JRadioButton square = new JRadioButton("Square");
		JRadioButton circle = new JRadioButton("Circle");

		rectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				square.setSelected(false);
				circle.setSelected(false);
			}
		});

		square.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rectangle.setSelected(false);
				circle.setSelected(false);
			}
		});

		circle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rectangle.setSelected(false);
				square.setSelected(false);
			}
		});

		secondRow.add(rectangle);
		secondRow.add(square);
		secondRow.add(circle);

		add(secondRow);

		JPanel thirdRow = new JPanel();

		thirdRow.add(new JLabel("What to color?"));

		JCheckBox background = new JCheckBox("Background");
		JCheckBox fill = new JCheckBox("Fill");
		JCheckBox line = new JCheckBox("Line");

		thirdRow.add(background);
		thirdRow.add(fill);
		thirdRow.add(line);

		add(thirdRow);

		JPanel fourthRow = new JPanel();

		fourthRow.add(new JLabel("What color line?"));

		String[] choices = { "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "MAGENTA" };
		Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA };

		JComboBox<String> menu = new JComboBox<>(choices);

		fourthRow.add(menu);

		add(fourthRow);

		JPanel fifthRow = new JPanel();

		fifthRow.add(new JLabel("What color of fill?"));

		JScrollPane scrollPane = new JScrollPane();

		JList<String> list = new JList<>(choices);

		list.setSelectedIndex(0);

		scrollPane.setPreferredSize(new Dimension(100, 40));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(list);

		fifthRow.add(scrollPane);

		add(fifthRow);

		JButton submit = new JButton("Submit");

		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame(textField.getText());

				frame.getContentPane().setLayout(new GridLayout(2, 1));

				boolean isFilled = fill.isSelected();
				boolean isOutlined = line.isSelected();
				boolean isBackColored = background.isSelected();

				Color outlineColor = null, fillColor = null, backColor = null;

				if (isFilled) {
					fillColor = colors[list.getSelectedIndex()];
				}

				if (isOutlined) {
					outlineColor = colors[menu.getSelectedIndex()];
				}

				if (isBackColored) {
					backColor = Color.BLACK;
				}

				if (rectangle.isSelected()) {
					frame.getContentPane().add(new Rectangle(outlineColor, fillColor, backColor, isFilled, isOutlined, isBackColored));
				} else if (square.isSelected()) {
					frame.getContentPane().add(new Square(outlineColor, fillColor, backColor, isFilled, isOutlined, isBackColored));
				} else if (circle.isSelected()) {
					frame.getContentPane().add(new Circle(outlineColor, fillColor, backColor, isFilled, isOutlined, isBackColored));
				}

				TextArea textArea = new TextArea(6, 30);

				textArea.setText("fillColor: " + fillColor + '\n' +
								 "outlineColor: " + outlineColor + '\n' +
								 "backColor: " + backColor + '\n' +
								 "isFilled: " + isFilled + '\n' +
								 "isOutlined: " + isOutlined + '\n' +
								 "isBackColored: " + isBackColored);

				frame.getContentPane().add(textArea);

				frame.setPreferredSize(new Dimension(300, 500));

				frame.pack();

				frame.setVisible(true);
			}
		});

		add(submit);
	}

}
