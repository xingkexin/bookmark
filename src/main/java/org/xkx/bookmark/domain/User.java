package org.xkx.bookmark.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户表
 * @author 小天狼x
 *
 */
@Entity
@Table(name = "AUTH_USER")
public class User {
	@Id
	private Long id;
	@Column(length = 20)
	private String nickname;
	@Column(length = 20)
	private String username;
	@Column(length = 32)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
