package task02.util;

import task02.entity.*;

import static task02.util.ApplianceConstants.*;

public class FieldHelperUtil {
    public static void setField(Appliance appliance, String value, String fieldName) {
        switch (appliance.getClass().getSimpleName()) {
            case LAPTOP:
                setLaptopField(appliance, value, fieldName);
                break;
            case OVEN:
                setOvenField(appliance, value, fieldName);
                break;
            case REFRIGERATOR:
                setRefrigeratorField(appliance, value, fieldName);
                break;
            case SPEAKERS:
                setSpeakersField(appliance, value, fieldName);
                break;
            case TABLET_PC:
                setTabletPCField(appliance, value, fieldName);
                break;
            case VACUUM_CLEANER:
                setVacuumCLeanerField(appliance, value, fieldName);
        }
    }

    private static void setLaptopField(Appliance appliance, String value, String fieldName) {
        Laptop laptop = (Laptop) appliance;
        switch (fieldName) {
            case PRICE:
                laptop.setPrice(Integer.parseInt(value));
                break;
            case BATTERY_CAPACITY:
                laptop.setBatteryCapacity(Integer.parseInt(value));
                break;
            case MEMORY_ROM:
                laptop.setMemoryRom(Integer.parseInt(value));
                break;
            case SYSTEM_MEMORY:
                laptop.setSystemMemory(Integer.parseInt(value));
                break;
            case CPU:
                laptop.setCpu(Integer.parseInt(value));
                break;
            case DISPLAY_INCHES:
                laptop.setDisplayInches(Integer.parseInt(value));
                break;
            case OS:
                laptop.setOs(value);
        }
    }

    private static void setOvenField(Appliance appliance, String value, String fieldName) {
        Oven oven = (Oven) appliance;
        switch (fieldName) {
            case PRICE:
                oven.setPrice(Integer.parseInt(value));
                break;
            case POWER_CONSUMPTION:
                oven.setPowerConsumption(Integer.parseInt(value));
                break;
            case WEIGHT:
                oven.setWeight(Integer.parseInt(value));
                break;
            case CAPACITY:
                oven.setCapacity(Integer.parseInt(value));
                break;
            case DEPTH:
                oven.setDepth(Integer.parseInt(value));
                break;
            case HEIGHT:
                oven.setHeight(Integer.parseInt(value));
                break;
            case WIDTH:
                oven.setWidth(Integer.parseInt(value));
        }
    }

    private static void setRefrigeratorField(Appliance appliance, String value, String fieldName) {
        Refrigerator refrigerator = (Refrigerator) appliance;
        switch (fieldName) {
            case PRICE:
                refrigerator.setPrice(Integer.parseInt(value));
                break;
            case POWER_CONSUMPTION:
                refrigerator.setPowerConsumption(Integer.parseInt(value));
                break;
            case WEIGHT:
                refrigerator.setWeight(Integer.parseInt(value));
                break;
            case FREEZER_CAPACITY:
                refrigerator.setFreezerCapacity(Integer.parseInt(value));
                break;
            case OVERALL_CAPACITY:
                refrigerator.setOverallCapacity(Integer.parseInt(value));
                break;
            case HEIGHT:
                refrigerator.setHeight(Integer.parseInt(value));
                break;
            case WIDTH:
                refrigerator.setWidth(Integer.parseInt(value));
        }
    }

    private static void setSpeakersField(Appliance appliance, String value, String fieldName) {
        Speakers speakers = (Speakers) appliance;
        switch (fieldName) {
            case PRICE:
                speakers.setPrice(Integer.parseInt(value));
                break;
            case POWER_CONSUMPTION:
                speakers.setPowerConsumption(Integer.parseInt(value));
                break;
            case NUMBER_OF_SPEAKERS:
                speakers.setNumberOfSpeakers(Integer.parseInt(value));
                break;
            case FREQUENCY_RANGE:
                speakers.setFrequencyRange(Integer.parseInt(value));
                break;
            case CORD_LENGTH:
                speakers.setCordLength(Integer.parseInt(value));
        }
    }

    private static void setTabletPCField(Appliance appliance, String value, String fieldName) {
        TabletPC tabletPC = (TabletPC) appliance;
        switch (fieldName) {
            case PRICE:
                tabletPC.setPrice(Integer.parseInt(value));
                break;
            case BATTERY_CAPACITY:
                tabletPC.setBatteryCapacity(Integer.parseInt(value));
                break;
            case DISPLAY_INCHES:
                tabletPC.setDisplayInches(Integer.parseInt(value));
                break;
            case MEMORY_ROM:
                tabletPC.setMemoryRom(Integer.parseInt(value));
                break;
            case FLASH_MEMORY_CAPACITY:
                tabletPC.setFlashMemoryCapacity(Integer.parseInt(value));
                break;
            case COLOR:
                tabletPC.setColor(value);
        }
    }

    private static void setVacuumCLeanerField(Appliance appliance, String value, String fieldName) {
        VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
        switch (fieldName) {
            case PRICE:
                vacuumCleaner.setPrice(Integer.parseInt(value));
                break;
            case POWER_CONSUMPTION:
                vacuumCleaner.setPowerConsumption(Integer.parseInt(value));
                break;
            case FILTER_TYPE:
                vacuumCleaner.setFilterType(value);
                break;
            case BAG_TYPE:
                vacuumCleaner.setBagType(value);
                break;
            case WAND_TYPE:
                vacuumCleaner.setWandType(value);
                break;
            case MOTOR_SPEED_REGULATION:
                vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt(value));
                break;
            case CLEANING_WIDTH:
                vacuumCleaner.setCleaningWidth(Integer.parseInt(value));
        }
    }
}
