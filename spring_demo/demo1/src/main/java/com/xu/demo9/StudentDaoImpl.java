package com.xu.demo9;

import org.springframework.stereotype.Repository;

@Repository("studentDaoId")
public class StudentDaoImpl implements StudentDao {

    @Override
    public void save() {
        System.out.println("###");
    }
}
