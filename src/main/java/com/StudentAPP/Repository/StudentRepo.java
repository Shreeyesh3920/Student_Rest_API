package com.StudentAPP.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentAPP.Entity.*;

public interface StudentRepo extends JpaRepository<Student,Integer>{

}
