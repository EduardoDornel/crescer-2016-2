package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.UserBean;
import br.com.cwi.crescer.aula5.dao.UserDao;
import br.com.cwi.crescer.aula5.entity.Usuario;
import static br.com.cwi.crescer.aula5.utils.UserDetails.USER_AUTH;

import br.com.cwi.crescer.aula5.filters.User;
import br.com.cwi.crescer.aula5.utils.FacesUtils;
import br.com.cwi.crescer.aula5.utils.UserDetails;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class LoginMBean implements Serializable {

    private User user;

    @PostConstruct
    public void init() {
        this.user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoggedUsername() {
        final UserDetails userDetails;
        userDetails = (UserDetails) FacesUtils.getSession().getAttribute(USER_AUTH);
        return userDetails == null ? null : userDetails.getUsername();
    }

    public String login() {
        if (existeUsuario(user)) {
            FacesUtils.getSession().setAttribute(USER_AUTH, this.user);
            return "index";
        } else {
            return "login";
        }
    }

    public String logout() {
        FacesUtils.getSession().invalidate();
        return "login";
    }

    private List<Usuario> listarUsuariosExistentes() {
        return new UserBean().findAll();
    }

    private boolean existeUsuario(User usuario) {
        List<Usuario> usuariosCadastrados = listarUsuariosExistentes();
        for (Usuario u : usuariosCadastrados) {
            if (u.getEmail().equals(usuario.getEmail()) && u.getSenha().equals(usuario.getPassword())) {
                return true;
            }
        }
        return false;
        //return usuariosCadastrados.stream().anyMatch((u) -> (u.getEmail().equals(usuario.getEmail()) && u.getSenha().equals(usuario.getPassword())));
    }

}
