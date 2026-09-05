package com.SpringCoreConecpts;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.UUID;

@Service
@Slf4j
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;


    public String initiate(Long sender, Long receiver, Long amount, String message) {

        Transaction transaction = Transaction.builder()
                .sender(sender)
                .receiver(receiver)
                .amount(amount)
                .message(message)
                .txnId(UUID.randomUUID().toString())
                .status(TransactionStatus.INITIATED)
                .build();

        this.transactionRepository.save(transaction);

        JSONObject jsonObject = this.objectMapper.convertValue(transaction, JSONObject.class);

        this.kafkaTemplate.send("txn-initiated", jsonObject.toJSONString());

        return transaction.getTxnId();

    }

    @KafkaListener(topics = "txn-updated",groupId = "txnUpdate")
    public void updateTxn(String message){

        JSONObject jsonObject = (JSONObject) JSONValue.parse(message);

        String txnId = jsonObject.get("txnId").toString();
        String status = jsonObject.get("status").toString();

        Transaction txn = this.transactionRepository.findByTxnId(txnId);

        if(txn.getStatus() != TransactionStatus.INITIATED){
            log.info("txn status is already Completed");
            return;
        }

        if(status.equals("FAILED")){
            txn.setStatus(TransactionStatus.FAILED);
        }
        if(status.equals("SUCCESS")){
            txn.setStatus(TransactionStatus.SUCCESS);
        }

        this.transactionRepository.save(txn);


    }
}
