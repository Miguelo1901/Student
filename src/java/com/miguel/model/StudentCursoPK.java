/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Lenovo Legion
 */
@Embeddable
public class StudentCursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CURSOID")
    private int cursoid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID")
    private int studentid;

    public StudentCursoPK() {
    }

    public StudentCursoPK(int cursoid, int studentid) {
        this.cursoid = cursoid;
        this.studentid = studentid;
    }

    public int getCursoid() {
        return cursoid;
    }

    public void setCursoid(int cursoid) {
        this.cursoid = cursoid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cursoid;
        hash += (int) studentid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentCursoPK)) {
            return false;
        }
        StudentCursoPK other = (StudentCursoPK) object;
        if (this.cursoid != other.cursoid) {
            return false;
        }
        if (this.studentid != other.studentid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.miguel.model.StudentCursoPK[ cursoid=" + cursoid + ", studentid=" + studentid + " ]";
    }
    
}
