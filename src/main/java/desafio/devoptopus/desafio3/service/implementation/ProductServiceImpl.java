package desafio.devoptopus.desafio3.service.implementation;

import desafio.devoptopus.desafio3.discount.DiscountManager;
import desafio.devoptopus.desafio3.discount.OddDiscount;
import desafio.devoptopus.desafio3.discount.PalindromeDisc;
import desafio.devoptopus.desafio3.discount.PrimeDiscount;
import desafio.devoptopus.desafio3.document.Product;
import desafio.devoptopus.desafio3.exception.InvalidRequestException;
import desafio.devoptopus.desafio3.exception.NotFoundException;
import desafio.devoptopus.desafio3.repository.ProductRepository;
import desafio.devoptopus.desafio3.service.ProductService;
import desafio.devoptopus.desafio3.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Value("${discount.palindrome}")
    private double palindrome;

    @Value("${discount.prime}")
    private double prime;

    @Value("${discount.odd}")
    private double odd;

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findProducts(String search) {
        PalindromeDisc palindromeDisc = new PalindromeDisc(search, palindrome);
        PrimeDiscount primeDiscount = new PrimeDiscount(prime);
        OddDiscount oddDiscount = new OddDiscount(odd);

        palindromeDisc.setNext(primeDiscount).setNext(oddDiscount);
        DiscountManager chain = palindromeDisc;

        List<Product> listProduct = new ArrayList<>();
        Pattern pat = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher mat = pat.matcher(search);
        boolean result = mat.matches();
        Long id = tryParseLong(search);
        if (result) {
            if (id != null) {
                Product product = productRepository.findById(id);
                if (product != null) {
                    listProduct.add(product);
                }
            } else {
                List<Product> product = productRepository.findByRegex(search);
                listProduct.addAll(product);
            }
        }else if (!result){
            LOGGER.error("Request sending is Invalid " + search);
            throw new InvalidRequestException("Invalid Request");
        }
        //Insertar else con exception
        LOGGER.trace("Entering isEmpty for listProduct " + search);
        LOGGER.debug("Authenticating products exist");
        if (listProduct.isEmpty()) {
            LOGGER.error("Product Not Found " + search);
            throw new NotFoundException("Products not found");
        }
        listProduct.forEach(p -> chain.check(p));
        return listProduct;
    }

    private Long tryParseLong(String str) {
        Long longValue = null;
        try {
            longValue = Long.parseLong(str);
            LOGGER.info("Search for Long");
        } catch (Exception e) {
            LOGGER.info("Search for String");
        }
        return longValue;
    }

}