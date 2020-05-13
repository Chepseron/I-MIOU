/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amon.Sabul
 */
@Entity
@Table(name = "lending")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lending.findAll", query = "SELECT l FROM Lending l")
    , @NamedQuery(name = "Lending.findByIdlending", query = "SELECT l FROM Lending l WHERE l.idlending = :idlending")
    , @NamedQuery(name = "Lending.findByAmount", query = "SELECT l FROM Lending l WHERE l.amount = :amount")
    , @NamedQuery(name = "Lending.findByDatelent", query = "SELECT l FROM Lending l WHERE l.datelent = :datelent")
    , @NamedQuery(name = "Lending.findByCurrentbalance", query = "SELECT l FROM Lending l WHERE l.currentbalance = :currentbalance")})
public class Lending implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlending")
    private Integer idlending;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datelent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentbalance")
    private int currentbalance;
    @JoinColumn(name = "lender", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private Users lender;
    @JoinColumn(name = "borrower", referencedColumnName = "idusers")
    @ManyToOne(optional = false)
    private Users borrower;

    public Lending() {
    }

    public Lending(Integer idlending) {
        this.idlending = idlending;
    }

    public Lending(Integer idlending, int amount, Date datelent, int currentbalance) {
        this.idlending = idlending;
        this.amount = amount;
        this.datelent = datelent;
        this.currentbalance = currentbalance;
    }

    public Integer getIdlending() {
        return idlending;
    }

    public void setIdlending(Integer idlending) {
        this.idlending = idlending;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDatelent() {
        return datelent;
    }

    public void setDatelent(Date datelent) {
        this.datelent = datelent;
    }

    public int getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(int currentbalance) {
        this.currentbalance = currentbalance;
    }

    public Users getLender() {
        return lender;
    }

    public void setLender(Users lender) {
        this.lender = lender;
    }

    public Users getBorrower() {
        return borrower;
    }

    public void setBorrower(Users borrower) {
        this.borrower = borrower;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlending != null ? idlending.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lending)) {
            return false;
        }
        Lending other = (Lending) object;
        if ((this.idlending == null && other.idlending != null) || (this.idlending != null && !this.idlending.equals(other.idlending))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Lending[ idlending=" + idlending + " ]";
    }
    
}
