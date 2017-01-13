package DAO;

import Mapper.ProductMapper;
import Model.DTO.ProductDTO;
import Util.SqlSessionFactoryProvider;
import javafx.beans.property.StringProperty;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by L T on 2017/1/12.
 */
public interface ProductDAO {
    default List<ProductDTO> getAllProducts(){
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        List<ProductDTO> list = session.getMapper(ProductMapper.class).selectAll()
                .stream()
                .map(i->new ProductDTO(i.getId(),i.getName(),i.getPrice(),i.getInfo()))
                .collect(Collectors.toList());
        session.close();
        return list;
    }

    default String getIdByName(StringProperty name){

        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        String id = session.getMapper(ProductMapper.class).selectIdByName(name.get());
        session.close();
        return id;
    }
}
