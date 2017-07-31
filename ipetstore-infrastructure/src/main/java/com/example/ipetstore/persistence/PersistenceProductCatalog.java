package com.example.ipetstore.persistence;

import com.example.ipetstore.domain.Product;
import com.example.ipetstore.domain.ProductCatalog;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Created by qilei on 17/7/28.
 */
@Repository
public class PersistenceProductCatalog implements ProductCatalog {

  private final SqlSession sqlSession;

  public PersistenceProductCatalog(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public Optional<Product> findByNumber(String number) {
    Product p = this.sqlSession.selectOne("findByNumber", number);
    return p == null ? Optional.empty() : Optional.of(p);
  }

  @Override
  public List<Product> findByKeyword(String keyword) {
    List<Product> list = this.sqlSession.selectList("findByKeyword", "%" +keyword + "%");
    return list;
  }

  @Override
  public void add(Product product) {
    this.sqlSession.insert("insert", product);

  }

  @Override
  public void clean() {
    this.sqlSession.delete("clean");
  }
}
