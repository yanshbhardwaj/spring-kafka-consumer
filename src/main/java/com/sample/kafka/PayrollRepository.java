package com.sample.kafka;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<EmployeePayroll, Integer> {
}
