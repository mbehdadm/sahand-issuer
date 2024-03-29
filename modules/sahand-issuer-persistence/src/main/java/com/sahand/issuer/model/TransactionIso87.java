package com.sahand.issuer.model;


// Generated Apr 23, 2008 10:37:13 AM by Hibernate Tools 3.2.1.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.sahand.lookup.Tx87de22;
//import com.sahand.lookup.Tx87de39;

/**
 * Trnsxn87 generated by hbm2java
 */
@Entity
@Table(name = "TRNSXN87")
public class TransactionIso87 implements java.io.Serializable,Cloneable {

	private TransactionIso87Id id;
	private Transaction trnsxn;
	private byte[] tx87bmp;
	private String tx87de1;
	private String tx87de2;
	private String tx87de3;
	private String tx87de4;
	private String tx87de5;
	private String tx87de6;
	private String tx87de7;
	private String tx87de8;
	private String tx87de9;
	private String tx87de10;
	private String tx87de11;
	private String tx87de12;
	private String tx87de13;
	private String tx87de14;
	private String tx87de15;
	private String tx87de16;
	private String tx87de17;
	private String tx87de18;
	private String tx87de19;
	private String tx87de20;
	private String tx87de21;
	private String tx87de22;
	private String tx87de23;
	private String tx87de24;
	private String tx87de25;
	private String tx87de26;
	private String tx87de27;
	private String tx87de28;
	private String tx87de29;
	private String tx87de30;
	private String tx87de31;
	private String tx87de32;
	private String tx87de33;
	private String tx87de34;
	private String tx87de35;
	private String tx87de36;
	private String tx87de37;
	private String tx87de38;
	private String tx87de39;
	private String tx87de40;
	private String tx87de41;
	private String tx87de42;
	private String tx87de43;
	private String tx87de44;
	private String tx87de45;
	private String tx87de46;
	private String tx87de47;
	private String tx87de48;
	private String tx87de49;
	private String tx87de50;
	private String tx87de51;
	private byte[] tx87de52;
	private String tx87de53;
	private String tx87de54;
	private byte[] tx87de55;
	private String tx87de56;
	private String tx87de57;
	private String tx87de58;
	private String tx87de59;
	private String tx87de60;
	private String tx87de61;
	private String tx87de62;
	private String tx87de63;
	private byte[] tx87de64;
	
//	//Transient
//	private Tx87de22 tx87de22Class;
//	private Tx87de39 tx87de39Class;

	public TransactionIso87() {
	}

	public TransactionIso87(TransactionIso87Id id, Transaction trnsxn) {
		this.id = id;
		this.trnsxn = trnsxn;
	}
	
	

