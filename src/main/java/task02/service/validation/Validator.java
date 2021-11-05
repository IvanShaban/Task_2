package task02.service.validation;

import task02.entity.criteria.Criteria;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static task02.util.ApplianceConstants.*;

public class Validator {
	private static final List<String> GROUP_SEARCH_NAMES = Arrays.asList(OVEN, LAPTOP, REFRIGERATOR,
			SPEAKERS, TABLET_PC, VACUUM_CLEANER);

	public static boolean validateCriteria(Criteria criteria) {
		if (criteria == null) {
			return false;
		}

		return criteria.getGroupSearchName() != null
				&& GROUP_SEARCH_NAMES.contains(criteria.getGroupSearchName())
				&& validateFieldCriteria(criteria);
	}

	private static boolean validateFieldCriteria(Criteria criteria) {
		AtomicBoolean isValid = new AtomicBoolean(true);
		criteria.getFieldCriteria().forEach((field, value) -> {
			if (field == null || field.isEmpty()) {
				isValid.set(false);
			}
		});
		return isValid.get();
	}
}