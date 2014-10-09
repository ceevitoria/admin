package com.cee.admin.entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIf;
import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIfType;
import org.hibernate.annotations.ForeignKey;

import com.powerlogic.jcompany.config.domain.PlcReference;
import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;

@MappedSuperclass
public abstract class PapelUsuario extends AppBaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_PAPEL_USUARIO")
	private Long id;

	@ManyToOne(targetEntity = UsuarioEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_PAPELUSUARIO_USUARIO")
	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "nomeUsuario", is = RequiredIfType.not_empty)
	private Usuario usuario;

	@ManyToOne(targetEntity = PapelEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_PAPELUSUARIO_PAPEL")
	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "nomeUsuario", is = RequiredIfType.not_empty)
	private Papel papel;

	@Size(max = 50)
	@PlcReference(testDuplicity=true)
	private String nomePapel;

	@Size(max = 15)
	private String nomeUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomePapel() {
		return nomePapel;
	}

	public void setNomePapel(String nomePapel) {
		this.nomePapel = nomePapel;
	}

}
