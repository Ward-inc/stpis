package demolab.stpiss.models;

import jakarta.persistence.*;

@Entity
@Table(name = "hr")
public class HR  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int idperson;
    @Column(name = "hrposition")
    private String hrposition;
    @Column(name = "event")
    private String event;
    @Column(name = "coursesnum")
    private Long coursesnum;
    @Column(name = "salary")
    private int salary;

    public HR(){

    }

    public HR(int idperson, String hrposition, String event, Long coursesnum, int salary) {
        this.idperson = idperson;
        this.hrposition = hrposition;
        this.event = event;
        this.coursesnum = coursesnum;
        this.salary = salary;
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public String getHrposition() {
        return hrposition;
    }

    public void setHrposition(String hrposition) {
        this.hrposition = hrposition;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Long getCoursesnum() {
        return coursesnum;
    }

    public void setCoursesnum(Long coursesnum) {
        this.coursesnum = coursesnum;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

