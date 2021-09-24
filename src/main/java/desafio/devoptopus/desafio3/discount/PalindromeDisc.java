package desafio.devoptopus.desafio3.discount;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.util.Util;

public class PalindromeDisc extends DiscountCheck{
    private final double discountPalindrome;
    private final String str;
    public PalindromeDisc(String str,double discountPalindrome){
        this.str = str;
        this.discountPalindrome = discountPalindrome;
    }

    @Override
    public Product check(Product product) {
        boolean isPalindrome = Util.isPalindrome(str);
        if(isPalindrome){
            product.setDiscount(product.getPrice()*discountPalindrome);
            return product;
        }
        return checkNext(product);
    }

}
