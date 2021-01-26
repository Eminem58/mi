package com.mi.mongo;

import com.mi.sys.vo.UserShoppingGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * 购物车mongo dao层
 *
 * @author 金彪
 * @date 2021-01-20
 */
@Repository
public class ShoppingCartDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public UserShoppingGoodsVO findByUserId(String userId) {
        return mongoTemplate.findOne(new Query(Criteria.where("userId").is(userId)), UserShoppingGoodsVO.class, "user_shoppingcart");
    }

    public void save(UserShoppingGoodsVO userShoppingGoods) {
        mongoTemplate.save(userShoppingGoods, "user_shoppingcart");
    }
}
