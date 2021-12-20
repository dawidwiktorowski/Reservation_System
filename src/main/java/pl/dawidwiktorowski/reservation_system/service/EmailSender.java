package pl.dawidwiktorowski.reservation_system.service;

public interface EmailSender {
    void send (String to, String email);
}