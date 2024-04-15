package com.api.medfacil.services;

import com.api.medfacil.entities.User;
import com.api.medfacil.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User save(User user){
        //user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public boolean existsNumber(){
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        return userRepository.findByCpf(cpf).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado")
        );
    }

    @Transactional
    public User updatePassword(String cpf, String code) {
        User user = userRepository.findByCpf(cpf).orElseThrow(
                        () -> new UsernameNotFoundException("Usuário não encontrado")
        );
        user.setPassword(passwordEncoder.encode(code));
        return userRepository.save(user);
    }

    @Transactional
    public void cleanPassword(String cpf){
        log.info("Limpar senha do usuário: {}", cpf);
        User user = userRepository.findByCpf(cpf).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado")
        );
        user.setPassword(null);
    }

}
