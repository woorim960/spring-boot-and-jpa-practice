package jpabook.jpashop.repository;

import java.util.List;
import javax.persistence.EntityManager;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

  private final EntityManager em;

  public void save(Item item) {
    if (item.getId() == null) {
      // 아이템이 저장이 안되어있다면 저장한다.
      // 아이템 저장이 되어있어야지만, Id가 생긴다.
      em.persist(item);
    } else {
      // 아이템이 저장이 되어있다면, 업데이트를 수행한다.
      em.merge(item);
    }
  }

  public Item findOne(Long id) {
    return em.find(Item.class, id);
  }

  public List<Item> findAll() {
    return em.createQuery("select i from Item i", Item.class)
        .getResultList();
  }
}
