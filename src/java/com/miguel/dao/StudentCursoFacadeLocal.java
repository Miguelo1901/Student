/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.dao;

import com.miguel.model.StudentCurso;
import com.miguel.model.StudentCursoPK;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lenovo Legion
 */
@Local
public interface StudentCursoFacadeLocal {

    void create(StudentCurso studentCurso);

    void edit(StudentCurso studentCurso);

    void remove(StudentCurso studentCurso);

    StudentCurso find(Object id);

    List<StudentCurso> findAll();

    List<StudentCurso> findRange(int[] range);

    int count();
    
    boolean insertarStudentCurso(int cursoid, int studentid, double nota);

    StudentCurso consultarStudentCurso(StudentCursoPK pk);
}
