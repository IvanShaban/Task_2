package task02.main;

import task02.entity.Appliance;
import task02.entity.Oven;
import task02.entity.criteria.Criteria;
import task02.service.ApplianceService;
import task02.service.ServiceFactory;

import java.util.List;

import static task02.entity.criteria.SearchCriteria.*;
import static task02.util.ApplianceConstants.*;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(CAPACITY, 3);

		appliances = service.find(criteriaOven);

		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(HEIGHT, 45);
		criteriaOven.add(DEPTH, 60);

		appliances = service.find(criteriaOven);

		PrintApplianceInfo.print(appliances);

		//////////////////////////////////////////////////////////////////

		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(COLOR, "RED");
		criteriaTabletPC.add(DISPLAY_INCHES, 13);

		appliances = service.find(criteriaTabletPC);

		PrintApplianceInfo.print(appliances);
	}
}
