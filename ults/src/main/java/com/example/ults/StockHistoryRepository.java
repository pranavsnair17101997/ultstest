package com.example.ults;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockHistoryRepository extends JpaRepository<StockHistory,Long>{

	List<StockHistory> findTop5Product(Long productId,int quantityChanged);
}
