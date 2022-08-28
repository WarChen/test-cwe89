package com.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.java.Driverm;

/**
 * A data access object (DAO) providing persistence and search support for
 * Driverm entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.java.Driverm
 * @author MyEclipse Persistence Tools
 */

public class DrivermDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(DrivermDAO.class);
	// property constants
	public static final String DRIVNM = "drivnm";
	public static final String EMPNUM = "empnum";
	public static final String SEX = "sex";
	public static final String NATION = "nation";
	public static final String BIRTHPL = "birthpl";
	public static final String PHNUM = "phnum";
	public static final String EMAIL = "email";
	public static final String DRNUM = "drnum";
	public static final String KIND = "kind";
	public static final String FDEP = "fdep";
	public static final String ADDRESS = "address";
	public static final String STATS = "stats";
	public static final String DES = "des";

	protected void initDao() {
		// do nothing
	}

	public void save(Driverm transientInstance) {
		log.debug("saving Driverm instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Driverm persistentInstance) {
		log.debug("deleting Driverm instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Driverm findById(java.lang.Long id) {
		log.debug("getting Driverm instance with id: " + id);
		try {
			Driverm instance = (Driverm) getHibernateTemplate().get(
					"com.java.Driverm", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Driverm instance) {
		log.debug("finding Driverm instance by example");
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
		log.debug("finding Driverm instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Driverm as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDrivnm(Object drivnm) {
		return findByProperty(DRIVNM, drivnm);
	}

	public List findByEmpnum(Object empnum) {
		return findByProperty(EMPNUM, empnum);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByNation(Object nation) {
		return findByProperty(NATION, nation);
	}

	public List findByBirthpl(Object birthpl) {
		return findByProperty(BIRTHPL, birthpl);
	}

	public List findByPhnum(Object phnum) {
		return findByProperty(PHNUM, phnum);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByDrnum(Object drnum) {
		return findByProperty(DRNUM, drnum);
	}

	public List findByKind(Object kind) {
		return findByProperty(KIND, kind);
	}

	public List findByFdep(Object fdep) {
		return findByProperty(FDEP, fdep);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByStats(Object stats) {
		return findByProperty(STATS, stats);
	}

	public List findByDes(Object des) {
		return findByProperty(DES, des);
	}

	public List findAll() {
		log.debug("finding all Driverm instances");
		try {
			String queryString = "from Driverm";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Driverm merge(Driverm detachedInstance) {
		log.debug("merging Driverm instance");
		try {
			Driverm result = (Driverm) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Driverm instance) {
		log.debug("attaching dirty Driverm instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Driverm instance) {
		log.debug("attaching clean Driverm instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DrivermDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DrivermDAO) ctx.getBean("DrivermDAO");
	}
}