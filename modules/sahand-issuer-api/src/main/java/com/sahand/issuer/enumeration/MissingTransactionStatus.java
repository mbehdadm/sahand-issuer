package com.sahand.issuer.enumeration;

public enum MissingTransactionStatus {

   	register((char)'0'),
	confirmed((char)'1'),
	notConfirmed((char)'2'),
	suspended((char)'3');
	
	private char value;

	public char toValue(){
	    return value;
	}
	
	MissingTransactionStatus(char value){
		this.value = value;
	}
	
	public static MissingTransactionStatus fromValue(char v) {
		for (MissingTransactionStatus status : values()) {
			if (status.value == v)
				return status;
		}
		return null;
	}

}
