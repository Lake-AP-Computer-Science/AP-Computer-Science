package problem5;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorDisplay extends JFrame 
{
	
	private static final long serialVersionUID = 1L;
	private Container contentPane;
	private JComboBox<String> definedColorsMenu;
	private JButton passthroughButton;
	private JPanel[] panels;
	
	private JLabel ColorFamilyLabel;
	private JButton getNewListButton;
	
	private static final Color BLACK = new Color(0, 0, 0);
	private static final Color WHITE = new Color(255, 255, 255);
	private static final Color RED = new Color(255, 0, 0);
	private static final Color GREEN = new Color(0, 255, 0);
	private static final Color BLUE = new Color(0, 0, 255);
	private static final Color YELLOW = new Color(255, 255, 0);
	
	Color CurrentColor = WHITE;
	
	public ColorDisplay()
	{
		createUserInterface();
	}
	
	private void createUserInterface()
	{
		setUpContentPane();
		definedColorsMenu = setUpDefinedColorsMenu(definedColorsMenu, 40, 10, 200, 50);
		definedColorsMenu.addActionListener(this.createActionListener());
		passthroughButton = setUpButton(passthroughButton, "Display Passthrough Colors", 250, 15, 200, 20);
		passthroughButton.addActionListener(this.createActionListener());
		getNewListButton = setUpButton(passthroughButton, "Get New List", 250, 35, 200, 20);
		getNewListButton.addActionListener(this.createActionListener());
		panels = setUpPanels(panels);
		clearPanels();
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
		box.setSelectedIndex(0);
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
		int y = 100;
		panels = new JPanel[21];
		for(int i = 0; i < panels.length; i++)
		{
			panels[i] = new JPanel();
			panels[i].setBorder(BorderFactory.createLineBorder(Color.black));
			if(i == 0)
			{
				panels[i].setBounds(50, 60, 400, 25);
				panels[i].setLayout(null);
				ColorFamilyLabel = new JLabel("COLOR FAMILY");
				ColorFamilyLabel.setBounds(150, 0, 100, 25);
				panels[i].add(ColorFamilyLabel);
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
				performAction(event);
			}
		};
		return listener;
	}
	
	
	private void performAction(ActionEvent event)
	{
		Object object = event.getSource();
		if(object instanceof JButton)
		{
			switch(((JButton)(object)).getText())
			{
				case "Display Passthrough Colors":
						activatePassthroughFilter();
					break;
				case "Get New List":
						generateRandomColorFile();
						activatePassthroughFilter();
					break;
			}
		}
		else if(object instanceof JComboBox)
		{
			showColorFamily();
		}
		
	}
	
	/*
	 * Display the color family selected by the user on the first panel.
	 * This is the panel with the label "COLOR FAMILY" 
	 * [5 points]
	 */
	private void showColorFamily()
	{
		CurrentColor = WHITE;
		
		ColorFamilyLabel.setText(definedColorsMenu.getSelectedItem().toString());
		
		switch(ColorFamilyLabel.getText())
		{
		case "Black":
			CurrentColor = BLACK;
			break;
		case  "White":
			CurrentColor = WHITE;
			break;
		case "Red":
			CurrentColor = RED;
			break;
		case "Green":
			CurrentColor = GREEN;
			break;
		case "Blue":
			CurrentColor = BLUE;
			break;
		case "Yellow":
			CurrentColor = YELLOW;
			break;
		}
		
		ColorFamilyLabel.setForeground((CurrentColor != WHITE && CurrentColor != YELLOW) ? WHITE : BLACK);
		panels[0].setBackground(CurrentColor);
		
	} 
	
	/*
	 * Create a file called random_colors.txt filled with 480 random bit values.
	 * There should be no spaces between these bits.
	 * This means that they will show up in the file as 480 contiguous bits.
	 * [5 points]
	 */
	private void generateRandomColorFile()
	{
		FileWrite FW = new FileWrite("random_colors.txt");
		
		String Contents = "";
		
		for (int i = 0; i < 480; ++i)
		{
			Contents += String.valueOf(Math.abs((new Random()).nextInt()) % 2);
		}
		
		try {
			FW.writeToFile(Contents);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//just used to test the filewrite
	public void test()
	{
		generateRandomColorFile();
	}
	
	private void clearPanels()
	{
		for (int i = 1; i < 21; ++i)
		{
			panels[i].setBackground(WHITE);
		}
	}
	
	/*
	 * Create an instance of a ColorPassthroughFilter.
	 * Use this instance to read the randomly created file random_colors.txt.
	 * Show those colors that were allowed to pass through, if any.
	 * [5 points] 
	 */
	private void activatePassthroughFilter()
	{
		clearPanels();
		
		if (definedColorsMenu.getSelectedIndex() == 0)
			return;
		
		ColorPassthroughFilter CPF = new ColorPassthroughFilter(CurrentColor);
		
		ArrayList<Color> Filtered = CPF.getPassthroughColors();
		
		for (int i = 1; i < Filtered.size(); ++i)
		{
			panels[i].setBackground(Filtered.get(i));
		}
	}

}
