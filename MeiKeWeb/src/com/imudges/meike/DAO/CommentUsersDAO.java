package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.CommentUsers;

/**
 * A data access object (DAO) providing persistence and search support for
 * CommentUsers entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.imudges.meike.bean.CommentUsers
 * @author MyEclipse Persistence Tools
 */
public class CommentUsersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CommentUsersDAO.class);

	// property constants

	public void save(CommentUsers transientInstance) {
		log.debug("saving CommentUsers instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CommentUsers persistentInstance) {
		log.debug("deleting CommentUsers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CommentUsers findById(com.imudges.meike.bean.CommentUsersId id) {
		log.debug("getting CommentUsers instance with id: " + id);
		try {
			CommentUsers instance = (CommentUsers) getSession().get(
					"com.imudges.meike.bean.CommentUsers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CommentUsers instance) {
		log.debug("finding CommentUsers instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.CommentUsers")
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
		log.debug("finding CommentUsers instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from CommentUsers as model where model."
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
		log.debug("finding all CommentUsers instances");
		try {
			String queryString = "from CommentUsers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CommentUsers merge(CommentUsers detachedInstance) {
		log.debug("merging CommentUsers instance");
		try {
			CommentUsers result = (CommentUsers) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CommentUsers instance) {
		log.debug("attaching dirty CommentUsers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CommentUsers instance) {
		log.debug("attaching clean CommentUsers instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}