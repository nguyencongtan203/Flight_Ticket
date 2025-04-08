package com.nhom18.flight_ticket.controller;

import com.nhom18.flight_ticket.dto.request.AccountCreationRequest;
import com.nhom18.flight_ticket.dto.request.AccountUpdateRequest;
import com.nhom18.flight_ticket.dto.request.ApiResponse;
import com.nhom18.flight_ticket.entity.Accounts;
import com.nhom18.flight_ticket.service.AccountService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/admin/users")
    public ApiResponse<List<Accounts>> getAllAccounts() {
        ApiResponse<List<Accounts>> apiResponse = new ApiResponse<>();
        try {
            List<Accounts> list = accountService.getAllAccounts();
            apiResponse.setResult(list);
            apiResponse.setCode(200);
            apiResponse.setMessage("Get Success");
        } catch (Exception e) {
            apiResponse.setCode(500);
            apiResponse.setMessage("Error retrieving list account: " + e.getMessage());
        }
        return apiResponse;
    }

    @GetMapping("/admin/users/{user_id}")
    public ApiResponse<Accounts> getByIdAccount(@PathVariable("user_id") int id) {
        ApiResponse<Accounts> apiResponse = new ApiResponse<>();
        try {
            Accounts account = accountService.getByIdAccount(id);
            apiResponse.setResult(account);
            apiResponse.setCode(200);
            apiResponse.setMessage("Get Success");
        } catch (Exception e) {
            apiResponse.setCode(500);
            apiResponse.setMessage("Error retrieving account: " + e.getMessage());
        }
        return apiResponse;
    }

    @PostMapping("/user/login")
    public ResponseEntity<ApiResponse<String>> loginAccount(@RequestBody AccountCreationRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        if (accountService.loginAccount(request)) {
            apiResponse.setCode(200);
            apiResponse.setMessage("Login Successful");
            return ResponseEntity.ok(apiResponse);
        } else {
            apiResponse.setCode(401);
            apiResponse.setMessage("Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiResponse);
        }
    }

    @PostMapping("/user/register")
    public ApiResponse<Accounts> registerAccount(@RequestBody AccountCreationRequest request) {
        ApiResponse<Accounts> apiResponse = new ApiResponse<>();
        try {
            Accounts account = accountService.addAccount(request);
            apiResponse.setResult(account);
            apiResponse.setCode(200);
            apiResponse.setMessage("Info account create successfully");
        } catch (Exception e) {
            apiResponse.setCode(500);
            apiResponse.setMessage("Error create account: " + e.getMessage());
        }
        return apiResponse;
    }

    @PutMapping("/admin/users/{user_id}")
    public ApiResponse<Accounts> updateInfoAccount(@PathVariable("user_id") int id,
            @RequestBody AccountUpdateRequest request) {
        ApiResponse<Accounts> apiResponse = new ApiResponse<>();
        try {
            Accounts account = accountService.updateInfoAccount(id, request);
            apiResponse.setResult(account);
            apiResponse.setCode(200);
            apiResponse.setMessage("Info account update successfully");
        } catch (Exception e) {
            apiResponse.setCode(500);
            apiResponse.setMessage("Error updating info account: " + e.getMessage());
        }
        return apiResponse;
    }

    @DeleteMapping("/admin/users/{user_id}")
    public ApiResponse<String> deleteAccount(@PathVariable("user_id") int id) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        try {
            accountService.deleteAccount(id);
            apiResponse.setCode(200);
            apiResponse.setMessage("Delete successfully");
        } catch (Exception e) {
            apiResponse.setCode(500);
            apiResponse.setMessage("Error deleting account: " + e.getMessage());
        }
        return apiResponse;
    }
}
