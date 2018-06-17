
package br.com.pontoEletronico.listeners;

import br.com.pontoEletronico.dal.EntityManagerHelper;
import br.com.pontoEletronico.entities.FolhaPonto;
import br.com.pontoEletronico.entities.Funcionario;
import br.com.pontoEletronico.frames.Form_Cad_Funcionario;
import br.com.pontoEletronico.frames.Form_Menu_Gestao;
import br.com.pontoEletronico.frames.Form_Menu_Principal;
import br.com.pontoEletronico.intefaces.ListenerAbstractDefaultAdapter;
import br.com.pontoEletronico.util.Calculos;
import br.com.pontoEletronico.util.ControleInstancias;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Listener_Menu_Gestao extends ListenerAbstractDefaultAdapter<Form_Menu_Gestao> {

    private static final long serialVersionUID = -5503341429024563808L;
    private EntityManagerHelper emh = new EntityManagerHelper();

    public Listener_Menu_Gestao(Form_Menu_Gestao form) {
        super(form);
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent acEvent) {
        super.actionPerformed(acEvent);
        switch (acEvent.getActionCommand()) {
            case "verFolha":
                JOptionPane.showConfirmDialog(form, "Em desenvolvimento! Não seja apressado!");
                break;
            case "verHoras":
                verHorasTrabalhadas();
                break;
            case "exportarFolha":
                exportarFolhaPonto();
                break;
            case "voltar":
                Form_Menu_Principal menu = (Form_Menu_Principal) ControleInstancias.getInstance(Form_Menu_Principal.class.getName());
                menu.setVisible(true);
                break;
            case "cadastrarFunc":
                Form_Cad_Funcionario cad_func = (Form_Cad_Funcionario) ControleInstancias.getInstance(Form_Cad_Funcionario.class.getName());
                cad_func.setVisible(true);
                break;
        }
    }

    private void verHorasTrabalhadas() {
        try {
            int matricula = Integer.parseInt(JOptionPane.showInputDialog("Qual a matricula do funcionário? (Somente o número - EX: 1)", null));
            String dia = JOptionPane.showInputDialog("Qual o dia que deseja? (Ex: 10/06/2018)", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            if (!dia.equals("")) {
                Funcionario funcionario = (Funcionario) emh.getObjectNamedQuery(Funcionario.class, "funcionario.findByMatricula", "paramMatricula", matricula, EntityManagerHelper.MYSQL_PU);
                List<FolhaPonto> folha = emh.getObjectListNamedQuery(FolhaPonto.class, "folha.findByMesFunc", new String[]{"paramFuncionario", "paramMes"}, new Object[]{funcionario, LocalDate.parse(dia, DateTimeFormatter.ofPattern("dd/MM/yyyy")).format(DateTimeFormatter.ofPattern("MM/yyyy"))}, EntityManagerHelper.MYSQL_PU);
                folha.forEach(fl -> {
                    JOptionPane.showMessageDialog(form, Calculos.getHorasTrabalhadas(fl, LocalDate.parse(dia, DateTimeFormatter.ofPattern("dd/MM/yyyy"))), "Horas Trabalhadas", JOptionPane.INFORMATION_MESSAGE);
                });
            } else {
                JOptionPane.showMessageDialog(form, "Dados de entrada inválidos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "Erro de entrada de dados");
            e.printStackTrace();
        }
    }

    private void exportarFolhaPonto() {
        try {
            int matricula = Integer.parseInt(JOptionPane.showInputDialog("Qual a matricula do funcionário? (Somente o número - EX: 1)", null));
            String dia = JOptionPane.showInputDialog("Qual o dia que deseja? (Ex: 10/06/2018)", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            if (!dia.equals("")) {
                File file = null;
                Funcionario funcionario = (Funcionario) emh.getObjectNamedQuery(Funcionario.class, "funcionario.findByMatricula", "paramMatricula", matricula, EntityManagerHelper.MYSQL_PU);
                List<FolhaPonto> folha = emh.getObjectListNamedQuery(FolhaPonto.class, "folha.findByMesFunc", new String[]{"paramFuncionario", "paramMes"}, new Object[]{funcionario, LocalDate.parse(dia, DateTimeFormatter.ofPattern("dd/MM/yyyy")).format(DateTimeFormatter.ofPattern("MM/yyyy"))}, EntityManagerHelper.MYSQL_PU);
                folha.forEach(fl -> {
                    JFileChooser fc = new JFileChooser();
                    fc.setSize(200, 150);
                    fc.removeChoosableFileFilter(fc.getAcceptAllFileFilter());
                    fc.addChoosableFileFilter(new FileNameExtensionFilter("Folha de Ponto", "txt"));
                    fc.showDialog(form, "Salvar");
                    if (fc.getApproveButtonMnemonic() == JFileChooser.APPROVE_OPTION) {
                        //caminho onde o arquivo será gravado
                        //String path = System.getProperty("user.home") + "\\Documents\\FolhaPonto_".concat(fl.getFuncionario().getNome());
                        System.out.println(fc.getCurrentDirectory());
                        String path = fc.getCurrentDirectory() + "\\FolhaPonto_".concat(fl.getFuncionario().getNome());
                        //cria escritor de arquivo
                        FileWriter fw;
                        try {
                            fw = new FileWriter(path.concat(".txt"));
                            //saida de caracteres para arquivo
                            PrintWriter writer = new PrintWriter(fw);
                            if (fl.getListaPonto() != null) {
                                writer.println("------------------------Folha de Ponto---------------------------");
                                writer.println("Nome do Funcionário: " + fl.getFuncionario().getNome() + "\n");
                                fl.getListaPonto().forEach(p -> {
                                    String msg = p.getTipo() + ": " + p.getHorario().format(DateTimeFormatter.ofPattern("HH:mm")) + " - " + p.getDataPonto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                    if (Objects.equals("Entrada", p.getTipo())) {
                                        writer.print(msg);
                                    } else {
                                        writer.println(" - ".concat(msg));
                                    }
                                });
                                writer.println("\n----------------------------------------------------------------");
                            } else {
                                System.out.println("Este funcionário não registrou nenhum ponto até o momento");
                            }

                            //encerra a escrita do arquivo
                            fw.close();
                            JOptionPane.showMessageDialog(form, "Arquivo exportado com sucesso!");
                        } catch (IOException ex) {
                            Logger.getLogger(Listener_Menu_Gestao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            } else {
                JOptionPane.showMessageDialog(form, "Dados de entrada inválidos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(form, "Erro de entrada de dados");
            e.printStackTrace();
        }
    }

}
