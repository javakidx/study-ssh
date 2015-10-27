package idv.jk.fun.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by javakid on 2015/10/27.
 */
@Entity
@Table(name="tb_person2")
public class Person2
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = Email.class,
                cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumns(value = {@JoinColumn(name = "person_id", referencedColumnName = "id")})
    private List<Email> emailList = new ArrayList<Email>();

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
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

    public List<Email> getEmailList()
    {
        return emailList;
    }

    public void setEmailList(List<Email> emailList)
    {
        this.emailList = emailList;
    }
}
