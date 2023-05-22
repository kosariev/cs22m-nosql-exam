package kosariev.cs22m.nosql.exam.service;

import kosariev.cs22m.nosql.exam.model.UniversityDTO;
import kosariev.cs22m.nosql.exam.model.UniversityEntity;
import kosariev.cs22m.nosql.exam.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository universityRepository;

    public UniversityEntity addUniversity(UniversityDTO universityDTO) {
        UniversityEntity universityEntity = new UniversityEntity();
        universityEntity.setTitle(universityDTO.getTitle());
        universityEntity.setName(universityDTO.getName());
        universityEntity.setDescription(universityDTO.getDescription());
        universityEntity.setFounded(universityDTO.getFounded());
        universityEntity.setRector(universityDTO.getRector());
        universityEntity.setCountry(universityDTO.getCountry());
        universityEntity.setAddress(universityDTO.getAddress());
        universityEntity.setPhone(universityDTO.getPhone());
        universityEntity.setEmail(universityDTO.getEmail());
        universityEntity.setWebsite(universityDTO.getWebsite());
        return universityRepository.save(universityEntity);
    }

    public ResponseEntity<UniversityEntity> getUniversity(String id) {
        Optional<UniversityEntity> optionalEntity = universityRepository.findById(id);
        if (optionalEntity.isPresent()) {
            return new ResponseEntity<>(optionalEntity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public List<UniversityEntity> getUniversities() {
        return universityRepository.findAll();
    }
}
