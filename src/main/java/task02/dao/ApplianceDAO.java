package task02.dao;

import task02.entity.Appliance;
import task02.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {
	List<Appliance> find(Criteria criteria);
	void save(Appliance appliance);
}
