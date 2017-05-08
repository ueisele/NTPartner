package ntpartner.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.hateoas.Identifiable;

import java.io.Serializable;

/**
 * Address entity
 * @author user
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
	private static final long serialVersionUID = -6503692835232524166L;
	
	@NotEmpty
    public String street;
	
	@NotEmpty
    public String streetNo;
	
	@NotEmpty
    public String zipCode;
	
	@NotEmpty
    public String city;
}
