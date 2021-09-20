package desafio.devoptopus.desafio3.discount;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.util.Util;

public class OddDiscount extends DiscountCheck{

    @Override
    public Product check(Product product) {
        boolean isOdd = Util.isOdd(product.getId());
        if (isOdd){
            product.setDiscount(product.getPrice()*0.9);
            return product;
        }
        return checkNext(product);
    }
}
