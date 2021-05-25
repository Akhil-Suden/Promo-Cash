package request;

public class Debit implements java.io.Serializable {
    public String name;
    public int amt;

    public Debit (String name, int amt) {
        this.name = name;
        this.amt = amt;
    }

}
