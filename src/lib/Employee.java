package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Employee extends Person{

	private String employeeId;
	private String firstName;
	private String lastName;
	private String address;

	private EmploymentPeriod employmentPeriod;

	private boolean isForeigner;
	private boolean gender; //true = Laki-laki, false = Perempuan

	private SalaryDetails salaryDetails;

	private Person spouse;
	private List<Person> children;
	
	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int grade, EmploymentPeriod employmentPeriod, boolean isForeigner, boolean gender) {
		super(firstName + " " + lastName, idNumber);
		
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.isForeigner = isForeigner;
		this.gender = gender;

		this.salaryDetails = new SalaryDetails();
		this.employmentPeriod = employmentPeriod;
		this.children = new ArrayList<>();
	}

	public void setAnnualDeductible(int deductible) {	
		salaryDetails.setAnnualDeductible(deductible);
	}
	
	public void setAdditionalIncome(int income) {	
		salaryDetails.setOtherMonthlyIncome(income);
	}

	public void setMonthlySalary(int grade) {
		salaryDetails.setMonthlySalary(grade, this.isForeigner);
	}
	
	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}
	
	public void addChild(List<Person> children) {
		this.children = children;
	}

	public EmploymentPeriod getEmploymentPeriod() {
		return employmentPeriod;
	}

	public SalaryDetails getSalaryDetails() {
		return salaryDetails;
	}

	public Person getSpouse() {
		return spouse;
	}

	public List<Person> getChildren() {
		return children;
	}
}
