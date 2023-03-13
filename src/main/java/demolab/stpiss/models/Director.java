package demolab.stpiss.models;

import jakarta.persistence.*;

@Entity
@Table(name = "director")
public class Director  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idperson;
    @Column(name = "directorposition")
    private String directorposition;
    @Column(name = "salary")
    private int salary;

    public Director(){


    }

    public Director(int idperson, String directorposition, int salary) {
        this.idperson = idperson;
        this.directorposition = directorposition;
        this.salary = salary;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public String getDirectorposition() {
        return directorposition;
    }

    public void setDirectorposition(String directorposition) {
        this.directorposition = directorposition;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
