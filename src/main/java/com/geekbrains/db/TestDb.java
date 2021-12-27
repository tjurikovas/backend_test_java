package com.geekbrains.db;

import com.geekbrains.db.dao.CategoriesMapper;
import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Categories;
import com.geekbrains.db.model.Products;
import com.geekbrains.db.model.ProductsExample;

public class TestDb {
    public static void main(String[] args) {
        DbService dbService = new DbService();
        ProductsMapper productsMapper = dbService.getProductsMapper();
        Products product = productsMapper.selectByPrimaryKey(4L);
        System.out.println(product);

        CategoriesMapper categoriesMapper = dbService.getCategoriesMapper();
        Categories clothes = new Categories();
        clothes.setTitle("Clothes");
        categoriesMapper.insert(clothes);

        Products shorts = new Products();
        shorts.setTitle("Shorts");
        shorts.setPrice(700);
        shorts.setCategoryId(3L);

        productsMapper.insert(shorts);

        Products trousers = new Products();
        trousers.setTitle("Trousers");
        trousers.setPrice(900);
        trousers.setCategoryId(3L);

        productsMapper.insert(trousers);

        Products cap = new Products();
        cap.setTitle("Cap");
        cap.setPrice(400);
        cap.setCategoryId(3L);

        productsMapper.insert(cap);


        Categories book = new Categories();
        book.setTitle("Book");
        categoriesMapper.insert(book);

        Products quality_Assurance = new Products();
        quality_Assurance.setTitle("Quality_Assurance");
        quality_Assurance.setPrice(350);
        quality_Assurance.setCategoryId(4L);

        productsMapper.insert(quality_Assurance);

        Products java = new Products();
        java.setTitle("Java");
        java.setPrice(1350);
        java.setCategoryId(4L);

        productsMapper.insert(java);

        Products sQl = new Products();
        sQl.setTitle("SQL");
        sQl.setPrice(1350);
        sQl.setCategoryId(4L);

        productsMapper.insert(sQl);

        Categories sport_goods = new Categories();
        sport_goods.setTitle("Sport_goods");
        categoriesMapper.insert(sport_goods);

        Products ski = new Products();
        ski.setTitle("Ski");
        ski.setPrice(8740);
        ski.setCategoryId(5L);

        productsMapper.insert(ski);

        Products bicycle = new Products();
        bicycle.setTitle("Bicycle");
        bicycle.setPrice(10140);
        bicycle.setCategoryId(5L);

        productsMapper.insert(bicycle);

        Products skates = new Products();
        skates.setTitle("Skates");
        skates.setPrice(1100);
        skates.setCategoryId(5L);

        productsMapper.insert(skates);

        Categories children_s_goods = new Categories();
        children_s_goods.setTitle("Children_s_goods");
        categoriesMapper.insert(children_s_goods);

        Products diapers = new Products();
        diapers.setTitle("Diapers");
        diapers.setPrice(1200);
        diapers.setCategoryId(6L);

        productsMapper.insert(diapers);

        Products wheelchair = new Products();
        wheelchair.setTitle("Wheelchair");
        wheelchair.setPrice(85000);
        wheelchair.setCategoryId(6L);

        productsMapper.insert(wheelchair);

        Products designer = new Products();
        designer.setTitle("Designer");
        designer.setPrice(2970);
        designer.setCategoryId(6L);

        productsMapper.insert(designer);

        Categories category1 = categoriesMapper.selectByPrimaryKey(1L);
        System.out.println(category1);

        Categories category2 = categoriesMapper.selectByPrimaryKey(2L);
        System.out.println(category2);

        Categories category3 = categoriesMapper.selectByPrimaryKey(3L);
        System.out.println(category3);

        Categories category4 = categoriesMapper.selectByPrimaryKey(4L);
        System.out.println(category4);

        Categories category5 = categoriesMapper.selectByPrimaryKey(5L);
        System.out.println(category5);

        Categories category6 = categoriesMapper.selectByPrimaryKey(6L);
        System.out.println(category6);

        ProductsExample filter = new ProductsExample();
        filter.createCriteria().andPriceBetween(100, 2000);

        System.out.println(productsMapper.selectByExample(filter));


//        categoriesMapper.deleteByPrimaryKey(3L);

        dbService.closeSession();
    }
}
