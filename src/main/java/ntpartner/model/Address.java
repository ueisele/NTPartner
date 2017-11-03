package ntpartner.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
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
