package com.example.ults;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UltsService {

	@Autowired
	private UltsRepository ultsRepository;
	
	@Autowired
	private StockHistoryRepository stockHistoryRepository;
	
	public ProductEntity createProduct(ProductEntity product) {
		
		return ultsRepository.save(product);
	}

	public ProductEntity updateStock(Long id, int quantityChanged) {
		Optional<ProductEntity> optionalProduct = ultsRepository.findById(id);
		if(optionalProduct.isPresent()) {
			ProductEntity product = optionalProduct.get();
			product.setCurrentStock(product.getCurrentStock() + quantityChanged);
			ultsRepository.save(product);
			StockHistory stockHistory = new StockHistory();
			stockHistory.setProductId(id);
			stockHistory.setQuantityChanged(quantityChanged);
			stockHistoryRepository.save(stockHistory);
			return product;
		} else {
			throw new RuntimeException("Product not found with id" +id);
		}
		
	}
	
	public List<ProductEntity> getLowStockProducts(String category){
		if(category != null) {
			return ultsRepository.findByCategoryAndCurrentStockLessThanEqual(category,ultsRepository.getMinStockThreshold());
		} else {
			return ultsRepository.findAllByCurrentStockLessThanEqual(ultsRepository.getMinStockThreshold());
		}
	}
	
	public int getRestockSuggestion(Long id) throws Exception{
		Optional<ProductEntity> productOptional = ultsRepository.findById(id);
		if(productOptional.isEmpty()) {
			throw new Exception("Product not found with Id:" + id);
		}
		ProductEntity product = productOptional.get();
		int restockAmount = product.getMinStockThreshold();
		product.getCurrentStock();
		return(restockAmount > 0) ? restockAmount:0; 
	}


}
