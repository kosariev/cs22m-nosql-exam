package kosariev.cs22m.nosql.exam.repository;

import kosariev.cs22m.nosql.exam.model.UniversityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends MongoRepository<UniversityEntity, String> {
}
