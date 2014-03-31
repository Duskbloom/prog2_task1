import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainWindow extends JFrame implements ActionListener {
  int start = 1;

  ArrayList<Runner> Runners; 

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

  public MainWindow(){
    this(new ArrayList<Runner>());
  }
  
  public MainWindow(ArrayList<Runner> runners){
    super("Fönster");

    Runners = runners;
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

  public void actionPerformed(ActionEvent e){
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

}