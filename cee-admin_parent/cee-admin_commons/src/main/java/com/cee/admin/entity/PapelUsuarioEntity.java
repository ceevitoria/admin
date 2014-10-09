package com.cee.admin.entity;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Access;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.AccessType;

import com.powerlogic.jcompany.commons.annotation.PlcDetail;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import com.powerlogic.jcompany.config.application.PlcConfigModule;
import com.powerlogic.jcompany.config.collaboration.PlcConfigTabular;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name = "PAPEL_USUARIO")
@SequenceGenerator(name = "SE_PAPEL_USUARIO", sequenceName = "SE_PAPEL_USUARIO")
@PlcConfigTabular(orderProp="nomePapel")
@Access(AccessType.FIELD)
@NamedQueries({ @NamedQuery(name = "PapelUsuarioEntity.querySelLookup", query = "select id as id, nomePapel as nomePapel from PapelUsuarioEntity where id = ? order by id asc") })
public class PapelUsuarioEntity extends PapelUsuario {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public PapelUsuarioEntity() {
	}

	@Override
	public String toString() {
		return getNomePapel();
	}

	@Transient
	private String indExcPlc = "N";

	public void setIndExcPlc(String indExcPlc) {
		this.indExcPlc = indExcPlc;
	}

	public String getIndExcPlc() {
		return indExcPlc;
	}

}
