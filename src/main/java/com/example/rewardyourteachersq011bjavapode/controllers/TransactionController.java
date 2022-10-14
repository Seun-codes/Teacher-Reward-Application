package com.example.rewardyourteachersq011bjavapode.controllers;

import com.example.rewardyourteachersq011bjavapode.models.Transaction;
import com.example.rewardyourteachersq011bjavapode.response.ApiResponse;
import com.example.rewardyourteachersq011bjavapode.service.TransactionService;
import com.example.rewardyourteachersq011bjavapode.utils.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api")
public class TransactionController {
    private final TransactionService transactionService;
    private final ResponseService<ApiResponse<List<Transaction>>> responseService;

    @GetMapping("/transaction/{id}")
    public ResponseEntity<ApiResponse<List<Transaction>>> getTransactionForAUser(@PathVariable(value="id") Long id){
        return responseService.response(transactionService.findAllTransactionForAUser(id) , OK);
    }

    @GetMapping("/total-amount")
    public ResponseEntity<?> getTotalAmountSentByUser(){
       return  new ResponseEntity<>(transactionService.totalMoneySent() , OK);
    }
}
