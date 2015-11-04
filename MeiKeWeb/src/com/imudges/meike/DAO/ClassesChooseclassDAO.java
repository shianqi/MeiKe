package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.ClassesChooseclass;

/**
 * A data access object (DAO) providing persistence and search support for
 * ClassesChooseclass entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.imudges.meike.bean.ClassesChooseclass
 * @author MyEclipse Persistence Tools
 */
public class ClassesChooseclassDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ClassesChooseclassDAO.class);

	// property constants

	public void save(ClassesChooseclass transientInstance) {
		log.debug("saving ClassesChooseclass instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ClassesChooseclass persistentInstance) {
		log.debug("deleting ClassesChooseclass instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ClassesChooseclass findById(
			com.imudges.meike.bean.ClassesChooseclassId id) {
		log.debug("getting ClassesChooseclass instance with id: " + id);
		try {
			ClassesChooseclass instance = (ClassesChooseclass) getSession()
					.get("com.imudges.meike.bean.ClassesChooseclass", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ClassesChooseclass instance) {
		log.debug("finding ClassesChooseclass instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.ClassesChooseclass")
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
		log.debug("finding ClassesChooseclass instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ClassesChooseclass as model where model."
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
		log.debug("finding all ClassesChooseclass instances");
		try {
			String queryString = "from ClassesChooseclass";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ClassesChooseclass merge(ClassesChooseclass detachedInstance) {
		log.debug("merging ClassesChooseclass instance");
		try {
			ClassesChooseclass result = (ClassesChooseclass) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ClassesChooseclass instance) {
		log.debug("attaching dirty ClassesChooseclass instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClassesChooseclass instance) {
		log.debug("attaching clean ClassesChooseclass instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}