package com.netcracker.dao;

import java.util.List;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dto.Employee;

public interface EmployeeDao {
	public Employee getEmployeeById(int id)throws DatabaseException;
	public List<Employee> getAllEmployee()throws DatabaseException;
	public int deleteEmployeeById(int id)throws DatabaseException;
	public int updateEmployee(Employee employee)throws DatabaseException;
	public int addEmployee(Employee employee)throws DatabaseException;

}
