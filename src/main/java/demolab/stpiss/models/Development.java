package demolab.stpiss.models;

import jakarta.persistence.*;

@Entity
@Table(name = "development")
public class Development  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idperson;

    @Column(name = "position")
    private String position;
    @Column(name = "technology")
    private String technology;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "ordernum")
    private Long ordernum;

    public Development(){

    }

    public Development(Long idperson, String position, String technology, int salary, Long ordernum) {
        this.idperson = idperson;
        this.position = position;
        this.technology = technology;
        this.salary = salary;
        this.ordernum = ordernum;
    }


    public Long getIdperson() {
        return idperson;
    }

    public void setIdperson(Long idperson) {
        this.idperson = idperson;
    }

    public String getDevposition() {
        return position;
    }

    public void setDevposition(String devposition) {
        this.position = devposition;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Long getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Long ordernum) {
        this.ordernum = ordernum;
    }
}
