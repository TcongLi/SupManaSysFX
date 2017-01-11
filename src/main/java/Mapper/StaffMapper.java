package Mapper;

import Model.PO.Staff;

import java.util.List;

public interface StaffMapper {
    int deleteByPrimaryKey(String id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String id);

    Staff selectSelective(Staff record);

    List<Staff> selectAll();

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
}