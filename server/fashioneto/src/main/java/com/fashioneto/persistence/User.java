/**
 * 
 */
package com.fashioneto.persistence;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterJoinTable;

/**
 * @author Felipe
 */
@Entity
@Table(name = "fashionetoer")
@FilterDef(name = User.PARENT_TYPE_FILTER)
public class User implements Serializable
{
	public static final String PARENT_TYPE_FILTER = "parentTypeFilter";

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "comment_parent", joinColumns = @JoinColumn(name = "id_parent"), inverseJoinColumns = @JoinColumn(name = "id_comment"))
	@FilterJoinTable(name = User.PARENT_TYPE_FILTER, condition = "parent_type == USER")
	//	@OrderBy("date desc")
	private Set<Comment> comments = new LinkedHashSet<Comment>();

	public Set<Comment> getCommentList()
	{
		return comments;
	}

	public void setCommentList(Set<Comment> commentList)
	{
		this.comments = commentList;
	}

	public User()
	{
		//No args constructor
	}

	public User(int id, String username, String email)
	{
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", commentList=" + comments + "]";
	}

}
