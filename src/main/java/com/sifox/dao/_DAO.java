package com.sifox.dao;

import java.util.*;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import com.sifox.entity.ShameDesk;
import com.sifox.entity.User;
import com.sifox.entity._Entity;
import com.sifox.utils.Logger;

import java.lang.reflect.*;

/**
 * Abstract class assign to do base operation as:
 * 		 Create, Read, Update, Delete, List, Count
 * 
 * @author Roman.Zaytseff
 * @date 18.05.2017
 *
 * @param generic <Entity> - Hibernate Entity
 * 
 */
@SuppressWarnings("hiding")
public abstract class _DAO<Entity extends _Entity> {
	
	protected Logger logger = new Logger(_DAO.class);
	
	@PersistenceContext
	protected EntityManager em;
	
	protected String tableName = tableName();
	
	protected String entityName = entityName();
	
    @SuppressWarnings("unchecked")
	protected Class<Entity> entityType() {
		return (Class<Entity>)
				((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	protected String entityName() {
		return entityType().getCanonicalName(); 
	}

	protected String tableName() {
		try {
			return entityType().newInstance().getTableName();
		} catch (Exception e) {
			return entityName();
		} 
	}

	public abstract boolean isUnique(Entity entity);

	protected Integer safeLongToInt(Long longNumber ) {
		if(longNumber == null)
			return null;
		
        if ( longNumber < Integer.MIN_VALUE || longNumber > Integer.MAX_VALUE ) {
            throw new IllegalArgumentException( longNumber + " cannot be cast to int without changing its value." );
        }
        return longNumber.intValue();
    }
	
	// --------  below methods is under read only declarative Transaction control 	
	
	/** count of Entities with the code */
	public int count(String... sqlParams) {
		Query query;
		String qlString = "SELECT count(" + tableName + ") FROM " + entityName + " as " + tableName;
		if(sqlParams.length >= 2) 
			qlString += " WHERE " + tableName + "." + sqlParams[0] + " LIKE " + "'" + sqlParams[1] + "'";
		
		try {
			query = em.createQuery(qlString);	
			return safeLongToInt((Long)query.getSingleResult());
			
		} catch (NoResultException e) {
			logger.error(e);
			return 0;
		}
	}

	/** find list Entities by code */
	@SuppressWarnings("unchecked")
	public List<Entity> list(String... sqlParams) {
		String qlString = "SELECT OBJECT(" + tableName + ") FROM " + entityName + " as " + tableName;
		if(sqlParams.length > 0) 
			qlString += " WHERE ";
		if(sqlParams.length > 1 && sqlParams[0] != null &&  sqlParams[1] != null) 
			qlString += tableName + "." + sqlParams[0] + " = " + "'" + sqlParams[1] + "'";
		if(sqlParams.length > 2  && sqlParams[2] != null) 
			qlString += " " + sqlParams[2];
		
		Query query = em.createQuery(qlString);	
		try {
			return (List<Entity>)query.getResultList();
		} catch (NoResultException e) {
			return new LinkedList<Entity>();
		} 
	}

	/** read Entity line by his id */
	public Entity findById(int id) {
		return em.find(entityType(), id);
	}
	
	/** read Entity by his code */
	@SuppressWarnings("unchecked")
	public Entity read(String field, String code) {
		String qlString = "SELECT OBJECT("  + tableName + ") FROM " + entityName + " as " + tableName + " WHERE " + tableName + "." + field + " = ?1";
		Query query = em.createQuery(qlString);		
		query.setParameter(1, code);
		try {
			return (Entity)query.getSingleResult();
			
		} catch (NonUniqueResultException e) {
			logger.error(e);
			List<Entity> list = query.getResultList();
			return list.get(0);
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

// ---------  below methods are under AOP transaction control
	
	/** the method return new user id 
	 *  The method is under AOP transaction control 
	 *  so it can return null value if transaction is fail
	 */
	public int create(Entity entity) {
		if(!isUnique(entity)) // check for Entity is unique
			return -1;
		
		em.persist(entity); // em.find(ShameDesk.class, 1); em.find(User.class, 1);
		em.flush();
		return entity.getId();
	}

	/** 
	 * update Entity info 
	 * Note: Entity object info must include not empty Entity ID
	 */
	public Entity update(Entity entity) {
		return em.merge(entity);
	}	
	
	/** delete Entity by his field code */
	public void delete(Entity entity) {
		em.remove(entity); 
		em.flush();
	}

}
