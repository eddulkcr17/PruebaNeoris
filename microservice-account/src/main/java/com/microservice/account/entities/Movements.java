package com.microservice.account.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Builder
@Table(name="movimientos")
@AllArgsConstructor
@NoArgsConstructor
public class Movements {

    @Id
    @Column(name = "movimiento_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movementId;

    @Column(name = "fecha")
    private Date movementDate;

    @Column(name = "tipo_movimiento")
    private String movementType;

    @Column(name = "valor")
    private Long movementValue;

    @Column(name = "saldo")
    private Long movementBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuenta_id")
    private Account cuenta;
}
