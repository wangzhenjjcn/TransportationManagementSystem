package org.myazure.repository;

import org.myazure.domain.Plan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends
PagingAndSortingRepository<Plan, Long> {

 }