package com.ssm.common.datasource;

/**
 * @Description: 数据源类型定义类
 * @author harry.zhang
 * CreateDate:	2017年6月15日
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<DataSoureKey> dataSoureThreadLocal = new ThreadLocal<>();

    public static String getDataSourceKey() {
        String persisName = "";
        DataSoureKey dataSoureKey = dataSoureThreadLocal.get();
        if (dataSoureKey == null) {
            persisName = DataSoureKey.MASTER.getKey();
        } else {
            persisName = dataSoureKey.getKey();
        }
        return persisName;
    }

    public static void setDataSourceKey(DataSoureKey dataSource) {
        dataSoureThreadLocal.set(dataSource);
    }

    public static enum DataSoureKey {
        MASTER {
            @Override
            String getKey() {
                return DATASOURCE_MASTER;
            }
        }, SLAVE {
            @Override
            String getKey() {
                return DATASOURCE_SALVE;
            }
        }, CMS {
            @Override
            String getKey() {
                return DATASOURCE_CMS;
            }
        };

        private static final String DATASOURCE_MASTER = "master";
        private static final String DATASOURCE_SALVE = "slave";
        private static final String DATASOURCE_CMS = "cms";
        

        abstract String getKey();
    }
}
