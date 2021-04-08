/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo Legion
 */
@Entity
@Table(name = "STUDENT_CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentCurso.findAll", query = "SELECT s FROM StudentCurso s"),
    @NamedQuery(name = "StudentCurso.findByCursoid", query = "SELECT s FROM StudentCurso s WHERE s.studentCursoPK.cursoid = :cursoid"),
    @NamedQuery(name = "StudentCurso.findByStudentid", query = "SELECT s FROM StudentCurso s WHERE s.studentCursoPK.studentid = :studentid"),
    @NamedQuery(name = "StudentCurso.findByNota", query = "SELECT s FROM StudentCurso s WHERE s.nota = :nota")})
public class StudentCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentCursoPK studentCursoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NOTA")
    private Double nota;
    @JoinColumn(name = "CURSOID", referencedColumnName = "CODIGO_CURSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public StudentCurso() {
    }

    public StudentCurso(StudentCursoPK studentCursoPK, double nota) {
        this.studentCursoPK = studentCursoPK;
        this.nota = nota;
    }

    public StudentCurso(int cursoid, int studentid) {
        this.studentCursoPK = new StudentCursoPK(cursoid, studentid);
    }

    public StudentCursoPK getStudentCursoPK() {
        return studentCursoPK;
    }

    public void setStudentCursoPK(StudentCursoPK studentCursoPK) {
        this.studentCursoPK = studentCursoPK;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentCursoPK != null ? studentCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentCurso)) {
            return false;
        }
        StudentCurso other = (StudentCurso) object;
        if ((this.studentCursoPK == null && other.studentCursoPK != null) || (this.studentCursoPK != null && !this.studentCursoPK.equals(other.studentCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.miguel.model.StudentCurso[ studentCursoPK=" + studentCursoPK + " ]";
    }
    
}
