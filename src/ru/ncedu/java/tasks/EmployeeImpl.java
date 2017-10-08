package ru.ncedu.java.tasks;

public class EmployeeImpl implements Employee{

	private 
		int salary=1000;
		String firstname;
		String secondname;
		Employee Manager = null;
		Employee BigManager;
		
	@Override
	public int getSalary() {
		return salary;
	}

	@Override
	public void increaseSalary(int value) {
		salary = salary+value;
		
	}

	@Override
	public String getFirstName() {
		
		return firstname;
	}

	@Override
	public void setFirstName(String firstName) {
		firstname = firstName;
		
	}

	@Override
	public String getLastName() {
		return secondname;
	}

	@Override
	public void setLastName(String lastName) {
		secondname = lastName;
	}

	@Override
	public String getFullName() {
		String tmp = firstname + ' ' + secondname;
		return tmp;
	}

	@Override
	public void setManager(Employee manager) {
		Manager = manager;		
	}

	@Override
	public String getManagerName() {
		if(Manager != null){
			String tmp1 = Manager.getFirstName();
			String tmp2 = Manager.getLastName();
			String tmp = tmp1 + ' ' + tmp2;
			return tmp;
		}
		else{
			String tmp = "No manager";
			return tmp;
		}
	}

	@Override
	public Employee getTopManager() {
		if(Manager != null){
			return getTopManager();
		}
		else{
			return Manager;
		}
	}

}
