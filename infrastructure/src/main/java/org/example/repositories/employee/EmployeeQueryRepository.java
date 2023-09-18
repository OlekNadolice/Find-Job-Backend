package org.example.repositories.employee;

import org.example.entities.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeQueryRepository extends JpaRepository<Employee , UUID> {
}
