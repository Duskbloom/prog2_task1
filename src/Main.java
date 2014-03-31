import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class Main{
  public static void main (String[]args){
    Runner r = new Runner("Ola", "Sverige", 43, 354);
    Runner d = new Runner("Eli", "Kanada", 25, 34);
    Runner b = new Runner("Ken", "USA", 37, 63);
    ArrayList<Runner> Runners = new ArrayList<Runner>();
    Runners.add(r);
    Runners.add(d);
    Runners.add(b);
    new MainWindow(Runners);
  }
}
