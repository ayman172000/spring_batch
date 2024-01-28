package com.arh.sprin_batch.config;

import com.arh.sprin_batch.model.BankTransaction;
import com.arh.sprin_batch.repository.BankTransactionRepository;
import lombok.AllArgsConstructor;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BankTransactionItemWriter implements ItemWriter<BankTransaction> {
    private BankTransactionRepository bankTransactionRepository;

    @Override
    public void write(List<? extends BankTransaction> list) throws Exception {
        bankTransactionRepository.saveAll(list);
    }
}
