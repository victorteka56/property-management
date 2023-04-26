package com.finalproject.finalproject.controller;

import com.finalproject.finalproject.domain.Accounts;
import com.finalproject.finalproject.domain.Offer;
import com.finalproject.finalproject.domain.Property;
import com.finalproject.finalproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class AccountsController {
    @Autowired
    AccountService accountService;
    @PostMapping()
    public void createAccount(@RequestBody Accounts account, @RequestParam(name = "role", required = false) String role) {
        accountService.createAccount(account, role);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteAccount(@PathVariable("id") Long id) {
        return accountService.deleteAccount(id);
    }
    @PutMapping("/{id}/deactivate")
    @ResponseBody
    public String deactivateAccount(@PathVariable("id") Long id) {
        return accountService.deactivateAccount(id);
    }
    @PutMapping("/{id}/activate")
    @ResponseBody
    public String activateAccount(@PathVariable("id") Long id) {
        return accountService.activateAccount(id);
    }
    @PutMapping("/{id}/resetpassword")
    @ResponseBody
    public String resetPassword(@PathVariable("id") Long id, Accounts a) {
        return accountService.resetPassword(id, a);
    }
    // add owner property
    @PutMapping("/{id}/property")
    public void addOwnerProperty(@PathVariable("id") Long id, @RequestBody Property p) {
        accountService.addOwnerProperty(id,p);
    }
    // offer from customer
    @PutMapping("/{id}/property/{pid}/offer")
    public void addCustomerOffer(@PathVariable("id") Long id, @PathVariable("pid") int pid, @RequestBody Offer o) {
        accountService.addCustomerOffer(id,pid,o);
    }
    @GetMapping("/{id}/property")
    public List<Property> getOwnerProperties(@PathVariable("id") Long id) {
        return accountService.getOwnerProperties(id);
    }

    @GetMapping("/{id}/offers")
    public List<Offer> getOwnerOffers(@PathVariable("id") Long id) {
        return accountService.getOwnerOffers(id);
    }

    @GetMapping("/{id}")
    public Accounts getUser(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping()
    public List<Accounts> findAllUsers() {
        return accountService.getAllUsers();
    }
}
