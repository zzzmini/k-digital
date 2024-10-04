package com.my.jpaTest.service;

import com.my.jpaTest.entity.Child;
import com.my.jpaTest.entity.Parent;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CascadeService {
    @Autowired
    EntityManager em;


    public void saveCascade() {
        Child c1 = new Child();
        Child c2 = new Child();

        Parent parent = new Parent();
        c1.setParent(parent);
        c2.setParent(parent);

        parent.getChildren().add(c1);
        parent.getChildren().add(c2);

        // 부모를 저장하면, 자식도 자동 저장
        // 부모객체에 선언한...  cascade.Persist
        em.persist(parent);

    }

    public void deleteCascade() {
        Parent findParent = em.find(Parent.class, 1L);
        em.remove(findParent);
    }
}
