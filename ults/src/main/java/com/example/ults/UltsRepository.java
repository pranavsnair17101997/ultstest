package com.example.ults;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UltsRepository extends JpaRepository<ProductEntity,Long>{

	List<ProductEntity> findAllByCurrentStockLessThanEqual(int minStockThreshold);
	List<ProductEntity> findByCategoryAndCurrentStockLessThanEqual(String category,int minStockThreshold);
@Query("SELECT MIN(p.minStockThreshold) FROM Product p")
int getMinStockThreshold();
}
