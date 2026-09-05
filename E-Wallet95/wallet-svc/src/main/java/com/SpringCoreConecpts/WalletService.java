package com.SpringCoreConecpts;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${wallet.balance}")
    private Long balance;

    @KafkaListener(topics = "user-created95",groupId = "walletConsumerGroup")
    public void createWallet(String message) {

        JSONObject jsonObject = (JSONObject) JSONValue.parse(message);

        Long user_id = (Long) jsonObject.get("id");

        Wallet wallet = this.walletRepository.findByUserId(user_id);

        if (wallet != null) {
            log.info("Wallet already exists");
            return;
        }

        wallet = Wallet.builder()
                .userId(user_id)
                .walletStatus(WalletStatus.ACTIVE)
                .id(UUID.randomUUID().toString())
                .balance(this.balance)
                .build();

        this.walletRepository.save(wallet);

        log.info("Wallet created with id {}", wallet.getId());

        log.info("user data accepted {}", jsonObject.toString());

    }

    @KafkaListener(topics = "txn-initiated",groupId = "walletConsumerGroup")
    public void getTxn(String message) {

        JSONObject jsonObject = (JSONObject) JSONValue.parse(message);

        Long sender = (Long) jsonObject.get("sender");
        Long receiver = (Long) jsonObject.get("receiver");
        Long amount = (Long) jsonObject.get("amount");

        String txnId = (String) jsonObject.get("txnId");

        Wallet senderWallet = this.walletRepository.findByUserId(sender);
        Wallet receiverWallet = this.walletRepository.findByUserId(receiver);

        log.info("got txn - {}",jsonObject.toString());

        if(senderWallet == null || receiverWallet == null || senderWallet.getBalance() < amount || amount<0) {
            JSONObject event = new JSONObject();
            event.put("status","FAILED");
            event.put("sender",sender);
            event.put("receiver",receiver);
            event.put("amount",amount);
            event.put("txnId",txnId);

            this.kafkaTemplate.send("txn-updated",event.toString());
            return;
        }

        senderWallet.setBalance(senderWallet.getBalance()-amount);
        receiverWallet.setBalance(receiverWallet.getBalance()+amount);

        this.walletRepository.saveAll(List.of(senderWallet,receiverWallet));

        JSONObject event = new JSONObject();
        event.put("status","SUCCESS");
        event.put("sender",sender);
        event.put("receiver",receiver);
        event.put("amount",amount);
        event.put("txnId",txnId);

        this.kafkaTemplate.send("txn-updated",event.toString());
    }
}
