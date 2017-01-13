package Mapper;

import Model.PO.Customer;

import java.util.List;

public interface CustomerMapper {

    String getIdByName(String name);
    List<Customer> selectAll();
    int deleteByPrimaryKey(String id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}