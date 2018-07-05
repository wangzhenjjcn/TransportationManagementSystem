package org.myazure.repository;

import java.util.List;

import org.myazure.domain.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends
		PagingAndSortingRepository<Payment, Long> {

	List<Payment> findByOrderId(Long id);

	List<Payment> findByCreatorUserId(Long id);

	List<Payment> findByRemarksContainingOrRemarkspyContaining(String key,
			String key2);

}
