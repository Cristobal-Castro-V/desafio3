package desafio.devoptopus.desafio3.discount;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.util.Util;

public class OddDiscount extends DiscountCheck{

    private double discountOdd;

    public OddDiscount(double discountOdd){
        this.discountOdd = discountOdd;
    }

    @Override
    public Product check(Product product) {
        boolean isOdd = Util.isOdd(product.getId());
        if (isOdd){
            product.setDiscount(product.getPrice()*discountOdd);
            return product;
        }
        return checkNext(product);
    }
}
