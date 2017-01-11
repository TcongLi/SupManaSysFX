package DAO;

import Mapper.StaffMapper;
import Model.DTO.StaffDTO;
import Model.PO.Staff;
import Util.SqlSessionFactoryProvider;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by L T on 2017/1/11.
 */
public interface StaffDAO {
    default List<StaffDTO> getAllStaffs() {
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        List<StaffDTO> list = session.getMapper(StaffMapper.class).selectAll()
                .stream()
                .map(item -> new StaffDTO(item.getId(), item.getName(), item.getGender(), item.getAddress(), item.getDept()))
                .collect(Collectors.toList());
        session.close();

        //for log
        //list.forEach(i-> System.out.println(i.getName()));
        //log
        return list;
    }

    default void insertStaff(StaffDTO staffDTO) {
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        session.getMapper(StaffMapper.class).insertSelective(new Staff(UUID.randomUUID().toString(), staffDTO.getName(), staffDTO.getGender(), staffDTO.getAddress(), staffDTO.getDept()));
        session.commit();
        session.close();
    }

    default void deleteStaffbyPK(String id) {
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        session.getMapper(StaffMapper.class).deleteByPrimaryKey(id);
        session.commit();
        session.close();
    }

    default List<StaffDTO> selectStaff(StaffDTO s) {
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        List<StaffDTO> list = session.getMapper(StaffMapper.class).selectSelective(new Staff(s.getId(),
                s.getName(),
                s.getGender(),
                s.getAddress(),
                s.getDept()))
                .stream()
                .map(item -> new StaffDTO(item.getId(), item.getName(), item.getGender(), item.getAddress(), item.getDept()))
                .collect(Collectors.toList());
        session.close();

        return list;
    }

    default void updateStaff(StaffDTO staffDTO){
        SqlSession session = SqlSessionFactoryProvider.getInstance().openSession();
        session.getMapper(StaffMapper.class).updateByPrimaryKeySelective(new Staff(staffDTO.getId(), staffDTO.getName(), staffDTO.getGender(), staffDTO.getAddress(), staffDTO.getDept()));
        session.commit();
        session.close();
    }
}
