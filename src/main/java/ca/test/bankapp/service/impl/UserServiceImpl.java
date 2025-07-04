package ca.test.bankapp.service.impl;

import ca.test.bankapp.dto.UserDTO;
import ca.test.bankapp.dto.UserRegisterDTO;
import ca.test.bankapp.entity.Account;
import ca.test.bankapp.entity.User;
import ca.test.bankapp.mapper.UserMapper;
import ca.test.bankapp.repository.AccountRepository;
import ca.test.bankapp.repository.UserRepository;
import ca.test.bankapp.service.UserService;
import ca.test.bankapp.validation.UserValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SuppressWarnings("FieldCanBeLocal")
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserValidation userValidation;

    public UserServiceImpl(UserRepository userRepository, AccountRepository accountRepository,
                           PasswordEncoder passwordEncoder, UserMapper userMapper, UserValidation userValidation) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userValidation = userValidation;
    }

    @Override
    @Transactional
    public User createUser(UserRegisterDTO userRegisterDTO) {
        //Call validation
        this.userValidation.validRegister(userRegisterDTO);

        //Everything is ok, so register
        User user = this.userMapper.toUserRegisterDTO(userRegisterDTO);
        user.setPassword(this.passwordEncoder.encode(userRegisterDTO.getPassword()));

        Account account = new Account();
        account.setAccountNumber(String.join("B-", "" + System.currentTimeMillis()));
        account.setCurrency(userRegisterDTO.getCurrency());
        account.setBalance(BigDecimal.ZERO);

        //
        this.accountRepository.save(account);

        //
        user.setAccount(account);

        return this.userRepository.save(user);
    }

    @Override
    public String authenticateUser(String email, String password) {
        return null;
    }

    @Override
    public UserDTO getUser(UserDetails userDetails) {
        return null;
    }

}
