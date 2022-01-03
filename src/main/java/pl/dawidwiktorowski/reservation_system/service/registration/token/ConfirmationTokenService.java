package pl.dawidwiktorowski.reservation_system.service.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dawidwiktorowski.reservation_system.model.ConfirmationToken;
import pl.dawidwiktorowski.reservation_system.repository.ConfirmTokenRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmTokenRepository confirmTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confirmTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}