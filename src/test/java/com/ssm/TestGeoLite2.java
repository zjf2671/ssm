package com.ssm;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;

import org.junit.Test;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Location;
import com.maxmind.geoip2.record.Postal;
import com.maxmind.geoip2.record.Subdivision;

/**
 * @Description: 参数文档
 * http://blog.csdn.net/chwshuang/article/details/71951000
 * http://dev.maxmind.com/geoip/geoip2/geolite2/
 * @author harry.zhang
 * @CreateDate:	2017年12月13日
 * @version 1.0
 */
public class TestGeoLite2 {

	@Test
	public void testIp() throws IOException, GeoIp2Exception {

		String file = TestGeoLite2.class.getClassLoader().getResource("GeoLite2-City.mmdb").getPath();
		// 解决通过getClassLoader().getResource()获取到路径后，
		// 会发现使用File类去打开，却打不开，原因是url路径使用了url编码，空格被转义为"%20"字符，这时，
		// 使用File类通过该路径是不能找到想要找的文件的,使用 URLDecoder.decode(PATH,
		// "UTF-8")：对文件路径进行转义
		file = URLDecoder.decode(file, "UTF-8");
		// 创建 GeoLite2 数据库
		File database = new File(file);
		// 读取数据库内容
		DatabaseReader reader = new DatabaseReader.Builder(database).build();
		InetAddress ipAddress = InetAddress.getByName("116.231.136.150");

		// 获取查询结果
		CityResponse response = reader.city(ipAddress);

		// 获取国家信息
		Country country = response.getCountry();
		System.out.println(country.getIsoCode()); // 'CN'
		System.out.println(country.getName()); // 'China'
		System.out.println(country.getNames().get("zh-CN")); // '中国'

		// 获取省份
		Subdivision subdivision = response.getMostSpecificSubdivision();
		System.out.println(subdivision.getName()); // 'Guangxi Zhuangzu Zizhiqu'
		System.out.println(subdivision.getIsoCode()); // '45'
		System.out.println(subdivision.getNames().get("zh-CN")); // '广西壮族自治区'

		// 获取城市
		City city = response.getCity();
		System.out.println(city.getName()); // 'Nanning'
		Postal postal = response.getPostal();
		System.out.println(postal.getCode()); // 'null'
		System.out.println(city.getNames().get("zh-CN")); // '南宁'
		Location location = response.getLocation();
		System.out.println(location.getLatitude()); // 22.8167
		System.out.println(location.getLongitude()); // 108.3167

	}

}
