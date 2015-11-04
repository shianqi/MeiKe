package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.Userimage;

/**
 * A data access object (DAO) providing persistence and search support for
 * Userimage entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.imudges.meike.bean.Userimage
 * @author MyEclipse Persistence Tools
 */
public class UserimageDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserimageDAO.class);

	// property constants

	public void save(Userimage transientInstance) {
		log.debug("saving Userimage instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Userimage persistentInstance) {
		log.debug("deleting Userimage instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userimage findById(com.imudges.meike.bean.UserimageId id) {
		log.debug("getting Userimage instance with id: " + id);
		try {
			Userimage instance = (Userimage) getSession().get(
					"com.imudges.meike.bean.Userimage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Userimage instance) {
		log.debug("finding Userimage instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.Userimage")
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
		log.debug("finding Userimage instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userimage as model where model."
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
		log.debug("finding all Userimage instances");
		try {
			String queryString = "from Userimage";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Userimage merge(Userimage detachedInstance) {
		log.debug("merging Userimage instance");
		try {
			Userimage result = (Userimage) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Userimage instance) {
		log.debug("attaching dirty Userimage instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userimage instance) {
		log.debug("attaching clean Userimage instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}