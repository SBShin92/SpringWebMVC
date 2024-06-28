package com.example.phonebook.data.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhonebookVO {
	private Integer id;
	private String name;
	private String hp;
	private String tel;

}
