package com.mi.mongo;

import com.mi.sys.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * 商品mongo dao层
 *
 * @author 金彪
 * @date 2021-01-20
 */
@Repository
public class GoodsDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public GoodsVO findOneBySpecGoodsId(Integer specGoodsId) {
        return mongoTemplate.findOne(new Query(Criteria.where("specGoodsPriceList._id").is(specGoodsId)), GoodsVO.class, "goods");
    }

    public void save(GoodsVO goods) {
        mongoTemplate.save(goods, "goods");
    }
}
