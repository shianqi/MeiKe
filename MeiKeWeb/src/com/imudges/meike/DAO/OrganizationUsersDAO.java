package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.OrganizationUsers;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrganizationUsers entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.imudges.meike.bean.OrganizationUsers
 * @author MyEclipse Persistence Tools
 */
public class OrganizationUsersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrganizationUsersDAO.class);

	// property constants

	public void save(OrganizationUsers transientInstance) {
		log.debug("saving OrganizationUsers instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrganizationUsers persistentInstance) {
		log.debug("deleting OrganizationUsers instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrganizationUsers findById(
			com.imudges.meike.bean.OrganizationUsersId id) {
		log.debug("getting OrganizationUsers instance with id: " + id);
		try {
			OrganizationUsers instance = (OrganizationUsers) getSession().get(
					"com.imudges.meike.bean.OrganizationUsers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrganizationUsers instance) {
		log.debug("finding OrganizationUsers instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.OrganizationUsers")
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
		log.debug("finding OrganizationUsers instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from OrganizationUsers as model where model."
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
		log.debug("finding all OrganizationUsers instances");
		try {
			String queryString = "from OrganizationUsers";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrganizationUsers merge(OrganizationUsers detachedInstance) {
		log.debug("merging OrganizationUsers instance");
		try {
			OrganizationUsers result = (OrganizationUsers) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrganizationUsers instance) {
		log.debug("attaching dirty OrganizationUsers instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrganizationUsers instance) {
		log.debug("attaching clean OrganizationUsers instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}