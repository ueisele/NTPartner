package ntpartner.repository;

import ntpartner.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * JPA Repository for accessing Partner entities
 */
@Transactional
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    List<Partner> findByNameFirstname(String firstname);
    List<Partner> findByNameLastname(String lastname);
    List<Partner> findByNameFirstnameAndNameLastname(String firstname, String lastname);
}
