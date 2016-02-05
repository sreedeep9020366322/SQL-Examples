package com.taining.ifaces;

import java.util.List;

public interface DAO<T> {

	public int add(T t);
	public T find(int key);
	public List<T> findAll();
	public int update(int key,String name);
	public int delete(int key);

}
