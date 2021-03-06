package entities;

public class Company extends TaxPayer {

	private Integer numberOfEmployee;

	public Company() {
		super();
	}

	public Company(String name, Double anualIncome, Integer numberOfEmployee) {
		super(name, anualIncome);
		this.numberOfEmployee = numberOfEmployee;
	}

	public Integer getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(Integer numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	@Override
	public double tax() {

		// double basicTax = (getAnualIncome() < numberOfEmployee) ? getAnualIncome() * 0.16 : getAnualIncome() * 0.14;
		double basictax;
		if (getAnualIncome() < numberOfEmployee) {
			basictax = getAnualIncome() * 0.16;
		} else {
			basictax = getAnualIncome() * 0.14;
		}

		return basictax;
	}
}
