package com.odos.app.repositories;

import com.odos.app.models.applicant.Applicant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
     
}