package DAO;

import Mapper.OrderProdMapper;
import Mapper.SaleOrderMapper;
import Model.DTO.SaleOrderDTO;
import Model.PO.OrderProd;
import Model.PO.SaleOrder;
import Util.SqlSessionFactoryProvider;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by L T on 2017/1/12.
 */
public interface SaleOrderDetailsDAO {
    default List<SaleOrderDTO> selectAllSaleOrderDetail(){
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        List<SaleOrderDTO>  list = session.getMapper(SaleOrderMapper.class).selectAllSaleOrder();
        session.close();
        return list;
    }

    default String insertOrder(String cusId){
        String uuid = UUID.randomUUID().toString();
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();

        session.getMapper(SaleOrderMapper.class).insert(new SaleOrder(uuid,
                Timestamp.valueOf(LocalDateTime.now()),
                cusId));

        session.commit();
        session.close();
        return uuid;
    }

    default void deleteOrder(String pk){
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        session.getMapper(SaleOrderMapper.class).deleteByPrimaryKey(pk);
        session.commit();
        session.close();
    }

    default void deleteItem(String pk){
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        session.getMapper(OrderProdMapper.class).deleteByPrimaryKey(pk);
        session.commit();
        session.close();
    }

    default void updateItem(String orderPk, String itemPk, String prodPk, int amount){
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        session.getMapper(OrderProdMapper.class).updateByPrimaryKey(new OrderProd(itemPk,orderPk,prodPk,amount));
        session.commit();
        session.close();
    }

    default void insertItem(String orderPk,String prodPk,int amount){
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        session.getMapper(OrderProdMapper.class).insertSelective(new OrderProd(UUID.randomUUID().toString(),orderPk,prodPk,amount));
        session.commit();
        session.close();
    }
}
