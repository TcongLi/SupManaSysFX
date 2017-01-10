package Mapper;

import Model.Bean.Staff;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(String id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String id);

    List<Staff> selectAll();

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}