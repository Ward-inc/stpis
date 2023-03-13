package demolab.stpiss.models;

import jakarta.persistence.*;

@Entity
@Table(name = "orderr")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ordernum;
    @Column(name = "ordername")
    private String ordername;
    @Column(name = "cost")
    private int cost;
    @Column(name = "platform")
    private String platform;
    @Column(name = "status")
    private String status;


    public Order() {


    }

    public Order(int ordernum, String ordername, int cost, String platform, String status) {
        this.ordernum = ordernum;
        this.ordername = ordername;
        this.cost = cost;
        this.platform = platform;
        this.status = status;
    }

    public Order(String ordername, int cost, String platform, String status) {
        this.ordername = ordername;
        this.cost = cost;
        this.platform = platform;
        this.status = status;
    }



    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


