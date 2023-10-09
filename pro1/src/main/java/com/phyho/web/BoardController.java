package com.phyho.web;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String board() {
		List<Map<String, Object>> list = boardService.boardList();
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		json.put("list", arr);
		//System.out.println(json.toString());
		return json.toString();
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(name="bno", required=true)int bno){
		Map<String, Object> detail = boardService.detail(bno);
		JSONObject json = new JSONObject();
		json.put("detail", detail);
		//System.out.println(json.toString());
		//{"detail":{"bno":727,"commentcount":0,"m_name":"뽀로로","bdate":"2023-10-07","bip":"DESKTOP-ERR5D88/172.30.1.99","btitle":"글하나","bcontent":"더쓴다.","blike":1,"m_id":"pororo"}}
		return json.toString();
	}

	
	@PostMapping("/write")
	public String write(@RequestBody Map<String, Object> map) {
		//System.out.println(map); //{title=제목쓰고 , content=내용쓰}
		int result = boardService.write(map);
		JSONObject json = new JSONObject();
		json.put("result", result);
		//System.out.println(json.toString());
		return json.toString();
	}
	
}