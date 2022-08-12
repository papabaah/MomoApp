package com.momo.model;

import java.sql.Timestamp;
import java.util.Date;

public class MomoTransaction {
  private Long id;
  private String cusNumber;
  private TransactionType transType;
  private Double amount;
  private Double percentProfit;
  private Double totalAmount;
  private Timestamp transactionDate;
  private Integer userId;

  public MomoTransaction(){}

  public MomoTransaction(String cusNumber, TransactionType transType, Double amount) {
    this.cusNumber = cusNumber;
    this.transType = transType;
    this.amount = amount;
    this.transactionDate = new Timestamp(new Date().getTime());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCusNumber() {
    return cusNumber;
  }

  public void setCusNumber(String cusNumber) {
    this.cusNumber = cusNumber;
  }

  public TransactionType getTransType() {
    return transType;
  }

  public void setTransType(TransactionType transType) {
    this.transType = transType;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Double getPercentProfit() {
    return percentProfit;
  }

  public void setPercentProfit(Double percentProfit) {
    this.percentProfit = percentProfit;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Timestamp getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Timestamp transactionDate) {
    this.transactionDate = transactionDate;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "MomoTransaction{" +
        "id=" + id +
        ", cusNumber='" + cusNumber + '\'' +
        ", transType=" + transType +
        ", amount=" + amount +
        ", percentProfit=" + percentProfit +
        ", totalAmount=" + totalAmount +
        ", transactionDate=" + transactionDate +
        ", userId=" + userId +
        '}';
  }
}
