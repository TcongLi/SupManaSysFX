package Mapper;

import Model.PO.OrderProd;

public interface OrderProdMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderProd record);

    int insertSelective(OrderProd record);

    OrderProd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderProd record);

    int updateByPrimaryKey(OrderProd record);
}