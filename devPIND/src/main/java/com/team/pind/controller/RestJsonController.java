package com.team.pind.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.UUID;


import org.apache.commons.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.pind.vo.ProductVO;

//ajax-controller 리스트 리턴 시 JSON 타입으로 자동으로 변환하여 반환한다.
@RestController
public class RestJsonController{

	/** * 캡쳐된 화면 서버 저장 * @param request * @return * @throws Exception */
	@ResponseBody
	@RequestMapping(value = "imageCreate", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public Object createImage(String binaryData) throws Exception {
		System.out.println(binaryData);
		FileOutputStream stream = null;
		ArrayList<String> resultStr = new ArrayList<String>();
		String str = "";
		String s = "";
		String kind = "";
		String color = "";
		try {
			System.out.println("binary file " + binaryData);
			if (binaryData == null || binaryData == "") {
				throw new Exception();
			}
			binaryData = binaryData.replaceAll("data:image/png;base64,", "");
			byte[] file = Base64.decodeBase64(binaryData);
			System.out.println("file :::::::: " + file + " || " + file.length);
			String fileName = UUID.randomUUID().toString();
			stream = new FileOutputStream("c:\\PINDMediaServer\\" + fileName + ".png");
			stream.write(file);
			stream.close();
			System.out.println("파일 작성 완료");

			String fileNames = fileName + ".png";

			System.out.println("Executing python code");
			Process p = Runtime.getRuntime().exec("python C:/sts-workspace/PINDOrigin/obdetect.py " + fileNames);
			// Process p = Runtime.getRuntime().exec("python
			// C:/sts-workspace/PIND/obdetect.py " +"momo.jpg");
			Process pC = Runtime.getRuntime().exec("python C:/sts-workspace/PINDOrigin/obdetectColor.py " + fileNames);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream(), "MS949"));
			BufferedReader stdInputColor = new BufferedReader(new InputStreamReader(pC.getInputStream(), "MS949"));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream(), "MS949"));

			System.out.println("python should be run.");
			int i = 0;

			// 결과값 문자열 처리(상품명만 뽑아야 함)
			while ((kind = stdInput.readLine()) != null && (color = stdInputColor.readLine()) != null) {
				String result = color + " " + kind;
				resultStr.add(result);
			}
			HashSet<String> distinctString = new HashSet<String>(resultStr);
			resultStr = new ArrayList<String>(distinctString);

			System.out.println("Here is the standard error of the command (if any):\n");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}
		} catch (Exception e) {
			System.out.println("파일이 정상적으로 넘어오지 않았습니다");
			e.printStackTrace();
		} finally {
			stream.close();

		}
		return resultStr;
	}

	@ResponseBody
	@RequestMapping(value = "searchProduct", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public ArrayList<ProductVO> searchProduct(String searchText) throws IOException {
		ArrayList<ProductVO> sList = new ArrayList<ProductVO>();
		
		String s = "";
		String str = "";
		searchText = searchText.replaceAll(" ", "+");
		Process p1 = Runtime.getRuntime().exec("python C:/sts-workspace/PINDOrigin/productSearch.py " + searchText);
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p1.getInputStream(), "MS949"));
		String[] item;

		while ((s = stdInput.readLine()) != null) {
			str += s + "\n";
		}
		System.out.println(str);
		item = str.split(": ");

		for (int i = 0; i < item.length; i++) {
			if (item[i].indexOf("\"title\"") != -1) {
				ProductVO pVO = new ProductVO();
				pVO.setProductTitle(item[i + 1].replaceAll("\"link\"", "").trim().split(",")[0].replace("\"", ""));
				pVO.setProductURL(item[i + 2].replaceAll("\"image\"", "").trim().split(",")[0]);
				pVO.setProductImage(item[i + 3].replaceAll("\"lprice\"", "").trim().split(",")[0]);
				pVO.setProductLPrice(Integer
						.parseInt((item[i + 4].replaceAll("\"hprice\"", "").trim().split(",")[0].replace("\"", ""))));
				sList.add(pVO);
			}
		}
		
		MiniComparator comp = new MiniComparator();
		Collections.sort(sList, comp);

		return sList;
	}

}

class MiniComparator implements Comparator<ProductVO>{
	@Override
	public int compare(ProductVO pv1, ProductVO pv2){
		int firstValue = pv1.getProductLPrice();
		int secondValue = pv2.getProductLPrice();
		
		if(firstValue > secondValue){
			return 1;
		}else if (firstValue < secondValue){
			return -1;
		}else{
			return 0;
		}
	}
}