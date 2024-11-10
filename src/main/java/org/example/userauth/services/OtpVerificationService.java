package org.example.userauth.services;

import org.example.userauth.models.OTP;
import org.example.userauth.models.Token;
import org.example.userauth.repositories.OtpRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OtpVerificationService {

    private final OtpRepository otpRepository;

    public OtpVerificationService(OtpRepository otpRepository) {
        this.otpRepository = otpRepository;
    }

    public boolean verifyOtp(String email, String otpValue) {
        Optional<OTP> otpEntry = otpRepository.findByEmailAndOtpValue(email, otpValue);

        if (otpEntry.isPresent()) {
            OTP otp = otpEntry.get();
            if (!otp.isVerified() && otp.getExpiryTime().isAfter(LocalDateTime.now())) {
                otp.setVerified(true);
              otpRepository.save(otp);
                return true;
            }
        }
        return false;
    }

}
