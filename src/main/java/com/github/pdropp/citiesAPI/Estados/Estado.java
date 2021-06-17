package com.github.pdropp.citiesAPI.Estados;

import com.github.pdropp.citiesAPI.paises.Pais;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import javax.persistence.Table;
import javax.persistence.Id;


import javax.persistence.*;
import java.util.List;

@Entity(name = "state")
@Table(name = "estado")
@TypeDefs ({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Estado {

    @Id
    private Long id;

    @Column (name = "nome")
    private String name;

    private String uf;

    private Integer ibge;

    //1st
   // @Column(name = "pais")
   // private Integer countryId;

    // 2nd - @ManyToOne
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Pais pais;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

    public Estado(){

    }

    public Long getID(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getUf(){
        return uf;
    }
    public Integer getIbge(){
        return ibge;
    }

    public List<Integer> getDdd(){
        return ddd;
    }


    public Pais getPais(){
        return pais;
    }

   /* public Integer getCountryId(){
        return countryId;
    }*/



}
