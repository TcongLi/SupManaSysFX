package Service;

import DAO.CustomerDAO;
import DAO.ProductDAO;
import DAO.SaleOrderDetailsDAO;
import Model.DTO.CustomerDTO;
import Model.DTO.ProductDTO;
import Model.DTO.SaleOrderDTO;
import javafx.beans.property.StringProperty;

import java.util.List;

/**
 * Created by L T on 2017/1/12.
 */
public interface SaleOrderService {
    default List<SaleOrderDTO> getAllOrderDetails(){
        return new SaleOrderDetailsDAO(){}.selectAllSaleOrderDetail();
    }

    default List<CustomerDTO> getAllCustomers(){
        return new CustomerDAO(){}.getAllCustomers();
    }

    default List<ProductDTO> getAllProducts(){
        return new ProductDAO(){}.getAllProducts();
    }

    default String insertOrder(StringProperty cusName){
        String cusId = new CustomerDAO(){}.getIdByName(cusName.get());
        String orderId = new SaleOrderDetailsDAO(){}.insertOrder(cusId);
        return orderId;
    }

    default void deleteOrder(StringProperty pk){
        new SaleOrderDetailsDAO(){}.deleteOrder(pk.get());
    }

    default void updateItem(StringProperty orderPk,StringProperty itemPk,StringProperty prodName,int amount){
        String prodId = new ProductDAO(){}.getIdByName(prodName);
        new SaleOrderDetailsDAO(){}.updateItem(orderPk.get(),itemPk.get(),prodId,amount);
    }

    default void insertItem(StringProperty orderPk,StringProperty prodName,int amount){
        String prodId = new ProductDAO(){}.getIdByName(prodName);
        new SaleOrderDetailsDAO(){}.insertItem(orderPk.get(),prodId,amount);
    }

    default void deleteItem(StringProperty pk){
        new SaleOrderDetailsDAO(){}.deleteItem(pk.get());
    }
}
