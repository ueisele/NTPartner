package ntpartner.api.resource;

import ntpartner.model.Partner;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class PartnerResourceAssembler extends ResourceAssemblerSupport<Partner, PartnerResource> {

	public PartnerResourceAssembler(Class<?> controllerClass, Class<PartnerResource> resourceType) {
		super(controllerClass, resourceType);
	}

	@Override
	public PartnerResource toResource(Partner partner) {
		PartnerResource partnerResource = createResourceWithId(partner.getId(), partner);
		partnerResource.id = partner.getId();
		partnerResource.name = partner.name.firstname + " " + partner.name.lastname;
		
		if (partner.address != null) {
			partnerResource.address = new AddressResource();
			partnerResource.address.city = partner.address.city;
			partnerResource.address.zipCode= partner.address.zipCode;
			partnerResource.address.street = partner.address.street;
			partnerResource.address.streetNo=partner.address.streetNo;
		}
		return partnerResource;
	}

}
