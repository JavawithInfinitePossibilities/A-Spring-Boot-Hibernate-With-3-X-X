/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.services.impl;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.ClinicalData;
import com.sid.tutorials.spring.boot3.hibernate.app.repositories.ClinicalDataRepo;
import com.sid.tutorials.spring.boot3.hibernate.app.services.IClinicalDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 *
 */
@Service
public class ClinicalDataServiceImpl implements IClinicalDataServices {

	@Autowired
	private ClinicalDataRepo clinicalDataRepo;

	@Override
	public ClinicalData save(ClinicalData clinicalData) {
		return null;
	}

	@Override
	public ClinicalData get(int ClinicalDataId) {
		return null;
	}

	@Override
	public ClinicalData update(ClinicalData clinicalData) {
		return null;
	}

}
