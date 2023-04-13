package com.example.demo;

public class Transaction {
private int creditId;
private int debitId;
private int amount;
/**
 * @return the creditId
 */
public int getCreditId() {
	return creditId;
}
/**
 * @param creditId the creditId to set
 */
public void setCreditId(int creditId) {
	this.creditId = creditId;
}
/**
 * @return the debitId
 */
public int getDebitId() {
	return debitId;
}
/**
 * @param debitId the debitId to set
 */
public void setDebitId(int debitId) {
	this.debitId = debitId;
}
/**
 * @return the amount
 */
public int getAmount() {
	return amount;
}
/**
 * @param amount the amount to set
 */
public void setAmount(int amount) {
	this.amount = amount;
}

}
