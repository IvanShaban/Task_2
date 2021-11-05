package task02.main;

import task02.entity.Appliance;

import java.util.List;

public class PrintApplianceInfo {
	
	public static void print(List<Appliance> appliances) {
		appliances.forEach(System.out::println);
	}
}
