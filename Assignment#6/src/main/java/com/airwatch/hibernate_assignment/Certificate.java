package com.airwatch.hibernate_assignment;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ABhat on 18 Aug 2014 - 18/08/14.
 */
@Entity
@Table(name = "CERTIFICATE")
public class Certificate implements Serializable {
    @Id
    @GeneratedValue
    @Column(updatable = false, name = "id")
    private int certificateID;

    @Column(unique = true, name = "certificate_name")
    private String name;
    //@ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @Column(name = "employeeID")
    private int employeeID;

    public int getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(int certificateID) {
        this.certificateID = certificateID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
