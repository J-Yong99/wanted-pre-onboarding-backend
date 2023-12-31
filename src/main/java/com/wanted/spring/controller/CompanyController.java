package com.wanted.spring.controller;

import com.wanted.spring.domain.Company;
import com.wanted.spring.dto.company.CompanyRegisterRequestDto;
import com.wanted.spring.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // 등
    @PostMapping()
    @Operation(summary = "등록", description = "회사를 등록합니다.")
    public ResponseEntity<Company> registerCompany(
            @RequestBody CompanyRegisterRequestDto body
    ){
        return ResponseEntity.ok(companyService.registerCompany(body));
    }
}
