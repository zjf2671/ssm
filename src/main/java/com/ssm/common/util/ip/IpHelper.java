package com.ssm.common.util.ip;

import java.io.BufferedReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ssm.common.util.file.FileUtil;
import com.ssm.common.util.file.PoiUtil;

/**
 * Created by Wang Zhe on 2015/8/11.
 */
public class IpHelper {

    private static IpTree ipTree = IpTree.getInstance();

    private static final String ipFile = "ipDatabase.csv";

    private static final String regionFile = "ipRegion.xlsx";

    static{
        buildTrain();
    }

    private static void buildTrain() {
        List<IpRelation> ipRelationList;
        try {
            ipRelationList = IpHelper.getIpRelation();
            int count = 0;
            for (IpRelation ipRelation : ipRelationList) {
                ipTree.train(ipRelation.getIpStart(), ipRelation.getIpEnd(), ipRelation.getProvince());
                if(count > 10){
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 静态方法，传入ip地址，返回ip地址所在城市或地区
     * @param ip    IP地址，例：58.30.15.255
     * @return  返回IP地址所在城市或地区，例：北京市
     */
    public static String findRegionByIp(String ip){
        return ipTree.findIp(ip);
    }
    
    public static void main(String[] args) {
		System.out.println(findRegionByIp("116.231.136.150"));
	}

    public static List<IpRelation> getIpRelation() throws Exception {

        // <ipCode, province>
        Map<Integer, String> regionRelationMap = getRegionRelationMap();
        String file =  IpHelper.class.getClassLoader().getResource(ipFile).getPath();
        //解决通过getClassLoader().getResource()获取到路径后，
        //会发现使用File类去打开，却打不开，原因是url路径使用了url编码，空格被转义为"%20"字符，这时，
        //使用File类通过该路径是不能找到想要找的文件的,使用 URLDecoder.decode(PATH, "UTF-8")：对文件路径进行转义
        file = URLDecoder.decode(file, "UTF-8"); 
        BufferedReader ipRelationReader = FileUtil.readFile(file);

        String line;
        List<IpRelation> list = new ArrayList<IpRelation>();
        while((line = ipRelationReader.readLine()) != null){
            String[] split = line.split(",");
            String ipStart = split[0];
            String ipEnd = split[1];
            Integer ipCode = Integer.valueOf(split[2]);

            String province = regionRelationMap.get(ipCode);
            IpRelation ipRelation = new IpRelation();
            ipRelation.setIpStart(ipStart);
            ipRelation.setIpEnd(ipEnd);
            ipRelation.setProvince(province);
            list.add(ipRelation);
        }
        return list;

    }

    /**
     * @return Map<ipCode, province>
     * @throws Exception
     */
    public static Map<Integer, String> getRegionRelationMap() throws Exception {
        String file =  IpHelper.class.getClassLoader().getResource(regionFile).getPath();
        //解决通过getClassLoader().getResource()获取到路径后，
        //会发现使用File类去打开，却打不开，原因是url路径使用了url编码，空格被转义为"%20"字符，这时，
        //使用File类通过该路径是不能找到想要找的文件的,使用 URLDecoder.decode(PATH, "UTF-8")：对文件路径进行转义
        file = URLDecoder.decode(file, "UTF-8"); 
        Workbook workbook = PoiUtil.getWorkbook(file);

        Sheet sheet = workbook.getSheetAt(0);
        Map<Integer, String> map = new HashMap<Integer, String>();
        int rowLen = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowLen; i++) {
            Row row = sheet.getRow(i);
            String province = row.getCell(0).getStringCellValue();
            Double a = row.getCell(2).getNumericCellValue();
            Integer ipCode = a.intValue();
            map.put(ipCode, province);
        }

        return map;
    }
}
