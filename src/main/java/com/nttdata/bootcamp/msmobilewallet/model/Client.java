package com.nttdata.bootcamp.msmobilewallet.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Client {

    @Id
    private String idClient;
    private String clientType;
    private String documentType;
    private String documentNumber;
    private String cellphone;
    private String imei_cellphone;
    private String email;

}
