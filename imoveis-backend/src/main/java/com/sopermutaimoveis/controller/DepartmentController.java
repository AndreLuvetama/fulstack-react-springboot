package com.sopermutaimoveis.controller;

import com.sopermutaimoveis.dto.DepartmentDTO;
import com.sopermutaimoveis.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> createEmployee(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartment = departmentService.createDepartment(departmentDTO);
        return  new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDTO);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment(){
        List<DepartmentDTO> department = departmentService.getAllDepartment();
        return ResponseEntity.ok(department);
    }
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") Long departmentId, @RequestBody DepartmentDTO updatedDepartmentDTO){
        DepartmentDTO departmentDTO = departmentService.updateDepartment(departmentId, updatedDepartmentDTO);
        return ResponseEntity.ok(departmentDTO);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully!!!");
    }
}
