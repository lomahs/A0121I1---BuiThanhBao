package optional.demerging_dataorganization;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Comparable<Student> {
    private String name;
    private String sex;
    private Date birthday;

    public Student() {
    }

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public Student(String name, String sex, String birthday) {
        this.name = name;
        this.sex = sex;
        setBirthday(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.birthday = dateFormat.parse(birthday);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public void show() {
        System.out.printf("Name: %-15s - Sex: %-7s - Birthday: %tF \n",name,sex,birthday);
    }

    @Override
    public int compareTo(Student o) {
        return this.birthday.compareTo(o.birthday);
    }
}
