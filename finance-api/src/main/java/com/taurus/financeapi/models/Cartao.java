package com.taurus.financeapi.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "card")
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "card_number")
    private int cardNumber;
    @Column
    private String name;
    @Column(name = "expiration_date")
    private Date expirationDate;
    @Column
    private int CVV;

//    @OneToOne(mappedBy = "card")
//    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

}
