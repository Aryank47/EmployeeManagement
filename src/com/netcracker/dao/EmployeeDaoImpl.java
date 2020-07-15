package com.netcracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.netcracker.allquery.Query;
import com.netcracker.customexception.DatabaseException;
import com.netcracker.dbutil.DatabaseUtility;
import com.netcracker.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee getEmployeeById(int id) throws DatabaseException {
		// TODO Auto-generated method stub
		Connection connection=DatabaseUtility.getDBConnection();
		Employee employee=null;
		try {
			PreparedStatement statement=connection.prepareStatement(Query.SELECTBYID);
			statement.setInt(1, id);
			ResultSet res=statement.executeQuery();
			if(res.next()) {
				employee=new Employee(res.getInt(1),res.getString(2),res.getFloat(3));
			}
			else {
				throw new DatabaseException("Sorry, No Record found.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DatabaseException(e.getMessage());
		}
		finally {
			DatabaseUtility.releaseConnection();
		}
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() throws DatabaseException {
		// TODO Auto-generated method stub
		Connection connection=DatabaseUtility.getDBConnection();
		List<Employee> emp=new LinkedList<Employee>();
		Employee employee=null;
		try {
			PreparedStatement statement=connection.prepareStatement(Query.GETALL);
			ResultSet res=statement.executeQuery();
			while(res.next()) {
				employee=new Employee(res.getInt(1),res.getString(2),res.getFloat(3));
				emp.add(employee);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DatabaseException(e.getMessage());
		}
		DatabaseUtility.releaseConnection();
		return emp;
		
	}

	@Override
	public int deleteEmployeeById(int id) throws DatabaseException {
		// TODO Auto-generated method stub
		int count;
		Connection connection=DatabaseUtility.getDBConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(Query.DELETEEMP);
			statement.setInt(1,id);
			count=statement.executeUpdate();
			if(count>0) {
				connection.commit();
			}
			else {
				throw new DatabaseException("No record with emp_id="+id+" found in employee database.");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DatabaseException(e.getMessage());
		}
		DatabaseUtility.releaseConnection();
		
		return count;
	}

	@Override
	public int updateEmployee(Employee employee) throws DatabaseException {
		// TODO Auto-generated method stub
		int count;
		Connection connection=DatabaseUtility.getDBConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(Query.UPDATEEMP);
			statement.setString(1, employee.getName());
			statement.setFloat(2, employee.getSalary());
			statement.setInt(3, employee.getId());
			count=statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DatabaseException(e.getMessage());
		}
		DatabaseUtility.releaseConnection();
		return count;
	}

	@Override
	public int addEmployee(Employee employee) throws DatabaseException {
		// TODO Auto-generated method stub
		int count;
		Connection connection=DatabaseUtility.getDBConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(Query.SAVEEMP);
			statement.setInt(1,employee.getId());
			statement.setString(2, employee.getName());
			statement.setFloat(3, employee.getSalary());
			count=statement.executeUpdate();
			connection.commit();
		}
		catch(SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
		DatabaseUtility.releaseConnection();
		return count;
		
	}

}
