package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.Slidebox;

/**
 * A data access object (DAO) providing persistence and search support for
 * Slidebox entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.imudges.meike.bean.Slidebox
 * @author MyEclipse Persistence Tools
 */
public class SlideboxDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SlideboxDAO.class);
	// property constants
	public static final String URL1 = "url1";
	public static final String URL2 = "url2";
	public static final String URL3 = "url3";

	public void save(Slidebox transientInstance) {
		log.debug("saving Slidebox instance");
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
	}

	public void delete(Slidebox persistentInstance) {
		log.debug("deleting Slidebox instance");
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

	public Slidebox findById(java.lang.Integer id) {
		log.debug("getting Slidebox instance with id: " + id);
		try {
			Slidebox instance = (Slidebox) getSession().get(
					"com.imudges.meike.bean.Slidebox", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Slidebox instance) {
		log.debug("finding Slidebox instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.Slidebox")
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
		log.debug("finding Slidebox instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Slidebox as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUrl1(Object url1) {
		return findByProperty(URL1, url1);
	}

	public List findByUrl2(Object url2) {
		return findByProperty(URL2, url2);
	}

	public List findByUrl3(Object url3) {
		return findByProperty(URL3, url3);
	}

	public List findAll() {
		log.debug("finding all Slidebox instances");
		try {
			String queryString = "from Slidebox";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Slidebox merge(Slidebox detachedInstance) {
		log.debug("merging Slidebox instance");
		try {
			Slidebox result = (Slidebox) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Slidebox instance) {
		log.debug("attaching dirty Slidebox instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Slidebox instance) {
		log.debug("attaching clean Slidebox instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}