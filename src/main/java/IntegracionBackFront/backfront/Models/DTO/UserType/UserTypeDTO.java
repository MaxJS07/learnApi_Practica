package IntegracionBackFront.backfront.Models.DTO.UserType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class UserTypeDTO {

    private Long id;
    private String nombreTipo;
    private String descripcion;
}
