package com.jbb.user.biz.mapper;

import com.jbb.user.biz.entity.Business;
import com.jbb.user.biz.entity.BusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusinessMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbb_business
     *
     * @mbggenerated
     */
    int countByExample(BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbb_business
     *
     * @mbggenerated
     */
    int deleteByExample(BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbb_business
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbb_business
     *
     * @mbggenerated
     */
    int insert(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbb_business
     *
     * @mbggenerated
     */
    int insertSelective(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbb_business
     *
     * @mbggenerated
     */
    List<Business> selectByExample(BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbb_business
     *
     * @mbggenerated
     */
    Business selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbb_business
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Business record, @Param("example") BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbb_business
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Business record, @Param("example") BusinessExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbb_business
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Business record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbb_business
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Business record);
}