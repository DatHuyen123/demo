package com.dangvandat.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Embeddable
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "companyname")
    private String companyName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "demand")
    private String demand;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private Integer status;

    @ManyToMany(mappedBy = "customers")
    private List<UserEntity> users = new ArrayList<>();

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getDemand() {
        return demand;
    }
    public void setDemand(String demand) {
        this.demand = demand;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
