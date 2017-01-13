package Mapper;

import Model.PO.Product;

import java.util.List;

public interface ProductMapper {
    String selectIdByName(String name);

    List<Product> selectAll();
    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
}