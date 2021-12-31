package com.sample.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PayrollService {
    Logger logger = LoggerFactory.getLogger(PayrollService.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private PayrollRepository payrollRepository;

    public EmployeePayroll addEmployee(EmployeePayroll payroll){
        logger.info("Adding Employee payroll data to database method called.");
        EmployeePayroll result = payrollRepository.save(payroll);
        logger.info("Add Employee payroll method added data and returned");
        return result;
    }

    @KafkaListener(topics = "KafkaTopic2", groupId = "group_1", containerFactory = "concurrentKafkaListenerContainerFactory")
    public void consume(String payroll) {
        EmployeePayroll employeePayroll = null;
        try {
            logger.trace("Mapping consumed employee data to EmployeePayroll Object");
            employeePayroll = objectMapper.readValue(payroll, EmployeePayroll.class);
        } catch (JsonProcessingException e) {
            logger.error("Error occurred while mapping consumed : "+e.getMessage());
            e.printStackTrace();
        }
        System.out.println(employeePayroll);
        Optional payroll1= payrollRepository.findById(employeePayroll.getEmpId());
        if(payroll1.isEmpty())
            addEmployee(employeePayroll);
        logger.info("Employee payroll data added successfully to database");
    }
}
