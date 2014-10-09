package com.cee.admin.persistence.jpa.usuario;

import com.cee.admin.persistence.jpa.AppJpaDAO;
import com.cee.admin.entity.UsuarioEntity;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryParameter;
import com.cee.admin.entity.Pessoa;

import java.util.List;

import com.powerlogic.jcompany.persistence.jpa.PlcQuery;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryLineAmount;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryOrderBy;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryFirstLine;
import com.powerlogic.jcompany.commons.annotation.PlcAggregationDAOIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcDataAccessObject;
import com.powerlogic.jcompany.persistence.jpa.PlcQueryService;
import com.powerlogic.jcompany.commons.PlcBaseContextVO;
/**
 * Classe de Persistência gerada pelo assistente
 */

@PlcAggregationDAOIoC(UsuarioEntity.class)
@SPlcDataAccessObject
@PlcQueryService
public class UsuarioDAO extends AppJpaDAO  {

	@PlcQuery("querySel")
	public native List<UsuarioEntity> findList(
			PlcBaseContextVO context,
			@PlcQueryOrderBy String dynamicOrderByPlc,
			@PlcQueryFirstLine Integer primeiraLinhaPlc, 
			@PlcQueryLineAmount Integer numeroLinhasPlc,		   
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="pessoa", expression="obj1 = :pessoa") Pessoa pessoa
	);

	@PlcQuery("querySel")
	public native Long findCount(
			PlcBaseContextVO context,
			
			@PlcQueryParameter(name="id", expression="obj.id = :id") Long id,
			@PlcQueryParameter(name="pessoa", expression="obj1 = :pessoa") Pessoa pessoa
	);
	
}
