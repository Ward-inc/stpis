package demolab.stpiss.models;

import jakarta.persistence.*;

@Entity
@Table (name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idperson;

    @Column (name = "name")
    private String name;
    @Column (name = "longname")
    private String longname;
    @Column (name = "number")
    private String number;
    @Column (name = "login")
    private String login;
    @Column (name = "password")
    private String password;
    @Column (name = "depnumber")
    private int depnumber;


    public Person(){


    }

    public Person(int idperson, String name, String longname, String number, String login, String password, int depnumber) {
        this.idperson = idperson;
        this.name = name;
        this.longname = longname;
        this.number = number;
        this.login = login;
        this.password = password;
        this.depnumber = depnumber;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDepnumber() {
        return depnumber;
    }

    public void setDepnumber(int depnumber) {
        this.depnumber = depnumber;
    }


}