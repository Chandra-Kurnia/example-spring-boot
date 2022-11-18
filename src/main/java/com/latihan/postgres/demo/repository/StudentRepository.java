package com.latihan.postgres.demo.repository;

import com.latihan.postgres.demo.entity.Students;
import com.latihan.postgres.demo.pojo.StudentPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Students, Long> {
    @Query(value = "SELECT name, email FROM students", nativeQuery = true)
    List<StudentPojo> nameEmail();
}
