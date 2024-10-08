package ie.atu.week4cicd1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private List<Product> productList = new ArrayList<>();
    public ProductController() {
        productList.add(new Product("100", "Tv", "Electric", 399));
        productList.add(new Product("101", "Radio", "Electric", 99));
    }

    @GetMapping("/getProducts")
    public List<Product> getProduct(){
        return productList;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product){
        productList.add(product);
        return ResponseEntity.ok(productList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List> updateProduct(@RequestBody Product product, @PathVariable String id){
        for(Product p : productList) {
            if(p.getId().equals(id)){
                productList.remove(p);
            }
        }
        productList.add(product);
        return ResponseEntity.ok(productList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List> deleteProduct(@PathVariable String id){
        for(Product p : productList) {
            if(p.getId().equals(id)){
                productList.remove(p);
            }
        }
        return ResponseEntity.ok(productList);
    }
}
