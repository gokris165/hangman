package hangman;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

public class GUI extends JPanel implements ActionListener
{
	private JFrame frame;
	private JFrame conclusion;
	private JPanel panel;
	private Phrases behindTheScenes;
	private String letter;
	private ArrayList<Integer> indexes;
	private HashMap<Integer, Integer> location;
	private ArrayList<String> remainingLetters;
	private final int STRIKES = 7;
	private int countStrikes = 0;
	private BufferedImage bi;
	private JLabel picture;
	
	// Alphabet buttons
	private JButton a;
	private JButton b; 
	private JButton c; 
	private JButton d;
	private JButton e;
	private JButton f;
	private JButton g;
	private JButton h;
	private JButton i;
	private JButton j;
	private JButton k;
	private JButton l; 
	private JButton m; 
	private JButton n; 
	private JButton o;
	private JButton p; 
	private JButton q; 
	private JButton r; 
	private JButton s; 
	private JButton t; 
	private JButton u; 
	private JButton v; 
	private JButton w; 
	private JButton x; 
	private JButton y; 
	private JButton z; 

	
	// Create hangman board
	public GUI()
	{
		// Create Alphabet Buttons
		createAlphabetButtons();
		
		// Set Button Locations
		setButtonLocation();
		
		// Set Button Functionality
		setButtonFunctionality();
		
		// Create panel of the hangman board
		panel = new JPanel();
		panel.setLayout(null);
		
		// Add Alphabet Buttons to Panel
		addAlphabetButtonsToPanel();

		// Create frame of the hangman board
		frame = new JFrame();
		frame.setSize(1100, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Hangman");
		frame.setVisible(true);
		frame.add(panel);
		
		// Create a Phrase Object to get phrases
		behindTheScenes = new Phrases();
		
		// Mapping locations of blanks to corresponding blank number
		location = new HashMap<>();
		int xValue = 100;
		for(int i = 0; i < 27; i++)
		{
			location.put(i, xValue);
			xValue += 30;
		}
		
		// Set background
		picture = new JLabel();
		try
		{
			bi = ImageIO.read(new File("pix/blank.PNG"));
			picture.setIcon(new ImageIcon(bi));
			picture.setBounds(90, 20, 800, 380);
			panel.add(picture);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		panel.revalidate();
		panel.repaint();
	}
	
	
	// Create 26 alphabet buttons
	public void createAlphabetButtons()
	{
		a = new JButton("A");
		b = new JButton("B");
		c = new JButton("C");
		d = new JButton("D");
		e = new JButton("E");
		f = new JButton("F");
		g = new JButton("G");
		h = new JButton("H");
		i = new JButton("I");
		j = new JButton("J");
		k = new JButton("K");
		l = new JButton("L");
		m = new JButton("M");
		n = new JButton("N");
		o = new JButton("O");
		p = new JButton("P");
		q = new JButton("Q");
		r = new JButton("R");
		s = new JButton("S");
		t = new JButton("T");
		u = new JButton("U");
		v = new JButton("V");
		w = new JButton("W");
		x = new JButton("X");
		y = new JButton("Y");
		z = new JButton("Z");
	}
	
	
	// Add all 26 alphabet buttons to panel
	public void addAlphabetButtonsToPanel()
	{
		panel.add(a);
		panel.add(b);
		panel.add(c);
		panel.add(d);
		panel.add(e);
		panel.add(f);
		panel.add(g);
		panel.add(h);
		panel.add(i);
		panel.add(j);
		panel.add(k);
		panel.add(l);
		panel.add(m);
		panel.add(n);
		panel.add(o);
		panel.add(p);
		panel.add(q);
		panel.add(r);
		panel.add(s);
		panel.add(t);
		panel.add(u);
		panel.add(v);
		panel.add(w);
		panel.add(x);
		panel.add(y);
		panel.add(z);
	}
	
	
	// Set button locations on the board
	public void setButtonLocation()
	{
		a.setBounds(100, 460, 50, 20);		
		b.setBounds(160, 460, 50, 20);
		c.setBounds(220, 460, 50, 20);
		d.setBounds(280, 460, 50, 20);
		e.setBounds(340, 460, 50, 20);
		f.setBounds(400, 460, 50, 20);
		g.setBounds(460, 460, 50, 20);
		h.setBounds(520, 460, 50, 20);
		i.setBounds(580, 460, 50, 20);
		j.setBounds(640, 460, 50, 20);
		k.setBounds(700, 460, 50, 20);
		l.setBounds(760, 460, 50, 20);
		m.setBounds(820, 460, 50, 20);
		n.setBounds(100, 490, 50, 20);
		o.setBounds(160, 490, 50, 20);
		p.setBounds(220, 490, 50, 20);
		q.setBounds(280, 490, 50, 20);
		r.setBounds(340, 490, 50, 20);
		s.setBounds(400, 490, 50, 20);
		t.setBounds(460, 490, 50, 20);
		u.setBounds(520, 490, 50, 20);
		v.setBounds(580, 490, 50, 20);
		w.setBounds(640, 490, 50, 20);
		x.setBounds(700, 490, 50, 20);
		y.setBounds(760, 490, 50, 20);
		z.setBounds(820, 490, 50, 20);
	}
	
	
	// Make the buttons do something when clicked
	public void setButtonFunctionality()
	{
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);
		f.addActionListener(this);
		g.addActionListener(this);
		h.addActionListener(this);
		i.addActionListener(this);
		j.addActionListener(this);
		k.addActionListener(this);
		l.addActionListener(this);
		m.addActionListener(this);
		n.addActionListener(this);
		o.addActionListener(this);
		p.addActionListener(this);
		q.addActionListener(this);
		r.addActionListener(this);
		s.addActionListener(this);
		t.addActionListener(this);
		u.addActionListener(this);
		v.addActionListener(this);
		w.addActionListener(this);
		x.addActionListener(this);
		y.addActionListener(this);
		z.addActionListener(this);
	}
	
	
	// Enable all buttons (for playing again)
	public void reactivateButtons()
	{
		a.setEnabled(true);
		b.setEnabled(true);
		c.setEnabled(true);
		d.setEnabled(true);
		e.setEnabled(true);
		f.setEnabled(true);
		g.setEnabled(true);
		h.setEnabled(true);
		i.setEnabled(true);
		j.setEnabled(true);
		k.setEnabled(true);
		l.setEnabled(true);
		m.setEnabled(true);
		n.setEnabled(true);
		o.setEnabled(true);
		p.setEnabled(true);
		q.setEnabled(true);
		r.setEnabled(true);
		s.setEnabled(true);
		t.setEnabled(true);
		u.setEnabled(true);
		v.setEnabled(true);
		w.setEnabled(true);
		x.setEnabled(true);
		y.setEnabled(true);
		z.setEnabled(true);
	}
	
	
	// Create blanks for the phrase/word
	public void createBlanks()
	{
		String word = behindTheScenes.getWord();								// get word/phrase
		String[] lettersInWord = word.split("");								// split the words into letters	
		remainingLetters = new ArrayList<>(Arrays.asList(lettersInWord));		// keep track of all remaining letters but not whitespace
		remainingLetters.removeIf(n -> n.equals(" "));							// remove whitespace (only keep track of letters)		
		int xValue = 100;														// initialize horizontal location of blanks
		for(int i = 0; i < word.length(); i++)
		{
			// Don't add a blank if whitespace
			if(lettersInWord[i].equals(" "))
			{
				JLabel blankSlot = new JLabel("   ");
				blankSlot.setBounds(xValue, 420, 20, 20);
				panel.add(blankSlot);
			}
			
			// Add a blank if there is a letter
			else
			{
			JLabel slot = new JLabel("___");
			slot.setBounds(xValue, 420, 20, 20);
			panel.add(slot);
			}
			
			// Increment the horizontal location of the blanks
			xValue+=30;
		}
		
		// refresh the board
		frame.revalidate();
		frame.repaint();
	}

	
	// Do something when the button is clicked
	public void actionPerformed(ActionEvent e) 
	{
		// Disable the button that was clicked
		JButton buttonAction = (JButton)e.getSource();
		buttonAction.setEnabled(false);
		
		// Get the text of the button
		String text = buttonAction.getText();
		
		// Close the game if the user chooses to exit
		if(text.equals("Exit"))
		{
			conclusion.dispose();
			frame.dispose();
		}
		
		// Restart game if the user chooses to play again
		else if(text.equals("Yes"))
		{
			frame.dispose();
			conclusion.setVisible(false);
			conclusion.dispose();
			GUI hangman = new GUI();
			hangman.createBlanks();
		}
		
		// See if the text of the button is a letter in the word/phrase
		else if(behindTheScenes.checkForMatch(text))
		{
			letter = text;
			indexes = behindTheScenes.findIndexOf(letter);		// Find all occurrences of the letter in the word/phrase
			updateBoard();										// Display all occurrences of the letter and update the board
		}
		
		// Move to next slide of hangman animation if 
		// user chooses a letter not in word/phrase
		else
		{
			countStrikes++;										// Increment the number of mistakes the user made
			insertPix();										// Move to the next hangman slide
			
			// Game over if user makes 7 mistakes
			if(countStrikes >= STRIKES)							
				endOfGame("YOU LOSE!!!");
		}
	}
	
	
	// Display all occurrences of the letter
	public void updateBoard()
	{
		for(int i = 0; i < indexes.size(); i++)
		{
			// Add letters to the board
			JLabel letterInWord = new JLabel(letter);
			letterInWord.setBounds(5 + location.get(indexes.get(i)), 420, 20, 20);
			panel.add(letterInWord);
			
			// Refresh board
			panel.revalidate();							
			panel.repaint();
			
			// Remove letter from the list of remaining letters of the word/phrase 
			remainingLetters.remove(letter);
		}
		
		// Check if the user won
		checkWinCondition();					
	}
	
	
	// User wins if there are no more remaining letters 
	public void checkWinCondition()
	{
		if(!(remainingLetters.size() == 0))
		{
			return;
		}
		endOfGame("YOU WIN!!!");
	}
	
	
	// Ask the user if they want to play again at the end
	public void endOfGame(String title)
	{
		// Close the board
		frame.setVisible(false); 
		
		// Create a new window at the end of the game
		JPanel pan = new JPanel();										// New panel for new window
		pan.setLayout(null);	
	
		JButton playAgain = new JButton("Yes");							// Play Again button
		playAgain.addActionListener(this);
		playAgain.setBounds(50, 30, 65, 20);
		pan.add(playAgain);
		
		JButton exit = new JButton("Exit");								// Exit game button
		exit.addActionListener(this);
		exit.setBounds(120, 30, 65, 20);
		pan.add(exit);
		
		JLabel prompt = new JLabel("Do you want to play again?");		// Ask if the user wants to play again
		prompt.setBounds(40, 10, 200, 20);
		pan.add(prompt);
		
		conclusion = new JFrame();										// New frame for new window
		conclusion.setSize(250, 100);
		conclusion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		conclusion.setTitle(title);
		conclusion.setVisible(true);
		conclusion.add(pan);											// Add new panel to new frame
	}
	
	
	// Change hangman animation picture
	public void insertPix()
	{
		// Remove old animation picture
		panel.remove(picture);											
		
		// Location of other hangman animation pictures
		File image1 = new File("pix/stand.PNG");
		File image2 = new File("pix/head.PNG");
		File image3 = new File("pix/body.PNG");
		File image4 = new File("pix/left leg.PNG");
		File image5 = new File("pix/right leg.PNG");
		File image6 = new File("pix/left arm.PNG");
		File image7 = new File("pix/right arm and dead.PNG");
		
		// Don't change picture if the user has made no mistakes
		if(countStrikes == 0)
		{
			return;
		}
		
		// Change animation picture with each mistake
		else if(countStrikes == 1)
		{
			try
			{
				bi = ImageIO.read(image1);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		else if(countStrikes == 2)
		{
			try
			{
				bi = ImageIO.read(image2);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		else if(countStrikes == 3)
		{
			try
			{
				bi = ImageIO.read(image3);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		else if(countStrikes == 4)
		{
			try
			{
				bi = ImageIO.read(image4);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		else if(countStrikes == 5)
		{
			try
			{
				bi = ImageIO.read(image5);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		else if(countStrikes == 6)
		{
			try
			{
				bi = ImageIO.read(image6);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		else
		{
			try
			{
				bi = ImageIO.read(image7);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		// Add picture to panel
		try
		{
			picture = new JLabel();
			panel.add(picture);
			picture.setIcon(new ImageIcon(bi));
			picture.setBounds(90, 20, 800, 380);
			
			// Refresh the board
			revalidate();
			repaint();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	// Run the game 
	public static void main(String[] args) 
	{
		GUI hangman = new GUI();
		hangman.createBlanks();
	}
}
