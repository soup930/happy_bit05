package vs.ka.ka_001_1.service;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import vs.ka.ka_001_1.vo.KakaoPayApprovalVO;
import vs.ka.ka_001_1.vo.KakaoPayReadyVO;

@Service
public class kakaoPay{
    // document.getElementsByClassName("link_gnb")[1].click()
    // document.getElementById("userPhone").value="01055754786";
    // document.getElementById("userBirth").value="931229";
    // document.getElementsByClassName("btn_payask")[0].click()
    private static final String HOST = "https://kapi.kakao.com";
    
    @Autowired
    private KakaoPayReadyVO kakaoPayReadyVO;
    @Autowired
    private KakaoPayApprovalVO kakaoPayApprovalVO;


    public String kakaoPayReady(HashMap<String, String> map, String co_b_index) {
        RestTemplate restTemplate = new RestTemplate();      
        System.out.println("여기2");
        System.out.println(co_b_index);
        System.out.println(map.get("amount"));
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders(); 
        headers.add("Authorization", "KakaoAK " + "8ec6da08852e69c18cf741295349d6b8");
       // headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
       // headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        headers.add("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"); 
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");  //가맹점코드, 10자, 테스트버전아닐시 카카오한테서 cid받아야함
        params.add("partner_order_id", "1");    //가맹점 주문번호, 최대100자
        params.add("partner_user_id","이찬영");   //가맹점 회원id, 최대100자, 회원넣자
        params.add("item_name", "비트캠프마라톤");        //상품명, 최대100자
        params.add("quantity", "1");    //상품수량, integer타입
        params.add("total_amount", "1");  //상품총액 integer타입
        params.add("tax_free_amount", "0");   //상품비과세 금액, integer타입
        params.add("approval_url", "http://localhost:8080/kakaoPaySuccess?co_b_index="+co_b_index+"");    //결제성공시 redirect url
        params.add("cancel_url", "http://localhost:8080/kakaoPayCancel");       //결제취소시 redirect url
        params.add("fail_url", "http://localhost:8080/kakaoPaySuccessFail");    //결제실패시 redirect url
       
         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        try {
        	System.out.println("오냐?");
            kakaoPayReadyVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);         
            //요청한 클라이언트가 pc 웹일 경우 redirect. 카카오톡으로 TMS를 보내기 위한 사용자입력화면이으로 redirect
            System.out.println("와 뭐야 ㅡㅡ" + kakaoPayReadyVO.getNext_redirect_pc_url());
            //return kakaoPayReadyVO.getNext_redirect_pc_url(); 
            return kakaoPayReadyVO.getNext_redirect_pc_url();
        } catch (RestClientException e) {
        	System.out.println("Rest 에러");  
        	e.printStackTrace();
        } catch (URISyntaxException e) {
        	System.out.println("url 에러");
            e.printStackTrace();
        }     
        System.out.println("여기3");
        return "/pay";     
    }


    public KakaoPayApprovalVO kakaoPayInfo(String pg_token, String amount) {
        //log.info("KakaoPayInfoVO............................................");
        System.out.println("전달받은 어마운트랑 아이디 : " + amount);
        System.out.println("pg_token : " + pg_token);
        System.out.println("kakaoPayInfo 메소드 도착");
        RestTemplate restTemplate = new RestTemplate();     
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "8ec6da08852e69c18cf741295349d6b8");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        System.out.println("kakaoPayReadyVO : " + kakaoPayReadyVO);
        System.out.println("kakaoPayApprovalVO : " + kakaoPayApprovalVO);
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        System.out.println(kakaoPayReadyVO.getTid());
        params.add("cid", "TC0ONETIME");
        params.add("tid", kakaoPayReadyVO.getTid()); //결제 고유 번호 20자 
        params.add("partner_order_id", "1");  
        params.add("partner_user_id", "이찬영");   //회원 정보넣자
        params.add("pg_token", pg_token);
        params.add("total_amount", amount);
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        try {                     
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            //kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/order?cid=TC0ONETIME&tid="+kakaoPayReadyVO.getTid()), body, KakaoPayApprovalVO.class);
            System.out.println("kakaoPayApprovalVO : "+kakaoPayApprovalVO);
            return kakaoPayApprovalVO;      
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }       
        return null;
    }
    
}