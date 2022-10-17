package al.lat.demo.clientbase.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private Address billing;

    @OneToOne(cascade = CascadeType.ALL, optional = true, orphanRemoval = true)
    private Address mailing;
}
