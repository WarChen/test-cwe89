package com.po;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * DriverInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.po.DriverInfo
 * @author MyEclipse Persistence Tools
 */

public class DriverInfoDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(DriverInfoDAO.class);
	// property constants
	public static final String DRIVER_NAME = "driverName";
	public static final String DRIVER_AGE = "driverAge";
	public static final String DRIVER_SEX = "driverSex";
	public static final String DRIVER_PHOTO = "driverPhoto";
	public static final String DRIVER_DRIVE_CARD_ID = "driverDriveCardId";
	public static final String DRIVER_CARD_ID = "driverCardId";
	public static final String DRIVER_PHONE = "driverPhone";
	public static final String DRIVER_MEMO = "driverMemo";
	public static final String DRIVER_IS_VACANCY = "driverIsVacancy";

	protected void initDao() {
		// do nothing
	}

	public void save(DriverInfo transientInstance) {
		log.debug("saving DriverInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(DriverInfo persistentInstance) {
		log.debug("deleting DriverInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DriverInfo findById(java.lang.Integer id) {
		log.debug("getting DriverInfo instance with id: " + id);
		try {
			DriverInfo instance = (DriverInfo) getHibernateTemplate().get(
					"com.po.DriverInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(DriverInfo instance) {
		log.debug("finding DriverInfo instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DriverInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from DriverInfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDriverName(Object driverName) {
		return findByProperty(DRIVER_NAME, driverName);
	}

	public List findByDriverAge(Object driverAge) {
		return findByProperty(DRIVER_AGE, driverAge);
	}

	public List findByDriverSex(Object driverSex) {
		return findByProperty(DRIVER_SEX, driverSex);
	}

	public List findByDriverPhoto(Object driverPhoto) {
		return findByProperty(DRIVER_PHOTO, driverPhoto);
	}

	public List findByDriverDriveCardId(Object driverDriveCardId) {
		return findByProperty(DRIVER_DRIVE_CARD_ID, driverDriveCardId);
	}

	public List findByDriverCardId(Object driverCardId) {
		return findByProperty(DRIVER_CARD_ID, driverCardId);
	}

	public List findByDriverPhone(Object driverPhone) {
		return findByProperty(DRIVER_PHONE, driverPhone);
	}

	public List findByDriverMemo(Object driverMemo) {
		return findByProperty(DRIVER_MEMO, driverMemo);
	}

	public List findByDriverIsVacancy(Object driverIsVacancy) {
		return findByProperty(DRIVER_IS_VACANCY, driverIsVacancy);
	}

	public List findAll() {
		log.debug("finding all DriverInfo instances");
		try {
			String queryString = "from DriverInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	/**
	 * 查询指定公司的所有司机
	 * @param int 公司编号
	 * @return List 司机集合
	 * */
	public List findByBranchID(int branchID){
		String hql = "from DriverInfo where branchInfo=?";
		Query qy = this.getSession(true).createQuery(hql);
		
		qy.setInteger(0, branchID);
		
		List li = qy.list();
		
		return li;
	}

	public DriverInfo merge(DriverInfo detachedInstance) {
		log.debug("merging DriverInfo instance");
		try {
			DriverInfo result = (DriverInfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DriverInfo instance) {
		log.debug("attaching dirty DriverInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DriverInfo instance) {
		log.debug("attaching clean DriverInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DriverInfoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DriverInfoDAO) ctx.getBean("DriverInfoDAO");
	}
}