package com.cee.admin.persistence.jpa;

import com.powerlogic.jcompany.persistence.jpa.PlcBaseJpaManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.powerlogic.jcompany.commons.annotation.PlcDbFactory;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcJpaManager;

@SPlcJpaManager
@PlcDbFactory(nome="GLOBAL", autoDetectDialect=true)
public class AppGlobalJpaManager extends PlcBaseJpaManager {

	@PersistenceUnit(unitName = "GLOBAL")
	private EntityManagerFactory persistenceUnit;
	
	public EntityManagerFactory getPersistenceUnit() {
		return persistenceUnit;
	}
	
}
