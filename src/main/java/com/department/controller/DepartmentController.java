package com.department.controller;

import com.department.entity.Department;
import com.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/department")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.findDepartmentById(departmentId);
    }

    @PutMapping("/{id}")
    public Department editDepartmentById(@RequestBody Department department, @PathVariable("id") Long departmentId){
      Department exdepartment = departmentService.findDepartmentById(departmentId);
      exdepartment.setDepartmentName(department.getDepartmentName());
      exdepartment.setDepartmentAddress(department.getDepartmentAddress());
      exdepartment.setDepartmentCode(department.getDepartmentCode());
      return departmentService.saveDepartment(exdepartment);

    }

}
