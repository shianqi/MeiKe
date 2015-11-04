package com.imudges.meike.DAO;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.Classes;

/**
 * A data access object (DAO) providing persistence and search support for
 * Classes entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.imudges.meike.bean.Classes
 * @author MyEclipse Persistence Tools
 */
public class ClassesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ClassesDAO.class);
	// property constants
	public static final String CLASS_NAME = "className";
	public static final String CLASS_TYPE = "classType";
	public static final String OF_TEACHER_ID = "ofTeacherId";
	public static final String OF_ORGANIZATION = "ofOrganization";
	public static final String IMAGE_ID = "imageId";
	public static final String DESCRIPTION = "description";
	public static final String POSITION = "position";
	public static final String QUANTITY = "quantity";
	public static final String NUMBERS = "numbers";
	public static final String WHICH_DAY_IN_WEEK = "whichDayInWeek";
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String CITY = "city";

	public void save(Classes transientInstance) {
		log.debug("saving Classes instance");
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

	public void delete(Classes persistentInstance) {
		log.debug("deleting Classes instance");
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

	public Classes findById(java.lang.Integer id) {
		log.debug("getting Classes instance with id: " + id);
		try {
			Classes instance = (Classes) getSession().get(
					"com.imudges.meike.bean.Classes", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Classes instance) {
		log.debug("finding Classes instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.Classes")
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
		log.debug("finding Classes instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Classes as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByClassName(Object className) {
		return findByProperty(CLASS_NAME, className);
	}

	public List findByClassType(Object classType) {
		return findByProperty(CLASS_TYPE, classType);
	}

	public List findByOfTeacherId(Object ofTeacherId) {
		return findByProperty(OF_TEACHER_ID, ofTeacherId);
	}

	public List findByOfOrganization(Object ofOrganization) {
		return findByProperty(OF_ORGANIZATION, ofOrganization);
	}

	public List findByImageId(Object imageId) {
		return findByProperty(IMAGE_ID, imageId);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByPosition(Object position) {
		return findByProperty(POSITION, position);
	}

	public List findByQuantity(Object quantity) {
		return findByProperty(QUANTITY, quantity);
	}

	public List findByNumbers(Object numbers) {
		return findByProperty(NUMBERS, numbers);
	}

	public List findByWhichDayInWeek(Object whichDayInWeek) {
		return findByProperty(WHICH_DAY_IN_WEEK, whichDayInWeek);
	}

	public List findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List findByCity(Object city) {
		return findByProperty(CITY, city);
	}

	public List findAll() {
		log.debug("finding all Classes instances");
		try {
			String queryString = "from Classes";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Classes merge(Classes detachedInstance) {
		log.debug("merging Classes instance");
		try {
			Classes result = (Classes) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Classes instance) {
		log.debug("attaching dirty Classes instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Classes instance) {
		log.debug("attaching clean Classes instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List findByKeyword(String keyword, String city) {

		try {
			String queryString = "from Classes as model where model.city = '"+city+"' and model.classId in (select a.classId from Classes as a  where a.className like '%"+keyword+"%' or a.classType like '%"+keyword+"%'  or a.description like '%"+keyword+"%' or a.intro like '%" + keyword +"%')  and (to_days(now()) - to_days(model.endDate)) < 1) ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}