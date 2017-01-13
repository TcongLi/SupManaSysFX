package Mapper;

import Model.DTO.SaleOrderDTO;
import Model.PO.SaleOrder;

import java.util.List;

public interface SaleOrderMapper {
    List<SaleOrderDTO> selectAllSaleOrder();

    int deleteByPrimaryKey(String id);

    int insert(SaleOrder record);

    int insertSelective(SaleOrder record);

    SaleOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SaleOrder record);

    int updateByPrimaryKey(SaleOrder record);
}