package com.nttdata.bootcamp.msmobilewallet.dto;

import com.nttdata.bootcamp.msmobilewallet.model.Movement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BalanceSummaryDto {

    private String documentNumber;
    private List<InfoBankAccount> objBankAccountInfo;
    private List<Movement> movements;

}
