package br.com.pontoEletronico.entities;

import br.com.pontoEletronico.intefaces.Bean;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Index;
import org.eclipse.persistence.annotations.Indexes;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "CAD_FOLHA_PONTO")
@Indexes(value = {
    @Index(name = "idx_func", columnNames = {"funcionario"})
})
@NamedQueries(value = {
    @NamedQuery(name = "folha.findAll", query = "SELECT fl FROM FolhaPonto AS fl"),
    @NamedQuery(name = "folha.findByMesRef", query = "SELECT fl FROM FolhaPonto AS fl WHERE fl.mesReferencia = :paramMes"),
    @NamedQuery(name = "folha.findByFuncionario", query = "SELECT fl FROM FolhaPonto AS fl WHERE fl.funcionario.matricula = :paramFuncionario")
})
@SequenceGenerator(name = "folha_seq", sequenceName = "seq_folha", allocationSize = 1, initialValue = 1)
public class FolhaPonto implements Serializable, Bean<FolhaPonto> {

    private static final long serialVersionUID = -9105471585174539067L;

    private Long id;
    private String mesReferencia;
    private Funcionario funcionario;
    private List<Ponto> listaPonto;

    public FolhaPonto() {
    }

    public FolhaPonto(String mesReferencia, Funcionario funcionario, List<Ponto> listaPonto) {
        this.mesReferencia = mesReferencia;
        this.funcionario = funcionario;
        this.listaPonto = listaPonto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "folha_seq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "MES_REFERENCIA", length = 7, nullable = false)
    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    @JoinColumn(referencedColumnName = "matricula", name = "funcionario", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Funcionario.class)
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Ponto.class)
    public List<Ponto> getListaPonto() {
        return listaPonto;
    }

    public void setListaPonto(List<Ponto> listaPonto) {
        this.listaPonto = listaPonto;
    }

    @Override
    public void clear() {
        this.id = null;
        this.mesReferencia = null;
        this.funcionario = null;
        this.listaPonto = null;
    }

    @Override
    public void copiar(FolhaPonto object) {
        this.id = object.getId();
        this.mesReferencia = object.getMesReferencia();
        this.funcionario = object.getFuncionario();
        this.listaPonto = object.getListaPonto();
    }

    @Override
    public FolhaPonto clonar() {
        FolhaPonto f = new FolhaPonto(mesReferencia, funcionario, listaPonto);
        f.setId(id);
        return f;
    }

}
