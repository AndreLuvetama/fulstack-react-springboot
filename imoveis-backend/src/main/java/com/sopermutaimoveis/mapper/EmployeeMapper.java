package com.sopermutaimoveis.mapper;

import com.sopermutaimoveis.dto.EmployeeDTO;
import com.sopermutaimoveis.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDto(Employee employee){
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirsteName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment().getId()
        );
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
             Employee employee = new Employee();
                    employee.setId(employeeDTO.getId());
                    employee.setFirsteName(employeeDTO.getFirstName());
                    employee.setLastName(employeeDTO.getLastName());
                    employee.setEmail(employeeDTO.getEmail());
                    return  employee;



       /* return new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail()
        );*/
    }



}
