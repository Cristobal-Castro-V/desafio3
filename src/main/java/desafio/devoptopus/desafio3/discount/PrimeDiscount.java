package desafio.devoptopus.desafio3.discount;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.util.Util;

public class PrimeDiscount extends DiscountCheck{

   @Override
   public Product check( Product product) {
      boolean isPrime = Util.isPrime(product.getId());
      if (isPrime){
         product.setDiscount(product.getPrice()*0.85);
         return product;
      }
      return checkNext(product);
   }

}

