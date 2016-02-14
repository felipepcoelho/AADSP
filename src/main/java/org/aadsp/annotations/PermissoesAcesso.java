
package org.aadsp.annotations;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AADSP.PERFIL.AADSP_PERFIL_PERMISSOES")
public class PermissoesAcesso implements Serializable 
{
    @Id
    @GeneratedValue
    @Column(name="ID") private Integer ID;
    @Column(name="ID_usuarioTipo") private Integer ID_usuarioTipo;
    @Column(name="pagina") private String pagina;

    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID = ID;
    }

    public Integer getID_usuarioTipo()
    {
        return ID_usuarioTipo;
    }

    public void setID_usuarioTipo(Integer ID_usuarioTipo)
    {
        this.ID_usuarioTipo = ID_usuarioTipo;
    }

    public String getPagina()
    {
        return pagina;
    }

    public void setPagina(String pagina)
    {
        this.pagina = pagina;
    }

   
    
}
