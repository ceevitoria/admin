package com.cee.admin.entity;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Access;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.AccessType;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcEntity;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Classe Concreta gerada a partir do assistente
 */
@SPlcEntity
@Entity
@Table(name = "PAPEL")
@SequenceGenerator(name = "SE_PAPEL", sequenceName = "SE_PAPEL")
@Access(AccessType.FIELD)
@NamedQueries({
	@NamedQuery(name="PapelEntity.queryMan", query="from PapelEntity"), @NamedQuery(name = "PapelEntity.querySelLookup", query = "select id as id, nomePapel as nomePapel from PapelEntity where id = ? order by id asc") })
public class PapelEntity extends Papel {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public PapelEntity() {
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
