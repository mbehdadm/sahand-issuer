package com.sahand.issuer.enumeration;

public enum TLV {
	
	  //Web Terminal Porogram
		cardHolderFullName(70),
		cardHolderBirthDay(71),
		cardHolderBirthCity(72),
		cardHolderCellPhoneNumber(73),
		cardHolderEMailAddress(74),
		cardHolderClubNumber(75),
		
	    	//GuarantyProgram
	    	GuarantyBeginDate(11),
	    	GuarantyLife(12),
	    	GuarantySerialNo(13),
	    	GuarantyEndDate(14),
	    	
	    	VendorPoint(10),
	    	CustomerType(15),
	    	CustomerPoint(16),
	    	
	    	GuaranteeType(17),
	    	RedeemPoint(18),
	    	
	    	cardTransactionFlag(19),
	    	
	    	// extra information in installment program
	    	LateFee(20),
	    	balanceInquiryType(21),
	    	nationalId(22),
	    	
	    	cardNum(23),
	    	termNum(24),
	    	voucherNumber(25),
	    	
	    	goldenCardNum(26),
	    	
	    	marketRation(27),
	    	investorRation(28),
	    	cardDiscount(29),
	    	
	    	theRevolvingAmountPerCard(73),
		 //mandatory in cocalcola
		VoucherNumber(80),

		 //mandatory in pazar
		IntroducerCardNumber(81),
		
		//mandatory in cocalcola
		FactorNumber(82),  
		
		//mandatory in cocalcola
		PointOfFactor(83), 
		
		//optional in cocalcola
		NumberOfBox(84),
		
		//pointingDiscountingProgram
		GiftType(85),
		
		//pointingDiscountingProgram
		GiftQuantity(86),
		
		//RentProgram
		Plaque(89),
		PinCharge(90),
		AuthorizerType(91),
		GoodCode(92),
		
		//InstalmentCardProgram
		IntervalBetweenInstalment(93),
		FirstDateOfPayment(94),
		NumOfInstalment(95),
		AmountOfInstalment(96),
		Prepayment(97),
		
		//DiscountingShanliCard
		mobileNumber(98),
		
		whoPanGetPeresent(99)
		;
		
		private int  value;
		
		public int toValue(){
			return value;
		}
		
		TLV (int v){
		this.value = v;
	}
		
	public static TLV fromValue(int v) {

		for (TLV tlv : values()) {
			if (tlv.value == v)
				return tlv;
		}
		return null;
	}

}
