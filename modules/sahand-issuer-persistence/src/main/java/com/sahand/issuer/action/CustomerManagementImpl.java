package com.sahand.issuer.action;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.acquirer.action.CustomerManagement;
import com.sahand.acquirer.action.CustomerManagementImpl;
import com.sahand.acquirer.action.GeographicalManagement;
import com.sahand.acquirer.action.SequenceGenerator;
import com.sahand.acquirer.data.CustomerDto;
import com.sahand.acquirer.data.enumeration.CustomerType;
import com.sahand.acquirer.data.enumeration.GenderType;
import com.sahand.acquirer.data.enumeration.MarriageStatus;
import com.sahand.acquirer.model.Customer;
import com.sahand.acquirer.model.CustomerAcceptor;
import com.sahand.acquirer.model.Geographical;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.exception.IssuerException;


@Stateless
public class CustomerManagementImpl implements CustomerManagement {

	private static Logger logger = SahandLogger.getSahandLogger(CustomerManagementImpl.class);

	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;
	
	@EJB
	private GeographicalManagement geographicalManagement;

	
	private Customer checkAndConvertFrom(CustomerDto customer, 
			Customer customerDa) throws Exception{
		if(customerDa == null)
			customerDa = new Customer();
		customerDa.setCustomerId(customer.getId());
		customerDa.setAccountNumber(customer.getAccountNumber());
		customerDa.setBirthCity(customer.getBirthCity());
		customerDa.setBirthday(customer.getBirthday());
		customerDa.setCustomerNumber(customer.getCustomerNumber());
		customerDa.setFatherName(customer.getFatherName());
		if(customer.getGender() != null ){
			customerDa.setGender(customer.getGender().toValue());
		}
		customerDa.setHomeAddress(customer.getHomeAddress());
		customerDa.setHomePhone(customer.getHomePhone());
		if(customer.getHomePostalCode() != null && customer.getHomePostalCode().length() > 0)
			customerDa.setHomePostalCode(Long.valueOf(customer.getHomePostalCode()));
		customerDa.setIdCardNumber(customer.getIdCardNumber());
		customerDa.setLatinFatherName(customer.getLatinFatherName());
		customerDa.setLatinName(customer.getLatinName());
		if(customer.getMarriageStatus() != null ){
			customerDa.setMarriageStatus(customer.getMarriageStatus().toValue());
		}
		customerDa.setMobile(customer.getMobile());
		customerDa.setName(customer.getName());
		customerDa.setNationalCode(customer.getNationalCode());
		customerDa.setPassportID(customer.getPassportID());
		customerDa.setWorkAddress(customer.getWorkAddress());
		customerDa.setWorkPhone(customer.getWorkPhone());
		if(customer.getWorkPostalCode() != null && customer.getWorkPostalCode().length() > 0)
			customerDa.setWorkPostalCode(Long.valueOf(customer.getWorkPostalCode()));
		if(customer.getWorkCity() != null && customer.getWorkCity().getCode() != null ){
//			customerDa.setWorkCity(geo);
			Geographical geographical = geographicalManagement.find(customer.getWorkCity().getCode());
			customerDa.setWorkCity(geographical);
		}
		if(customer.getHomeCity() != null && customer.getHomeCity().getCode() != null ){
//			customerDa.setHomeCity(geo);
			Geographical geographical = geographicalManagement.find(customer.getHomeCity().getCode());
			customerDa.setHomeCity(geographical);
		}
		customerDa.setType(customer.getType().toValue());
		logger.debug(customerDa.toString());

		return customerDa;
	}
	
	private CustomerAcceptor checkAndConvertFrom(CustomerDto customer,
			CustomerAcceptor customerAcceptorDa) throws Exception{
		if(customerAcceptorDa == null)
			customerAcceptorDa = new CustomerAcceptor();
		customerAcceptorDa.setCustomerId(customer.getId());
		customerAcceptorDa.setFaxNumber(customer.getFaxNumber());
		customerAcceptorDa.setManagerName(customer.getManagerName());
		if(customer.getInstitutePostalCode() != null && customer.getInstitutePostalCode().length() > 0)
			customerAcceptorDa.setPostalCode(Long.valueOf(customer.getInstitutePostalCode()));
		customerAcceptorDa.setRegisterLocation(customer.getRegisterLocation());
		customerAcceptorDa.setRegisterNumber(customer.getRegisterNumber());
		customerAcceptorDa.setRequestPos(customer.getRequestPos());
		customerAcceptorDa.setEndRentDate(customer.getRentExpireDate());
		customerAcceptorDa.setEstateType(customer.getEstateType());
		logger.debug(customerAcceptorDa.toString());

		return customerAcceptorDa;
	}
	
	public Customer edit(CustomerDto customer) throws Exception {
		Customer customerDa = null;
		try {

			customerDa = find(customer.getId());
			if(customerDa == null)
				throw new IssuerException("customer.not.find");

			customerDa = checkAndConvertFrom(customer,customerDa);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return customerDa;
	}

	

	public Customer create(CustomerDto customer) throws Exception {
		Customer customerDa = null;

		try {
			customerDa = checkAndConvertFrom(customer,customerDa);

			String customerID = "";
			Customer customer_  = new Customer();
			while(customer_ != null){
				customerID = SequenceGenerator.sequenceGenerator(/*pm.getEntityManager()*/entityManager, Customer.class, customer.getId(),"customer-seq");
				customer_ = find(customerID);
			}
			customerDa.setCustomerId(customerID);



		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return customerDa;
	}

	public Customer find(String customerId) throws Exception {
		Customer customer = null;
		try {

			customer = /*pm.getEntityManager()*/entityManager.find(Customer.class, customerId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return customer;
	}

	public void persist(Customer customer) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.persist(customer);
			/*pm.getEntityManager()*/entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("customer.persist.exception");

		}
		
	}

	public void update(Customer customer) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.merge(customer);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("customer.update.exception");

		}
		
	}

