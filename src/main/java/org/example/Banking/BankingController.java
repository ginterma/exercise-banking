package org.example.Banking;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "Banking")
public class BankingController {

    private final BankingService bankingService;


    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @GetMapping
    public int Show() {
        return 4;
    }

    @PostMapping
    public void addBankAccount(@RequestBody BankAccount bankAccount) {
        bankingService.addNewBankAccount(bankAccount);
    }

    @DeleteMapping(path = "{bankingId}")
    public void deleteBankAccount(@PathVariable("bankingId") Long id) {
        bankingService.deleteAccount(id);
    }

    @PutMapping(path = "{bankingId}/name")
    public void updateName(@PathVariable("bankingId") Long id,
                           @RequestParam(required = false) String name) {
        bankingService.updateName(id, name);

    }

    @PutMapping(path = "{bankingId}/balance")
    public void updateBalance(@PathVariable("bankingId") Long id,
                           @RequestParam(required = true) String action,
                           @RequestParam(required = true) Double amount)
    {
        bankingService.updateBalance(id, amount, action);

    }

}
