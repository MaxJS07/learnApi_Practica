package IntegracionBackFront.backfront.Services.Users;

import IntegracionBackFront.backfront.Entities.Users.UserEntity;
import IntegracionBackFront.backfront.Models.DTO.Users.UserDTO;
import IntegracionBackFront.backfront.Repositories.UserTypes.UserTypeRepository;
import IntegracionBackFront.backfront.Repositories.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //REPOS
    @Autowired
    private UserRepository repo;
    @Autowired
    private UserTypeRepository repoUserType;


    //METODOS DE CONVERSION
    private UserDTO convertirAdto(UserEntity entity){
        UserDTO dto = new UserDTO();

        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setApellido(entity.getApellido());
        dto.setCorreo(entity.getCorreo());
        dto.setContrasena(entity.getContrasena());
        dto.setFechaRegistro(entity.getFechaRegistro());

        return dto;
    }

}
