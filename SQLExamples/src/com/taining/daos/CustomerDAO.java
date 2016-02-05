package com.taining.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.taining.ifaces.DAO;
import com.taining.utils.SqlConnection;
import com.training.entity.Customer;
//import com.training.*;
public class CustomerDAO implements DAO<Customer> {

	private Connection con;
	
	public CustomerDAO() {
		super();
		// TODO Auto-generated constructor stub
		con = SqlConnection.getOracleConnection();
	}

	public CustomerDAO(Connection con) {
		super();
		this.con = con;
	}


	@Override
	public int add(Customer t) {
		
		String sql = "insert into customer2016 values(?,?,?,?)";
		int rowAdded = 0;
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getCustomerId());
			pstmt.setString(2, t.getCustomerName());
			pstmt.setString(3, t.getEmailId());
			pstmt.setLong(4, t.getHandPhone());
			
			rowAdded = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowAdded;
	}

	@Override
	public Customer find(int key) {
		
		String sql = "Select * from customer2016 where customerId = ?";
		Customer cust = new Customer();
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				//cust.setCustomerId(key);
//				cust.setCustomerId(rs.getInt("customerId"));
//				cust.setCustomerName(rs.getString("customerName"));
//				cust.setEmailId(rs.getString("emailId"));
//				cust.setHandPhone(rs.getLong("handPhone"));
				
				cust = getCustomer(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cust;
	}

	@Override
	public List<Customer> findAll() {
	
		String sql = "Select * from customer2016";
		List<Customer> customerList = new ArrayList<Customer>();
		//Customer cust = new Customer();
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				customerList.add(getCustomer(rs));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return customerList;
	}

	private Customer getCustomer(ResultSet rs) {
	
		String customerName = null;
		int customerId = 0;
		String emailId = null;
		long handPhone = 0;
		
		try {
			customerName = rs.getString("customerName");
			customerId = rs.getInt("customerId");
			emailId = rs.getString("emailId");
			handPhone = rs.getInt("handPhone");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Customer cust = new Customer(customerId, customerName, emailId, handPhone);
		
		return cust;
	}
	
	@Override
	public int update(int key,String newName) {
		
		String sql = "Update customer2016 set customerName = ? where customerId= ?";
		int value = 0;
		try {
			
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, newName);
			psmt.setInt(2, key);
			
			value = psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public int delete(int key) {
		
		String sql = "Delete from Customer2016 where customerId = ?";
		int value= 0;
		try {
		
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, key);
			
			value = psmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}

}
