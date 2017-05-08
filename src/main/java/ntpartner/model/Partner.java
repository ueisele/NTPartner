package ntpartner.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.hateoas.Identifiable;

import java.io.Serializable;

/**
 * Partner Entity
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Partner extends AbstractPersistable<Long> implements Identifiable<Long>, Serializable {
	private static final long serialVersionUID = -7728962437347271840L;
	
	/**
     * Constructor to be able to set id of entity explicitly
     * @param id Primary key of address
     */
	public Partner(Long id) {
		setId(id);
	}
	
	@Embedded
	public Name name;

	@Embedded
	public Address address;
}
