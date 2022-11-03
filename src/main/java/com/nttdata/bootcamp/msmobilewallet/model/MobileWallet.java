package com.nttdata.bootcamp.msmobilewallet.model;

import com.nttdata.bootcamp.msmobilewallet.dto.DebitCardDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MobileWallet")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MobileWallet {

    @Id
    private String idMobileWallet;

    private Client client;

    private DebitCardDto debitCard;

    private Double balance;
}
