
public class Runner{

  private String name;
  private String country;
  private int age;
  private double time;
  private int startn;

  Runner(String n, String c, int a, int s){
    this.name = n;
    this.country = c;
    this.age = a;
    this.startn = s;
  }

  @Override
  public String toString() {
    return name + ", " + country + ", " + age
      + "år, " + ", Startnummer:" + startn + ", " + time + " s";
  }


}
