package com.example.shop.adapter.in.rest.product;

import static com.example.shop.adapter.in.rest.common.ControllerCommons.clientErrorException;

import com.example.shop.application.port.in.product.FindProductsUseCase;
import com.example.shop.model.product.Product;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * REST controller for all product use cases.
 *
 * @author Paul Anthony Begley
 */
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class FindProductsController {

  private final FindProductsUseCase findProductsUseCase;

  public FindProductsController(FindProductsUseCase findProductsUseCase) {
    this.findProductsUseCase = findProductsUseCase;
  }

  @GET
  public List<ProductInListWebModel> findProducts(@QueryParam("query") String query) {
    if (query == null) {
      throw clientErrorException(Response.Status.BAD_REQUEST, "Missing 'query'");
    }

    List<Product> products;

    try {
      products = findProductsUseCase.findByNameOrDescription(query);
    } catch (IllegalArgumentException e) {
      throw clientErrorException(Response.Status.BAD_REQUEST, "Invalid 'query'");
    }

    return products.stream().map(ProductInListWebModel::fromDomainModel).toList();
  }
}
