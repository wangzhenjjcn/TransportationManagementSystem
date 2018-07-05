package org.myazure.repository;

import org.myazure.domain.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends
		PagingAndSortingRepository<Payment, Long> {

}
