package br.com.fiap.eventomvc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"nome", "estado"})

@Entity
@Table(name = "tb_cidade")
public class Cidade {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    @Size(min = 3, message = "Nome da cidade com o mínimo de 3 caracteres")
    private String nome;

    @NotBlank(message = "Campo obrigatório")
    @Size(min = 2, message = "Coloque a sigla do estado ou seu nome")
    private String estado;

    @OneToMany(mappedBy = "cidade")
    private List<Evento> eventos = new ArrayList<>();

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
