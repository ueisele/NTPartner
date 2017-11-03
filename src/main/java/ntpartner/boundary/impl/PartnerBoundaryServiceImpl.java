package ntpartner.boundary.impl;

import ntpartner.boundary.PartnerBoundaryService;
import ntpartner.model.Partner;
import ntpartner.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartnerBoundaryServiceImpl implements PartnerBoundaryService {

	private static final Pageable DEFAULT_PAGEABLE = new PageRequest(0, 10);

	@Autowired
	private PartnerRepository partnerRepository;

	@Override
	public Partner createPartner(Partner partner) {
		Partner newPartner = null;
		if (partner != null) {
			newPartner = partnerRepository.save(partner);
		}
		return newPartner;
	}

	@Override
	public Page<Partner> findAllPartner(Pageable pageable) {
		if (pageable == null) {
			pageable = DEFAULT_PAGEABLE;
		}
		return partnerRepository.findAll(pageable);
	}

	@Override
	public void deletePartner(Long id) {
		partnerRepository.deleteById(id);
	}

}
