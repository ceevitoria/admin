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
@Table(name = "USUARIO")
@SequenceGenerator(name = "SE_USUARIO", sequenceName = "SE_USUARIO")
@Access(AccessType.FIELD)
@NamedQueries({
	@NamedQuery(name="UsuarioEntity.queryMan", query="from UsuarioEntity"),
	@NamedQuery(name="UsuarioEntity.querySel", query="select obj.id as id, obj1.id as pessoa_id , obj1.nome as pessoa_nome from UsuarioEntity obj left outer join obj.pessoa as obj1 order by obj.id asc"), @NamedQuery(name = "UsuarioEntity.querySelLookup", query = "select id as id, nomeUsuario as nomeUsuario from UsuarioEntity where id = ? order by id asc") })
public class UsuarioEntity extends Usuario {

	private static final long serialVersionUID = 1L;

	/*
	 * Construtor padrao
	 */
	public UsuarioEntity() {
	}

	@Override
	public String toString() {
		return getNomeUsuario();
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
