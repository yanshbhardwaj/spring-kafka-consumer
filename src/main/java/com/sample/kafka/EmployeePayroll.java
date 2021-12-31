package com.sample.kafka;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "employee_payroll3")
public class EmployeePayroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    private String empName;
    private String empSalary="7000";
    private String empAccount="634717988324834";
    private String empIfscCode="INH21723";

    public EmployeePayroll() {
    }

    public EmployeePayroll(int empId, String empName, String empSalary, String empAccount, String empIfscCode) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAccount = empAccount;
        this.empIfscCode = empIfscCode;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(String empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpAccount() {
        return empAccount;
    }

    public void setEmpAccount(String empAccount) {
        this.empAccount = empAccount;
    }

    public String getEmpIfscCode() {
        return empIfscCode;
    }

    public void setEmpIfscCode(String empIfscCode) {
        this.empIfscCode = empIfscCode;
    }

    @Override
    public String toString() {
        return "EmployeePayroll{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary='" + empSalary + '\'' +
                ", empAccount='" + empAccount + '\'' +
                ", empIfscCode='" + empIfscCode + '\'' +
                '}';
    }
}
