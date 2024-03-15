package com.sopermutaimoveis.service.impl;

import com.sopermutaimoveis.dto.DepartmentDTO;
import com.sopermutaimoveis.dto.EmployeeDTO;
import com.sopermutaimoveis.entity.Department;
import com.sopermutaimoveis.entity.Employee;
import com.sopermutaimoveis.exception.ResourceNotFoundException;
import com.sopermutaimoveis.mapper.DepartmentMapper;
import com.sopermutaimoveis.mapper.EmployeeMapper;
import com.sopermutaimoveis.repository.DepartmentRepository;
import com.sopermutaimoveis.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = DepartmentMapper.mapDepartment(departmentDTO);
        Department savedDepartment =  departmentRepository.save(department);
        return DepartmentMapper.mapDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).
                orElseThrow(()-> new ResourceNotFoundException("Department is not found with this id"+ departmentId));
        return DepartmentMapper.mapDepartmentDto(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department)-> DepartmentMapper.mapDepartmentDto(department)).
                collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(departmentId).
                orElseThrow(()-> new ResourceNotFoundException("Employeed is not found with this id"+ departmentId));
        department.setDepartmentDescription(departmentDTO.getDepartmentDescription());
        department.setDepartmentName(departmentDTO.getDepartmentName());

        Department updatedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapDepartmentDto(updatedDepartment);

    }
    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).
                orElseThrow(()-> new ResourceNotFoundException("Department is not found with this id"+ departmentId));
        departmentRepository.deleteById(departmentId);

    }







}
