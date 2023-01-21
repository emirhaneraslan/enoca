package com.emirhaneraslan.enocaproject.Model.Dto;

import com.emirhaneraslan.enocaproject.Model.Entity.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    private String employeeName;

    private String employeeSurname;

    private String employeeEmail;

    private String employeePhone;

    private Long companyId;
}
