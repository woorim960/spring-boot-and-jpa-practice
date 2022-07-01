package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

  @PersistenceContext // 스프링부트가 알아서 em에 EntityManager를 주입해준다.
  private EntityManager em;
}
