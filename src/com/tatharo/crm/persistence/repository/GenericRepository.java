package com.tatharo.crm.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GenericRepository<T> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GenericRepository.class);
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("Maes");

	public T merge(T entity) {
		EntityManager em = this.getEntityManager();
		T mergedEntity = null;
		try {
			em.getTransaction().begin();
			mergedEntity = em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			LOGGER.error("Unable to update Entity " + entity.getClass().toString(), e);
			try {
				em.getTransaction().rollback();
			} catch (Exception ex) {
				LOGGER.error("exception", ex);
			}
		}
		return mergedEntity;
	}

	public void remove(T entity) {
		EntityManager em = this.getEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			LOGGER.error("Unable to update Entity " + entity.getClass().toString(), e);
		}
	}

	// TODO Entity manager per logged in user/session
	protected EntityManager getEntityManager() {
		EntityManager em = factory.createEntityManager();
		return em;
	}

}
