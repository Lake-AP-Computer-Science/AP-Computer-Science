package problem5;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ColorDisplay extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private Container contentPane;
	private JComboBox<String> definedColorsMenu;
	private JButton passthroughButton;
	private JPanel[] panels;
	private JLabel colorFamilyLabel;
	private ColorPassthroughFilter filter = new ColorPassthroughFilter(Color.gray);
	
	public static String fileName = "random_colors.txt";
	
	public ColorDisplay() throws Exception 
	{
		createUserInterface();
	}
	
	private void createUserInterface() throws Exception 
	{
		generateRandomColorFile();
		setUpContentPane();
		definedColorsMenu = setUpDefinedColorsMenu(definedColorsMenu, 40, 10, 200, 50);
		definedColorsMenu.addActionListener(this.createActionListener());
		passthroughButton = setUpButton(passthroughButton, "Display Passthrough Colors", 250, 23, 200, 20);
		passthroughButton.addActionListener(this.createActionListener());
		panels = setUpPanels(panels);
		setUpWindow();
	}
	
	private void setUpContentPane()
	{
		contentPane = getContentPane();
		contentPane.setLayout(null);
	}
	
	private JComboBox<String> setUpDefinedColorsMenu(JComboBox<String> box, int x, int y, int width, int height)
	{
		String colors[] = {"Select Color Family", "Black", "White", "Red", "Green", "Blue", "Yellow"};
		box = new JComboBox<String>(colors); 
		box.setBounds(x, y, width, height);
		contentPane.add(box);
		return box;
	}
	
	private JButton setUpButton(JButton button, String text, int x, int y, int width, int height)
	{
		button = new JButton(text);
		button.setBounds(x, y, width, height);
		contentPane.add(button);
		return button;
	}
	
	private JPanel[] setUpPanels(JPanel panels[])
	{
		colorFamilyLabel = new JLabel("Color Family: NONE");
		int y = 100;
		panels = new JPanel[21];
		for(int i = 0; i < panels.length; i++)
		{
			panels[i] = new JPanel();
			panels[i].setBorder(BorderFactory.createLineBorder(Color.black));
			if(i == 0)
			{
				panels[0].setBounds(50, 60, 400, 25);
				panels[0].add(colorFamilyLabel);
			}
			else
				panels[i].setBounds(50, y, 400, 25);
			contentPane.add(panels[i]);
			y += 25;
		}
		
		return panels;
	}
	
	private void setUpWindow()
	{
		this.setBounds(400, 300, 500, 700);
		this.setTitle("Color Passthrough Filter");
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private ActionListener createActionListener()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				try {
					performAction(event);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		return listener;
	}
	
	private void performAction(ActionEvent event) throws Exception
	{
		Object object = event.getSource();
		if(object instanceof JButton)
		{
			activatePassthroughFilter();
		}
		else if(object instanceof JComboBox)
		{
			showColorFamily();
			generateRandomColorFile();
		}
	}
	
	/*
	 * Display the color family selected by the user on the first panel.
	 * This is the panel with the label "COLOR FAMILY" 
	 * [5 points]
	 */
	private void showColorFamily()
	{
		String colorFamily = definedColorsMenu.getSelectedItem().toString();
		
		if(colorFamily.equals("Select Color Family"))
		{
			colorFamilyLabel.setText("Color Family: NONE");
			colorFamilyLabel.setForeground(Color.black);
			panels[0].setBackground(this.getBackground());
		}
		else
		{
			Color color = Color.black;
			colorFamilyLabel.setText("Color Family: " + colorFamily);
			switch(colorFamily){
				case "Black":
					color = new Color(0, 0, 0);
					colorFamilyLabel.setForeground(Color.white);
					break;
				case "White":
					color = new Color(255, 255, 255);
					colorFamilyLabel.setForeground(Color.black);
					break;
				case "Red":
					color = new Color(255, 0, 0);
					colorFamilyLabel.setForeground(Color.black);
					break;
				case "Green":
					color = new Color(0, 255, 0);
					colorFamilyLabel.setForeground(Color.black);
					break;
				case "Blue":
					color = new Color(0, 0, 255);
					colorFamilyLabel.setForeground(Color.white);
					break;
				case "Yellow":
					color = new Color(255, 255, 0);
					colorFamilyLabel.setForeground(Color.black);
					break;
			}
			panels[0].setBackground(color);
		}
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() {
				repaint();
			}
		});
	}
	
	/*
	 * Create a file called random_colors.txt filled with 480 random bit values.
	 * There should be no spaces between these bits.
	 * This means that they will show up in the file as 480 contiguous bits.
	 * [5 points]
	 */
	private void generateRandomColorFile() throws Exception 
	{
		FileWrite fileWrite = new FileWrite(fileName);
		String bits = "";
		for(int i = 0; i < 480; i++) 
		{
			bits += (int)(Math.random() * 2);
		}
		fileWrite.writeToFile(bits);
		filter.setReader(new ReadFile(fileName));
	}
	
	/*
	 * Create an instance of a ColorPassthroughFilter.
	 * Use this instance to read the randomly created file random_colors.txt.
	 * Show those colors that were allowed to pass through, if any.
	 * [5 points]
	 */
	private void activatePassthroughFilter() throws Exception 
	{
		for(int i = 1; i < panels.length; i++)
		{
			panels[i].setBackground(contentPane.getBackground());
			panels[i].removeAll();
		}
		
		Color color = new Color(128, 128, 128);
		
		switch(definedColorsMenu.getSelectedItem().toString())
		{
			case "Black":
				color = new Color(0, 0, 0);
				break;
			case "White":
				color = new Color(255, 255, 255);
				break;
			case "Red":
				color = new Color(255, 0, 0);
				break;
			case "Green":
				color = new Color(0, 255, 0);
				break;
			case "Blue":
				color = new Color(0, 0, 255);
				break;
			case "Yellow":
				color = new Color(255, 255, 0);
				break;
			default:
				return;
		}
		
		filter = new ColorPassthroughFilter(color);
		ArrayList<Color> passedColors = filter.getPassthroughColors();
		for(int i = 0; i < passedColors.size(); i++) {
			panels[i + 1].setBackground(passedColors.get(i));
		}
	}
}