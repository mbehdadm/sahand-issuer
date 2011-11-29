
package com.sahand.issuer.services.missingTransaction;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sahand.cmsWebService.service.MissingTransactionService package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegisterOfflineMissingTransactionResponse_QNAME = new QName("http://service.loyalty.authorizer.sahand.com/", "registerOfflineMissingTransactionResponse");
    private final static QName _ConfirmManualMissingTransactionResponse_QNAME = new QName("http://service.loyalty.authorizer.sahand.com/", "confirmManualMissingTransactionResponse");
    private final static QName _ConfirmManualMissingTransaction_QNAME = new QName("http://service.loyalty.authorizer.sahand.com/", "confirmManualMissingTransaction");
    private final static QName _RegisterOfflineMissingTransaction_QNAME = new QName("http://service.loyalty.authorizer.sahand.com/", "registerOfflineMissingTransaction");
    private final static QName _GetProgramRefrences_QNAME = new QName("http://service.loyalty.authorizer.sahand.com/", "getProgramRefrences");
    private final static QName _RegisterManualMissingTransactionResponse_QNAME = new QName("http://service.loyalty.authorizer.sahand.com/", "registerManualMissingTransactionResponse");
    private final static QName _RegisterManualMissingTransaction_QNAME = new QName("http://service.loyalty.authorizer.sahand.com/", "registerManualMissingTransaction");
    private final static QName _GetProgramRefrencesResponse_QNAME = new QName("http://service.loyalty.authorizer.sahand.com/", "getProgramRefrencesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sahand.cmsWebService.service.MissingTransactionService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfirmManualMissingTransaction }
     * 
     */
    public ConfirmManualMissingTransaction createConfirmManualMissingTransaction() {
        return new ConfirmManualMissingTransaction();
    }

    /**
     * Create an instance of {@link GetProgramRefrencesResponse }
     * 
     */
    public GetProgramRefrencesResponse createGetProgramRefrencesResponse() {
        return new GetProgramRefrencesResponse();
    }

    /**
     * Create an instance of {@link ProgramRefrenceSpecification }
     * 
     */
    public ProgramRefrenceSpecification createProgramRefrenceSpecification() {
        return new ProgramRefrenceSpecification();
    }

    /**
     * Create an instance of {@link ChangePinData }
     * 
     */
    public ChangePinData createChangePinData() {
        return new ChangePinData();
    }

    /**
     * Create an instance of {@link AuthorizerRequest }
     * 
     */
    public AuthorizerRequest createAuthorizerRequest() {
        return new AuthorizerRequest();
    }

    /**
     * Create an instance of {@link RegisterOfflineMissingTransaction }
     * 
     */
    public RegisterOfflineMissingTransaction createRegisterOfflineMissingTransaction() {
        return new RegisterOfflineMissingTransaction();
    }

    /**
     * Create an instance of {@link GetProgramRefrences }
     * 
     */
    public GetProgramRefrences createGetProgramRefrences() {
        return new GetProgramRefrences();
    }

    /**
     * Create an instance of {@link AuthorizerResponse }
     * 
     */
    public AuthorizerResponse createAuthorizerResponse() {
        return new AuthorizerResponse();
    }

    /**
     * Create an instance of {@link RegisterManualMissingTransaction }
     * 
     */
    public RegisterManualMissingTransaction createRegisterManualMissingTransaction() {
        return new RegisterManualMissingTransaction();
    }

    /**
     * Create an instance of {@link TransactionData }
     * 
     */
    public TransactionData createTransactionData() {
        return new TransactionData();
    }

    /**
     * Create an instance of {@link ResponseBase }
     * 
     */
    public ResponseBase createResponseBase() {
        return new ResponseBase();
    }

    /**
     * Create an instance of {@link RegisterOfflineMissingTransactionResponse }
     * 
     */
    public RegisterOfflineMissingTransactionResponse createRegisterOfflineMissingTransactionResponse() {
        return new RegisterOfflineMissingTransactionResponse();
    }

    /**
     * Create an instance of {@link RegisterManualMissingTransactionResponse }
     * 
     */
    public RegisterManualMissingTransactionResponse createRegisterManualMissingTransactionResponse() {
        return new RegisterManualMissingTransactionResponse();
    }

    /**
     * Create an instance of {@link ConfirmManualMissingTransactionResponse }
     * 
     */
    public ConfirmManualMissingTransactionResponse createConfirmManualMissingTransactionResponse() {
        return new ConfirmManualMissingTransactionResponse();
    }

    /**
     * Create an instance of {@link ProgramRefrences }
     * 
     */
    public ProgramRefrences createProgramRefrences() {
        return new ProgramRefrences();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterOfflineMissingTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.loyalty.authorizer.sahand.com/", name = "registerOfflineMissingTransactionResponse")
    public JAXBElement<RegisterOfflineMissingTransactionResponse> createRegisterOfflineMissingTransactionResponse(RegisterOfflineMissingTransactionResponse value) {
        return new JAXBElement<RegisterOfflineMissingTransactionResponse>(_RegisterOfflineMissingTransactionResponse_QNAME, RegisterOfflineMissingTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmManualMissingTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.loyalty.authorizer.sahand.com/", name = "confirmManualMissingTransactionResponse")
    public JAXBElement<ConfirmManualMissingTransactionResponse> createConfirmManualMissingTransactionResponse(ConfirmManualMissingTransactionResponse value) {
        return new JAXBElement<ConfirmManualMissingTransactionResponse>(_ConfirmManualMissingTransactionResponse_QNAME, ConfirmManualMissingTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmManualMissingTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.loyalty.authorizer.sahand.com/", name = "confirmManualMissingTransaction")
    public JAXBElement<ConfirmManualMissingTransaction> createConfirmManualMissingTransaction(ConfirmManualMissingTransaction value) {
        return new JAXBElement<ConfirmManualMissingTransaction>(_ConfirmManualMissingTransaction_QNAME, ConfirmManualMissingTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterOfflineMissingTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.loyalty.authorizer.sahand.com/", name = "registerOfflineMissingTransaction")
    public JAXBElement<RegisterOfflineMissingTransaction> createRegisterOfflineMissingTransaction(RegisterOfflineMissingTransaction value) {
        return new JAXBElement<RegisterOfflineMissingTransaction>(_RegisterOfflineMissingTransaction_QNAME, RegisterOfflineMissingTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProgramRefrences }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.loyalty.authorizer.sahand.com/", name = "getProgramRefrences")
    public JAXBElement<GetProgramRefrences> createGetProgramRefrences(GetProgramRefrences value) {
        return new JAXBElement<GetProgramRefrences>(_GetProgramRefrences_QNAME, GetProgramRefrences.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterManualMissingTransactionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.loyalty.authorizer.sahand.com/", name = "registerManualMissingTransactionResponse")
    public JAXBElement<RegisterManualMissingTransactionResponse> createRegisterManualMissingTransactionResponse(RegisterManualMissingTransactionResponse value) {
        return new JAXBElement<RegisterManualMissingTransactionResponse>(_RegisterManualMissingTransactionResponse_QNAME, RegisterManualMissingTransactionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterManualMissingTransaction }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.loyalty.authorizer.sahand.com/", name = "registerManualMissingTransaction")
    public JAXBElement<RegisterManualMissingTransaction> createRegisterManualMissingTransaction(RegisterManualMissingTransaction value) {
        return new JAXBElement<RegisterManualMissingTransaction>(_RegisterManualMissingTransaction_QNAME, RegisterManualMissingTransaction.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProgramRefrencesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.loyalty.authorizer.sahand.com/", name = "getProgramRefrencesResponse")
    public JAXBElement<GetProgramRefrencesResponse> createGetProgramRefrencesResponse(GetProgramRefrencesResponse value) {
        return new JAXBElement<GetProgramRefrencesResponse>(_GetProgramRefrencesResponse_QNAME, GetProgramRefrencesResponse.class, null, value);
    }

}
