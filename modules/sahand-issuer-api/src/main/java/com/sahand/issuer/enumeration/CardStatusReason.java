
package com.sahand.issuer.enumeration;

public enum CardStatusReason
{

	NOTHING(1),
	STOLEN(2),
	LOST(3);

	private int value;

	CardStatusReason(int value)
	{

		this.value = value;
	}

	public int toValue()
	{

		return value;
	}


	public static CardStatusReason fromValue(byte values) {
		for (CardStatusReason value : values()) {
			if (value.value == values)
				return value;
		}
		return null;
	}
}
