package problem5;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	
	public ColorDisplay()
	{
		createUserInterface();
	}
	
	private void createUserInterface()
	{
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
				JLabel label = new JLabel("COLOR FAMILY");
				label.setBounds(150, 0, 100, 25);
				panels[i].add(label);
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
		
		
	} 
	
	/*
	 * Create a file called random_colors.txt filled with 480 random bit values.
	 * There should be no spaces between these bits.
	 * This means that they will show up in the file as 480 contiguous bits.
	 * [5 points]
	 */
	private void generateRandomColorFile()
	{
			
	}
	
	/*
	 * Create an instance of a ColorPassthroughFilter.
	 * Use this instance to read the randomly created file random_colors.txt.
	 * Show those colors that were allowed to pass through, if any.
	 * [5 points] 
	 */
	private void activatePassthroughFilter()
	{
		
	}
	
	

}
