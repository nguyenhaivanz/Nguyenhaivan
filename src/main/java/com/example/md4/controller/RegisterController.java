package com.example.md4.controller;


import com.example.md4.model.Account;
import com.example.md4.model.Role;
import com.example.md4.repository.IAccountRepository;
import com.example.md4.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/registers")
public class RegisterController {
    @Autowired
    IAccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<Account> register(@RequestBody Account account) {
        Set<Role> role = new HashSet<>();
        Role role1 = new Role();
        role1.setId(1);
        role1.setName("PLAYER");
        role.add(role1);
        account.setRoles(role);
        accountRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
//    @GetMapping("/checkGmail")
//    public  ResponseEntity<Account> checks(@RequestParam String gmail){
//        Optional<Account> account = accountService.findByGmail(gmail);
//        if(account == null){
//            return new ResponseEntity<>(account, HttpStatus.OK);
//        }else{
//            return  new ResponseEntity<>(account, HttpStatus.OK);
//        }
//    }
//
//    @GetMapping("/check")
//    public ResponseEntity<Account> check(@RequestParam String password, String gmail){
//        Account account = accountService.findAccountByGmailAndPassword(password,gmail);
//        if(account == null){
//            return new ResponseEntity<>(account, HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(account, HttpStatus.OK);
//        }
//    }