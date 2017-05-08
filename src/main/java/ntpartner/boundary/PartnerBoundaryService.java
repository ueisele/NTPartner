package ntpartner.boundary;

import ntpartner.model.Address;
import ntpartner.model.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PartnerBoundaryService {
	/**
     * Creates a partner
     *
     * @param partner create a new partner
     * @return the created partner
     */
    Partner createPartner(Partner partner);

    /**
     * Retrieves all persons in a pageable fashion.
     * 
     * @param pageable parameter for creating pages
     * @return a collection of all persons
     */
    Page<Partner> findAllPartner(Pageable pageable);

    /**
     * Deletes the specified partner (by id)
     * 
     * @param id person to delete
     */
    void deletePartner(Long id);
}
