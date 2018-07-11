package org.myazure.repository;

import java.util.List;

import org.myazure.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends
		PagingAndSortingRepository<Order, Long> {

	// List<Order> findByFactoryId(int factoryId);
	List<Order> findTop5ByOrderByOrderIdDesc();



	List<Order> findByEntryNumberContainingOrCustomerNumberContainingOrPickupNumberContainingOrTransferNumberContainingOrSourceContainingOrSourcepyContainingOrDestinationContainingOrDestinationpyContainingOrTransportVehicleRegistrationNumberContainingOrDeliveryVehicleRegistrationNumberContainingOrContactNameContainingOrContactNamepyContainingOrRemarksContainingOrRemarkspyContaining(
			String key, String key2, String key3, String key4, String key5,
			String key6, String key7, String key8, String key9, String key10,
			String key11, String key12, String key13, String key14);

}