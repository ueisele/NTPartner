package ntpartner.api.resource;

import ntpartner.model.Address;
import ntpartner.model.Name;
import ntpartner.model.Partner;
import org.springframework.hateoas.ResourceSupport;

public class PartnerResource extends ResourceSupport {
	public static String NAME_DELIMITER = " ";
	
	public Long id;
    public String name;
    public AddressResource address;

    public Partner toPartner() {
        Partner partner = new Partner(this.id);
        int delimiter = this.name.indexOf(" ");
        if (delimiter != -1) {
            partner.name = new Name(this.name.substring(0, delimiter), this.name.substring(delimiter + 1));
        }
        if (this.address != null) {
            partner.address = new Address();
            partner.address.city = this.address.city;
            partner.address.zipCode = this.address.zipCode;
            partner.address.street = this.address.street;
            partner.address.streetNo = this.address.streetNo;
        }
        return partner;
    }
}
