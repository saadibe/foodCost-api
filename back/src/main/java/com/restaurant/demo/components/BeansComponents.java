package com.restaurant.demo.components;

import com.restaurant.demo.models.CategoryModel;
import com.restaurant.demo.models.ElementModel;
import com.restaurant.demo.models.ProductModel;
import com.restaurant.demo.models.SizeCommodityModel;
import com.restaurant.demo.repositorys.CategorysRepository;
import com.restaurant.demo.repositorys.ElementRepository;
import com.restaurant.demo.repositorys.ProductRepository;
import com.restaurant.demo.repositorys.SizeCommodityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BeansComponents {
    @Autowired
    CategorysRepository categorysRepository;

    @Autowired
    SizeCommodityRepository sizeRepository;

    @Autowired
    ElementRepository elementRepository;

    @Autowired
    ProductRepository productRepository;


    @Bean(name="modelmapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void makeAfterInit() {
        setDemoCategorysSizes();
        //setDemoElements();
        //setDemoProducts();
    }


    private void setDemoCategorysSizes(){
        categorysRepository.saveAllAndFlush(Arrays.asList(
                new CategoryModel( (long) 1, "Salée"),
                new CategoryModel( (long) 2, "Boisson"),
                new CategoryModel( (long) 3, "Dessert"),
                new CategoryModel( (long) 4, "Piquant"),
                new CategoryModel( (long) 5, "Légume")
        ));

        sizeRepository.saveAllAndFlush( Arrays.asList(
                new SizeCommodityModel( (long)1, "Small" ),
                new SizeCommodityModel( (long)2, "Medium" ),
                new SizeCommodityModel( (long)3, "Large" )
        ));
    }
    private void setDemoElements(){
        ElementModel hrisa = new ElementModel();
        hrisa.setId((long) 1);
        hrisa.setName("Hrisa");
        hrisa.setImage("https://cdn.shopify.com/s/files/1/0276/5802/7106/products/bs1870_1024x1024@2x.png?v=1589545721");
        hrisa.setKg_buy_price( (double)4500 );hrisa.setKg_price( (double) 5000);
        hrisa.setKg_in_stock( (double) 10 );hrisa.setGramme_price( (double) 5 );
        hrisa.setElementCategorys(Arrays.asList(
                new CategoryModel((long)1, "Salée"),
                new CategoryModel( (long)4, "Piquant")
        ));
        elementRepository.save( hrisa );

        ElementModel tomate = new ElementModel();
        tomate.setId((long) 2);
        tomate.setName("Tomate");
        tomate.setImage("https://assets.stickpng.com/images/580b57fcd9996e24bc43c238.png");
        tomate.setKg_buy_price( (double)4500 );tomate.setKg_price( (double) 5000);
        tomate.setKg_in_stock( (double) 10 );tomate.setGramme_price( (double) 5 );
        tomate.setElementCategorys(Arrays.asList(
                new CategoryModel((long)1, "Salée"),
                new CategoryModel( (long)5, "Légume")
        ));
        elementRepository.save( tomate );

        ElementModel frit = new ElementModel();
        frit.setId((long) 3);
        frit.setName("Frit");
        frit.setImage("http://www.pngall.com/wp-content/uploads/4/Fries-Transparent.png");
        frit.setKg_buy_price( (double)4500 );frit.setKg_price( (double) 5000);
        frit.setKg_in_stock( (double) 10 );frit.setGramme_price( (double) 5 );
        frit.setElementCategorys(Arrays.asList(
                new CategoryModel((long)1, "Salée"),
                new CategoryModel( (long)5, "Légume")
        ));
        elementRepository.save( frit );
    }


    private void setDemoProducts(){
        ProductModel pizza = new ProductModel();
        pizza.setId( (long)1 );
        pizza.setName("Pizza");
        pizza.setType("Pasta");
        pizza.setImage("https://1for1pizza.com/french/wp-content/uploads/2016/06/Pizza-Veggie-Lovers.png");
        pizza.setDiscount(10);
        pizza.setPrice( (double) 1000 );
        pizza.setActual_price( (double) 900 );
        pizza.setProductCategorys(
                Arrays.asList(
                    new CategoryModel((long)1, "Salée")
                )
        );
        pizza.setProductSizes( Arrays.asList(
                new SizeCommodityModel( (long)1, "Small" ),
                new SizeCommodityModel( (long)2, "Medium" ),
                new SizeCommodityModel( (long)3, "Large" )
        ));
        productRepository.save( pizza );

        ProductModel tacos = new ProductModel();
        tacos.setId( (long)2 );
        tacos.setName("Tacos");
        tacos.setType("Pasta");
        tacos.setImage("https://static.wixstatic.com/media/122695_702c6b67e85e4a4791e49867db05b602~mv2.png/v1/fill/w_504,h_391,al_c,q_85,usm_0.66_1.00_0.01/TACOS.webp");
        tacos.setDiscount(10);
        tacos.setPrice( (double) 1000 );
        tacos.setActual_price( (double) 900 );
        tacos.setProductCategorys(
                Arrays.asList(
                        new CategoryModel((long)1, "Salée")
                )
        );
        tacos.setProductSizes( Arrays.asList(
                new SizeCommodityModel( (long)1, "Small" ),
                new SizeCommodityModel( (long)2, "Medium" ),
                new SizeCommodityModel( (long)3, "Large" )
        ));
        productRepository.save( tacos );
    }
}
