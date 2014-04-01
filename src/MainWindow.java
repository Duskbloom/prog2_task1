import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainWindow extends JFrame implements ActionListener {
  /**
   * 
   */
  private static final long serialVersionUID = 652242427934896712L;

  private int start = 1;

  private ArrayList<Runner> Runners; 

  private JButton newButton = new JButton("Ny");
  private JButton showButton = new JButton("Visa");
  private JButton timeButton = new JButton("Tid");

  private JRadioButton rStart = new JRadioButton("Startnr");
  private JRadioButton rName = new JRadioButton("Namn");
  private JRadioButton rAge = new JRadioButton("Ålder");
  private JRadioButton rTime = new JRadioButton("Tid");

  private JList  runnerList;
  private DefaultListModel runnerListModel;
  private JLabel header = new JLabel("Kista Maraton");
  private JLabel sort = new JLabel("Sortering");

  public MainWindow(){
    this(new ArrayList<Runner>());
  }

  public MainWindow(ArrayList<Runner> runners){
    super("Fönster");
    Runners = runners;

    add(buildHeaderPanel(), BorderLayout.NORTH);
    add(buildControllsPanel(), BorderLayout.SOUTH);
    add(buildListPanel(), BorderLayout.CENTER);
    add(buildSortingPanel(), BorderLayout.EAST);

    setSize(500, 600);
    setLocation(400, 50);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private JPanel buildHeaderPanel(){
    JPanel panel = new JPanel();
    panel.add(header);
    return panel;
  }

  private JPanel buildControllsPanel(){
    JPanel panel = new JPanel();

    panel.add(newButton);
    panel.add(showButton);
    panel.add(timeButton);

    newButton.addActionListener(this);
    showButton.addActionListener(this);
    timeButton.addActionListener(this);

    return panel;
  }

  private JPanel buildSortingPanel(){
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    ButtonGroup group = new ButtonGroup();
    group.add(rAge);
    group.add(rName);
    group.add(rStart);
    group.add(rTime);

    panel.add(sort);
    panel.add(rStart);
    panel.add(rName);
    panel.add(rAge);
    panel.add(rTime);

    return panel;
  }

  private JPanel buildListPanel(){
    runnerListModel = new DefaultListModel();
    runnerList = new JList(runnerListModel);

    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(runnerList);

    return panel;
  }

  public void actionPerformed(ActionEvent e){
    if (e.getSource() == newButton){
      newButtonClicked(e);
    }
    if (e.getSource() == showButton){
      showButtonClicked(e);
    }
    if (e.getSource() == timeButton){
      timeButtonClicked(e);
    }
  }

  private void newButtonClicked(ActionEvent e){
    NewRunnerForm form = new NewRunnerForm();
    int result = JOptionPane.showConfirmDialog(null, form, "Ny tävlande", JOptionPane.OK_CANCEL_OPTION, JOptionPane.NO_OPTION);
    if(result == JOptionPane.OK_OPTION){
      if(form.isValidForm())    
        Runners.add(new Runner(form.getName(), form.getCountry(), form.getAge(), start));
      else
        newButtonClicked(e);
    }

    start++;
    //skriv om listan på löpare
  }

  private void showButtonClicked(ActionEvent e){
    if (rStart.isSelected()){     
      sort(new StartComparator()); 
    }
    else if (rName.isSelected()){
      sort(new NameComparator());
    }
    else if (rAge.isSelected()){
      sort(new AgeComparator());
    }
    else if (rTime.isSelected()){
      sort(new TimeComparator());
    }
    //kolla radiobutton.isSelected() else if  lägg till lyssnare på radiobuttons
    refreshList();
  }

  private void refreshList(){
    runnerListModel.clear();
    for(Runner runner: Runners){
      runnerListModel.addElement(runner);
    }
  }

  private void timeButtonClicked(ActionEvent e){
    //lägg till tid
  }

  private void sort(Comparator<Runner> comparator){
    Collections.sort(Runners,  comparator);
  }

}
