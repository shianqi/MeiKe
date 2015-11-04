package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.OrganizationImage;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrganizationImage entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.imudges.meike.bean.OrganizationImage
 * @author MyEclipse Persistence Tools
 */
public class OrganizationImageDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrganizationImageDAO.class);

	// property constants

	public void save(OrganizationImage transientInstance) {
		log.debug("saving OrganizationImage instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrganizationImage persistentInstance) {
		log.debug("deleting OrganizationImage instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrganizationImage findById(
			com.imudges.meike.bean.OrganizationImageId id) {
		log.debug("getting OrganizationImage instance with id: " + id);
		try {
			OrganizationImage instance = (OrganizationImage) getSession().get(
					"com.imudges.meike.bean.OrganizationImage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrganizationImage instance) {
		log.debug("finding OrganizationImage instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.OrganizationImage")
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
		log.debug("finding OrganizationImage instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from OrganizationImage as model where model."
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
		log.debug("finding all OrganizationImage instances");
		try {
			String queryString = "from OrganizationImage";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrganizationImage merge(OrganizationImage detachedInstance) {
		log.debug("merging OrganizationImage instance");
		try {
			OrganizationImage result = (OrganizationImage) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrganizationImage instance) {
		log.debug("attaching dirty OrganizationImage instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrganizationImage instance) {
		log.debug("attaching clean OrganizationImage instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}