package com.sopermutaimoveis.service.impl;

import com.sopermutaimoveis.dto.EmployeeDTO;
import com.sopermutaimoveis.entity.Department;
import com.sopermutaimoveis.entity.Employee;
import com.sopermutaimoveis.exception.ResourceNotFoundException;
import com.sopermutaimoveis.mapper.EmployeeMapper;
import com.sopermutaimoveis.repository.DepartmentRepository;
import com.sopermutaimoveis.repository.EmployeeRepository;
import com.sopermutaimoveis.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Department department = departmentRepository.findById(employeeDTO.getDepartmentId()).orElseThrow(
                ()-> new ResourceNotFoundException("Department with this " +employeeDTO.getDepartmentId()+ "not exist" ));
        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
       Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(()-> new ResourceNotFoundException("Employeed is not found with this id"+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).
                collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(()-> new ResourceNotFoundException("Employeed is not found with this id"+ employeeId));
        employee.setFirsteName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Department department = departmentRepository.findById(updatedEmployee.getDepartmentId()).orElseThrow(
                ()-> new ResourceNotFoundException("Department with this " +updatedEmployee .getDepartmentId()+ "not exist" ));
        employee.setDepartment(department);

        Employee updatedEmployees = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployees);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(()-> new ResourceNotFoundException("Employeed is not found with this id"+ employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
