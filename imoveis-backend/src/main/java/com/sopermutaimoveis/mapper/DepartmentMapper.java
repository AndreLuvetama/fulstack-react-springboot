package com.sopermutaimoveis.mapper;

import com.sopermutaimoveis.dto.DepartmentDTO;
import com.sopermutaimoveis.entity.Department;

public class DepartmentMapper {
    public static DepartmentDTO mapDepartmentDto(Department department){
        return new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }
    public static Department mapDepartment(DepartmentDTO departmentDTO){
        return new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription()
        );
    }
}
