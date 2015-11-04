package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.OrganizationClassesTeacher;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrganizationClassesTeacher entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.imudges.meike.bean.OrganizationClassesTeacher
 * @author MyEclipse Persistence Tools
 */
public class OrganizationClassesTeacherDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrganizationClassesTeacherDAO.class);

	// property constants

	public void save(OrganizationClassesTeacher transientInstance) {
		log.debug("saving OrganizationClassesTeacher instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrganizationClassesTeacher persistentInstance) {
		log.debug("deleting OrganizationClassesTeacher instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrganizationClassesTeacher findById(
			com.imudges.meike.bean.OrganizationClassesTeacherId id) {
		log.debug("getting OrganizationClassesTeacher instance with id: " + id);
		try {
			OrganizationClassesTeacher instance = (OrganizationClassesTeacher) getSession()
					.get("com.imudges.meike.bean.OrganizationClassesTeacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrganizationClassesTeacher instance) {
		log.debug("finding OrganizationClassesTeacher instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.imudges.meike.bean.OrganizationClassesTeacher")
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
		log.debug("finding OrganizationClassesTeacher instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from OrganizationClassesTeacher as model where model."
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
		log.debug("finding all OrganizationClassesTeacher instances");
		try {
			String queryString = "from OrganizationClassesTeacher";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrganizationClassesTeacher merge(
			OrganizationClassesTeacher detachedInstance) {
		log.debug("merging OrganizationClassesTeacher instance");
		try {
			OrganizationClassesTeacher result = (OrganizationClassesTeacher) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrganizationClassesTeacher instance) {
		log.debug("attaching dirty OrganizationClassesTeacher instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrganizationClassesTeacher instance) {
		log.debug("attaching clean OrganizationClassesTeacher instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}