package com.example.onlinedelivery.services;

import java.util.List;
import java.util.Optional;

public interface GenericService<T>{

	
	public T saveInfo(T t);

	public T updateInfo(T t);

	public boolean deleteById(int id);

	public List<T> getallInfo();

	public Optional<T> getInfoById(int id);

}
