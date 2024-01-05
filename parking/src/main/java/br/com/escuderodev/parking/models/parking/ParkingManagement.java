package br.com.escuderodev.parking.models.parking;

import br.com.escuderodev.parking.models.vehicle.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity(name = "ParkingManagement")
@Table(name = "parking_management")
@Getter
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParkingManagement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private String paymentMethod;
    private BigDecimal fixedParkingPrice = new BigDecimal(10.00);
    private BigDecimal variableParkingPrice = new BigDecimal(15.00);
    private LocalDateTime startParking;
    private LocalDateTime stopParking;
    private Integer usageTime;
    private Integer fixedTime;
    private BigDecimal amountToPay;
    @ManyToOne
    private Vehicle vehicle;

    public ParkingManagement(Vehicle vehicle, ParkingRegistrationData data) {
        this.vehicle = vehicle;
        this.fixedTime = data.fixedTime();
        this.paymentMethod = data.paymentMethod();
        startParking();
    }

    public ParkingManagement() {

    }

    //    metodos auxiliares
    public void startParking() {
        if (this.fixedTime != null) {
            this.amountToPay = this.fixedParkingPrice.multiply(BigDecimal.valueOf(this.fixedTime));
            this.startParking = LocalDateTime.now();
            this.stopParking = LocalDateTime.now().plusHours(this.fixedTime);
        } else {
            this.startParking = LocalDateTime.now();
        }
    }

    public void calculatesUsageTime() {
        if (this.startParking != null) {
            this.stopParking = LocalDateTime.now();
            Duration parkedTime = Duration.between(startParking,stopParking);
            this.usageTime = Math.toIntExact(parkedTime.toHours());
            this.amountToPay = this.variableParkingPrice.multiply(BigDecimal.valueOf(usageTime));

            System.out.println("Inicio registrado às: " + startParking);
            System.out.println("Saida registrada em " + stopParking);
            System.out.println("Tempo estacionado: " + parkedTime);
            System.out.println("Tempo total estacionado: " + usageTime + " horas.");
        } else {
            System.out.println("Erro: registro de entrada não encontrado!");

        }
    }
}
