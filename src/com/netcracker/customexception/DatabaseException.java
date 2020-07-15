package com.netcracker.customexception;

public class DatabaseException extends Exception {
	
	private static final long serialVersionUID = 4163558056404158575L;

	public DatabaseException() {
		
	}
	
	public DatabaseException(String msg) {
		super(msg);
		//System.out.println(msg);
		
	}

}
