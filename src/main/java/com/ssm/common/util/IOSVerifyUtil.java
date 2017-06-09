package com.ssm.common.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONObject;

/**
 * 苹果服务器验证util
 * @author harry.zhang 参考文献
 *         http://blog.csdn.net/u010246789/article/details/51281185
 *         https://developer.apple.com/library/content/releasenotes/General/ValidateAppStoreReceipt/Chapters/ReceiptFields.html#//apple_ref/doc/uid/TP40010573-CH106-SW1
 */
public class IOSVerifyUtil {

	// 沙盒环境
	private static final String url_sandbox = "https://sandbox.itunes.apple.com/verifyReceipt";
	// 真实环境
	private static final String url_verify = "https://buy.itunes.apple.com/verifyReceipt";

	/**
	 * 重写X509TrustManager
	 */
	private static TrustManager myX509TrustManager = new X509TrustManager() {

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

		}

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

		}
	};

	/*
	 * private static class TrustAnyHostnameVerifier implements HostnameVerifier
	 * { public boolean verify(String hostname, SSLSession session) { return
	 * true; } }
	 */

	/**
	 * 苹果服务器验证
	 * 
	 * @param receipt
	 *            账单
	 * @url 要验证的地址
	 * @param chooseEnv
	 * @return null 或返回结果 沙盒 https://sandbox.itunes.apple.com/verifyReceipt
	 * @throws Exception
	 * 
	 */
	public static String buyAppVerify(String receipt, boolean chooseEnv) throws Exception {

		String url = null;
		url = chooseEnv == true ? url_verify : url_sandbox;
		final String certificateCode = receipt;
		if (StringUtils.isNotEmpty(certificateCode)) {
			return sendHttpsCoon(url, certificateCode);
		} else {
			return null;
		}
	}

	/**
	 * 发送请求
	 * 
	 * @param url
	 * @param strings
	 * @return
	 */
	private static String sendHttpsCoon(String url, String code) throws Exception {
		if (url.isEmpty()) {
			return null;
		}
		// 设置SSLContext
		SSLContext ssl = SSLContext.getInstance("SSL");
		ssl.init(null, new TrustManager[] { myX509TrustManager }, new java.security.SecureRandom());

		// 打开连接
		HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
		// 设置套接工厂
		conn.setSSLSocketFactory(ssl.getSocketFactory());
		// conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
		// 加入数据
		conn.setRequestMethod("POST");
		// conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-type", "application/json");
		// conn.setRequestProperty("Proxy-Connection", "Keep-Alive");

		JSONObject obj = new JSONObject();
		obj.put("receipt-data", code);

		BufferedOutputStream buffOutStr = new BufferedOutputStream(conn.getOutputStream());
		buffOutStr.write(obj.toString().getBytes());
		buffOutStr.flush();
		buffOutStr.close();

		// 获取输入流
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String line = null;
		StringBuffer sb = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();

	}

	public static void main(String[] args) throws Exception {
		String receipt = "ewoJInNpZ25hdHVyZSIgPSAiQTQ4aG9XeEkwM0U1Q2x3VWxaSGQxS24vbDJNZFRzRDA1dXMwMVlLTXdJYUdZcE5uenFidU9LcS9ON1E0QWIvOEdtWnVBL3d5QXZFN1JudzBSemdvb2ppRlAvWFdsYlNaOVVUUXlEWmp2S2U5UjB4OGhSN1pOSFZ1cjcyR2l5MVJONnViVGx0WklUY2dncHdYVHZBOEpNRnZ3Z2p2aHpjaVF1S0ExQkRoTWxwR21SY0RmSnpYbGEwRzZwZ3hHdm5MSlBPUDJFaURqZFUreW9lZ2ZmK2lxelJaZ09nK0V4YW1EbUw1TWdjWDQ5ZTdSSDhVK0k5bkhaOHQ5QkR2UVZvQjRVdkZQUk1JdU9MSE9BamtNdDNubk5tcDZMZ21tWTk4ZVMycGpiVGFmNE14TVdHbjF5UDFXS25OWTk2L3Nad1F4S1JicWVBNjAxclozNGRBMm1LR3dXWUFBQVdBTUlJRmZEQ0NCR1NnQXdJQkFnSUlEdXRYaCtlZUNZMHdEUVlKS29aSWh2Y05BUUVGQlFBd2daWXhDekFKQmdOVkJBWVRBbFZUTVJNd0VRWURWUVFLREFwQmNIQnNaU0JKYm1NdU1Td3dLZ1lEVlFRTERDTkJjSEJzWlNCWGIzSnNaSGRwWkdVZ1JHVjJaV3h2Y0dWeUlGSmxiR0YwYVc5dWN6RkVNRUlHQTFVRUF3dzdRWEJ3YkdVZ1YyOXliR1IzYVdSbElFUmxkbVZzYjNCbGNpQlNaV3hoZEdsdmJuTWdRMlZ5ZEdsbWFXTmhkR2x2YmlCQmRYUm9iM0pwZEhrd0hoY05NVFV4TVRFek1ESXhOVEE1V2hjTk1qTXdNakEzTWpFME9EUTNXakNCaVRFM01EVUdBMVVFQXd3dVRXRmpJRUZ3Y0NCVGRHOXlaU0JoYm1RZ2FWUjFibVZ6SUZOMGIzSmxJRkpsWTJWcGNIUWdVMmxuYm1sdVp6RXNNQ29HQTFVRUN3d2pRWEJ3YkdVZ1YyOXliR1IzYVdSbElFUmxkbVZzYjNCbGNpQlNaV3hoZEdsdmJuTXhFekFSQmdOVkJBb01Da0Z3Y0d4bElFbHVZeTR4Q3pBSkJnTlZCQVlUQWxWVE1JSUJJakFOQmdrcWhraUc5dzBCQVFFRkFBT0NBUThBTUlJQkNnS0NBUUVBcGMrQi9TV2lnVnZXaCswajJqTWNqdUlqd0tYRUpzczl4cC9zU2cxVmh2K2tBdGVYeWpsVWJYMS9zbFFZbmNRc1VuR09aSHVDem9tNlNkWUk1YlNJY2M4L1cwWXV4c1FkdUFPcFdLSUVQaUY0MWR1MzBJNFNqWU5NV3lwb041UEM4cjBleE5LaERFcFlVcXNTNCszZEg1Z1ZrRFV0d3N3U3lvMUlnZmRZZUZScjZJd3hOaDlLQmd4SFZQTTNrTGl5a29sOVg2U0ZTdUhBbk9DNnBMdUNsMlAwSzVQQi9UNXZ5c0gxUEttUFVockFKUXAyRHQ3K21mNy93bXYxVzE2c2MxRkpDRmFKekVPUXpJNkJBdENnbDdaY3NhRnBhWWVRRUdnbUpqbTRIUkJ6c0FwZHhYUFEzM1k3MkMzWmlCN2o3QWZQNG83UTAvb21WWUh2NGdOSkl3SURBUUFCbzRJQjF6Q0NBZE13UHdZSUt3WUJCUVVIQVFFRU16QXhNQzhHQ0NzR0FRVUZCekFCaGlOb2RIUndPaTh2YjJOemNDNWhjSEJzWlM1amIyMHZiMk56Y0RBekxYZDNaSEl3TkRBZEJnTlZIUTRFRmdRVWthU2MvTVIydDUrZ2l2Uk45WTgyWGUwckJJVXdEQVlEVlIwVEFRSC9CQUl3QURBZkJnTlZIU01FR0RBV2dCU0lKeGNKcWJZWVlJdnM2N3IyUjFuRlVsU2p0ekNDQVI0R0ExVWRJQVNDQVJVd2dnRVJNSUlCRFFZS0tvWklodmRqWkFVR0FUQ0IvakNCd3dZSUt3WUJCUVVIQWdJd2diWU1nYk5TWld4cFlXNWpaU0J2YmlCMGFHbHpJR05sY25ScFptbGpZWFJsSUdKNUlHRnVlU0J3WVhKMGVTQmhjM04xYldWeklHRmpZMlZ3ZEdGdVkyVWdiMllnZEdobElIUm9aVzRnWVhCd2JHbGpZV0pzWlNCemRHRnVaR0Z5WkNCMFpYSnRjeUJoYm1RZ1kyOXVaR2wwYVc5dWN5QnZaaUIxYzJVc0lHTmxjblJwWm1sallYUmxJSEJ2YkdsamVTQmhibVFnWTJWeWRHbG1hV05oZEdsdmJpQndjbUZqZEdsalpTQnpkR0YwWlcxbGJuUnpMakEyQmdnckJnRUZCUWNDQVJZcWFIUjBjRG92TDNkM2R5NWhjSEJzWlM1amIyMHZZMlZ5ZEdsbWFXTmhkR1ZoZFhSb2IzSnBkSGt2TUE0R0ExVWREd0VCL3dRRUF3SUhnREFRQmdvcWhraUc5Mk5rQmdzQkJBSUZBREFOQmdrcWhraUc5dzBCQVFVRkFBT0NBUUVBRGFZYjB5NDk0MXNyQjI1Q2xtelQ2SXhETUlKZjRGelJqYjY5RDcwYS9DV1MyNHlGdzRCWjMrUGkxeTRGRkt3TjI3YTQvdncxTG56THJSZHJqbjhmNUhlNXNXZVZ0Qk5lcGhtR2R2aGFJSlhuWTR3UGMvem83Y1lmcnBuNFpVaGNvT0FvT3NBUU55MjVvQVE1SDNPNXlBWDk4dDUvR2lvcWJpc0IvS0FnWE5ucmZTZW1NL2oxbU9DK1JOdXhUR2Y4YmdwUHllSUdxTktYODZlT2ExR2lXb1IxWmRFV0JHTGp3Vi8xQ0tuUGFObVNBTW5CakxQNGpRQmt1bGhnd0h5dmozWEthYmxiS3RZZGFHNllRdlZNcHpjWm04dzdISG9aUS9PamJiOUlZQVlNTnBJcjdONFl0UkhhTFNQUWp2eWdhWndYRzU2QWV6bEhSVEJoTDhjVHFBPT0iOwoJInB1cmNoYXNlLWluZm8iID0gImV3b0pJbTl5YVdkcGJtRnNMWEIxY21Ob1lYTmxMV1JoZEdVdGNITjBJaUE5SUNJeU1ERTNMVEEyTFRBeElEQXhPakU1T2pFNElFRnRaWEpwWTJFdlRHOXpYMEZ1WjJWc1pYTWlPd29KSW5WdWFYRjFaUzFwWkdWdWRHbG1hV1Z5SWlBOUlDSmlZamhqTTJRMk5EWTFOelZoTXpJNU0yRmxOamd4TlRGa056UmhNelk1Tmpsa1pHVTFabVUxSWpzS0NTSnZjbWxuYVc1aGJDMTBjbUZ1YzJGamRHbHZiaTFwWkNJZ1BTQWlNVEF3TURBd01ETXdNelkxTlRZMU55STdDZ2tpWW5aeWN5SWdQU0FpTVM0d0lqc0tDU0owY21GdWMyRmpkR2x2YmkxcFpDSWdQU0FpTVRBd01EQXdNRE13TXpZM01EYzJOU0k3Q2draWNYVmhiblJwZEhraUlEMGdJakVpT3dvSkltOXlhV2RwYm1Gc0xYQjFjbU5vWVhObExXUmhkR1V0YlhNaUlEMGdJakUwT1RZek1EVXhOVGd3TURBaU93b0pJblZ1YVhGMVpTMTJaVzVrYjNJdGFXUmxiblJwWm1sbGNpSWdQU0FpTmtFd1JqTXpNalF0TXpsRVF5MDBNall4TFVGQ01EQXROekUwTVRVNU1FSTFNMEUySWpzS0NTSndjbTlrZFdOMExXbGtJaUE5SUNKRVJFTXdNRGdpT3dvSkltbDBaVzB0YVdRaUlEMGdJakV5TkRNek9UWXhOelVpT3dvSkltSnBaQ0lnUFNBaVkyOXRMbWRtWlc1bkxrUmhlVVJoZVVOdmIyc2lPd29KSW5CMWNtTm9ZWE5sTFdSaGRHVXRiWE1pSUQwZ0lqRTBPVFl6TURjMU9UQXdNalFpT3dvSkluQjFjbU5vWVhObExXUmhkR1VpSUQwZ0lqSXdNVGN0TURZdE1ERWdNRGc2TlRrNk5UQWdSWFJqTDBkTlZDSTdDZ2tpY0hWeVkyaGhjMlV0WkdGMFpTMXdjM1FpSUQwZ0lqSXdNVGN0TURZdE1ERWdNREU2TlRrNk5UQWdRVzFsY21sallTOU1iM05mUVc1blpXeGxjeUk3Q2draWIzSnBaMmx1WVd3dGNIVnlZMmhoYzJVdFpHRjBaU0lnUFNBaU1qQXhOeTB3Tmkwd01TQXdPRG94T1RveE9DQkZkR012UjAxVUlqc0tmUT09IjsKCSJlbnZpcm9ubWVudCIgPSAiU2FuZGJveCI7CgkicG9kIiA9ICIxMDAiOwoJInNpZ25pbmctc3RhdHVzIiA9ICIwIjsKfQ==";
		receipt = URLDecoder.decode(receipt,"utf-8");

		// System.out.println(IOSVerifyUtil.getFromBASE64(s));

		System.out.println(IOSVerifyUtil.buyAppVerify(receipt, false));
		// 返回的结果：
		/*
		 * { "receipt": { "original_purchase_date_pst":
		 * "2017-06-01 01:19:18 America/Los_Angeles", "purchase_date_ms":
		 * "1496307590024", "unique_identifier":
		 * "bb8c3d646575a3293ae68151d74a36969dde5fe5",
		 * "original_transaction_id": "1000000303655657", "bvrs": "1.0",
		 * "transaction_id": "1000000303670765", "quantity": "1",
		 * "unique_vendor_identifier": "6A0F3324-39DC-4261-AB00-7141590B53A6",
		 * "item_id": "1243396175", "product_id": "DDC008", "purchase_date":
		 * "2017-06-01 08:59:50 Etc/GMT", "original_purchase_date":
		 * "2017-06-01 08:19:18 Etc/GMT", "purchase_date_pst":
		 * "2017-06-01 01:59:50 America/Los_Angeles", "bid":
		 * "com.gfeng.DayDayCook", "original_purchase_date_ms": "1496305158000"
		 * }, "status": 0 }
		 */
	}

}
