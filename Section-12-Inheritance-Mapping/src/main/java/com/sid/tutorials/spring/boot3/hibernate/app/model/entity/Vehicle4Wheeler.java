/**
 * 
 */
package com.sid.tutorials.spring.boot3.hibernate.app.model.entity;

import com.sid.tutorials.spring.boot3.hibernate.app.model.db.Vehicle;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kunmu
 *
 */
@Data
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Vehicle4Wheeler extends Vehicle {

	private String vehicleType;
	private String vehileBrand;

	/**
	 * @param vahicleNumber
	 * @param vahicleCategory
	 * @param vehicleType
	 * @param vehileBrand
	 */
	@Builder
	public Vehicle4Wheeler(String vahicleNumber, String vahicleCategory, String vehicleType, String vehileBrand) {
		super(vahicleNumber, vahicleCategory);
		this.vehicleType = vehicleType;
		this.vehileBrand = vehileBrand;
	}

}
