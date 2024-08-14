package com.unites.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificadorEmail {

    private final EmailCliente emailCliente;

    @Autowired
    public NotificadorEmail(EmailCliente emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void notificar(String direccion, String mensaje) {
        if (direccion == null || direccion.isEmpty() || !esDireccionValida(direccion)) {
            throw new IllegalArgumentException("Dirección de correo inválida");
        }
        emailCliente.enviarCorreo(direccion, "Notificación");
    }

    private boolean esDireccionValida(String direccion) {
        // Implementa una validación básica de email, o utiliza una librería de validación.
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return direccion.matches(emailRegex);
    }
}
