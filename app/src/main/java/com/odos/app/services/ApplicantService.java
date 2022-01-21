import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odos.app.repositories.ApplicantRepository;
import com.odos.app.services.interfaces.ApplicantServiceInterface;
import com.odos.app.models.applicant.Applicant;


@Service
public class ApplicantService implements ApplicantServiceInterface {
 
    @Autowired
    private ApplicantRepository applicantRepository;
 
    // Save operation
    @Override
    public Applicant saveApplicant(Applicant applicant){
        return applicantRepository.save(applicant);
    }
 
    // Read operation
    @Override public List<Applicant> fetchApplicantList(){
        return (List<Applicant>) applicantRepository.findAll();
    }
 
    // Update operation
    @Override
    public Applicant updateApplicant(Applicant applicant, Long applicantId){
        Applicant app = applicantRepository.findById(applicantId).get();
 
        if (Objects.nonNull(applicant.getApplicantName())) {
            app.setApplicantName(applicant.getApplicantName());
        }
 
        return applicantRepository.save(app);
    }
 
    // Delete operation
    @Override
    public void deleteApplicantById(Long applicantId){
        applicantRepository.deleteById(applicantId);
    }
}