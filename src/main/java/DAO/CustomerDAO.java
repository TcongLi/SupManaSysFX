package DAO;

import Mapper.CustomerMapper;
import Model.DTO.CustomerDTO;
import Util.SqlSessionFactoryProvider;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by L T on 2017/1/12.
 */
public interface CustomerDAO {
    default List<CustomerDTO> getAllCustomers(){
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        List<CustomerDTO> list = session.getMapper(CustomerMapper.class).selectAll()
                .stream()
                .map(i->new CustomerDTO(i.getId(),i.getPhone(),i.getName(),i.getGender(),i.getAddress(),i.getMail()))
                .collect(Collectors.toList());
        session.close();
        return list;
    }

    default String getIdByName(String name){
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        String id = session.getMapper(CustomerMapper.class).getIdByName(name);
        session.close();
        return id;
    }
}
