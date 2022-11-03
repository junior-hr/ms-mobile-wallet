package com.nttdata.bootcamp.msmobilewallet.model;

import java.util.List;

import com.nttdata.bootcamp.msmobilewallet.dto.DebitCardDto;
import lombok.Builder;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotEmpty;

@Document(collection = "BankAccount")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BankAccount {

    @Id
    private String idBankAccount;

    private Client client;

    @NotEmpty(message = "no debe estar vacío")
    private String accountType;

    // private String cardNumber;
    private DebitCardDto debitCard;

    @NotEmpty(message = "no debe estar vacío")
    private String accountNumber;

    private Double commission;

    private Integer movementDate;

    private Integer maximumMovement;

    private List<Headline> listHeadline;

    private List<Headline> listAuthorizedSignatories;

    private Double startingAmount;

    @NotEmpty(message = "no debe estar vacío")
    private String currency;

    private Double minimumAmount;

    private Double transactionLimit;

    private Double commissionTransaction;

    private Double balance;
}
