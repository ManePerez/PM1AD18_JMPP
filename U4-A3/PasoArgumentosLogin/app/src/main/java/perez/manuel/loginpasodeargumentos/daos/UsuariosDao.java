package perez.manuel.loginpasodeargumentos.daos;

import java.util.HashSet;
import java.util.Set;

import perez.manuel.loginpasodeargumentos.models.Usuario;

public class UsuariosDao {
    Set<Usuario> listaUsuarioDao;

    public UsuariosDao(){
        listaUsuarioDao = new HashSet<>();
    }

    public Set<Usuario> listaUs(){
        listaUsuarioDao.add(new Usuario("Mane", "Perez"));
        listaUsuarioDao.add(new Usuario("Chema", "Perez"));
        listaUsuarioDao.add(new Usuario("Jose", "Paramo"));
        listaUsuarioDao.add(new Usuario("Manuel", "Paramo"));

        return listaUsuarioDao;

    }

    public  boolean usuExist(final Usuario us){
        listaUsuarioDao= listaUs();
        for (Usuario usr:listaUsuarioDao) {
            if(usr.getUsuario().equals(us.getUsuario())&& usr.getPassword().equals(us.getPassword())){
                // serializacion
                return true;
            }
        }
        return false;
    }
}
