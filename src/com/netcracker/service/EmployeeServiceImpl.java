package com.netcracker.service;

import java.util.List;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dao.EmployeeDao;
import com.netcracker.dao.EmployeeDaoImpl;
import com.netcracker.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao empDao=new EmployeeDaoImpl();
	@Override
	public Employee getEmployeeById(int id) throws DatabaseException {
		// TODO Auto-generated method stub
		return empDao.getEmployeeById(id);
	}
	@Override
	public List<Employee> getAllEmployee() throws DatabaseException {
		// TODO Auto-generated method stub
		return empDao.getAllEmployee();
	}
	@Override
	public int deleteEmployeeById(int id) throws DatabaseException {
		// TODO Auto-generated method stub
		return empDao.deleteEmployeeById(id);
	}
	@Override
	public int updateEmployee(Employee employee) throws DatabaseException {
		// TODO Auto-generated method stub
		return empDao.updateEmployee(employee);
	}
	@Override
	public int addEmployee(Employee employee) throws DatabaseException {
		// TODO Auto-generated method stub
		return empDao.addEmployee(employee);
	}

}
