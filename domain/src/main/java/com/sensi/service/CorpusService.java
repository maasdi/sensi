package com.sensi.service;

import java.util.List;

import com.sensi.domain.Corpus;

/**
 *
 * @author <a href="mailto:maas_dianto@xybase.com">Maas Dianto</a>
 * @version 1.0 - Jun 20, 2012
 */
public interface CorpusService {
	
	public Long countCorpuses();
	
	public Corpus findCorpus(Long id);
	
	public List<Corpus> findCorpuses();
	
	public List<Corpus> findCorpuses(int start, int end);
	
	public void save(Corpus corpus);
	
	public void delete(Corpus corpus);
	
}
