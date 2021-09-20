package desafio.devoptopus.desafio3.discount;

import desafio.devoptopus.desafio3.document.Product;

public abstract class DiscountCheck implements DiscountManager {

    private DiscountCheck next;

    public abstract Product check(Product product);

    public DiscountCheck setNext(DiscountCheck dm){
        this.next = dm;
        return dm;
    }

    protected Product checkNext(Product product){
        if(next == null){
            return product;
        }
        return next.check(product);
    }
}
