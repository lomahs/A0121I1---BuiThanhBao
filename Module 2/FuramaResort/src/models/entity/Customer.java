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
public class Customer implements Comparable<Customer> {
        private String id;
        private String nameCus;
        private LocalDate birthday;
        private String gender;
        private String phoneNumber;
        private String email;
        private int typeCus;
        private String address;

        private final String[] TYPE_CUSTOMER = {"Member","Silver","Gold","Platinum","Diamond"};

    public Customer() {
    }

    public Customer(String id, String nameCus, LocalDate birthday, String gender, String phoneNumber, String email, int typeCus, String address) {
        this.id = id;
        this.nameCus = nameCus;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCus = typeCus;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getTypeCus() {
        return TYPE_CUSTOMER[typeCus-1];
    }

    public void setTypeCus(int typeCus) {
        this.typeCus = typeCus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void showInfo() {
        System.out.printf("\t\t%-13s %-15s %-11s %-7s %-11s %-20s %-10s %-15s\n",
                id,
                nameCus,
                birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                gender,
                phoneNumber,
                email,
                getTypeCus(),
                address);
    }

    @Override
    public int compareTo(Customer o) {
        if (this.nameCus.compareTo(o.getNameCus())>0){
            return 1;
        }else if (this.nameCus.compareTo(o.getNameCus())<0){
            return -1;
        }else {
            if (this.birthday.isBefore(o.getBirthday())){
                return 1;
            }else if (this.birthday.isAfter(o.getBirthday())){
                return -1;
            }return 0;
        }
    }
}
