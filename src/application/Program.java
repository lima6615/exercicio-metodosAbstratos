package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Tax payer #" + (i + 1) + " data:");
			System.out.print("Individual or company (i/c)? ");
			char letra = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
			if (letra == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();

				Individual ind = new Individual(name, anualIncome, healthExpenditures);
				list.add(ind);
			}
			if (letra == 'c') {
				System.out.print("Number of Employees:  ");
				int numberOfEmployee = sc.nextInt();

				Company com = new Company(name, anualIncome, numberOfEmployee);
				list.add(com);
			}
		}

		System.out.println();
		System.out.println("TAXES PAID:");
		for (TaxPayer c : list) {
			System.out.println(c);
		}
		double sum = 0.0;
		for (TaxPayer c : list) {
			sum += c.tax();
		}
		System.out.println();
		System.out.println("Total Taxes: $ " + String.format("%.2f", sum));
		sc.close();
	}
}
