package ntpartner.api;

import ntpartner.api.config.RabbitMqDevelopmentConfiguration;
import ntpartner.api.resource.PartnerResource;
import ntpartner.api.resource.PartnerResourceAssembler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ntpartner.api.resource.ListResource;
import ntpartner.api.resource.PartnerListResourceAssembler;
import ntpartner.boundary.PartnerBoundaryService;
import ntpartner.model.Partner;

/**
 * REST-Service to access Partner resources
 */
@RestController
// @RequestMapping(PartnerController.PARTNER_RESOURCE_PATH)
public class PartnerController {
	@Autowired
	private PartnerListResourceAssembler partnerListAssembler;

	public PartnerResourceAssembler getPartnerAssembler() {
		if (partnerAssembler == null) {
			partnerAssembler = new PartnerResourceAssembler(this.getClass(), PartnerResource.class);
		}
		return partnerAssembler;
	}

	private PartnerResourceAssembler partnerAssembler;

	@Autowired
	private PartnerBoundaryService partnerService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private QueueReceiver receiver;


    /**
	 * Creates a partner
	 *
	 * @param partnerResource
	 *            the new partner
	 * @return the created partner
	 */
	@RequestMapping(value = "/v1/partner", method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.CREATED )
	public PartnerResource createPartner(@RequestBody PartnerResource partnerResource) {
		Partner partner = partnerResource.toPartner();
		Partner newPartner = partnerService.createPartner(partner);
		PartnerResource newPartnerResource =  this.getPartnerAssembler().toResource(newPartner);
		return newPartnerResource;
	}

    /**
     * Creates a partner asynchronously
     *
     * @param partnerResource
     *            the new partner
     */
    @RequestMapping(value = "/v1/partner/async", method = RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    public void createPartnerAsync(@RequestBody PartnerResource partnerResource) {
        Partner partner = partnerResource.toPartner();
        rabbitTemplate.convertAndSend(RabbitMqDevelopmentConfiguration.queueName, partner);
    }


    /**
	 * Retrieves all persons in a pageable fashion.
	 * 
	 * @param pageable
	 *            parameter for creating pages
	 * @return a collection of all persons
	 */
	@RequestMapping(value = "/v1/partner", method = RequestMethod.GET)
	public ListResource<PartnerResource> findAllPartner(Pageable pageable) {
		Page<Partner> page = partnerService.findAllPartner(pageable);
		ListResource<PartnerResource> partnerListResource = partnerListAssembler.build(page);
		return partnerListResource;
	}

	/**
	 * Deletes the specified partner (by id)
	 * 
	 * @param id
	 *            person to delete
	 */
	@RequestMapping(value = "/v1/partner/{id}", method = RequestMethod.DELETE)
	public void deletePartner(@PathVariable("id") Long id) {
		System.out.println("delete called");
	    partnerService.deletePartner(id);
	}
}