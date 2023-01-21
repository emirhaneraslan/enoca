package com.emirhaneraslan.enocaproject.Model.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {

    private String companyName;

    private String companyEmail;

    private String companyPhone;
}
