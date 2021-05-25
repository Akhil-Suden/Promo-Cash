package request;

public class Credit implements java.io.Serializable{
  public String name;
  public int amt;

  public Credit (String name, int amt){
    this.name=name;
    this.amt=amt;
  }
}
