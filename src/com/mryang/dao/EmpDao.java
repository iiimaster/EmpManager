package com.mryang.dao;

import com.mryang.model.Emp;
import com.mryang.utils.PageModel;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName EmpDao.java
 * @Description TODO 员工业务接口
 * @createTime 2021年05月17日 22:03:00
 */
public interface EmpDao {

    /**
     * 添加员工
     * @return
     */
    public int insert(Emp emp);

    /**
     * 查询全部员工
     *
     * @return
     */
    public ArrayList<Emp> selectAll();

    /**
     * 分页：查询总记录数
     * @return 总记录数
     */
    public Integer selectTotalCount();

    /**
     * 分页：根据页数查询员工
     * @param pageModel 要查询的位置
     * @return 查询到的数据
     */
    public ArrayList<Emp> selectAll(PageModel pageModel);

    /**
     * 根据ID查询员工
     * @param id 要查询的员工ID
     * @return
     */
    public Emp selectByID(Integer id);

    /**
     * 根据name查询员工
     * @param name 要查询的员工
     * @return 完整员工信息
     */
    public Emp selectByName(String name);

    /**
     * 根据ID删除员工信息
     * @param id 要删除的员工ID
     * @return
     */
    public void delete(Integer id);

    /**
     * 修改员工信息
     * @param emp 要修改的员工信息
     * @return
     */
    public int update(Emp emp) throws Exception;

}
