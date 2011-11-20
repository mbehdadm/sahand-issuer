package com.sahand.issuer.enumeration;


public enum CardStatus {
	OK(1), INACTIVE(2), HOT(3), CAPTURE(5), WARMED(6), EXPIRED(7), CLOSED(8);

	private int value;

	CardStatus(int value) {
		this.value = value;
	}

	public int toValue() {
		return value;
	}

	public static CardStatus fromValue(byte values) {
		for (CardStatus value : values()) {
			if (value.value == values)
				return value;
		}
		return null;
	}
}
