package org.aadsp.controller;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.aadsp.interfaces.BaseBean;
import org.aadsp.interfaces.IUsuario;
import org.aadsp.model.rn.UsuarioRN;


@ManagedBean(name="recHumanosConsultar")
@RequestScoped
public class RecHumanosConsultar extends BaseBean
{   
    private IUsuario usuario;
    private IUsuario selecionado;
    
    public RecHumanosConsultar(){
        this.usuario = new UsuarioRN();
    }
    
    public List<IUsuario> getUsuarios(){
        return usuario.listar();
    }

    public IUsuario getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(IUsuario selecionado) {
        this.selecionado = selecionado;
    }
}
