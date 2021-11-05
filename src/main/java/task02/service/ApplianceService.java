package task02.service;

import task02.entity.Appliance;
import task02.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceService {
	List<Appliance> find(Criteria criteria);
}
