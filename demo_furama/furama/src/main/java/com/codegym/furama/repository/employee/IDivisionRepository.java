package com.codegym.furama.repository.employee;


import com.codegym.furama.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division,Integer> {
}
