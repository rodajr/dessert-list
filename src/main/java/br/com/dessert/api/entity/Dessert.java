package br.com.dessert.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dessert")
@DynamicUpdate
public class Dessert implements Serializable {

	private static final long serialVersionUID = -92956450150069655L;
	
	@Id
	@GeneratedValue
	@Column(name = "dessert_id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@JsonIgnore
	@Column(name = "created")
	private Date created;
	
	@JsonIgnore
	@Column(name = "modified")
	private Date modified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "{\nid : " + id + ", \nname : " + name + ", \ncreated : " + created + ", \nmodified : " + modified
				+ "\n}";
	}
}
