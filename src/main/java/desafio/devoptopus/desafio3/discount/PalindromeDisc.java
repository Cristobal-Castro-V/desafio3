package desafio.devoptopus.desafio3.discount;

import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.util.Util;

public class PalindromeDisc extends DiscountCheck{

    private boolean isPalindrome;
    public PalindromeDisc(String search){
        isPalindrome = Util.isPalindrome(search);
    }

    public PalindromeDisc() {
        
    }

    @Override
    public Product check(Product product) {
        if(this.isPalindrome){
            product.setDiscount(product.getPrice()*0.5);
            return product;
        }
        return checkNext(product);
    }

}
