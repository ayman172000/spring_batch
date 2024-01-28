package com.arh.sprin_batch.config;

import com.arh.sprin_batch.model.BankTransaction;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class BankTransactionItemProcessor implements ItemProcessor<BankTransaction,BankTransaction> {

    private SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy-HH:mm");
    @Override
    public BankTransaction process(BankTransaction item) throws Exception {
        item.setTransactionDate(dateFormat.parse(item.getStrTransactionDate()));
        return item;
    }
}
