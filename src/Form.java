import javax.swing.*;
class Form extends JPanel{

  /**
   * 
   */
  private static final long serialVersionUID = 5427276141986312219L;
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
