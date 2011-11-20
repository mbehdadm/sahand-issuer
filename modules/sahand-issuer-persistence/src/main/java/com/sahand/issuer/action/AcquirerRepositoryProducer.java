package com.sahand.issuer.action;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sahand.acquirer.action.AcquirerRepository;

/**
 * This class uses CDI to produce EntityManager instances qualified that are qualified as &#064;MemberRepository.
 * 
 * <p>
 * Example injection on a managed bean field:
 * </p>
 * 
 * <pre>
 * &#064;Inject
 * &#064;MemberRepository
 * private EntityManager memberRepository;
 * </pre>
 */
public class AcquirerRepositoryProducer {
    // use @SuppressWarnings to tell IDE to ignore warnings about field not being referenced directly
    @SuppressWarnings("unused")
    @Produces
    @AcquirerRepository
    @PersistenceContext(unitName="pu-acquirer")
    private EntityManager em;
}
