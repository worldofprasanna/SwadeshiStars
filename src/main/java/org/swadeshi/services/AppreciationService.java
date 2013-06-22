package org.swadeshi.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.swadeshi.dao.AppreciationDao;
import org.swadeshi.entities.Appreciation;
import org.swadeshi.exceptions.CustomException;



@Service
public class AppreciationService {

	@Autowired
	private AppreciationDao appreciationDao ;
	
	public List<Appreciation> fetchAllAppreciations() throws CustomException{
		Iterable<Appreciation> appreciationIterable = appreciationDao.findAll();
		Iterator<Appreciation> appreciationIterator = appreciationIterable.iterator();
		List<Appreciation> appreciation = new ArrayList<Appreciation>();
		while (appreciationIterator.hasNext())
			appreciation.add(appreciationIterator.next());
		return appreciation;
	}
	
	public Page<Appreciation> fetchAllAppreciations(Pageable page) throws CustomException{
		Page<Appreciation> paginationAppreciation = appreciationDao.findAll(page);		
		return paginationAppreciation;
	}
	
	public Appreciation saveAppreciation(Appreciation appreciation) throws CustomException{
		Appreciation appreciationSaved = appreciationDao.save(appreciation);
		return appreciationSaved;
	}
	
}
