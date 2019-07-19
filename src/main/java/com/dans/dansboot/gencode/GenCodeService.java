package com.dans.dansboot.gencode;


import com.dans.dansboot.domain.dto.ColumnDto;
import com.dans.dansboot.domain.dto.TableDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 读取数据中的表，写入表 中
 */
@Slf4j
@Service
public class GenCodeService {

    @Resource
    private DataSource dataSource;

    /**
     * 獲取數據庫所有的表
     * @return
     * @throws SQLException
     */
    public List<TableDto> getTableList() throws SQLException {
            Connection connection = dataSource.getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
            List<TableDto> tableList = getTableList(metaData, connection);
            return tableList;
    }

    /**
     * 獲取指定表中所有的 列
     * @param tableName
     * @return
     * @throws SQLException
     */
    public List<ColumnDto> getColumnList(String tableName) throws SQLException {
            Connection connection = dataSource.getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
        List<ColumnDto> columnList = getColumnList(metaData, connection, tableName);
        return columnList;
    }

    private List<TableDto> getTableList(DatabaseMetaData metaData, Connection connection){
        List<TableDto> tableList = new ArrayList<>(50);

        String catalog = null;
        try {
            catalog = connection.getCatalog();
            ResultSet dataTables = metaData.getTables(catalog, null, "%", new String[]{"TABLE"});
            while (dataTables.next()) {
                String table_name = dataTables.getString("TABLE_NAME");
                TableDto tableDto = TableDto.builder().tableName(table_name).build();
                tableList.add(tableDto);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }

    private List<ColumnDto> getColumnList(DatabaseMetaData metaData, Connection connection, String tableName){
        List<ColumnDto> columnDtos = new ArrayList<>(50);
        try {
            String catalog = connection.getCatalog();
            ResultSet columns = metaData.getColumns(catalog, "%", tableName, "%");
            while (columns.next()) {
                String column_name = columns.getString("COLUMN_NAME");
                String type_name = columns.getString("TYPE_NAME");
                String remarks = columns.getString("REMARKS");
                ColumnDto columnDto = ColumnDto.builder().name(column_name).type(type_name).remarks(remarks).build();
                //设置java 类型
                ColumnDtoDecorator columnDtoDecorator = new ColumnDtoDecorator(columnDto);
                columnDtoDecorator.mysqlColumnType2JavaFiledType(type_name);
                columnDtos.add(columnDto);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return columnDtos;
    }

}
