package ntpartner.repository;

import java.util.List;

import javax.transaction.Transactional;

import ntpartner.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * JPA Repository for accessing Partner entities
 */
@Transactional
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    List<Partner> findByNameFirstname(String firstname);
    List<Partner> findByNameLastname(String lastname);
    List<Partner> findByNameFirstnameAndNameLastname(String firstname, String lastname);
}
