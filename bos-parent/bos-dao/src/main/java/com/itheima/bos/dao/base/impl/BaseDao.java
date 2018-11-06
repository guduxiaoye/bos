package com.itheima.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.itheima.bos.dao.base.IBaseDao;

public class BaseDao<T> extends HibernateDaoSupport implements IBaseDao<T> {
	
	private Class<T> entityClass;
	@Resource
	public void setMySessionFactory (SessionFactory sessionFactory) {
		
		super.setSessionFactory(sessionFactory);
	}
	
	public BaseDao() {
		//获取到basedao类
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得父类的泛型数组
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		entityClass=(Class<T>) actualTypeArguments[0];
		
	}
	
//持久层通用查询
	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
		
	}

	@Override
	public void delect(T entity) {
		
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
		
	}

	@Override
	public void updateById(T entity) {
		
		
	}

	@Override
	public T findById(Serializable id) {
		
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<T> selectAll() {
		
		String hql ="FROM " + entityClass.getSimpleName();
		
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

}
