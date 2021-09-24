package desafio.devoptopus.desafio3.discount;

import desafio.devoptopus.desafio3.document.Product;

public abstract class DiscountCheck implements DiscountManager {

    private DiscountCheck next;

    public DiscountCheck setNext(DiscountCheck discountCheck){
        this.next = discountCheck;
        return discountCheck;
    }

    protected Product checkNext(Product product){
        if(next == null){
            return product;
        }
        return next.check(product);
    }
}
