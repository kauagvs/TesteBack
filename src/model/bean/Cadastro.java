/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Kaua Semenov
 */
public class Cadastro {
    
   private int id_customer;
   private long cpf_cnpj;
   private String nm_customer;
   private String is_active;
   private long vl_total;

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public long getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(long cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNm_customer() {
        return nm_customer;
    }

    public void setNm_customer(String nm_customer) {
        this.nm_customer = nm_customer;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public long getVl_total() {
        return vl_total;
    }

    public void setVl_total(long vl_total) {
        this.vl_total = vl_total;
    }

    
  
    
}
