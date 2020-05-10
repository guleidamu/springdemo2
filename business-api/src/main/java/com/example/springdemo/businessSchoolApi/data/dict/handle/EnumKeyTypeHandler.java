package com.example.springdemo.businessSchoolApi.data.dict.handle;


import com.example.springdemo.businessSchool.data.dict.IEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnumKeyTypeHandler extends BaseTypeHandler<IEnum> {

    private Class<IEnum> type;
    private final IEnum[] enums;

    public EnumKeyTypeHandler(Class<IEnum> type){
        this.type = type;
        this.enums = type.getEnumConstants();
    }


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, IEnum iEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,iEnum.getState());
    }

    @Override
    public IEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String state = resultSet.getString(s);
        if(resultSet.wasNull()){
            return null;
        }else {
            return locateIEnum(state);
        }
    }

    @Override
    public IEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String state = resultSet.getString(i);
        if(resultSet.wasNull()){
            return null;
        }else {
            return locateIEnum(state);
        }
    }

    @Override
    public IEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String state = callableStatement.getNString(i);
        if(callableStatement.wasNull()){
            return null;
        }else {
            return locateIEnum(state);
        }
    }

    private IEnum locateIEnum(String state) {
        for (IEnum status : enums) {
            if (state.equals(status.getState())) {
                return status;
            }
        }
        return null;
    }

}
