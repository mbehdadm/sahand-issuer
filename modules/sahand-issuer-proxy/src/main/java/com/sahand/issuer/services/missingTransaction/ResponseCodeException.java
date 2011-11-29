
package com.sahand.issuer.services.missingTransaction;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responseCodeException.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="responseCodeException">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LOADOFCARDNOTSUCCESFULL"/>
 *     &lt;enumeration value="CARDISNOTVALID"/>
 *     &lt;enumeration value="PINISNOTVALID"/>
 *     &lt;enumeration value="MEMBERISNOTACTIVE"/>
 *     &lt;enumeration value="AUTHENTICATEISFAILED"/>
 *     &lt;enumeration value="AUTHORIZEISFAILED"/>
 *     &lt;enumeration value="CARDHASNOTSUFFICCIENTFUNDS"/>
 *     &lt;enumeration value="CANNOTDECREASEOTB"/>
 *     &lt;enumeration value="UNKNOWNEXCEPTIONOCCURRED"/>
 *     &lt;enumeration value="CARDWITHPINNOTFOUND"/>
 *     &lt;enumeration value="STATUSOFCARDISNOTOK"/>
 *     &lt;enumeration value="PROGRAMNOTFOUND"/>
 *     &lt;enumeration value="PROGRAMISNOTVALID"/>
 *     &lt;enumeration value="ServiceCodeIsNotAllowsTxn"/>
 *     &lt;enumeration value="AUTHORIZETXNISFALSE"/>
 *     &lt;enumeration value="IsoMessageIsNull"/>
 *     &lt;enumeration value="CANNOTCREATEGENERALRESPONSE"/>
 *     &lt;enumeration value="ISNOTCREDITORGPARTNEROFPROGRAM"/>
 *     &lt;enumeration value="CARDTYPENOTPARTICIPATEINPROGRAM"/>
 *     &lt;enumeration value="CANNOTGETPARAMETERS"/>
 *     &lt;enumeration value="CardAcceptorWithThisCATerminalIdIsNotExist"/>
 *     &lt;enumeration value="CardAcceptorIdCanNotBeNull"/>
 *     &lt;enumeration value="ClassNotFound"/>
 *     &lt;enumeration value="canNotModifyMemberCard"/>
 *     &lt;enumeration value="ProgramIdIsNull"/>
 *     &lt;enumeration value="CANNOTINSERTAUTHORIZERTRANSACTIONRESPONSE"/>
 *     &lt;enumeration value="canNotReversalTransaction"/>
 *     &lt;enumeration value="SAVEOFTRANSACTIONRESPONSEISFAILED"/>
 *     &lt;enumeration value="CardProgramAccountNotFound"/>
 *     &lt;enumeration value="canNotModifyMemberCardProgramAccount"/>
 *     &lt;enumeration value="canNotSaveNewMemberCardProgramAccount"/>
 *     &lt;enumeration value="canNotDeactiveCard"/>
 *     &lt;enumeration value="ProgramRefrenceDataIsNull"/>
 *     &lt;enumeration value="FactorNumberIsNull"/>
 *     &lt;enumeration value="FactorNumberIsNotUnique"/>
 *     &lt;enumeration value="PointOfFactorIsNull"/>
 *     &lt;enumeration value="VoucherNumberIsNull"/>
 *     &lt;enumeration value="PanIsNull"/>
 *     &lt;enumeration value="MessageIsNull"/>
 *     &lt;enumeration value="CardAcceptorIdIsNull"/>
 *     &lt;enumeration value="AmountTransactionIsNull"/>
 *     &lt;enumeration value="DateTransactionIsNull"/>
 *     &lt;enumeration value="TerminalIdIsNull"/>
 *     &lt;enumeration value="yourPresentDedicated"/>
 *     &lt;enumeration value="youNotAllowedToGetPresent"/>
 *     &lt;enumeration value="plaqueNumberIsNull"/>
 *     &lt;enumeration value="PinChargeIsNull"/>
 *     &lt;enumeration value="minOfPointIsNull"/>
 *     &lt;enumeration value="authorizerTypeIsNull"/>
 *     &lt;enumeration value="thisCardHasNoTransaction"/>
 *     &lt;enumeration value="CardNotMatchWithPlaque"/>
 *     &lt;enumeration value="thisCardIsCapture"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "responseCodeException")
