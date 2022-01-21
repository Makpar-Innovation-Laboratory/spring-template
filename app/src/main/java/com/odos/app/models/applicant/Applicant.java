package com.odos.app.models.applicant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.odos.app.models.applicant.attributes.ApplicantName;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Applicant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private ApplicantName applicantName;

}