package com.imudges.meike.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imudges.meike.bean.Users;

/**
 * A data access object (DAO) providing persistence and search support for Users
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.imudges.meike.bean.Users
 * @author MyEclipse Persistence Tools
 */
public class UsersDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(UsersDAO.class);
	// property constants
	public static final String USERS_NAME = "usersName";
	public static final String PASSWORD = "password";
	public static final String IS_STUDENT = "isStudent";
	public static final String EMAIL = "email";
	public static final String WECHAT_ID = "wechatId";
	public static final String WEIBO_ID = "weiboId";
	public static final String IMAGE_ID = "imageId";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String NAME = "name";
	public static final String EMAIL_STATUS = "emailStatus";
	public static final String SEND_TIME = "sendTime";
	public static final String HASH_CODE = "hashCode";

	public void save(Users transientInstance) {
		log.debug("saving Users instance");
		Transaction transaction= getSession().beginTransaction();
		
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

	public void delete(Users persistentInstance) {
		log.debug("deleting Users instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Users findById(java.lang.Integer id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) getSession().get(
					"com.imudges.meike.bean.Users", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Users instance) {
		log.debug("finding Users instance by example");
		try {
			List results = getSession()
					.createCriteria("com.imudges.meike.bean.Users")
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
		log.debug("finding Users instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Users as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsersName(Object usersName) {
		return findByProperty(USERS_NAME, usersName);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByIsStudent(Object isStudent) {
		return findByProperty(IS_STUDENT, isStudent);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByWechatId(Object wechatId) {
		return findByProperty(WECHAT_ID, wechatId);
	}

	public List findByWeiboId(Object weiboId) {
		return findByProperty(WEIBO_ID, weiboId);
	}

	public List findByImageId(Object imageId) {
		return findByProperty(IMAGE_ID, imageId);
	}

	public List findByPhoneNumber(Object phoneNumber) {
		return findByProperty(PHONE_NUMBER, phoneNumber);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByEmailStatus(Object emailStatus) {
		return findByProperty(EMAIL_STATUS, emailStatus);
	}

	public List findBySendTime(Object sendTime) {
		return findByProperty(SEND_TIME, sendTime);
	}

	public List findByHashCode(Object hashCode) {
		return findByProperty(HASH_CODE, hashCode);
	}

	public List findAll() {
		log.debug("finding all Users instances");
		try {
			String queryString = "from Users";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Users merge(Users detachedInstance) {
		log.debug("merging Users instance");
		try {
			Users result = (Users) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Users instance) {
		log.debug("attaching dirty Users instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Users instance) {
		log.debug("attaching clean Users instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}