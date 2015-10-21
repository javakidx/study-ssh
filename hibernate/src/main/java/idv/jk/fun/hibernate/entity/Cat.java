package idv.jk.fun.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CAT")
public class Cat 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="mother_id")
	private Cat mother;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Cat getMother()
	{
		return mother;
	}

	public void setMother(Cat mother)
	{
		this.mother = mother;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
}
