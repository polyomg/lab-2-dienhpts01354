package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import poly.edu.model.Product;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    // ?1 → sản phẩm mặc định, tự động thêm vào model mọi request
    @ModelAttribute("p1")
    public Product defaultProduct() {
        Product p = new Product();
        p.setName("iPhone 30");
        p.setPrice(5000.0);
        return p;
    }

    // ?3 → danh sách sản phẩm
    @ModelAttribute("items")
    public List<Product> getItems() {
    	return Arrays.asList(
                new Product("iPhone 15", 30000.0),
                new Product("Samsung Galaxy S23", 25000.0),
                new Product("Xiaomi 13", 18000.0),
                new Product("Oppo Reno10", 15000.0),
                new Product("Vivo V27", 14000.0),
                new Product("Nokia X30", 12000.0),
                new Product("Sony Xperia 1 V", 28000.0),
                new Product("Asus ROG Phone 7", 32000.0),
                new Product("OnePlus 11", 26000.0),
                new Product("Realme GT Neo 5", 17000.0),
                new Product("Huawei P60 Pro", 29000.0),
                new Product("Google Pixel 7 Pro", 27000.0),
                new Product("Motorola Edge 40", 16000.0),
                new Product("Xiaomi Redmi Note 12", 9000.0),
                new Product("Samsung A54", 11000.0),
                new Product("Oppo Find N2 Flip", 33000.0),
                new Product("Vivo Y36", 8000.0),
                new Product("Honor Magic 5", 21000.0),
                new Product("ZTE Nubia Z50", 20000.0),
                new Product("Infinix Zero Ultra", 13000.0)
        );
    }


    @GetMapping("/product/form")
    public String form(Model model) {
        // tạo p2 để bind form
        model.addAttribute("p2", new Product());
        return "poly/product_form";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("p2") Product p, Model model) {
        // p2 đã tự động bind với form
        return "poly/product_form";
    }
}
