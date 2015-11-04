package com.imudges.meike.DAO;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.Search;

/**
 * A data access object (DAO) providing persistence and search support for
 * Search entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.imudges.meike.bean.Search
 * @author MyEclipse Persistence Tools
 */
public class SearchDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SearchDAO.class);
	// property constants
	public static final String SEARCH_STR = "searchStr";

	public void save(Search transientInstance) {
		log.debug("saving Search instance");
		Transaction transaction= getSession().beginTransaction();
		
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		transaction.commit();  
		getSession().flush();  
		getSession().close();
	}

	public void delete(Search persistentInstance) {
		log.debug("deleting Search instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Search findById(java.lang.Integer id) {
		log.debug("getting Search instance with id: " + id);
		try {
			Search instance = (Search) getSession().get(
					"com.imudges.meike.bean.Search", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Search instance) {
		log.debug("finding Search instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.Search")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Search instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Search as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySearchStr(Object searchStr) {
		return findByProperty(SEARCH_STR, searchStr);
	}

	public List findAll() {
		log.debug("finding all Search instances");
		try {
			String queryString = "from Search";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Search merge(Search detachedInstance) {
		log.debug("merging Search instance");
		try {
			Search result = (Search) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Search instance) {
		log.debug("attaching dirty Search instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Search instance) {
		log.debug("attaching clean Search instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}