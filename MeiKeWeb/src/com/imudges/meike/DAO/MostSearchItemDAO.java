package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.MostSearchItem;

/**
 * A data access object (DAO) providing persistence and search support for
 * MostSearchItem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.imudges.meike.bean.MostSearchItem
 * @author MyEclipse Persistence Tools
 */
public class MostSearchItemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MostSearchItemDAO.class);

	// property constants

	public void save(MostSearchItem transientInstance) {
		log.debug("saving MostSearchItem instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MostSearchItem persistentInstance) {
		log.debug("deleting MostSearchItem instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MostSearchItem findById(com.imudges.meike.bean.MostSearchItemId id) {
		log.debug("getting MostSearchItem instance with id: " + id);
		try {
			MostSearchItem instance = (MostSearchItem) getSession().get(
					"com.imudges.meike.bean.MostSearchItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MostSearchItem instance) {
		log.debug("finding MostSearchItem instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.MostSearchItem")
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
		log.debug("finding MostSearchItem instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MostSearchItem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all MostSearchItem instances");
		try {
			String queryString = "from MostSearchItem";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MostSearchItem merge(MostSearchItem detachedInstance) {
		log.debug("merging MostSearchItem instance");
		try {
			MostSearchItem result = (MostSearchItem) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MostSearchItem instance) {
		log.debug("attaching dirty MostSearchItem instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MostSearchItem instance) {
		log.debug("attaching clean MostSearchItem instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}