package com.muling3.thymeleaf.repo;

import com.muling3.thymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Employee, Integer> {
}
