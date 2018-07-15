package org.myazure.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.myazure.response.StatusResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController extends BaseController {

	public WebController() {

	}

	private static final Logger LOG = LoggerFactory
			.getLogger(WebController.class);

	@RequestMapping(path = "/debug", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void debugInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String str = "";
		InputStream in = request.getInputStream();
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader bd = new BufferedReader(reader);
		String inputLine = "";
		while ((inputLine = bd.readLine()) != null) {
			str += inputLine;
		}
		LOG.debug(str);
		System.err.println(str+"12321");
		Document doc = Jsoup.parse(str);
		// 根据id获取table
		Element table = doc.getElementById("kbtable");
		// 使用选择器选择该table内所有的<tr> <tr/>
		Elements trs = table.select("tr");
		// 遍历该表格内的所有的<tr> <tr/>
		for (int i = 0; i < trs.size(); ++i) {
			// 获取一个tr
			Element tr = trs.get(i);
			// 获取该行的所有td节点
			Elements tds = tr.select("td");
			// 选择某一个td节点
			for (int j = 0; j < tds.size(); ++j) {
				Element td = tds.get(j);
				// 获取td节点的所有div
				Elements divs = td.select("div");
				// 选择一个div
				for (int k = 0; k < divs.size(); k++) {
					Element div = divs.get(k);
					// 获取文本信息
					String text = div.text();
					// 输出到控制台
					System.out.println(text);
				}
			}
		}
		sentResponse(response, new StatusResponse("sucess", 0, true));

	}

}
