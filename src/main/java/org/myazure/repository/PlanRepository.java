package org.myazure.repository;

import java.util.List;

import org.myazure.domain.Plan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends PagingAndSortingRepository<Plan, Long> {

	List<Plan> findByCompanyNameLikeOrSourceLikeOrSourcepyLikeOrDestinationLikeOrDestinationpyLike(
			String key, String key2, String key3, String key4, String key5);



}