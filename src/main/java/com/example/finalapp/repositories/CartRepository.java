package com.example.finalapp.repositories;

import com.example.finalapp.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    //Найти пользователя по ИД
    //Будем формировать карзину по ИД
    //Нахоим какие товары привязаны к пользователю и возвращаем лист товаров
    List<Cart> findByPersonId(int id);

    //Данный метод нам понадобится чтобы удалить удалит товар из карзины
    @Modifying
    //Указываем, что не просто чтение, а уже модификация данных
    @Query(value = "delete from product_cart where product_id=?1", nativeQuery = true)
    void deleteCartByProductId(int id);
}
