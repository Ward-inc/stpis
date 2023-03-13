package demolab.stpiss.models;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Courses  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int coursesnum;
@Column(name = "coursesname")
    private String coursesname;
    @Column(name = "budget")
    private int budget;
    @Column(name = "studentsnum")
    private int studentsnum;

    public Courses(){

    }
    public Courses(int coursesnum, String coursesname, int budget, int studentsnum) {
        this.coursesnum = coursesnum;
        this.coursesname = coursesname;
        this.budget = budget;
        this.studentsnum = studentsnum;
    }

    public int getCoursesnum() {
        return coursesnum;
    }

    public void setCoursesnum(int coursesnum) {
        this.coursesnum = coursesnum;
    }

    public String getCoursesname() {
        return coursesname;
    }

    public void setCoursesname(String coursesname) {
        this.coursesname = coursesname;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getStudentsnum() {
        return studentsnum;
    }

    public void setStudentsnum(int studentsnum) {
        this.studentsnum = studentsnum;
    }
}

