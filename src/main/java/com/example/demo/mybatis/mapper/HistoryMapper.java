package com.example.demo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.mybatis.dto.History;
import com.example.demo.mybatis.dto.HistoryExample;

@Mapper
public interface HistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu May 25 17:43:03 JST 2017
     */
    long countByExample(HistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu May 25 17:43:03 JST 2017
     */
    int deleteByExample(HistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu May 25 17:43:03 JST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu May 25 17:43:03 JST 2017
     */
    int insert(History record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu May 25 17:43:03 JST 2017
     */
    int insertSelective(History record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu May 25 17:43:03 JST 2017
     */
    List<History> selectByExample(HistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu May 25 17:43:03 JST 2017
     */
    History selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu May 25 17:43:03 JST 2017
     */
    int updateByExampleSelective(@Param("record") History record, @Param("example") HistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu May 25 17:43:03 JST 2017
     */
    int updateByExample(@Param("record") History record, @Param("example") HistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu May 25 17:43:03 JST 2017
     */
    int updateByPrimaryKeySelective(History record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu May 25 17:43:03 JST 2017
     */
    int updateByPrimaryKey(History record);
}