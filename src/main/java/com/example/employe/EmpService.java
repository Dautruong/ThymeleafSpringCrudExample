package com.example.employe;

import java.util.List;

public interface  EmpService {
	List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id);

    void update(int id, Employee employee);

    void remove(int id);
}
