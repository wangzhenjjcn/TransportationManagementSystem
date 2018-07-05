package org.myazure.repository;

import java.util.List;

import org.myazure.domain.Customer;
import org.myazure.domain.Payment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends
		PagingAndSortingRepository<Customer, Long> {

	List<Customer> findByNameLikeOrNamepyLikeOrAddressLikeOrAddresspyLikeOrContactLike(
			String key, String key2, String key3, String key4, String key5);

	List<Customer> findByNameContainingOrNamepyContainingOrAddressContainingOrAddresspyContainingOrContactContaining(
			String key, String key2, String key3, String key4, String key5);

}
