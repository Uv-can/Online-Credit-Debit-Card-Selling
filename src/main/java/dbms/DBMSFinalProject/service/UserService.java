package dbms.DBMSFinalProject.service;

import dbms.DBMSFinalProject.helper.BankSystemConstants;
import dbms.DBMSFinalProject.helper.PasswordAuthenticator;
import dbms.DBMSFinalProject.model.User;
import dbms.DBMSFinalProject.repository.BankRepository;
import dbms.DBMSFinalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public int doLogin(User user) throws Exception {
        String storedPassword = userRepo.findStoredPassword(user.getEmail());
        if (!StringUtils.isEmpty(storedPassword) && PasswordAuthenticator.check(user.getPassword(), storedPassword)) {
            return BankSystemConstants.success;
        } else {
            return BankSystemConstants.failure;
        }
    }

    public String getUserType(User user) throws Exception {
        return userRepo.findUserType(user.getEmail());
    }

    public String getUserName(User user) throws Exception {
        return userRepo.findUserName(user.getEmail());
    }

    public int resetPassword(User user) throws Exception {
        String user_Password = PasswordAuthenticator.getSaltedHash(user.getPassword());
        Long userId = userRepo.getUserIdWithResetToken(user.getPassword_Reset_Token());
        userRepo.updateUserPasswordByID(user_Password, userId);
        return BankSystemConstants.success;
    }

    public int userExists(String email) {
        return userRepo.findCountByEmailId(email);
    }

    public void updatePasswordResetToken(User user) {
        userRepo.updatePasswordResetToken(user.getPassword_Reset_Token(), user.getEmail());
    }

    public int resetPasswordTokenExists(String token) {
        return userRepo.findResetPasswordToken(token);
    }

}
