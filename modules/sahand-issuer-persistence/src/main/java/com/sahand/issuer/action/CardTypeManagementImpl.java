package com.sahand.issuer.action;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import com.sahand.acquirer.action.AcquirerRepository;
import com.sahand.common.util.SequenceGenerator;
import com.sahand.common.util.logger.SahandLogger;
import com.sahand.issuer.config.IssuerConfigLoader;
import com.sahand.issuer.data.CardTypeInformation;
import com.sahand.issuer.exception.IssuerException;
import com.sahand.issuer.model.CardType;


@Stateless
public class CardTypeManagementImpl {

	private static Logger logger = SahandLogger.getSahandLogger(CardTypeManagementImpl.class);
	
	@Inject
	@AcquirerRepository
	EntityManager entityManager;


	public CardTypeInformation convertFrom(CardType cardType,CardTypeInformation cardTypeInformation) {
		if(cardTypeInformation == null)
			cardTypeInformation = new CardTypeInformation();
		cardTypeInformation.setApplication(cardType.getApplication());
		cardTypeInformation.setAuthentication(cardType.getAuthentication());
		cardTypeInformation.setAuthorization(cardType.getAuthorization());
		cardTypeInformation.setDefaultServiceCode(cardType.getDefaultServiceCode());
		cardTypeInformation.setDescription(cardType.getDescription());
		cardTypeInformation.setId(cardType.getId());
		cardTypeInformation.setPanFormat(cardType.getPanFormat());
		cardTypeInformation.setPinEncrytion(cardType.getPinEncrytion());
		cardTypeInformation.setPinFormat(cardType.getPinFormat());
		cardTypeInformation.setTrackDataFormat(cardType.getTrackDataFormat());
		return cardTypeInformation;
	}
	
	public CardType convertFrom(CardTypeInformation cardTypeInformation,CardType cardType) {
		if(cardType == null)
			cardType = new CardType();
		cardType.setApplication(cardTypeInformation.getApplication());
		cardType.setAuthentication(cardTypeInformation.getAuthentication());
		cardType.setAuthorization(cardTypeInformation.getAuthorization());
		cardType.setDefaultServiceCode(cardTypeInformation.getDefaultServiceCode());
		cardType.setDescription(cardTypeInformation.getDescription());
		cardType.setId(cardTypeInformation.getId());
		cardType.setPanFormat(cardTypeInformation.getPanFormat());
		cardType.setPinEncrytion(cardTypeInformation.getPinEncrytion());
		cardType.setPinFormat(cardTypeInformation.getPinFormat());
		cardType.setTrackDataFormat(cardTypeInformation.getTrackDataFormat());
		return cardType;
		
	}
	
	public CardType edit(CardTypeInformation cardTypeInformation) throws Exception {

		CardType cardType= null;
		try {

			cardType = find(cardTypeInformation.getId());
			if(cardType == null)
				throw new IssuerException("card.type.not.find");

			cardType = checkAndConvertFrom(cardTypeInformation,cardType);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cardType;
	}
	

	public CardType create(CardTypeInformation cardTypeInformation) throws Exception {

		CardType cardType = null;
		try {

			cardType = checkAndConvertFrom(cardTypeInformation,cardType);
			
			String cardTypeID = "";
			if(cardTypeInformation.isAutoGenerate()){
				CardType cardType_  = new CardType();
				while(cardType_ != null){
					String key = IssuerConfigLoader.getValue("cardtype-seq");
					cardTypeID = SequenceGenerator.sequenceGenerator(entityManager,  new String(),key,null);
					cardType_ = find(Integer.valueOf(cardTypeID));
				}
			}
			else{
				CardType cardType_ = find(cardTypeInformation.getId());
				if(cardType_ != null)
					throw new IssuerException("duplicate.card.type.exist");
				String key = IssuerConfigLoader.getValue("cardtype-seq");
				cardTypeID = String.valueOf(cardTypeInformation.getId());
				cardTypeID = SequenceGenerator.sequenceGenerator(null, cardTypeID,key,null);
			}
			cardType.setId(Integer.valueOf(cardTypeID));
			
			panSequenceGenerator(cardTypeID);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cardType;
	}
	

	public void panSequenceGenerator(String cardTypeID) {
		try {

			entityManager.createNativeQuery(
							"CREATE SEQUENCE "+
								"PAN_SEQ_"+ cardTypeID +
								" INCREMENT BY 1 MAXVALUE 999999 START WITH 110 " +
								" MINVALUE 1 NOCACHE NOCYCLE ORDER")
						.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

	public String generatePanSequence(Integer cardTypeId){
		String pan = "";
		String key = IssuerConfigLoader.getValue("pan-seq");

		pan = SequenceGenerator.sequenceGenerator(null, pan,key,String.valueOf(cardTypeId));


		return pan;
	}
	public CardType find(Integer cardId) throws Exception {
		CardType cardType = null;
		try {

			cardType = entityManager.find(CardType.class, cardId);


		} catch (Exception e) {
			e.printStackTrace();

		}
		return cardType;
	}

	public void persist(CardType cardType) throws Exception {
		try {

			entityManager.persist(cardType);
			entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("card.type.persist.exception");

		}
		
	}
	
	public void update(CardType cardType) throws Exception {
		try {

			entityManager.merge(cardType);


		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("card.type.update.exception");

		}
		
	}
	
	public void delete(Integer cardId) throws Exception {
		CardType cardType = null;
		try {

			cardType = find(cardId);
			if(cardType == null)
				throw new IssuerException("card.type.not.find");
			entityManager.remove(cardType);
			entityManager.flush();

		}catch (IssuerException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new IssuerException("card.type.delete.exception");
		}
		
	}
	
	public CardType checkAndConvertFrom(CardTypeInformation cardTypeInformation,CardType cardType) throws Exception{
		
		if(cardType == null)
			cardType = new CardType();
		
		cardType.setApplication(cardTypeInformation.getApplication());
		cardType.setAuthentication(cardTypeInformation.getAuthentication());
		cardType.setAuthorization(cardTypeInformation.getAuthorization());
		cardType.setDefaultServiceCode(cardTypeInformation.getDefaultServiceCode());
		cardType.setDescription(cardTypeInformation.getDescription());
		cardType.setId(cardTypeInformation.getId());
		cardType.setPanFormat(cardTypeInformation.getPanFormat());
		cardType.setPinEncrytion(cardTypeInformation.getPinEncrytion());
		cardType.setPinFormat(cardTypeInformation.getPinFormat());
		cardType.setTrackDataFormat(cardTypeInformation.getTrackDataFormat());
		
		logger.debug(cardType.toString());
		return cardType;
		
	}

	public CardType getCardType(Integer cardTypeId) throws Exception {
		CardType cardType = null;

		try {

			cardType = find(cardTypeId);
			if(cardType == null)
				throw new IssuerException("card.type.not.find");

		}  catch (IssuerException e) {
			throw e;
		}  catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cardType;
	}

	




}
