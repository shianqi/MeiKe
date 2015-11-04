package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.News;

/**
 * A data access object (DAO) providing persistence and search support for News
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.imudges.meike.bean.News
 * @author MyEclipse Persistence Tools
 */
public class NewsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(NewsDAO.class);
	// property constants
	public static final String STUDENT_ID = "studentId";
	public static final String MSG = "msg";

	public void save(News transientInstance) {
		log.debug("saving News instance");
		Transaction transaction=getSession().beginTransaction();
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

	public void delete(News persistentInstance) {
		log.debug("deleting News instance");
		Transaction transaction=getSession().beginTransaction();
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		transaction.commit();
		getSession().flush();
		getSession().close();
	}

	public News findById(java.lang.Integer id) {
		log.debug("getting News instance with id: " + id);
		try {
			News instance = (News) getSession().get(
					"com.imudges.meike.bean.News", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(News instance) {
		log.debug("finding News instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.News")
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
		log.debug("finding News instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from News as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStudentId(Object studentId) {
		return findByProperty(STUDENT_ID, studentId);
	}

	public List findByMsg(Object msg) {
		return findByProperty(MSG, msg);
	}

	public List findAll() {
		log.debug("finding all News instances");
		try {
			String queryString = "from News";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public News merge(News detachedInstance) {
		log.debug("merging News instance");
		try {
			News result = (News) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(News instance) {
		log.debug("attaching dirty News instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(News instance) {
		log.debug("attaching clean News instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}