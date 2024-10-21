package com.luv2code_springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code_springboot.cruddemo.entity.Employee;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// mengubah titik akhir pada suatu api
//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

  // that's it ... no need to write any code LOL!
  
}
