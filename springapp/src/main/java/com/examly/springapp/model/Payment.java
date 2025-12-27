package com.examly.springapp.model;
import java.time.LocalDate;
import jakarta.persistence.*;
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;
    @Column
    private double amount;
    @Column
    private LocalDate paymentDate;
    @Column
    private String paymentMethod;

    public Payment(){}
    public Payment(double amount,LocalDate paymentDate,String paymentMethod){
        this.amount=amount;
        this.paymentDate=paymentDate;
        this.paymentMethod=paymentMethod;
    }
    public double getAmount(){return amount;}
    public LocalDate getPaymentDate(){return paymentDate;}
    public String getPaymentMethod(){return paymentMethod;}

    public void setPaymentId(long paymentId){
        this.paymentId=paymentId;
    }
    public void setAmount(double amount){
        this.amount=amount;
    }
    public void setPayementDate(LocalDate paymentDate){
        this.paymentDate=paymentDate;
    }
    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod=paymentMethod;
    }
}
