package task02.dao.impl;

import task02.dao.ApplianceDAO;
import task02.entity.Appliance;
import task02.entity.criteria.Criteria;

import java.util.List;

public class ApplianceDAOImpl implements ApplianceDAO {

	@Override
	public List<Appliance> find(Criteria criteria) {
		Parser parser = new Parser();
		return parser.parse(criteria);
	}

	@Override
	public void save(Appliance appliance) {

	}
}