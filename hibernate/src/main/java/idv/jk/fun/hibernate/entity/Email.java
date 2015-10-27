package idv.jk.fun.hibernate.entity;

import javax.persistence.*;

/**
 * Created by javakid on 2015/10/27.
 */
@Entity
@Table(name = "tb_email")
public class Email
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
