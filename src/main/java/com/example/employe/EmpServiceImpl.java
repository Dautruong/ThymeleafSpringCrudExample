package com.example.employe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpServiceImpl implements EmpService {
	private static Map<Integer, Employee> employees;
	
	static {
		employees = new HashMap<>();
		employees.put(1, new Employee(1, "Dau", 22));
		employees.put(2, new Employee(2, "Quang", 33));
		employees.put(3, new Employee(3, "Truong", 44));
		employees.put(4, new Employee(4, "admin", 55));
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
