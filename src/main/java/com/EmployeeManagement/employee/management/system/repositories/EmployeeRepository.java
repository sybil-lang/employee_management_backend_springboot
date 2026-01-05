package com.EmployeeManagement.employee.management.system.repositories;


import com.EmployeeManagement.employee.management.system.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmployeeRepository extends JpaRepository<EmployeeEntity,Long>
{
}
