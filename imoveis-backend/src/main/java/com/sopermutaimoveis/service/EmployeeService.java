package com.sopermutaimoveis.service;

import com.sopermutaimoveis.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
        EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
        EmployeeDTO getEmployeeById(Long id);
        List<EmployeeDTO> getAllEmployee();
        EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO);
        void deleteEmployee(Long employeedId);

}