	public TransactionIso87(TransactionIso87Id id, Transaction trnsxn, byte[] tx87bmp,
			String tx87de1, String tx87de2, String tx87de3, String tx87de4,
			String tx87de5, String tx87de6, String tx87de7, String tx87de8,
			String tx87de9, String tx87de10, String tx87de11, String tx87de12,
			String tx87de13, String tx87de14, String tx87de15, String tx87de16,
			String tx87de17, String tx87de18, String tx87de19, String tx87de20,
			String tx87de21, String tx87de22, String tx87de23, String tx87de24,
			String tx87de25, String tx87de26, String tx87de27, String tx87de28,
			String tx87de29, String tx87de30, String tx87de31, String tx87de32,
			String tx87de33, String tx87de34, String tx87de35, String tx87de36,
			String tx87de37, String tx87de38, String tx87de39, String tx87de40,
			String tx87de41, String tx87de42, String tx87de43, String tx87de44,
			String tx87de45, String tx87de46, String tx87de47, String tx87de48,
			String tx87de49, String tx87de50, String tx87de51, byte[] tx87de52,
			String tx87de53, String tx87de54, byte[] tx87de55, String tx87de56,
			String tx87de57, String tx87de58, String tx87de59, String tx87de60,
			String tx87de61, String tx87de62, String tx87de63, byte[] tx87de64) {
		this.id = id;
		this.trnsxn = trnsxn;
		this.tx87bmp = tx87bmp;
		this.tx87de1 = tx87de1;
		this.tx87de2 = tx87de2;
		this.tx87de3 = tx87de3;
		this.tx87de4 = tx87de4;
		this.tx87de5 = tx87de5;
		this.tx87de6 = tx87de6;
		this.tx87de7 = tx87de7;
		this.tx87de8 = tx87de8;
		this.tx87de9 = tx87de9;
		this.tx87de10 = tx87de10;
		this.tx87de11 = tx87de11;
		this.tx87de12 = tx87de12;
		this.tx87de13 = tx87de13;
		this.tx87de14 = tx87de14;
		this.tx87de15 = tx87de15;
		this.tx87de16 = tx87de16;
		this.tx87de17 = tx87de17;
		this.tx87de18 = tx87de18;
		this.tx87de19 = tx87de19;
		this.tx87de20 = tx87de20;
		this.tx87de21 = tx87de21;
		this.setTx87de22(tx87de22);
		this.tx87de23 = tx87de23;
		this.tx87de24 = tx87de24;
		this.tx87de25 = tx87de25;
		this.tx87de26 = tx87de26;
		this.tx87de27 = tx87de27;
		this.tx87de28 = tx87de28;
		this.tx87de29 = tx87de29;
		this.tx87de30 = tx87de30;
		this.tx87de31 = tx87de31;
		this.tx87de32 = tx87de32;
		this.tx87de33 = tx87de33;
		this.tx87de34 = tx87de34;
		this.tx87de35 = tx87de35;
		this.tx87de36 = tx87de36;
		this.tx87de37 = tx87de37;
		this.tx87de38 = tx87de38;
		this.setTx87de39(tx87de39);
		this.tx87de40 = tx87de40;
		this.tx87de41 = tx87de41;
		this.tx87de42 = tx87de42;
		this.tx87de43 = tx87de43;
		this.tx87de44 = tx87de44;
		this.tx87de45 = tx87de45;
		this.tx87de46 = tx87de46;
		this.tx87de47 = tx87de47;
		this.tx87de48 = tx87de48;
		this.tx87de49 = tx87de49;
		this.tx87de50 = tx87de50;
		this.tx87de51 = tx87de51;
		this.tx87de52 = tx87de52;
		this.tx87de53 = tx87de53;
		this.tx87de54 = tx87de54;
		this.tx87de55 = tx87de55;
		this.tx87de56 = tx87de56;
		this.tx87de57 = tx87de57;
		this.tx87de58 = tx87de58;
		this.tx87de59 = tx87de59;
		this.tx87de60 = tx87de60;
		this.tx87de61 = tx87de61;
		this.tx87de62 = tx87de62;
		this.tx87de63 = tx87de63;
		this.tx87de64 = tx87de64;
	}

	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "txunqid", column = @Column(name = "TXUNQID", nullable = false, precision = 6, scale = 0)),
			@AttributeOverride(name = "txreqdt", column = @Column(name = "TXREQDT", nullable = false, length = 7)) })
	public TransactionIso87Id getId() {
		return this.id;
	}

	public void setId(TransactionIso87Id id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns( {
			@JoinColumn(name = "TXUNQID", referencedColumnName = "TXUNQID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "TXREQDT", referencedColumnName = "TXREQDT", nullable = false, insertable = false, updatable = false) })
	public Transaction getTrnsxn() {
		return this.trnsxn;
	}

	public void setTrnsxn(Transaction trnsxn) {
		this.trnsxn = trnsxn;
	}

	@Column(name = "TX87BMP")
	public byte[] getTx87bmp() {
		return this.tx87bmp;
	}

	public void setTx87bmp(byte[] tx87bmp) {
		this.tx87bmp = tx87bmp;
	}

	@Column(name = "TX87DE1", length = 1)
	public String getTx87de1() {
		return this.tx87de1;
	}

	public void setTx87de1(String tx87de1) {
		this.tx87de1 = tx87de1;
	}

	@Column(name = "TX87DE2", length = 19)
	public String getTx87de2() {
		return this.tx87de2;
	}

	public void setTx87de2(String tx87de2) {
		this.tx87de2 = tx87de2;
	}

	@Column(name = "TX87DE3", length = 6)
	public String getTx87de3() {
		return this.tx87de3;
	}

	public void setTx87de3(String tx87de3) {
		this.tx87de3 = tx87de3;
	}

	@Column(name = "TX87DE4", length = 12)
	public String getTx87de4() {
		return this.tx87de4;
	}

	public void setTx87de4(String tx87de4) {
		this.tx87de4 = tx87de4;
	}

	@Column(name = "TX87DE5", length = 1)
	public String getTx87de5() {
		return this.tx87de5;
	}

	public void setTx87de5(String tx87de5) {
		this.tx87de5 = tx87de5;
	}

	@Column(name = "TX87DE6", length = 1)
	public String getTx87de6() {
		return this.tx87de6;
	}

	public void setTx87de6(String tx87de6) {
		this.tx87de6 = tx87de6;
	}

	@Column(name = "TX87DE7", length = 1)
	public String getTx87de7() {
		return this.tx87de7;
	}

	public void setTx87de7(String tx87de7) {
		this.tx87de7 = tx87de7;
	}

	@Column(name = "TX87DE8", length = 1)
	public String getTx87de8() {
		return this.tx87de8;
	}

	public void setTx87de8(String tx87de8) {
		this.tx87de8 = tx87de8;
	}

	@Column(name = "TX87DE9", length = 1)
	public String getTx87de9() {
		return this.tx87de9;
	}

	public void setTx87de9(String tx87de9) {
		this.tx87de9 = tx87de9;
	}

	@Column(name = "TX87DE10", length = 1)
	public String getTx87de10() {
		return this.tx87de10;
	}

	public void setTx87de10(String tx87de10) {
		this.tx87de10 = tx87de10;
	}

	@Column(name = "TX87DE11", length = 6)
	public String getTx87de11() {
		return this.tx87de11;
	}

	public void setTx87de11(String tx87de11) {
		this.tx87de11 = tx87de11;
	}

	@Column(name = "TX87DE12", length = 6)
	public String getTx87de12() {
		return this.tx87de12;
	}

	public void setTx87de12(String tx87de12) {
		this.tx87de12 = tx87de12;
	}

	@Column(name = "TX87DE13", length = 4)
	public String getTx87de13() {
		return this.tx87de13;
	}

	public void setTx87de13(String tx87de13) {
		this.tx87de13 = tx87de13;
	}

	@Column(name = "TX87DE14", length = 4)
	public String getTx87de14() {
		return this.tx87de14;
	}

	public void setTx87de14(String tx87de14) {
		this.tx87de14 = tx87de14;
	}

	@Column(name = "TX87DE15", length = 1)
	public String getTx87de15() {
		return this.tx87de15;
	}

	public void setTx87de15(String tx87de15) {
		this.tx87de15 = tx87de15;
	}

	@Column(name = "TX87DE16", length = 1)
	public String getTx87de16() {
		return this.tx87de16;
	}

	public void setTx87de16(String tx87de16) {
		this.tx87de16 = tx87de16;
	}

	@Column(name = "TX87DE17", length = 1)
	public String getTx87de17() {
		return this.tx87de17;
	}

	public void setTx87de17(String tx87de17) {
		this.tx87de17 = tx87de17;
	}

	@Column(name = "TX87DE18", length = 1)
	public String getTx87de18() {
		return this.tx87de18;
	}

	public void setTx87de18(String tx87de18) {
		this.tx87de18 = tx87de18;
	}

	@Column(name = "TX87DE19", length = 1)
	public String getTx87de19() {
		return this.tx87de19;
	}

	public void setTx87de19(String tx87de19) {
		this.tx87de19 = tx87de19;
	}

	@Column(name = "TX87DE20", length = 1)
	public String getTx87de20() {
		return this.tx87de20;
	}

	public void setTx87de20(String tx87de20) {
		this.tx87de20 = tx87de20;
	}

	@Column(name = "TX87DE21", length = 1)
	public String getTx87de21() {
		return this.tx87de21;
	}

	public void setTx87de21(String tx87de21) {
		this.tx87de21 = tx87de21;
	}

	@Column(name = "TX87DE22", length = 3)
	public String getTx87de22() {
		return this.tx87de22;
	}

	public void setTx87de22(String tx87de22) {
		this.tx87de22 = tx87de22;
	}

	@Column(name = "TX87DE23", length = 1)
	public String getTx87de23() {
		return this.tx87de23;
	}

	public void setTx87de23(String tx87de23) {
		this.tx87de23 = tx87de23;
	}

	@Column(name = "TX87DE24", length = 3)
	public String getTx87de24() {
		return this.tx87de24;
	}

	public void setTx87de24(String tx87de24) {
		this.tx87de24 = tx87de24;
	}

	@Column(name = "TX87DE25", length = 2)
	public String getTx87de25() {
		return this.tx87de25;
	}

	public void setTx87de25(String tx87de25) {
		this.tx87de25 = tx87de25;
	}

	@Column(name = "TX87DE26", length = 1)
	public String getTx87de26() {
		return this.tx87de26;
	}

	public void setTx87de26(String tx87de26) {
		this.tx87de26 = tx87de26;
	}

	@Column(name = "TX87DE27", length = 1)
	public String getTx87de27() {
		return this.tx87de27;
	}

	public void setTx87de27(String tx87de27) {
		this.tx87de27 = tx87de27;
	}

	@Column(name = "TX87DE28", length = 1)
	public String getTx87de28() {
		return this.tx87de28;
	}

	public void setTx87de28(String tx87de28) {
		this.tx87de28 = tx87de28;
	}

	@Column(name = "TX87DE29", length = 1)
	public String getTx87de29() {
		return this.tx87de29;
	}

	public void setTx87de29(String tx87de29) {
		this.tx87de29 = tx87de29;
	}

	@Column(name = "TX87DE30", length = 1)
	public String getTx87de30() {
		return this.tx87de30;
	}

	public void setTx87de30(String tx87de30) {
		this.tx87de30 = tx87de30;
	}

	@Column(name = "TX87DE31", length = 1)
	public String getTx87de31() {
		return this.tx87de31;
	}

	public void setTx87de31(String tx87de31) {
		this.tx87de31 = tx87de31;
	}

	@Column(name = "TX87DE32", length = 1)
	public String getTx87de32() {
		return this.tx87de32;
	}

	public void setTx87de32(String tx87de32) {
		this.tx87de32 = tx87de32;
	}

	@Column(name = "TX87DE33", length = 1)
	public String getTx87de33() {
		return this.tx87de33;
	}

	public void setTx87de33(String tx87de33) {
		this.tx87de33 = tx87de33;
	}

	@Column(name = "TX87DE34", length = 1)
	public String getTx87de34() {
		return this.tx87de34;
	}

	public void setTx87de34(String tx87de34) {
		this.tx87de34 = tx87de34;
	}

	@Column(name = "TX87DE35", length = 37)
	public String getTx87de35() {
		return this.tx87de35;
	}

	public void setTx87de35(String tx87de35) {
		this.tx87de35 = tx87de35;
	}

	@Column(name = "TX87DE36", length = 1)
	public String getTx87de36() {
		return this.tx87de36;
	}

	public void setTx87de36(String tx87de36) {
		this.tx87de36 = tx87de36;
	}

	@Column(name = "TX87DE37", length = 12)
	public String getTx87de37() {
		return this.tx87de37;
	}

	public void setTx87de37(String tx87de37) {
		this.tx87de37 = tx87de37;
	}

	@Column(name = "TX87DE38", length = 6)
	public String getTx87de38() {
		return this.tx87de38;
	}

	public void setTx87de38(String tx87de38) {
		this.tx87de38 = tx87de38;
	}

	@Column(name = "TX87DE39", length = 2)
	public String getTx87de39() {
		return this.tx87de39;
	}

	public void setTx87de39(String tx87de39) {
		this.tx87de39 = tx87de39;
		
	}

	@Column(name = "TX87DE40", length = 1)
	public String getTx87de40() {
		return this.tx87de40;
	}

	public void setTx87de40(String tx87de40) {
		this.tx87de40 = tx87de40;
	}

	@Column(name = "TX87DE41", length = 8)
	public String getTx87de41() {
		return this.tx87de41;
	}

	public void setTx87de41(String tx87de41) {
		this.tx87de41 = tx87de41;
	}

	@Column(name = "TX87DE42", length = 15)
	public String getTx87de42() {
		return this.tx87de42;
	}

	public void setTx87de42(String tx87de42) {
		this.tx87de42 = tx87de42;
	}

	@Column(name = "TX87DE43", length = 40)
	public String getTx87de43() {
		return this.tx87de43;
	}

	public void setTx87de43(String tx87de43) {
		this.tx87de43 = tx87de43;
	}

	@Column(name = "TX87DE44", length = 1)
	public String getTx87de44() {
		return this.tx87de44;
	}

	public void setTx87de44(String tx87de44) {
		this.tx87de44 = tx87de44;
	}

	@Column(name = "TX87DE45", length = 76)
	public String getTx87de45() {
		return this.tx87de45;
	}

	public void setTx87de45(String tx87de45) {
		this.tx87de45 = tx87de45;
	}

	@Column(name = "TX87DE46", length = 1)
	public String getTx87de46() {
		return this.tx87de46;
	}

	public void setTx87de46(String tx87de46) {
		this.tx87de46 = tx87de46;
	}

	@Column(name = "TX87DE47", length = 1)
	public String getTx87de47() {
		return this.tx87de47;
	}

	public void setTx87de47(String tx87de47) {
		this.tx87de47 = tx87de47;
	}

	@Column(name = "TX87DE48", length = 999)
	public String getTx87de48() {
		return this.tx87de48;
	}

	public void setTx87de48(String tx87de48) {
		this.tx87de48 = tx87de48;
	}

	@Column(name = "TX87DE49", length = 1)
	public String getTx87de49() {
		return this.tx87de49;
	}

	public void setTx87de49(String tx87de49) {
		this.tx87de49 = tx87de49;
	}

	@Column(name = "TX87DE50", length = 1)
	public String getTx87de50() {
		return this.tx87de50;
	}

	public void setTx87de50(String tx87de50) {
		this.tx87de50 = tx87de50;
	}

	@Column(name = "TX87DE51", length = 1)
	public String getTx87de51() {
		return this.tx87de51;
	}

	public void setTx87de51(String tx87de51) {
		this.tx87de51 = tx87de51;
	}

	@Column(name = "TX87DE52")
	public byte[] getTx87de52() {
		return this.tx87de52;
	}

	public void setTx87de52(byte[] tx87de52) {
		this.tx87de52 = tx87de52;
	}

	@Column(name = "TX87DE53", length = 16)
	public String getTx87de53() {
		return this.tx87de53;
	}

	public void setTx87de53(String tx87de53) {
		this.tx87de53 = tx87de53;
	}

	@Column(name = "TX87DE54", length = 120)
	public String getTx87de54() {
		return this.tx87de54;
	}

	public void setTx87de54(String tx87de54) {
		this.tx87de54 = tx87de54;
	}

	@Column(name = "TX87DE55")
	public byte[] getTx87de55() {
		return this.tx87de55;
	}

	public void setTx87de55(byte[] tx87de55) {
		this.tx87de55 = tx87de55;
	}

	@Column(name = "TX87DE56", length = 1)
	public String getTx87de56() {
		return this.tx87de56;
	}

	public void setTx87de56(String tx87de56) {
		this.tx87de56 = tx87de56;
	}

	@Column(name = "TX87DE57", length = 1)
	public String getTx87de57() {
		return this.tx87de57;
	}

	public void setTx87de57(String tx87de57) {
		this.tx87de57 = tx87de57;
	}

	@Column(name = "TX87DE58", length = 1)
	public String getTx87de58() {
		return this.tx87de58;
	}

	public void setTx87de58(String tx87de58) {
		this.tx87de58 = tx87de58;
	}

	@Column(name = "TX87DE59", length = 1)
	public String getTx87de59() {
		return this.tx87de59;
	}

	public void setTx87de59(String tx87de59) {
		this.tx87de59 = tx87de59;
	}

	@Column(name = "TX87DE60", length = 999)
	public String getTx87de60() {
		return this.tx87de60;
	}

	public void setTx87de60(String tx87de60) {
		this.tx87de60 = tx87de60;
	}

	@Column(name = "TX87DE61", length = 999)
	public String getTx87de61() {
		return this.tx87de61;
	}

	public void setTx87de61(String tx87de61) {
		this.tx87de61 = tx87de61;
	}

	@Column(name = "TX87DE62", length = 999)
	public String getTx87de62() {
		return this.tx87de62;
	}

	public void setTx87de62(String tx87de62) {
		this.tx87de62 = tx87de62;
	}

	@Column(name = "TX87DE63", length = 999)
	public String getTx87de63() {
		return this.tx87de63;
	}

	public void setTx87de63(String tx87de63) {
		this.tx87de63 = tx87de63;
	}

	@Column(name = "TX87DE64")
	public byte[] getTx87de64() {
		return this.tx87de64;
	}

	public void setTx87de64(byte[] tx87de64) {
		this.tx87de64 = tx87de64;
	}
	
	 public TransactionIso87 clone() throws CloneNotSupportedException
	    {

		TransactionIso87 that;
		that = (TransactionIso87) super.clone();
		return that;
	    }
}
