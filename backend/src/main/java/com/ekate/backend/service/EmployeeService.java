package com.ekate.backend.service;
import com.ekate.backend.entity.Employee;
import com.ekate.backend.entity.request.AuthRequest;
import com.ekate.backend.repository.UserRepositoryInterface;
import com.ekate.backend.security.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Slf4j
@Service
public class EmployeeService {
    private final UserRepositoryInterface userRepository;
    private final byte[] salt = new byte[16];
    private final JwtUtil jwt;

    public EmployeeService(UserRepositoryInterface userRepository, JwtUtil jwt) {
        this.userRepository = userRepository;
        this.jwt = jwt;
    }

    public String loginUser(AuthRequest authRequest){
        Employee employee = userRepository.GetEmployeeByEmail(authRequest);
        if(employee != null) {
            boolean isPasswordCorrect = comparePassword(authRequest.getPassword(), employee.getPassword());
            if (isPasswordCorrect) {
                return jwt.generateToken(employee.getUuid());
            } else {
                return "";
            }
        }
        return "";
    }

    public String hashPassword(String password) {
        try {
            int iterCount = 65536;
            int keyLength = 128;
            KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterCount, keyLength);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e){
            log.error("Ошибка шифрования",e);
            return  null;
        }
    }

    public boolean comparePassword(String inputPassword , String storedHash){
            String newHash = hashPassword(inputPassword);
            return newHash.equals(storedHash);
    }
}
