package com.examly.springapp.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingid;
    @Column
    private LocalDate checkInDate;
    @Column
    private LocalDate checkOutDate;
    @Column
    private double totalAmount;

    public Booking(){}
    public Booking(LocalDate checkInDate,LocalDate checkOutDate,double totalAmount){
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
        this.totalAmount=totalAmount;
    }

    public LocalDate getcheckInDate(){
        return checkInDate;
    }
    public LocalDate getcheckOutDate(){
        return checkOutDate;
    }
    public double getTotalAmount(){
        return totalAmount;
    }

    public void setBookingId(long bookingid){
        this.bookingid=bookingid;
    }
    public void setcheckInDate(LocalDate checkInDate){
        this.checkInDate=checkInDate;
    }
    public void setcheckOutDate(LocalDate checkOutDate){
        this.checkOutDate=checkOutDate;
    }
    public void setTotalAmount(double totalAmount){
        this.totalAmount=totalAmount;
    }
}
