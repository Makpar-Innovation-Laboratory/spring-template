package com.odos.app.services.interfaces;

import java.util.List;
import com.odos.app.models.applicant.Applicant;
 
// Class
public interface ApplicantServiceInterface {
 
    // Save operation
    public Applicant saveApplicant(Applicant applicant);
 
    // Read operation
    public List<Applicant> fetchApplicantList();
 
    // Update operation
    public Applicant updateApplicant(Applicant applicant, Long applicantId);
 
    // Delete operation
    public void deleteApplicantById(Long applicantId);
}