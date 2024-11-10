package org.example.userauth.repositories;

import org.example.userauth.models.OTP;
import org.example.userauth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<OTP, Long> {
    Optional<OTP> findByEmailAndOtpValue(String email, String otpValue);

}
