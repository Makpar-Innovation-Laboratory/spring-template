package com.odos.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.odos.app.models.applicant.Applicant;
import com.odos.app.services.ApplicantService;

@RestController
public class ApplicantController {
 
    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/applicants")
    public Applicant saveApplicant(@Valid @RequestBody Applicant applicant){
        return applicantService.saveApplicant(applicant);
    }

    @GetMapping("/applicants")
    public List<Applicant> fetchApplicantList(){
        return applicantService.fetchApplicantList();
    }

    @DeleteMapping("/applicants/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        applicantService.deleteApplicantById(departmentId);
        return "Deleted Successfully";
    }

    // Update operation
    @PutMapping("/applicants/{id}")
    public Applicant updateApplicant(@RequestBody Applicant applicant,
                                     @PathVariable("id") Long applicantId){
        return applicantService.updateApplicant(applicant, applicantId);
    }
}
