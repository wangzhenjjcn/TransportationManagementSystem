package org.myazure.repository;

import org.myazure.domain.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentRepository extends
PagingAndSortingRepository<Payment, Long>{

}
