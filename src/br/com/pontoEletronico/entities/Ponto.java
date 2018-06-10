package br.com.pontoEletronico.entities;

import br.com.pontoEletronico.converters.LocalDateConverter;
import br.com.pontoEletronico.converters.LocalTimeConverter;
import br.com.pontoEletronico.intefaces.Bean;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Index;
import org.eclipse.persistence.annotations.Indexes;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "MOV_PONTO")
@Indexes(value = {
    @Index(name = "idx_data", columnNames = {"dataPonto"})
    ,
    @Index(name = "idx_hora", columnNames = {"horario"})
})
@NamedQueries(value = {
    @NamedQuery(name = "ponto.findAll", query = "SELECT pt FROM Ponto AS pt")
    ,
    @NamedQuery(name = "ponto.findFolha", query = "SELECT pt FROM Ponto AS pt WHERE pt.folha.id = :paramFolha")
    ,
    @NamedQuery(name = "ponto.findByFuncionario", query = "SELECT pt FROM Ponto AS pt WHERE pt.folha.funcionario.matricula = :paramFuncionario")
})
@SequenceGenerator(name = "ponto_seq", sequenceName = "seq_ponto", allocationSize = 1, initialValue = 1)
public class Ponto implements Serializable, Bean<Ponto> {

    private Long id;
    private FolhaPonto folha;
    private LocalDate dataPonto;
    private LocalTime horario;
    private int tipo;
    public static final int ENTRADA = 1, SAIDA = 2;

    public Ponto() {
    }

    public Ponto(FolhaPonto folha, LocalDate dataPonto, LocalTime horario, int tipo) {
        this.folha = folha;
        this.dataPonto = dataPonto;
        this.horario = horario;
        this.tipo = tipo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ponto_seq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH, targetEntity = FolhaPonto.class)
    public FolhaPonto getFolha() {
        return folha;
    }

    public void setFolha(FolhaPonto folha) {
        this.folha = folha;
    }

    @Convert(converter = LocalDateConverter.class)
    @Column(name = "DATA_PONTO", length = 10, nullable = false)
    public LocalDate getDataPonto() {
        return dataPonto;
    }

    public void setDataPonto(LocalDate dataPonto) {
        this.dataPonto = dataPonto;
    }

    @Convert(converter = LocalTimeConverter.class)
    @Column(name = "HORA_PONTO", length = 5, nullable = false)
    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    @Column(name = "TIPO", nullable = false)
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public void clear() {
        this.id = null;
        this.folha = null;
        this.dataPonto = null;
        this.horario = null;
        this.tipo = 0;
    }

    @Override
    public void copiar(Ponto object) {
        this.id = object.getId();
        this.folha = object.getFolha();
        this.dataPonto = object.getDataPonto();
        this.horario = object.getHorario();
        this.tipo = object.getTipo();
    }

    @Override
    public Ponto clonar() {
        Ponto p = new Ponto(folha, dataPonto, horario, tipo);
        p.setId(id);
        return p;
    }

}
