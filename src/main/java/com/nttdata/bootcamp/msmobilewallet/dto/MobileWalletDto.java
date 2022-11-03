package com.nttdata.bootcamp.msmobilewallet.dto;

import com.nttdata.bootcamp.msmobilewallet.model.BankAccount;
import com.nttdata.bootcamp.msmobilewallet.model.Client;
import com.nttdata.bootcamp.msmobilewallet.model.MobileWallet;
import com.nttdata.bootcamp.msmobilewallet.model.Movement;
import lombok.*;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import reactor.core.publisher.Mono;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Slf4j
public class MobileWalletDto {

    @Id
    private String idMobileWallet;

    private String documentNumber;

    private String cellphone;

    private String imei_cellphone;

    private String email;

    private String cardNumber;

    private Client client;

    private DebitCardDto debitCard;

    private Double balance;

    private BankAccount account;

    private List<Movement> movements;

    public Mono<MobileWallet> MapperToMobileWallet() {
        log.info("ini MapperToMobileWallet-------: ");

        Client client = Client.builder()
                .documentNumber(this.getDocumentNumber())
                .cellphone(this.getCellphone())
                .imei_cellphone(this.getImei_cellphone())
                .email(this.getEmail())
                .build();

        MobileWallet mobileWallet = MobileWallet.builder()
                .idMobileWallet(this.getIdMobileWallet())
                .client(client)
                .debitCard(this.getDebitCard())
                .balance(this.getBalance() == null ? 0 : this.getBalance())
                .build();
        log.info("fn MapperToMobileWallet-------: ");
        return Mono.just(mobileWallet);
    }
}