package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.OrganizationTeacher;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrganizationTeacher entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.imudges.meike.bean.OrganizationTeacher
 * @author MyEclipse Persistence Tools
 */
public class OrganizationTeacherDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrganizationTeacherDAO.class);

	// property constants

	public void save(OrganizationTeacher transientInstance) {
		log.debug("saving OrganizationTeacher instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrganizationTeacher persistentInstance) {
		log.debug("deleting OrganizationTeacher instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrganizationTeacher findById(
			com.imudges.meike.bean.OrganizationTeacherId id) {
		log.debug("getting OrganizationTeacher instance with id: " + id);
		try {
			OrganizationTeacher instance = (OrganizationTeacher) getSession()
					.get("com.imudges.meike.bean.OrganizationTeacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrganizationTeacher instance) {
		log.debug("finding OrganizationTeacher instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.OrganizationTeacher")
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
		log.debug("finding OrganizationTeacher instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from OrganizationTeacher as model where model."
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
		log.debug("finding all OrganizationTeacher instances");
		try {
			String queryString = "from OrganizationTeacher";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrganizationTeacher merge(OrganizationTeacher detachedInstance) {
		log.debug("merging OrganizationTeacher instance");
		try {
			OrganizationTeacher result = (OrganizationTeacher) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrganizationTeacher instance) {
		log.debug("attaching dirty OrganizationTeacher instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrganizationTeacher instance) {
		log.debug("attaching clean OrganizationTeacher instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}