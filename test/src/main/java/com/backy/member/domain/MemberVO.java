package com.backy.member.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//기본생성자를 만들어라
@AllArgsConstructor //전체 항목을 넣을 수 있는 생성자
public class MemberVO {
		   private String memId;
		   private String memPwd;
		   private String memName;
		   private String email;
		   private String postCode;
		   private String detailAddress;
		   private String regidate;

}