	public boolean isUniqueCustomer(String serialNo) {
		// TODO Auto-generated method stub
		return false;
	}

	public CustomerDto convertFrom(Customer customerDa,CustomerDto customerDto) {
		if(customerDto == null)
			customerDto = new CustomerDto();
		customerDto.setAccountNumber(customerDa.getAccountNumber());
		customerDto.setBirthCity(customerDa.getBirthCity());
		customerDto.setBirthday(customerDa.getBirthday());
		customerDto.setCustomerNumber(customerDa.getCustomerNumber());
		customerDto.setFatherName(customerDa.getFatherName());
		if(customerDa.getGender() != null)
			customerDto.setGender(GenderType.fromValue(customerDa.getGender()));
		customerDto.setHomeAddress(customerDa.getHomeAddress());
		customerDto.setHomePhone(customerDa.getHomePhone());
		customerDto.setHomeCity(geographicalManagement.convertFrom(customerDa.getHomeCity()));
		if(customerDa.getHomePostalCode() != null)
			customerDto.setHomePostalCode(String.valueOf(customerDa.getHomePostalCode()));
		customerDto.setId(customerDa.getCustomerId());
		customerDto.setIdCardNumber(customerDa.getIdCardNumber());
		customerDto.setLatinFatherName(customerDa.getLatinFatherName());
		customerDto.setLatinName(customerDa.getLatinName());
		if(customerDa.getMarriageStatus() != null)
			customerDto.setMarriageStatus(MarriageStatus.fromValue(customerDa.getMarriageStatus()));
		customerDto.setMobile(customerDa.getMobile());
		customerDto.setName(customerDa.getName()) ;
		customerDto.setNationalCode(customerDa.getNationalCode());
		customerDto.setPassportID(customerDa.getPassportID());
		customerDto.setType(CustomerType.fromValue(customerDa.getType()));
		customerDto.setWorkAddress(customerDa.getWorkAddress());
		customerDto.setWorkPhone(customerDa.getWorkPhone());
		customerDto.setWorkCity(geographicalManagement.convertFrom(customerDa.getWorkCity()));
		if(customerDa.getWorkPostalCode() != null)
			customerDto.setWorkPostalCode(String.valueOf(customerDa.getWorkPostalCode()));
		return customerDto;
	}
	public CustomerDto convertFrom(CustomerAcceptor customerAcceptorDa,CustomerDto customerDto) {
		if(customerDto == null)
			customerDto = new CustomerDto();
		customerDto.setEstateType(customerAcceptorDa.getEstateType());
		customerDto.setFaxNumber(customerAcceptorDa.getFaxNumber());
		customerDto.setId(customerAcceptorDa.getCustomerId());
		if(customerAcceptorDa.getPostalCode() != null)
			customerDto.setInstitutePostalCode(String.valueOf(customerAcceptorDa.getPostalCode()));
		customerDto.setManagerName(customerAcceptorDa.getManagerName());
		customerDto.setRegisterLocation(customerAcceptorDa.getRegisterLocation());
		customerDto.setRegisterNumber(customerAcceptorDa.getRegisterNumber());
		customerDto.setRequestPos(customerAcceptorDa.getRequestPos());
		customerDto.setRentExpireDate(customerAcceptorDa.getEndRentDate());
		return customerDto;
	}

	public CustomerAcceptor edit_(CustomerDto customer) throws Exception {
		CustomerAcceptor customerAcceptorDa = null;

		try {

			customerAcceptorDa = find_(customer.getId());
			if(customerAcceptorDa == null)
				throw new IssuerException("customer.acceptor.not.find");

			customerAcceptorDa = checkAndConvertFrom(customer,customerAcceptorDa);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return customerAcceptorDa;
	}

	


	public CustomerAcceptor create_(CustomerDto customer) throws Exception {
		CustomerAcceptor customerAcceptorDa = null;

		try {
			customerAcceptorDa = checkAndConvertFrom(customer,customerAcceptorDa);

			String customerID = "";
			CustomerAcceptor customerAcceptorDa_  = new CustomerAcceptor();
			while(customerAcceptorDa_ != null){
				customerID = SequenceGenerator.sequenceGenerator(/*pm.getEntityManager()*/entityManager, CustomerAcceptor.class, customer.getId(),"customer-seq");
				customerAcceptorDa_ = find_(customerID);
			}
			customerAcceptorDa.setCustomerId(customerID);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return customerAcceptorDa;
	}

	public CustomerAcceptor find_(String customerId) throws Exception {
		CustomerAcceptor customer = null;
		try {

			customer = /*pm.getEntityManager()*/entityManager.find(CustomerAcceptor.class, customerId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return customer;
	}

	public void persist_(CustomerAcceptor customer) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.persist(customer);
			/*pm.getEntityManager()*/entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("customer.acceptor.persist.exception");

		}
		
	}

	public void update_(CustomerAcceptor customer) throws Exception {
		try {

			/*pm.getEntityManager()*/entityManager.merge(customer);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("customer.acceptor.update.exception");

		}
		
	}

	

}
