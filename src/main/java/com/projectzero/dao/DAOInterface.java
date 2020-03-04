package com.projectzero.dao;

import java.util.List;

public interface DAOInterface {


		public boolean insert(Object obj);
		public Object find(int id);
		public List<?> findAll();

}
