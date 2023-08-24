package com.backy.member.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BoardVO {
	private long boardNo;//long 보다 Long 을 더 권장한다. Long 타입에는 숫자 뒤에 L을 붙여줘야함
    private String title;
    private String contents;
    private String writer;
    private String writeDate;
	public BoardVO() {
		
	}
	public BoardVO(long boardNo, String title, String contents, String writer) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}
	
    
}
