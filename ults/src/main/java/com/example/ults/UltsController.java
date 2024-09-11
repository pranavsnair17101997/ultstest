package com.example.ults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class UltsController {

	@Autowired
	private UltsService ultsService;
	
	@PostMapping
	public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product){
	
		ProductEntity createdProduct = ultsService.createProduct(product);
		return ResponseEntity.ok(createdProduct);
	}
	
	@PutMapping("/{id}/stock")
	public ResponseEntity<ProductEntity> updateStock(@PathVariable Long id,@RequestBody int quantityChanged){
		ProductEntity updatedProduct = ultsService.updateStock(id,quantityChanged);
		return ResponseEntity.ok(updatedProduct);
	}
	
//	@GetMapping("/low-stock")
//	public ResponseEntity<List<Product>> getLowStockProducts(@RequestParam(required = false) String category){
//		List<Product> lowStockProducts(category);
//		return ResponseEntity.ok(lowStockProducts);
//	}
}
