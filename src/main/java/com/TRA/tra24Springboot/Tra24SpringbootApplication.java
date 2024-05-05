package com.TRA.tra24Springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static com.TRA.tra24Springboot.InvoicingSystem.*;

@SpringBootApplication
public class Tra24SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tra24SpringbootApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		String name = null;

		Menue.invoice1.customerFullName = name;
		invoice1.setCustomerFullName(name);
		while (name == null) {
			try {
				System.out.println("Enter your full name: ");
				name = scanner.nextLine();

				if (!isValidString(name)) {
					throw new IllegalArgumentException("Invalid input. ");
				}

			} catch (IllegalArgumentException e) {
				System.out.print(e.getMessage());
				name = null;
			}
		}

		//System.out.println("Enter your phone number: ");
		String phoneNumber = null;
		Menue.invoice1.phoneNumber = phoneNumber;
		invoice1.setPhoneNumber(phoneNumber);

		while (phoneNumber == null) {
			try {
				System.out.println("Enter your phone number: ");
				phoneNumber = scanner.nextLine();

				if (!isValidPhoneN(phoneNumber)) {
					throw new IllegalArgumentException("Invalid input. ");
				}
			} catch (Exception e) {
				System.out.print(e.getMessage());
				phoneNumber = null;
			}
		}

		Menue.addItems(scanner);
		Menue.showMainMenu();

	}

}