@XmlEnum
public enum ResponseCodeException {

    LOADOFCARDNOTSUCCESFULL("LOADOFCARDNOTSUCCESFULL"),
    CARDISNOTVALID("CARDISNOTVALID"),
    PINISNOTVALID("PINISNOTVALID"),
    MEMBERISNOTACTIVE("MEMBERISNOTACTIVE"),
    AUTHENTICATEISFAILED("AUTHENTICATEISFAILED"),
    AUTHORIZEISFAILED("AUTHORIZEISFAILED"),
    CARDHASNOTSUFFICCIENTFUNDS("CARDHASNOTSUFFICCIENTFUNDS"),
    CANNOTDECREASEOTB("CANNOTDECREASEOTB"),
    UNKNOWNEXCEPTIONOCCURRED("UNKNOWNEXCEPTIONOCCURRED"),
    CARDWITHPINNOTFOUND("CARDWITHPINNOTFOUND"),
    STATUSOFCARDISNOTOK("STATUSOFCARDISNOTOK"),
    PROGRAMNOTFOUND("PROGRAMNOTFOUND"),
    PROGRAMISNOTVALID("PROGRAMISNOTVALID"),
    @XmlEnumValue("ServiceCodeIsNotAllowsTxn")
    SERVICE_CODE_IS_NOT_ALLOWS_TXN("ServiceCodeIsNotAllowsTxn"),
    AUTHORIZETXNISFALSE("AUTHORIZETXNISFALSE"),
    @XmlEnumValue("IsoMessageIsNull")
    ISO_MESSAGE_IS_NULL("IsoMessageIsNull"),
    CANNOTCREATEGENERALRESPONSE("CANNOTCREATEGENERALRESPONSE"),
    ISNOTCREDITORGPARTNEROFPROGRAM("ISNOTCREDITORGPARTNEROFPROGRAM"),
    CARDTYPENOTPARTICIPATEINPROGRAM("CARDTYPENOTPARTICIPATEINPROGRAM"),
    CANNOTGETPARAMETERS("CANNOTGETPARAMETERS"),
    @XmlEnumValue("CardAcceptorWithThisCATerminalIdIsNotExist")
    CARD_ACCEPTOR_WITH_THIS_CA_TERMINAL_ID_IS_NOT_EXIST("CardAcceptorWithThisCATerminalIdIsNotExist"),
    @XmlEnumValue("CardAcceptorIdCanNotBeNull")
    CARD_ACCEPTOR_ID_CAN_NOT_BE_NULL("CardAcceptorIdCanNotBeNull"),
    @XmlEnumValue("ClassNotFound")
    CLASS_NOT_FOUND("ClassNotFound"),
    @XmlEnumValue("canNotModifyMemberCard")
    CAN_NOT_MODIFY_MEMBER_CARD("canNotModifyMemberCard"),
    @XmlEnumValue("ProgramIdIsNull")
    PROGRAM_ID_IS_NULL("ProgramIdIsNull"),
    CANNOTINSERTAUTHORIZERTRANSACTIONRESPONSE("CANNOTINSERTAUTHORIZERTRANSACTIONRESPONSE"),
    @XmlEnumValue("canNotReversalTransaction")
    CAN_NOT_REVERSAL_TRANSACTION("canNotReversalTransaction"),
    SAVEOFTRANSACTIONRESPONSEISFAILED("SAVEOFTRANSACTIONRESPONSEISFAILED"),
    @XmlEnumValue("CardProgramAccountNotFound")
    CARD_PROGRAM_ACCOUNT_NOT_FOUND("CardProgramAccountNotFound"),
    @XmlEnumValue("canNotModifyMemberCardProgramAccount")
    CAN_NOT_MODIFY_MEMBER_CARD_PROGRAM_ACCOUNT("canNotModifyMemberCardProgramAccount"),
    @XmlEnumValue("canNotSaveNewMemberCardProgramAccount")
    CAN_NOT_SAVE_NEW_MEMBER_CARD_PROGRAM_ACCOUNT("canNotSaveNewMemberCardProgramAccount"),
    @XmlEnumValue("canNotDeactiveCard")
    CAN_NOT_DEACTIVE_CARD("canNotDeactiveCard"),
    @XmlEnumValue("ProgramRefrenceDataIsNull")
    PROGRAM_REFRENCE_DATA_IS_NULL("ProgramRefrenceDataIsNull"),
    @XmlEnumValue("FactorNumberIsNull")
    FACTOR_NUMBER_IS_NULL("FactorNumberIsNull"),
    @XmlEnumValue("FactorNumberIsNotUnique")
    FACTOR_NUMBER_IS_NOT_UNIQUE("FactorNumberIsNotUnique"),
    @XmlEnumValue("PointOfFactorIsNull")
    POINT_OF_FACTOR_IS_NULL("PointOfFactorIsNull"),
    @XmlEnumValue("VoucherNumberIsNull")
    VOUCHER_NUMBER_IS_NULL("VoucherNumberIsNull"),
    @XmlEnumValue("PanIsNull")
    PAN_IS_NULL("PanIsNull"),
    @XmlEnumValue("MessageIsNull")
    MESSAGE_IS_NULL("MessageIsNull"),
    @XmlEnumValue("CardAcceptorIdIsNull")
    CARD_ACCEPTOR_ID_IS_NULL("CardAcceptorIdIsNull"),
    @XmlEnumValue("AmountTransactionIsNull")
    AMOUNT_TRANSACTION_IS_NULL("AmountTransactionIsNull"),
    @XmlEnumValue("DateTransactionIsNull")
    DATE_TRANSACTION_IS_NULL("DateTransactionIsNull"),
    @XmlEnumValue("TerminalIdIsNull")
    TERMINAL_ID_IS_NULL("TerminalIdIsNull"),
    @XmlEnumValue("yourPresentDedicated")
    YOUR_PRESENT_DEDICATED("yourPresentDedicated"),
    @XmlEnumValue("youNotAllowedToGetPresent")
    YOU_NOT_ALLOWED_TO_GET_PRESENT("youNotAllowedToGetPresent"),
    @XmlEnumValue("plaqueNumberIsNull")
    PLAQUE_NUMBER_IS_NULL("plaqueNumberIsNull"),
    @XmlEnumValue("PinChargeIsNull")
    PIN_CHARGE_IS_NULL("PinChargeIsNull"),
    @XmlEnumValue("minOfPointIsNull")
    MIN_OF_POINT_IS_NULL("minOfPointIsNull"),
    @XmlEnumValue("authorizerTypeIsNull")
    AUTHORIZER_TYPE_IS_NULL("authorizerTypeIsNull"),
    @XmlEnumValue("thisCardHasNoTransaction")
    THIS_CARD_HAS_NO_TRANSACTION("thisCardHasNoTransaction"),
    @XmlEnumValue("CardNotMatchWithPlaque")
    CARD_NOT_MATCH_WITH_PLAQUE("CardNotMatchWithPlaque"),
    @XmlEnumValue("thisCardIsCapture")
    THIS_CARD_IS_CAPTURE("thisCardIsCapture");
    private final String value;

    ResponseCodeException(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResponseCodeException fromValue(String v) {
        for (ResponseCodeException c: ResponseCodeException.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
