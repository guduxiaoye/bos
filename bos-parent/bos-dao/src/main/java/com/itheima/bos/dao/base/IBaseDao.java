package com.itheima.bos.dao.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {

//	持久层通用接口
	public void save (T entity);
	public void delect (T entity) ;
	public void update (T entity) ;
	public void updateById (T entity) ;
	public T findById (Serializable id) ;
	public List<T> selectAll () ;
		
}
