package com.sahand.issuer.enumeration;


public enum ProcessCode {
	    
	    // /////////////////
	    // /// fields /// //
	    // /////////////////
	    
	    BalanceInquiry(319700, "\u06AF\u0632\u0627\u0631\u0634 \u0645\u0648\u062C\u0648\u062F\u06CC"),
	    BillPayment(500000, ""),
	    DontCare(-1, ""),
	    InitializationRequest(930000, ""),
	    Insurance(500099, ""),
	    LogonRequest(920000, ""),
	    LoyaltyCardIssue_Reissue(200097, "\u0641\u0639\u0627\u0644 \u0633\u0627\u0632\u06CC \u06A9\u0627\u0631\u062A"),
	    LoyaltyIssuePoints(97, "\u062B\u0628\u062A \u0627\u0645\u062A\u06CC\u0627\u0632"),
	    LoyaltyPointsRedemption(9700, "\u0645\u0635\u0631\u0641 \u0627\u0645\u062A\u06CC\u0627\u0632"),
	    Pre_PaidCardInformationRequest(970000, ""),
	    Pre_PaidCardOnlineSale_withCard(590000, ""),
	    SettlementRequestAfterupload(960000, ""), ;
	    
	    private int value;
	    private String faName;
	    
	    // //////////////////////
	    // /// Constructor /// //
	    // //////////////////////
	    
	    ProcessCode(int v, String faName)
	    {

		this.value = v;
		this.faName = faName;
	    }
	    
	    // //////////////////
	    // /// Methods /// //
	    // //////////////////
	    
	    /**
	     * @param value
	     * @return
	     */
	    public static ProcessCode fromValue(int value)
	    {

		if (value == 319700) { return BalanceInquiry; }
		if (value == 500000) { return BillPayment; }
		if (value == -1) { return DontCare; }
		if (value == 930000) { return InitializationRequest; }
		if (value == 500099) { return Insurance; }
		if (value == 920000) { return LogonRequest; }
		if (value == 200097) { return LoyaltyCardIssue_Reissue; }
		if (value == 97) { return LoyaltyIssuePoints; }
		if (value == 9700) { return LoyaltyPointsRedemption; }
		if (value == 970000) { return Pre_PaidCardInformationRequest; }
		if (value == 590000) { return Pre_PaidCardOnlineSale_withCard; }
		if (value == 960000) { return SettlementRequestAfterupload; }
		return null;
	    }
	    
	    /**
	     * @param value
	     * @return
	     */
	    public static ProcessCode fromValue(String value)
	    {

		try
		{
		    Integer transactionTypeInt = Integer.parseInt(value);
		    return ProcessCode.fromValue(transactionTypeInt);
		}
		catch (NumberFormatException e)
		{
		    e.printStackTrace();
		    return null;
		}
	    }
	    
	    public String toValueStr()
	    {

		return String.valueOf(value);
	    }
	    
	    // //////////////////////////////
	    // /// Setters and Getters /// //
	    // //////////////////////////////
	    
	    public String getFaName()
	    {

		return faName;
	    }
	    
	    public int toValue()
	    {

		return value;
	    }
	    
	    // ////////////////////
	    // /// to String /// //
	    // ////////////////////
	    
	    @Override
	    public String toString()
	    {

		return "ProcessCodeEnum [value= " + String.valueOf(this.toValue());
	    }
	
}
