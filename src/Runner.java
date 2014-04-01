
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
  
  public double getTime() {
    return time;
  }

  public void setTime(double time) {
    this.time = time;
  }

  public String getName() {
    return name;
  }

  public String getCountry() {
    return country;
  }

  public int getAge() {
    return age;
  }

  public int getStartn() {
    return startn;
  }
  @Override
  public String toString() {
    return startn + " " + name + ", " + country + ", " + age
      + " år, " + ", " + time;
  }


}
