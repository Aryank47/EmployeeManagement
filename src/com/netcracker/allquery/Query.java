package com.netcracker.allquery;

public interface Query {
	String SELECTBYID="select * from employee where emp_id=?";
	String SAVEEMP="insert into employee values(?,?,?)";
	String GETALL="select * from employee";
	String DELETEEMP="delete from employee where emp_id=?";
	String UPDATEEMP="update employee set emp_name=?,emp_salary=? where emp_id=?";

}
