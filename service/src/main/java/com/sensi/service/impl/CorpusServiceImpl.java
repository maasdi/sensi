/**
 * CorpusServiceImpl.java
 *
 * eBio-MOH gateway version 1.0
 * Licensed Material - Property of XYBASE.
 * Copyright (C) 2006 XYBASE SDN BHD. All rights reserved.
 */
package com.sensi.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sensi.domain.Corpus;
import com.sensi.service.CorpusService;

/**
 *
 * @author <a href="mailto:maas_dianto@xybase.com">Maas Dianto</a>
 * @version 1.0 - Jun 20, 2012
 */

@Service("corpusService")
@Transactional
public class CorpusServiceImpl implements CorpusService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Long countCorpuses() {
		return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Corpus o").uniqueResult();
	}
	
	@Override
	public Corpus findCorpus(Long id) {
		return (Corpus) sessionFactory.getCurrentSession().createQuery("select o from Corpus o where o.id = :id").setLong("id", id).uniqueResult();
	}
	
	@Override
	public List<Corpus> findCorpuses() {
		return sessionFactory.getCurrentSession().createQuery("select o from Corpus o").list();
	}
	
	@Override
	public List<Corpus> findCorpuses(int start, int end) {
		return sessionFactory.getCurrentSession().createQuery("select o from Corpus o").setFirstResult(start).setMaxResults(end).list();
	}
	
	@Override
	public void save(Corpus corpus) {
		sessionFactory.getCurrentSession().saveOrUpdate(corpus);
	}
	
	@Override
	public void delete(Corpus corpus) {
		sessionFactory.getCurrentSession().delete(corpus);
	}

}
