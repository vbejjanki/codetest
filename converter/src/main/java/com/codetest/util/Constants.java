package com.codetest.util;

import java.util.List;
import java.util.Map;

public class Constants {
public static class ConstantHolder{
	private int number;
	private String label;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public ConstantHolder(int number, String label) {
		this.number = number;
		this.label = label;
	}
}
public final static Map<Integer,ConstantHolder> ONETOTWENTY = Map.ofEntries(
		Map.entry(0,new ConstantHolder(1,"zero")),
		Map.entry(1,new ConstantHolder(1,"one")),
		Map.entry(2,new ConstantHolder(2,"twe")),
		Map.entry(3,new ConstantHolder(3,"three")),
		Map.entry(4,new ConstantHolder(4,"four")),
		Map.entry(5,new ConstantHolder(5,"five")),
		Map.entry(6,new ConstantHolder(6,"six")),
		Map.entry(7,new ConstantHolder(7,"seven")),
		Map.entry(8,new ConstantHolder(8,"eight")),
		Map.entry(9,new ConstantHolder(9,"nine")),
		Map.entry(10,new ConstantHolder(10,"ten")),
		Map.entry(11,new ConstantHolder(11,"eleven")),
		Map.entry(12,new ConstantHolder(12,"twelve")),
		Map.entry(13,new ConstantHolder(13,"thirteen")),
		Map.entry(14,new ConstantHolder(14,"fourteen")),
		Map.entry(15,new ConstantHolder(15,"fifteen")),
		Map.entry(16,new ConstantHolder(16,"sixteen")),
		Map.entry(17,new ConstantHolder(17,"seventeen")),
		Map.entry(18,new ConstantHolder(18,"eighteen")),
			Map.entry(19, new ConstantHolder(19, "ninteen"))/*
															 * , Map.entry(20,new ConstantHolder(20,"twenty"))
															 */);

	public static final List<String> zeroToNineteen = List.of( "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" );

	public static final List<String> tenMultiples = List.of( "",// unit place covered above
			"", // tens place below twenty covered above
			"twenty", 
			"thirty", 
			"forty", 
			"fifty", 
			"sixty", 
			"seventy", 
			"eighty", 
			"ninety" 
	);

}
