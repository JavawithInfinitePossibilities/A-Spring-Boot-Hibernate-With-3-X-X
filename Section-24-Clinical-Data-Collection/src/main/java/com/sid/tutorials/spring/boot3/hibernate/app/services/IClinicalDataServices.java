/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.services;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.ClinicalData;

/**
 * @author Lenovo
 *
 */
public interface IClinicalDataServices {
	public ClinicalData save(ClinicalData clinicalData);

	public ClinicalData get(int ClinicalDataId);

	public ClinicalData update(ClinicalData clinicalData);
}
