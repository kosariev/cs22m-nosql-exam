package kosariev.cs22m.nosql.exam.сontroller;

import kosariev.cs22m.nosql.exam.model.UniversityDTO;
import kosariev.cs22m.nosql.exam.model.UniversityEntity;
import kosariev.cs22m.nosql.exam.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping("/universities")
    public ResponseEntity<List<UniversityEntity>> getUniversities() {
        try {
            List<UniversityEntity> universities = new ArrayList<>();
            universityService.getUniversities().forEach(universities::add);
            if (universities.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(universities, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/university/{id}")
    public ResponseEntity<UniversityEntity> getUniversity(@PathVariable("id") String id) {
        return universityService.getUniversity(id);
    }

    @PostMapping("/university")
    public ResponseEntity<UniversityEntity> addUniversity(@RequestBody UniversityDTO universityDTO) {
        try {
            return new ResponseEntity<>(universityService.addUniversity(universityDTO), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
