package com.emirhaneraslan.enocaproject.Controller;

import com.emirhaneraslan.enocaproject.Model.Dto.EmployeeDto;
import com.emirhaneraslan.enocaproject.Model.Entity.CompanyEntity;
import com.emirhaneraslan.enocaproject.Model.Entity.EmployeeEntity;
import com.emirhaneraslan.enocaproject.Model.Repository.CompanyDao;
import com.emirhaneraslan.enocaproject.Model.Repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class EmployeeControler {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyDao companyDao;

    @PostMapping("/employee/create")
    @ResponseBody
    public EmployeeEntity createEmployee(@RequestBody EmployeeDto employeeDto) {

        CompanyEntity company = this.companyDao.findById(employeeDto.getCompanyId());

            EmployeeEntity employee = EmployeeEntity.builder()
                    .employeeName(employeeDto.getEmployeeName())
                    .employeeSurname(employeeDto.getEmployeeSurname())
                    .employeeEmail(employeeDto.getEmployeeEmail())
                    .employeePhone(employeeDto.getEmployeePhone())
                    .company(company)
                    .build();

            this.employeeDao.save(employee);

            return employee;
    }

    @GetMapping("/employee/getAll")
    @ResponseBody
    public List<EmployeeEntity> getAllEmployee () {
        List<EmployeeEntity> employees = this.employeeDao.findAll();
        return employees;
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee (@PathVariable(name = "id") Long id) {
        EmployeeEntity employee = this.employeeDao.getById(id);
        this.employeeDao.delete(employee);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Silindi",Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/employee/update/{id}")
    @ResponseBody
    public EmployeeEntity updateEmployee (@PathVariable(name = "id") Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employee = this.employeeDao.getById(id);
        CompanyEntity company = this.companyDao.findById(employeeDto.getCompanyId());

        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeSurname(employeeDto.getEmployeeSurname());
        employee.setEmployeeEmail(employeeDto.getEmployeeEmail());
        employee.setEmployeePhone(employeeDto.getEmployeePhone());
        employee.setCompany(company);


        EmployeeEntity employee1=employeeDao.save(employee);

        return employee1;
    }
}
