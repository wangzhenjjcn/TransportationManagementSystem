package org.myazure.repository;

import java.util.List;

import org.myazure.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends
		PagingAndSortingRepository<Customer, Long> {

//	List<Customer> findByNameOrNamepyOrAddressOrAddresspyOrContactLike(
//			String key);

}
