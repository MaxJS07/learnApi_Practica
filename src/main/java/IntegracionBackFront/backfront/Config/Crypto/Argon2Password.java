package IntegracionBackFront.backfront.Config.Crypto;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;

@Service
public class Argon2Password {

    //Configuracion recomendada para argon2Id
    private static final int ITERATIONS = 10;
    private static final int MEMORY = 32768;
    private static final int PARALLELISM = 2;

    //Creamos una instancia de Argon2Id
    private Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

    //EL metodo para encriptar cadenas de texto
    public String EncryptPassword(String contrasena){
        return argon2.hash(ITERATIONS, MEMORY, PARALLELISM, contrasena);
    }

    //El metodo para verificar si la contraseña es correcta
    public boolean VerifyPassword(String passDB, String password){
        return argon2.verify(passDB, password);
    }

}
