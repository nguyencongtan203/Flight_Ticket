package com.nhom18.flight_ticket.service;

import com.nhom18.flight_ticket.core.Role;
import com.nhom18.flight_ticket.dto.request.AccountCreationRequest;
import com.nhom18.flight_ticket.dto.request.AccountUpdateRequest;
import com.nhom18.flight_ticket.entity.Accounts;
import com.nhom18.flight_ticket.repository.AccountRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<Accounts> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Accounts getByIdAccount(int id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + id));
    }

    @Transactional
    public Accounts addAccount(AccountCreationRequest request) {
        // Kiểm tra email đã tồn tại chưa
        if (accountRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists: " + request.getEmail());
        }

        // Tạo tài khoản mới
        Accounts newAccount = new Accounts();
        newAccount.setEmail(request.getEmail());
        newAccount.setPhone_number(request.getPhone_number());
        newAccount.setPassword_hash(passwordEncoder.encode(request.getPassword_hash())); // Mã hóa mật khẩu
        // newAccount.setRole(request.getRole());
        String roleValue = request.getRole() == null ? "customer" : "admin";
        newAccount.setRole(Role.fromString(roleValue));
        newAccount.setCreated_at(Timestamp.valueOf(LocalDateTime.now()));
        return accountRepository.save(newAccount);
    }

    public Accounts updateInfoAccount(int id, AccountUpdateRequest request) {
        Accounts account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + id));
        if (request != null) {
            if (request.getEmail() != null && !request.getEmail().isBlank()) {
                account.setEmail(request.getEmail());
            }
            if (request.getPhone_number() != null && !request.getPhone_number().isBlank()) {
                account.setPhone_number(request.getPhone_number());
            }
            if (request.getRole() != null) {
                account.setRole(request.getRole());
            }
            return accountRepository.save(account);
        }
        return null;
    }

    public void deleteAccount(int id) {
        Accounts account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + id));
        accountRepository.delete(account);
    }
}
