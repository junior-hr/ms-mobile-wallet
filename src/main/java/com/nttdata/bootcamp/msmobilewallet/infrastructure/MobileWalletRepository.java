package com.nttdata.bootcamp.msmobilewallet.infrastructure;

import com.nttdata.bootcamp.msmobilewallet.dto.BankAccountDto;
import com.nttdata.bootcamp.msmobilewallet.dto.MobileWalletDto;
import com.nttdata.bootcamp.msmobilewallet.model.BankAccount;
import com.nttdata.bootcamp.msmobilewallet.model.MobileWallet;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface MobileWalletRepository extends ReactiveMongoRepository<MobileWallet, String> {
    // Mono<MobileWallet> findByAccountNumber(String accountNumber);

    @Query(value = "{'client.documentNumber' : ?0, accountType: ?1 }")
    Flux<MobileWallet> findByAccountClient(String documentNumber, String accountType);
    @Query(value = "{'client.documentNumber' : ?0, accountNumber: ?1 }")
    Mono<MobileWalletDto> findByAccountAndDocumentNumber(String documentNumber, String accountNumber);
    @Query(value = "{'client.documentNumber' : ?0, 'debitCard.cardNumber' : ?1 }")
    Flux<MobileWallet> findByClientAndCard(String documentNumber, String cardNumber);
    @Query(value = "{'client.documentNumber' : ?0, 'debitCard.cardNumber' : ?1, 'debitCard.isMainAccount' : false }")
    Flux<MobileWallet> findByClientAndCardAndIsNotMainAccount(String documentNumber, String cardNumber);
    @Query(value = "{'debitCard.cardNumber' : ?0, 'debitCard.isMainAccount' : true }")
    Mono<MobileWallet> findByCardNumberAndIsMainAccount(String cardNumber);
    @Query(value = "{'client.documentNumber' : ?0, 'debitCard.isMainAccount' : true }")
    Flux<MobileWallet> findBalanceByDocumentNumber(String documentNumber);

    @Query(value = "{'client.cellphone' : ?0 }")
    Flux<MobileWalletDto> findAllByCellphone(String cellphone);

    @Query(value = "{'client.cellphone' : ?0 }")
    Mono<MobileWalletDto> findByCellphone(String cellphone);
}
