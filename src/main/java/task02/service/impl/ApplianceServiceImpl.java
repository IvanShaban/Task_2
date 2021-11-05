package task02.service.impl;

import task02.dao.ApplianceDAO;
import task02.dao.DAOFactory;
import task02.entity.Appliance;
import task02.entity.criteria.Criteria;
import task02.service.ApplianceService;
import task02.service.validation.Validator;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public List<Appliance> find(Criteria criteria) {
		if (!Validator.validateCriteria(criteria)) {
			return null;
		}

		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		return applianceDAO.find(criteria);
	}
}