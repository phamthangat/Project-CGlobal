package com.project.CGlobal.Repository;

import com.project.CGlobal.Domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findShoppingCartByCartId(String cardId);
}
