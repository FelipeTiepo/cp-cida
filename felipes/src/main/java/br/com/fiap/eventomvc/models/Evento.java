package br.com.fiap.eventomvc.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"nome", "data", "url"})

@Entity
@Table(name = "tb_evento")
public class Evento {

    //Felipe Tiepo - RM 95026
    //Felipe Adriano - RM 93015

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "Nome do evento deve ter no mínimo 3 caracteres")
    private String nome;

    @NotBlank(message = "Campo requeido")
    private String data;

    @NotBlank(message = "Campo requerido")
    private String url;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidade;

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", url='" + url + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}
