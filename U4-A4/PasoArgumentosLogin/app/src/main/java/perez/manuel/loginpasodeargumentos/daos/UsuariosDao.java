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
        listaUsuarioDao.add(new Usuario("mane", "12345","Perez","Paramo","mane@gmail.com"));
        listaUsuarioDao.add(new Usuario("chema", "12345","Lopez","Rodriguez","chema@gmail.com"));
        listaUsuarioDao.add(new Usuario("jose", "54321","Rodriguez","Martinez","jose@gmail.com"));
        listaUsuarioDao.add(new Usuario("manuel", "hola","Perez","Cervantes","manuel@gmail.com"));

        return listaUsuarioDao;

    }

    public  Usuario usuExist(final Usuario us){
        listaUsuarioDao= listaUs();
        for (Usuario usr:listaUsuarioDao) {
            if(usr.getUsuario().equals(us.getUsuario())&& usr.getPassword().equals(us.getPassword())){
                // serializacion
                return usr;
            }
        }
        return null;
    }


}
