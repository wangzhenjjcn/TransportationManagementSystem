package org.myazure.repository;

import java.util.List;

import org.myazure.domain.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends
		PagingAndSortingRepository<Order, Long> {

	// List<Order> findByFactoryId(int factoryId);
	List<Order> findTop5ByOrderByOrderIdDesc();

}