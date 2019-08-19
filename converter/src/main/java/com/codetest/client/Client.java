package com.codetest.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.codetest.converter.api.Converter;
import com.codetest.converter.impl.NumberToWordConverter;

public class Client {

	private List<String> args = new ArrayList<>();

	private Scanner scanner = new Scanner(System.in);

	private static class MenuOption {
		private int number;
		private String label;

		public MenuOption(int number, String label) {
			this.setNumber(number);
			this.setLabel(label);
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
	}

	private static List<MenuOption> menuOptions = List.of(new MenuOption(1, "NumberToWordConverter"),
			new MenuOption(2, "Exit Program"));

	public Client(List<String> args) {
		this.setArgs(args);
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

	public void run() {
		while (true) {
			displayMainMenu();
			try {
				int menuChoice = chooseMainMenu();
				if (menuChoice == -1) {
					System.out.println("Exiting the program.");
					break;
				}
				menuChoiceAction(menuChoice);
			} catch (IllegalArgumentException iAE) {
				System.err.println(iAE.getMessage());
			}
		}

	}

	private void menuChoiceAction(int menuChoice) {
		// Future if we add more converters
		if (menuChoice == 1) {
			convertNumberToWord();
		} else {
			throw new IllegalStateException("Only 1 menu option available.");
		}

	}

	private void convertNumberToWord() throws NumberFormatException{
		System.out.print("Enter a number below 999,999,999 ");
		try {
		int input = Integer.valueOf(scanner.next());
		Converter converter = new NumberToWordConverter();
		String convertedWord = converter.convert(input);
		System.out.println("****************OUTPUT****************");
		System.out.println(convertedWord);
		System.out.println("**************************************");
		}catch(NumberFormatException nFE) {
			throw new NumberFormatException("Please enter valid input.");
		}
	}

	private void displayMainMenu() {
		// TODO Auto-generated method stub
		displayMenu(menuOptions);
	}

	private int chooseMainMenu() {
		return chooseMenu(menuOptions);
		// TODO Auto-generated method stub

	}

	private int chooseMenu(List<MenuOption> menuOptions2) {
		System.out.print("Enter your choice ");
		MenuOption firstOption = menuOptions.get(0);
		MenuOption lastOption = menuOptions.get(menuOptions.size() - 1);
		int choice = -1;
		try {
		choice = Integer.valueOf(scanner.next());
		}catch(NumberFormatException nFE) {
			throw new NumberFormatException("Please enter valid input.");
		}
		if (choice < firstOption.number || choice > lastOption.number) {
			throw new IllegalArgumentException("Invalid menu choice. Available currentOptions are: "
					+ firstOption.number + " to " + lastOption.number + ".");
		}
		if (choice == lastOption.number) {
			choice = -1;
		}
		return choice;

	}

	private void displayMenu(List<MenuOption> list) {
		list.forEach(m -> System.out.printf("%s\t%s%n", m.number, m.label));
	}
}
