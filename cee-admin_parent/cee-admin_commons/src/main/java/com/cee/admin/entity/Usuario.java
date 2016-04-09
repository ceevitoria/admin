package com.cee.admin.entity;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIfType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.GenerationType;
import org.hibernate.annotations.ForeignKey;
import com.powerlogic.jcompany.domain.validation.PlcValGroupEntityList;
import org.apache.myfaces.extensions.validator.crossval.annotation.RequiredIf;
import javax.validation.constraints.Size;
import javax.persistence.FetchType;
import com.powerlogic.jcompany.config.domain.PlcReference;
import javax.persistence.GeneratedValue;
import java.util.List;
import com.powerlogic.jcompany.domain.validation.PlcValDuplicity;
import javax.validation.Valid;
import com.powerlogic.jcompany.domain.validation.PlcValMultiplicity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@MappedSuperclass
public abstract class Usuario extends AppBaseEntity {
	private static final long serialVersionUID = 4070312378257037283L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SE_USUARIO")
	private Long id;

	@ManyToOne(targetEntity = PessoaEntity.class, fetch = FetchType.LAZY)
	@ForeignKey(name = "FK_USUARIO_PESSOA")
	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "nomeUsuario", is = RequiredIfType.not_empty)
	private Pessoa pessoa;

	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "id", is = RequiredIfType.not_empty)
	@Size(max = 15)
	@PlcReference(testDuplicity = true)
	private String nomeUsuario;

	@NotNull(groups = PlcValGroupEntityList.class)
	@RequiredIf(valueOf = "nomeUsuario", is = RequiredIfType.not_empty)
	@Size(max = 50)
	private String senhaUsuario;

	@OneToMany (targetEntity = com.cee.admin.entity.PapelUsuarioEntity.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="usuario")
	@ForeignKey(name="FK_PAPELUSUARIO_USUARIO")
	@PlcValDuplicity(property="nomePapel")
	@PlcValMultiplicity(referenceProperty="nomePapel",  message="{jcompany.aplicacao.mestredetalhe.multiplicidade.PapelUsuarioEntity}")
	@Valid
	private List<PapelUsuario> papelUsuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public List<PapelUsuario> getPapelUsuario() {
		return papelUsuario;
	}

	public void setPapelUsuario(List<PapelUsuario> papelUsuario) {
		this.papelUsuario=papelUsuario;
	}

}
