package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.Organization;

/**
 * A data access object (DAO) providing persistence and search support for
 * Organization entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.imudges.meike.bean.Organization
 * @author MyEclipse Persistence Tools
 */
public class OrganizationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrganizationDAO.class);
	// property constants
	public static final String ORGANIZATION_NAME = "organizationName";
	public static final String IMAGE = "image";
	public static final String DESCRIPTION = "description";
	public static final String DESCRIBE_IMAGE_ID1 = "describeImageId1";
	public static final String DESCRIBE_IMAGE_ID2 = "describeImageId2";
	public static final String DESCRIBE_IMAGE_ID3 = "describeImageId3";
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String CITY = "city";
	public static final String USERS_ID = "usersId";
	public static final String ADDRESS = "address";
	public static final String TEL = "tel";

	public void save(Organization transientInstance) {
		log.debug("saving Organization instance");
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

	public void delete(Organization persistentInstance) {
		log.debug("deleting Organization instance");
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

	public Organization findById(java.lang.Integer id) {
		log.debug("getting Organization instance with id: " + id);
		try {
			Organization instance = (Organization) getSession().get(
					"com.imudges.meike.bean.Organization", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Organization instance) {
		log.debug("finding Organization instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.Organization")
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
		log.debug("finding Organization instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Organization as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOrganizationName(Object organizationName) {
		return findByProperty(ORGANIZATION_NAME, organizationName);
	}

	public List findByImage(Object image) {
		return findByProperty(IMAGE, image);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByDescribeImageId1(Object describeImageId1) {
		return findByProperty(DESCRIBE_IMAGE_ID1, describeImageId1);
	}

	public List findByDescribeImageId2(Object describeImageId2) {
		return findByProperty(DESCRIBE_IMAGE_ID2, describeImageId2);
	}

	public List findByDescribeImageId3(Object describeImageId3) {
		return findByProperty(DESCRIBE_IMAGE_ID3, describeImageId3);
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

	public List findByUsersId(Object usersId) {
		return findByProperty(USERS_ID, usersId);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findAll() {
		log.debug("finding all Organization instances");
		try {
			String queryString = "from Organization";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Organization merge(Organization detachedInstance) {
		log.debug("merging Organization instance");
		try {
			Organization result = (Organization) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Organization instance) {
		log.debug("attaching dirty Organization instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Organization instance) {
		log.debug("attaching clean Organization instance");
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
			String queryString = "from Organization as model where  model.city = '"+city+"' and model.organizationId in (select a.organizationId from Organization as a  where a.organizationName like '%"+keyword+"%' or a.description like '%"+keyword+"%') ";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}