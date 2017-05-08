package ntpartner.api;

import ntpartner.boundary.PartnerBoundaryService;
import ntpartner.model.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueReceiver {

    @Autowired
    private PartnerBoundaryService partnerService;

    public void receiveMessage(Partner partner) {
        System.out.println("Received : "+partner);
        Partner newPartner = partnerService.createPartner(partner);
        System.out.println("Created : "+newPartner);
    }
}
