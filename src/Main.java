import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class Main extends JFrame implements ActionListener{
	
	JButton newButton = new JButton("Ny");
	JButton showButton = new JButton("Visa");
	JButton timeButton = new JButton("Tid");
	
	JRadioButton rStart = new JRadioButton("Startnr");
	JRadioButton rName = new JRadioButton("Namn");
	JRadioButton rAge = new JRadioButton("Ålder");
	JRadioButton rTime = new JRadioButton("Tid");
	
	JTextArea text = new JTextArea();
	JLabel header = new JLabel("Kista Maraton");
	JLabel sort = new JLabel("Sortering");
	
	int start = 1;

	static ArrayList<Runner> Runners = new ArrayList<Runner>();

	
	Main(){
		super("Fönster");
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		add(p3, BorderLayout.CENTER);
		add(p4, BorderLayout.EAST);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rAge);
		group.add(rName);
		group.add(rStart);
		group.add(rTime);
		
		p1.add(header);
		p2.add(newButton);
		p2.add(showButton);
		p2.add(timeButton);
		p3.add(text);
		p4.add(sort);
		p4.add(rStart);
		p4.add(rName);
		p4.add(rAge);
		p4.add(rTime);
		
		newButton.addActionListener(this);
		showButton.addActionListener(this);
		timeButton.addActionListener(this);
		
		setSize(500, 600);
		setLocation(400, 50);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	class Form extends JPanel{
		
		private JTextField nameField = new JTextField(10);
		private JTextField countryField = new JTextField(10);
		private JTextField ageField = new JTextField(2);
		
		Form(){
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel nameLabel = new JLabel("Namn: ");
		JLabel countryLabel = new JLabel("Land: ");
		JLabel ageLabel = new JLabel("Ålder: ");
		p1.add(nameLabel);
		p1.add(nameField);
		p2.add(countryLabel);
		p2.add(countryField);
		p3.add(ageLabel);
		p3.add(ageField);
		}
		
		public String getName(){
			return nameField.getText();
		}
		
		public String getCountry(){
			return countryField.getText();
		}
		
		public int getAge(){
			//fånga icke heltalsundantag, numberformatexception
			return Integer.parseInt(nameField.getText());
		}
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newButton){
			Form form = new Form();
			JOptionPane.showInputDialog(null, form, "Ny tävlande", JOptionPane.QUESTION_MESSAGE);
			Runners.add(new Runner(form.getName(), form.getCountry(), form.getAge(), start));
			start++;
			//skriv om listan på löpare
		}
		if (e.getSource() == showButton){
			text.setText("");
			
			//kolla radiobutton.isSelected() else if  lägg till lyssnare på radiobuttons
			
			for(Runner r : Runners){
				text.append(r.toString() + "\n");
			}
			
		}
		if (e.getSource() == timeButton){
			//lägg till tid
		}
	}
	
	
	public static void main (String[]args){
		Runner r = new Runner("Ola", "Sverige", 43, 354);
		Runner d = new Runner("Eli", "Kanada", 25, 34);
		Runner b = new Runner("Ken", "USA", 37, 63);
		Runners.add(r);
		Runners.add(d);
		Runners.add(b);
		new Main();
	}
}
