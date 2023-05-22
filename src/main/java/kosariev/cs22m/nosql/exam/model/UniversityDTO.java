package kosariev.cs22m.nosql.exam.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Document(collection = "university")
public class UniversityDTO {
    private String title;
    private String name;
    private String description;
    private String founded;
    private String rector;
    private String country;
    private String address;
    private String phone;
    private String email;
    private String website;
}
