package br.com.escuderodev.parking.models.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SMSRequest {
    private String to;       // Número de telefone de destino
    private String message;  // Mensagem de texto a ser enviada

    public SMSRequest(String to, String message) {
        this.to = to;
        this.message = message;
    }

    public SMSRequest() {
    }
}