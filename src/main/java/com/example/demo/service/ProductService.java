package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){
        this.productRepo=productRepo;
    }



    public List<Product> getAllProducts() {

        return productRepo.findAll();
        // Implementation for fetching all products

    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, org.springframework.web.multipart.MultipartFile imageFile) throws Exception {
        if (imageFile != null && !imageFile.isEmpty()) {
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImageData(imageFile.getBytes());
        }
        return productRepo.save(product);
    }


    public
Product updateProduct(int id, Product updatedProduct) {
        Product existingProduct = productRepo.findById(id).orElse(null);
        if (existingProduct == null) {
            return null; // or throw an exception
        }
        // Update the existing product with the new values
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setReleaseDate(updatedProduct.getReleaseDate());
        existingProduct.setBrand(updatedProduct.getBrand());
        existingProduct.setAvailable(updatedProduct.isAvailable());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        // Update image fields if needed
        if (updatedProduct.getImageName() != null) {
            existingProduct.setImageName(updatedProduct.getImageName());
            existingProduct.setImageType(updatedProduct.getImageType());
            existingProduct.setImageData(updatedProduct.getImageData());
        }
        return productRepo.save(existingProduct);
    }
    public String getImageNameById(int id){

        Product product=productRepo.findById(id).orElse(null);
        if(product==null){
            return null;
        }
        return product.getImageName();
    }

    public  int deleteProduct(int id){
        Product product=productRepo.findById(id).orElse(null);
        if(product==null){
            return 0;
        }
        productRepo.delete(product);
        return 1;
    }

    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }

}
