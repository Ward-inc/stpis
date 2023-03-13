package demolab.stpiss.models;

import jakarta.persistence.*;

@Entity
@Table(name = "finances")
public class Finances  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idperson;
    @Column(name = "position")
    private String position;
    @Column(name = "salary")
    private int salary;

    public Finances(int idperson, String position, int salary) {
        this.idperson = idperson;
        this.position = position;
        this.salary = salary;
    }

    public Finances() {

    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

