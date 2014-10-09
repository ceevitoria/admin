/* ************************* META-DADOS GLOBAIS DA APLICAÇÃO ******************************
  ********************** Configurações padrão para toda a aplicação *************************
  ************ Obs: configurações corporativas devem estar no nível anterior,****************
  ************              preferencialmente na camada Bridge               ****************
  *******************************************************************************************/


@PlcConfigApplication(
	definition=@PlcConfigApplicationDefinition(name="Administração",acronym="Admin",version=1,release=0),
	classesDiscreteDomain={com.cee.admin.entity.Sexo.class},
	classesLookup={com.cee.admin.entity.PapelEntity.class,com.cee.admin.entity.UfEntity.class,com.cee.admin.entity.CidadeEntity.class}
)


package com.powerlogic.jcompany.config.app;

import com.powerlogic.jcompany.config.application.PlcConfigApplication;
import com.powerlogic.jcompany.config.application.PlcConfigApplicationDefinition;
