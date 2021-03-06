package pe.bconf.study.sample.docker.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class MainController {
    @GetMapping({"/","/index"} )
    public String home() {
        return "index";
    }

    @GetMapping("/test")
    @ResponseBody
    @CrossOrigin("*")
    public Map<String, Object> testClient(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("RemoteAddr",request.getRemoteAddr());
        map.put("LocalAddr", request.getLocalAddr());
        map.put("UserAgent", request.getHeader("user-agent"));
        Enumeration<String> headers = request.getHeaderNames();
        List<Map<String, Object>> listHeader = new ArrayList<>();
        Map<String, Object> tempMap;
        while(headers.hasMoreElements()){
            String str = headers.nextElement();
            tempMap = new HashMap<>();
            tempMap.put(str, request.getHeader(str));
            listHeader.add(tempMap);
        }
        String currentAccessIp =
                request.getHeader("X-Forwarded-For") == null ?
                        request.getRemoteAddr() :
                        request.getHeader("X-Forwarded-For");
        map.put("requestIP", currentAccessIp);
        map.put("headers", listHeader);
        HttpSession session = request.getSession();
        session.setAttribute("testData", request.getHeader("user-agent"));
        return map;
    }

    @RequestMapping(value = "/jsonpTest", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object jsonpTest(){
        Map<String, Object> map = new HashMap<>();
        map.put("test", "JSONP");
        map.put("type", "JSONP");

        return map;
    }
}

