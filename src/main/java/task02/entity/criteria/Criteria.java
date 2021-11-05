package task02.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

	private String groupSearchName;
	private Map<String, Object> fieldCriteria = new HashMap<String, Object>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}
	
	public String getGroupSearchName() {
		return groupSearchName;
	}

	public void add(String searchCriteria, Object value) {
		fieldCriteria.put(searchCriteria, value);
	}

	public void setGroupSearchName(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	public void setFieldCriteria(Map<String, Object> fieldCriteria) {
		this.fieldCriteria = fieldCriteria;
	}

	public Map<String, Object> getFieldCriteria() {
		return fieldCriteria;
	}
}
