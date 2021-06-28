package models.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Project: FuramaResort
 * Package: models
 * User: lomahs
 * Date time: 23/06/2021 10:26
 * Created with IntelliJ IDEA
 */
public class Employee {
    private String id;
    private String name;
    private LocalDate birthday;
    private String phoneNumber;
    private String email;
    private String level;
    private String position;
    private int salary;
    private String department;

    public Employee() {
    }

    public Employee(String id, String name, LocalDate birthday, String phoneNumber, String email, String level, String position, int salary, String department) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.level = level;
        this.position = position;
        this.salary = salary;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void showInfo() {
        System.out.printf("\t\t%-10s %-15s %-11s %-11s %-20s %-13s %-13s %-10d %-20s\n",
                id,
                name,
                birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                phoneNumber,
                email,
                level,
                position,
                salary,
                department);
    }
}
