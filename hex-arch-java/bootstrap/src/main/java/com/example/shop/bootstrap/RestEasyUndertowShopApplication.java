package com.example.shop.bootstrap;

import com.example.shop.adapter.in.rest.product.FindProductsController;
import com.example.shop.adapter.out.persistence.inmemory.InMemoryProductRepository;
import com.example.shop.application.port.in.product.FindProductsUseCase;
import com.example.shop.application.port.out.persistence.ProductRepository;
import com.example.shop.application.service.product.FindProductsService;
import jakarta.ws.rs.core.Application;
import java.util.Set;

/**
 * The application configuration for the Undertow server. Instantiates the adapters and use cases,
 * and wires them.
 *
 * @author Paul Anthony Begley
 */
public class RestEasyUndertowShopApplication extends Application {

 
  private ProductRepository productRepository;

  // We're encouraged to use "automatic discovery of resources", but I want to define them manually.
  @SuppressWarnings("deprecation")
  @Override
  public Set<Object> getSingletons() {
    initPersistenceAdapters();
    return Set.of(

        findProductsController());
  }

  private void initPersistenceAdapters() {
    
    productRepository = new InMemoryProductRepository();
  }







  private FindProductsController findProductsController() {
    FindProductsUseCase findProductsUseCase = new FindProductsService(productRepository);
    return new FindProductsController(findProductsUseCase);
  }
}
