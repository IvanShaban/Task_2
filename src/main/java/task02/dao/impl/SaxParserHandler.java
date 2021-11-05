package task02.dao.impl;

import task02.entity.*;
import task02.entity.criteria.Criteria;
import task02.util.FieldHelperUtil;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import task02.entity.Appliance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static task02.util.ApplianceConstants.*;

public class SaxParserHandler extends DefaultHandler {
    private String parentTagName;
    private String currentTagName;
    private Boolean needToChangeParentTag;

    private final List<Appliance> result = new ArrayList<>();
    private final Criteria criteria;

    private Appliance currentAppliance;
    private Boolean applianceMatchesCriteria;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName == null || qName.isEmpty()) {
            return;
        }
        if (qName.equalsIgnoreCase(APPLIANCES)) {
            needToChangeParentTag = true;
            return;
        }
        if (needToChangeParentTag) {
            parentTagName = qName;
            needToChangeParentTag = false;
        }
        currentTagName = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName == null || qName.isEmpty()) {
            return;
        }
        if (qName.equalsIgnoreCase(parentTagName)) {
            needToChangeParentTag = true;
            applianceMatchesCriteria = true;
            if (currentAppliance != null) {
                Appliance appliance = currentAppliance;
                result.add(appliance);
                currentAppliance = null;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        if (value.trim().isEmpty()) {
            return;
        }
        if (!parentTagName.equalsIgnoreCase(criteria.getGroupSearchName()) || !applianceMatchesCriteria) {
            return;
        }
        if (currentAppliance == null) {
            currentAppliance = createAppliance(criteria.getGroupSearchName());
        }
        checkCriteriaAndSetField(value, currentAppliance);
    }

    private Appliance createAppliance(String className) throws SAXException {
        switch (className) {
            case LAPTOP:
                return new Laptop();
            case OVEN:
                return new Oven();
            case REFRIGERATOR:
                return new Refrigerator();
            case SPEAKERS:
                return new Speakers();
            case TABLET_PC:
                return new TabletPC();
            case VACUUM_CLEANER:
                return new VacuumCleaner();
            default:
                throw new SAXException("Invalid Class Name: " + className);
        }
    }

    private void checkCriteriaAndSetField(String value, Appliance appliance) {
        for (Map.Entry<String, Object> pair : criteria.getFieldCriteria().entrySet()) {
            if (pair.getKey().equalsIgnoreCase(currentTagName)) {
                if (pair.getValue().toString().equalsIgnoreCase(value)) {
                    FieldHelperUtil.setField(appliance, value, currentTagName);
                } else {
                    applianceMatchesCriteria = false;
                }
                return;
            }
        }
        FieldHelperUtil.setField(appliance, value, currentTagName);
    }

    public SaxParserHandler(Criteria criteria) {
        this.criteria = criteria;
        this.applianceMatchesCriteria = true;
    }

    public List<Appliance> getResult() {
        return result;
    }
}
