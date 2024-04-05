package lib;

public class Person {
    private String name;
	private String idNumber;

    public Person(String name, String idNumber){
        this.name = name;
        this.idNumber = idNumber;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
