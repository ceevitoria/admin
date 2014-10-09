package com.cee.admin.controller.jsf.usuario;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import com.cee.admin.controller.jsf.AppMB;
import com.cee.admin.entity.PapelUsuario;
import com.cee.admin.entity.Usuario;
import com.cee.admin.entity.UsuarioEntity;
import com.powerlogic.jcompany.commons.annotation.PlcUriIoC;
import com.powerlogic.jcompany.commons.config.stereotypes.SPlcMB;
import com.powerlogic.jcompany.config.aggregation.PlcConfigAggregation;
import com.powerlogic.jcompany.config.collaboration.FormPattern;
import com.powerlogic.jcompany.config.collaboration.PlcConfigForm;
import com.powerlogic.jcompany.config.collaboration.PlcConfigFormLayout;
import com.powerlogic.jcompany.controller.jsf.annotations.PlcHandleException;

//import org.apache.catalina.realm.RealmBase;

@PlcConfigAggregation(entity = com.cee.admin.entity.UsuarioEntity.class, details = { @com.powerlogic.jcompany.config.aggregation.PlcConfigDetail(clazz = com.cee.admin.entity.PapelUsuarioEntity.class, collectionName = "papelUsuario", numNew = 4, onDemand = false) })
@PlcConfigForm(formPattern = FormPattern.Mdt, formLayout = @PlcConfigFormLayout(dirBase = "/WEB-INF/fcls/usuario"))
/**
 * Classe de Controle gerada pelo assistente
 */
@SPlcMB
@PlcUriIoC("usuario")
@PlcHandleException
public class UsuarioMB extends AppMB {

	private static final long serialVersionUID = 1L;

	/**
	 * Entidade da ação injetado pela CDI
	 */
	@Produces
	@Named("usuario")
	public UsuarioEntity createEntityPlc() {
		if (this.entityPlc == null) {
			this.entityPlc = new UsuarioEntity();
			this.newEntity();
		}
		return (UsuarioEntity) this.entityPlc;
	}

	@Override
	public String save() {

		if (entityPlc != null) {
			Usuario usuario = (Usuario) entityPlc;

			try {
				MessageDigest md = MessageDigest.getInstance("SHA1");

				md.update(usuario.getSenhaUsuario().getBytes());
				byte[] hash = md.digest();

				String senha = bytesToHex(hash);

				usuario.setSenhaUsuario(senha);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

			// String senha = RealmBase.Digest(usuario.getSenhaUsuario(), "MD5",
			// null);
			//
			// usuario.setSenhaUsuario(senha);

			List<PapelUsuario> papelUsuario = (List<PapelUsuario>) usuario
					.getPapelUsuario();

			if (papelUsuario != null) {

				for (PapelUsuario pu : papelUsuario) {
					pu.setNomePapel(pu.getPapel() != null ? pu.getPapel()
							.getNomePapel() : null);
					pu.setNomeUsuario(pu.getUsuario() != null
							&& pu.getPapel() != null
							&& !"".equals(pu.getPapel()) ? pu.getUsuario()
							.getNomeUsuario() : null);
				}

			}
		}

		return super.save();
	}

	private static String bytesToHex(byte[] b) {
		char hexDigit[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		StringBuffer buf = new StringBuffer();
		for (int j = 0; j < b.length; j++) {
			buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
			buf.append(hexDigit[b[j] & 0x0f]);
		}
		return buf.toString();
	}
}
