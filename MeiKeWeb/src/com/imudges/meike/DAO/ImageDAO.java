package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.Image;

/**
 * A data access object (DAO) providing persistence and search support for Image
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.imudges.meike.bean.Image
 * @author MyEclipse Persistence Tools
 */
public class ImageDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ImageDAO.class);
	// property constants
	public static final String URL = "url";

	public void save(Image transientInstance) {
		log.debug("saving Image instance");
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

	public void delete(Image persistentInstance) {
		log.debug("deleting Image instance");
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

	public Image findById(java.lang.Integer id) {
		log.debug("getting Image instance with id: " + id);
		try {
			Image instance = (Image) getSession().get(
					"com.imudges.meike.bean.Image", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Image instance) {
		log.debug("finding Image instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.Image")
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
		log.debug("finding Image instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Image as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findAll() {
		log.debug("finding all Image instances");
		try {
			String queryString = "from Image";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Image merge(Image detachedInstance) {
		log.debug("merging Image instance");
		try {
			Image result = (Image) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Image instance) {
		log.debug("attaching dirty Image instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Image instance) {
		log.debug("attaching clean Image instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}