package IntegracionBackFront.backfront.Entities.UserType;

import IntegracionBackFront.backfront.Entities.Users.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TIPOUSUARIO")
@EqualsAndHashCode @Getter @Setter
public class UserTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_TipoUsuario")
    @SequenceGenerator(name = "seq_TipoUsuario", sequenceName = "seq_TipoUsuario", allocationSize = 1)
    @Column(name = "IDTIPOUSUARIO")
    private Long idTipoUsuario;

    @Column(name = "NOMBRETIPO")
    private String nombreTipo;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @OneToMany(mappedBy = "tipoUsuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserEntity> usuarios = new ArrayList<>();

    @Override
    public String toString() {
        return "UserTypeEntity{" +
                "idTipoUsuario=" + idTipoUsuario +
                ", nombreTipo='" + nombreTipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
