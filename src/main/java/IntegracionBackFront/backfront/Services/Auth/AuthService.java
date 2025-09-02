package IntegracionBackFront.backfront.Services.Auth;

import IntegracionBackFront.backfront.Config.Crypto.Argon2Password;
import IntegracionBackFront.backfront.Entities.Users.UserEntity;
import IntegracionBackFront.backfront.Repositories.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    //REPOS
    @Autowired
    private UserRepository repoUser;

    public boolean Login(String correo, String contrasena){

        //Creamos objeto de la clase Argon2
        Argon2Password objHash = new Argon2Password();
        //Buscamos un usuario por correo
        Optional<UserEntity> list = repoUser.findByCorreo(correo).stream().findFirst();
        if (list.isPresent()){
            //Creamos un objeto de user entity
            UserEntity user = list.get();
            String nombreTipoUsuario = user.getTipoUsuario().getNombreTipo();
            System.out.println("Usuario encontrado, ID: " + user.getId() +
                    ", email: " + user.getCorreo() +
                    ", rol: " + nombreTipoUsuario
            );
            String hashDB = user.getContrasena();
            //Verificamos si es la contraseña correcta
            return objHash.VerifyPassword(hashDB, contrasena);
        }
        else{
            return false;
        }
    }
}
