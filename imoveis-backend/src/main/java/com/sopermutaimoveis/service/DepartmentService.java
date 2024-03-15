package com.sopermutaimoveis.service;

import com.sopermutaimoveis.dto.DepartmentDTO;
import com.sopermutaimoveis.dto.EmployeeDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO getDepartmentById(Long id);
    List<DepartmentDTO> getAllDepartment();
    DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO);
    void deleteDepartment(Long departmentId);
}
