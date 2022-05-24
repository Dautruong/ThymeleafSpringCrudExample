package com.example.employe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpServiceImpl implements EmpService {
	private static Map<Integer, Employee> employees;
	
	static {
		employees = new HashMap<>();
		employees.put(11, new Employee(11, "Dau", 11));
		employees.put(22, new Employee(22, "Quang", 22));
		employees.put(32, new Employee(32, "Truong", 33));
		employees.put(41, new Employee(41, "Admin", 44));
		employees.put(52, new Employee(52, "custumer", 55));
    }
	@Override
	public List<Employee> findAll() {
		return new ArrayList<>(employees.values());
	}

	@Override
	public void save(Employee employee) {
		employees.put(employee.getId(), employee);
		
	}

	@Override
	public Employee findById(int id) {
		return employees.get(id);
	}

	@Override
	public void update(int id, Employee employee) {
		employees.put(id, employee);
	}

	@Override
	public void remove(int id) {
		employees.remove(id);
		
	}

}
