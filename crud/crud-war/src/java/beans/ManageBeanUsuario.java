/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import bc.UsuarioFacadeLocal;
import be.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author oaie
 */
@ManagedBean
@SessionScoped
public class ManageBeanUsuario implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private Usuario usuario;
    private int tipo_acao = 1;

    public ManageBeanUsuario() {
        usuario = new Usuario();
    }

    public int getTipo_acao() {
        return tipo_acao;
    }

    public void setTipo_acao(int tipo_acao) {
        this.tipo_acao = tipo_acao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLista() {
        return usuarioFacade.findAll();
    }

    public void selecionar_item(Usuario item, int tipo_ac) {
        usuario = item;
        tipo_acao = tipo_ac;
    }

    public void reinstanciar() {
        usuario = new Usuario();
    }

    public void criar() {
        if (tipo_acao == 1) {
            usuarioFacade.create(usuario);
        } else if (tipo_acao == 2) {
            usuarioFacade.edit(usuario);
        } else if (tipo_acao == 3) {
            usuarioFacade.remove(usuario);
        }
    }

}
