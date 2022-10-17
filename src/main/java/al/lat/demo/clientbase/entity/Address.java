package al.lat.demo.clientbase.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String line;
    private Integer postalCode;
    private String municipality;
}
