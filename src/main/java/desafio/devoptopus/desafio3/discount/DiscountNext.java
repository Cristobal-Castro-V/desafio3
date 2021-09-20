package desafio.devoptopus.desafio3.discount;

import desafio.devoptopus.desafio3.document.Product;

public class DiscountNext extends DiscountCheck{

    @Override
    public Product check(Product product) {
        PalindromeDisc pd = new PalindromeDisc();
        this.setNext(pd);

        PrimeDiscount prd = new PrimeDiscount();
        pd.setNext(prd);

        OddDiscount od = new OddDiscount();
        prd.setNext(od);

        return checkNext(product);
    }


}
