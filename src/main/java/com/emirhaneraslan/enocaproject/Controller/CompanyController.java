package com.emirhaneraslan.enocaproject.Controller;

import com.emirhaneraslan.enocaproject.Model.Dto.CompanyDto;
import com.emirhaneraslan.enocaproject.Model.Entity.CompanyEntity;
import com.emirhaneraslan.enocaproject.Model.Repository.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CompanyController {

    @Autowired
    private CompanyDao companyDao;

    @PostMapping("/company/create")
    @ResponseBody
    public CompanyEntity createCompany(@RequestBody CompanyDto companyDto) {

        CompanyEntity company = CompanyEntity.builder()
                .companyName(companyDto.getCompanyName())
                .companyEmail(companyDto.getCompanyEmail())
                .companyPhone(companyDto.getCompanyPhone())
                .build();

        this.companyDao.save(company);

        return company;
    }

    @GetMapping("/company/getAll")
    @ResponseBody
    public List<CompanyEntity> getAll () {
        List<CompanyEntity> companies = this.companyDao.findAll();
        return companies;
    }

    @DeleteMapping("/company/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteCompany (@PathVariable(name = "id") Long id) {
        CompanyEntity company = this.companyDao.findById(id);
        this.companyDao.delete(company);

        Map<String,Boolean> response = new HashMap<>();
        response.put("Silindi",Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/company/update/{id}")
    @ResponseBody
    public CompanyEntity updateCompany (@PathVariable(name = "id") Long id, @RequestBody CompanyDto companyDto) {
        CompanyEntity company = this.companyDao.findById(id);

        company.setCompanyName(companyDto.getCompanyName());
        company.setCompanyEmail(companyDto.getCompanyEmail());
        company.setCompanyPhone(companyDto.getCompanyPhone());


        CompanyEntity company1=companyDao.save(company);

        return company1;
    }
}
