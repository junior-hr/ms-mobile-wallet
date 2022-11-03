package com.nttdata.bootcamp.msmobilewallet.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InfoBankAccount {

    private String accountType;
    private String accountNumber;
    private Double averageDailyBalance;

}
