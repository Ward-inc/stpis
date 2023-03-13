package demolab.stpiss.models;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idclient;
    @Column (name = "name")
    private String name;
    @Column (name = "longname")
    private String longname;
    @Column (name = "firm")
    private String firm;

    public Client(){

    }

    public Client(int idclient, String name, String longname, String firm) {
        this.idclient = idclient;
        this.name = name;
        this.longname = longname;
        this.firm = firm;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }
}

