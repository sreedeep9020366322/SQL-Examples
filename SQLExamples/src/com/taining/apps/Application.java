package com.taining.apps;

import java.util.List;

import com.taining.daos.CustomerDAO;
//import com.taining.utils.SqlConnection;
import com.training.entity.Customer;

public class Application {

	public static void main(String[] args) {
		
		//System.out.println(SqlConnection.getOracleConnection());
	
		Customer cust = new Customer(101,"Mahesh","mahesh@gmail.com",78965412);
		Customer cust2 = new Customer(102,"Suresh","Suresh@gmail.com",123456);
		Customer cust3 = new Customer(103,"Vignesh","Vignesh@gmail.com",987456321);
		Customer cust4 = new Customer(104,"Sumeesh","Sumesh@gmail.com",654144321);
		
		CustomerDAO dao = new CustomerDAO();
		
		//For adding new row
		//int rowAdded = dao.add(cust4);
		
		//System.out.println(rowAdded + " row added");
		
		Customer findCustomer = dao.find(102);
		
	//	System.out.println(findCustomer.showCustomer());
		
	//	System.out.println(dao.find(103).showCustomer());
		
		List<Customer> customerList = dao.findAll();
		
		for(Customer cust1: customerList) {
		
			System.out.println(cust1.showCustomer());
		}
		
		//For Deleting the row
		//System.out.println(dao.delete(102));
		
		//For Updating name in the row 
		System.out.println(dao.update(104,"Sree"));
	}

}
