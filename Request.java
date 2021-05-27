public class Request implements java.io.Serializable {
    public String requestType;
    public String name;
    public int amt;

    public Request (String requestType,String name, int amt) {
        this.requestType= requestType;
        this.name = name;
        this.amt = amt;
    }

}
