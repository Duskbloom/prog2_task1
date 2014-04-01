
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
    this.time = Double.MAX_VALUE;
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
    if (this.time == Double.MAX_VALUE)
      return startn + " " + name + ", " + country + ", " + age
          + " år";
    else
      return startn + " " + name + ", " + country + ", " + age
          + " år, Tid: " + time;
    
  }


}
