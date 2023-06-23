package br.com.fiap.postech.fastfood.adapters.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes", uniqueConstraints = @UniqueConstraint(columnNames = "cpf"))
public class ClienteEntity {

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
