package com.dans.dansboot.gencode;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

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
@Configuration
public class GenCodeInitTables implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private DataSource dataSource;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            Connection connection = dataSource.getConnection();

            DatabaseMetaData metaData = connection.getMetaData();
            List tableList = getTableList(metaData, connection);
            log.error("{}",tableList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List getTableList(DatabaseMetaData metaData, Connection connection){
        List<String> tableList = new ArrayList<>(50);

        String catalog = null;
        try {
            catalog = connection.getCatalog();
            ResultSet dataTables = metaData.getTables(catalog, null, "%", new String[]{"TABLE"});
            while (dataTables.next()) {
                String table_name = dataTables.getString("TABLE_NAME");
                tableList.add(table_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }
}
