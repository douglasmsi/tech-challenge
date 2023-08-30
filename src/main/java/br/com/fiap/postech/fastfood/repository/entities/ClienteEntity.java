package br.com.fiap.postech.fastfood.repository.entities;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes", uniqueConstraints = @UniqueConstraint(columnNames = "cpf"))
public class ClienteEntity implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column
        private String cpf;

        @Column
        private String nome;

        @Column
        private String telefone;

        @Column
        private String endereco;

        @Column
        private String email;

        @OneToMany(mappedBy = "cliente")
        List<PedidoEntity> pedidos;

        @OneToMany(mappedBy = "cliente")
        private List<MetodoPagamentoEntity> metodosPagamento;

        @Override
        public String toString() {
                return "ClienteEntity{" +
                    "id=" + id +
                    ", cpf='" + cpf + '\'' +
                    ", nome='" + nome + '\'' +
                    ", telefone='" + telefone + '\'' +
                    ", endereco='" + endereco + '\'' +
                    ", email='" + email + '\'' +
                    ", pedidos=" + (pedidos != null ? pedidos.size() : null) + // Evita a recursão infinita
                    '}';
        }

}
