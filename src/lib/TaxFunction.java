package lib;

import java.time.LocalDate;
import java.util.List;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	public static int getAnnualIncomeTax(Employee employee) {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		if (date.getYear() == employee.getEmploymentPeriod().getYearJoined()) {
			employee.setWorkingInYear(date.getMonthValue() - employee.getEmploymentPeriod().getMonthJoined());
		} else {
			employee.setWorkingInYear(12);;
		}
		
		return calculateTax(employee);
	}
	
	private static int calculateTax(Employee employee) {
		
		int tax = 0;
		int numberOfChildren = 0;
		
		if (employee.getEmploymentPeriod().getMonthWorkingInYear() > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		if (employee.getChildren().size() > 3) {
			numberOfChildren = 3;
		} else {
			numberOfChildren = employee.getChildren().size();
		}
		
		if (employee.getSpouse().equals(null)) {

			tax = (int) Math.round(0.05 * (((employee.getSalaryDetails().getMonthlySalary() 
			+ employee.getSalaryDetails().getOtherMonthlyIncome()) * employee.getEmploymentPeriod().getMonthWorkingInYear() ) 
			- employee.getSalaryDetails().getAnnualDeductible() - 54000000));
		}else {
			tax = (int) Math.round(0.05 * (((employee.getSalaryDetails().getMonthlySalary()  + employee.getSalaryDetails().getOtherMonthlyIncome()) 
			* employee.getEmploymentPeriod().getMonthWorkingInYear()) - employee.getSalaryDetails().getAnnualDeductible() - (54000000 + 4500000 + (numberOfChildren * 1500000))));
		}
		
		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}
	}
	
}
