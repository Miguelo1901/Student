/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miguel.dao;

import com.miguel.model.StudentCurso;
import com.miguel.model.StudentCursoPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lenovo Legion
 */
@Stateless
public class StudentCursoFacade extends AbstractFacade<StudentCurso> implements StudentCursoFacadeLocal {

    @PersistenceContext(unitName = "CRUDWebAplicationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentCursoFacade() {
        super(StudentCurso.class);
    }

    @Override
    public boolean insertarStudentCurso(int cursoid, int studentid, double nota) 
    {
        StudentCursoPK pk = new StudentCursoPK(cursoid, studentid);
        
        if (consultarStudentCurso(pk)!= null) 
            return false;
        else{
            StudentCurso cp = new StudentCurso(pk, nota);
            em.persist(cp);
            return true;
        }
    }

    @Override
    public StudentCurso consultarStudentCurso(StudentCursoPK pk) {
        return em.find(StudentCurso.class, pk);
    }
    
}
