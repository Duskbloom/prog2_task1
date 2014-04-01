import java.util.ArrayList;

public class Main{
  public static void main (String[]args){
    Runner r = new Runner("Ola", "Sverige", 43, 354);
    Runner d = new Runner("Simon", "Kanada", 25, 34);
    Runner b = new Runner("Ken", "USA", 94, 63);
    ArrayList<Runner> Runners = new ArrayList<Runner>();
    Runners.add(r);
    Runners.add(d);
    Runners.add(b);
    new MainWindow(Runners);
  }
}
