package CadAgenda;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
public class Agenda extends WindowAdapter implements ActionListener{
    private Frame janela;
    private Panel painelEndereco,painelBotoes;
    private Label lCodigo, lNome, lEndereco, lFone, lCelular,lSexo;
    private TextField tCodigo, tNome, tEndereco, tFone, tCelular;
    private TextArea tObs;
    private Button bNovo, bSalva,bExclui,bProximo,bAnterior;
    private CheckboxGroup cbgSexo;
    private Checkbox masculino, feminino;
    private Vector vContatos;
    private int posicao;

//Método Construtor Criacão de vetor, frame
    public Agenda(){
        vContatos=new Vector();
        janela = new Frame();
        janela.setTitle("Agenda");
        janela.setSize(370,414);
        janela.setBackground(new Color(160,160,160));
        janela.setLayout(null);
        janela.addWindowListener(this);

//Método Construtor Criacão de Painel
        painelEndereco = new Panel();
        painelEndereco.setBackground(new Color(128,128,128));
        painelEndereco.setSize(350,234);
        painelEndereco.setLocation(10,80);
        painelEndereco.setLayout(null);

//Método Construtor Criacão de Painel
        painelBotoes = new Panel();
        painelBotoes.setBackground(new Color(64,128,128));
        painelBotoes.setSize(350,34);
        painelBotoes.setLocation(10,344);
        painelBotoes.setLayout(new FlowLayout());

//Método Construtor Criacão de Labels
        lCodigo = new Label("Codigo:");
        lNome = new Label("Nome:");
        lEndereco = new Label("Endereco:");
        lFone = new Label("Fone:");
        lCelular = new Label("Celular:");
        lSexo = new Label("Sexo:");

//Método Construtor Criacão de TextFields
        tCodigo = new TextField(10);
        tNome = new TextField(45);
        tEndereco = new TextField(60);
        tFone = new TextField(8);
        tCelular = new TextField(9);

//Substituição do item pelo compomente especificado, na posicao indicada
        lCodigo.setBounds(10,15,50,13);
        tCodigo.setBounds(70,12,50,19);
        lNome.setBounds(10,37,50,13);
        tNome.setBounds(70,34,240,19);
        lEndereco.setBounds(10,59,60,13);
        tEndereco.setBounds(70,56,270,19);
        lFone.setBounds(10,83,60,13);
        tFone.setBounds(70,80,86,19);
        lCelular.setBounds(180,83,50,13);
        tCelular.setBounds(240,80,80,19);
        lSexo.setBounds(10,105,30,13);

//Método Construtor Criacão de CheckboxGroup
        cbgSexo = new CheckboxGroup();
        masculino = new Checkbox("Masculino",false,cbgSexo);
        feminino = new Checkbox("Feminino",false,cbgSexo);
        masculino.setBounds(70,102,90,19);
        feminino.setBounds(160,102,90,19);

//Método Construtor Criacão de de TextArea
        tObs = new TextArea("",15,90,TextArea.SCROLLBARS_BOTH);
        tObs.setBounds(10,132,330,90);

//Adiciona no frame painelEndereco os componentes criados
        painelEndereco.add(lCodigo);
        painelEndereco.add(tCodigo);
        painelEndereco.add(lNome);
        painelEndereco.add(tNome);
        painelEndereco.add(lEndereco);
        painelEndereco.add(tEndereco);
        painelEndereco.add(lFone);
        painelEndereco.add(tFone);
        painelEndereco.add(lCelular);
        painelEndereco.add(tCelular);
        painelEndereco.add(lSexo);
        painelEndereco.add(tObs);
        painelEndereco.add(masculino);
        painelEndereco.add(feminino);

//Método Construtor Criacao de botoes e ativa o escutator(listener)
        bNovo = new Button("Novo");
        bNovo.addActionListener(this);
        bSalva = new Button("Salvar");
        bSalva.addActionListener(this);
        bExclui = new Button("Excluir");
        bExclui.addActionListener(this);
        bProximo=new Button("Próximo");
        bProximo.addActionListener(this);
        bAnterior=new Button("Anterior");
        bAnterior.addActionListener(this);

//Adiciona no frame painelBotões os botoes criados
        painelBotoes.add(bNovo);
        painelBotoes.add(bSalva);

        painelBotoes.add(bExclui);

        painelBotoes.add(bProximo);

        painelBotoes.add(bAnterior);

//Adiciona na Janela os frames
        janela.add(painelEndereco);
        janela.add(painelBotoes);

//Desabilita os Botões quando inicia o programa
        bExclui.setEnabled(false);
        bAnterior.setEnabled(false);
        bProximo.setEnabled(false);
    }

//Adiciona o conteúdo no vetor(setText)
    public void setCodigo(String codigo){
        tCodigo.setText(codigo);
    }
    public void setNome(String nome){
        tNome.setText(nome);
    }
    public void setEndereco(String endereco){
        tEndereco.setText(endereco);
    }
    public void setFone(String fone){
        tFone.setText(fone);
    }
    public void setCelular(String celular){
        tCelular.setText(celular);
    }
    public void setObs(String Obs){
        tObs.setText(Obs);
    }
    public void setSexo(String sexo) {
        if (sexo != null) {
            if (sexo.equals("F")) feminino.setState(true);
            else if (sexo.equals("M")) masculino.setState(true);
        }
    }
    public void setMenuBar(MenuBar mb) {
        janela.setMenuBar(mb);
    }

//Retorna o conteúdo(=objeto) que está no vetor
    public String getCodigo(){
        return tCodigo.getText();
    }
    public String getNome(){
        return tNome.getText();
    }
    public String getEndereco(){
        return tEndereco.getText();
    }
    public String getFone(){
        return tFone.getText();
    }
    public String getCelular(){
        return tCelular.getText();
    }

    public String getObs(){
        return tObs.getText();
    }

    public String getSexo() {
        if (masculino.getState() == true) return "M";
        else if (feminino.getState() == true) return "F";
        else return " ";
    }

//Verificação de qual dos botões foi acionado para chamar os procedimentos
    public void actionPerformed(ActionEvent e) {
        Button b=(Button)e.getSource();
        if (b==bNovo) this.botaoNovo();
        else if (b==bSalva) this.botaoSalva();
        else if (b==bExclui) this.botaoExclui();
        else if (b==bAnterior) this.botaoAnterior();
        else if (b==bProximo) this.botaoProximo();
    }

//Ação do botão Novo
    void botaoNovo() {
        this.limpaDados();
        bExclui.setEnabled(false);
        bAnterior.setEnabled(false);
        bProximo.setEnabled(false);
        tCodigo.requestFocus();
    }

//Ação do botão salva
    public void botaoSalva() {
        vContatos.addElement(new Contato(getCodigo(),getNome(),getEndereco(),getFone(),getCelular(),getSexo(),getObs()));
        bExclui.setEnabled(true);
        bAnterior.setEnabled(true);
        bProximo.setEnabled(true);
    }

//Ação do botão Exclui
    void botaoExclui() {
        if(!vContatos.isEmpty())
            vContatos.removeElementAt(posicao);
    }

//Ação do botão Anterior
    void botaoAnterior() {
        if(!vContatos.isEmpty()){
            bProximo.setEnabled(true);
            --posicao;
            if(posicao<=0) {
                posicao=0;
                bAnterior.setEnabled(false);
            }
            this.obterDadosContatos(posicao);
        }
    }

//Ação do botão Proximo
    void botaoProximo() {
        if(!vContatos.isEmpty()){
            bAnterior.setEnabled(true);
            ++posicao;
            if(posicao>=vContatos.size()-1) {
                posicao=vContatos.size()-1;
                bProximo.setEnabled(false);
            }
            this.obterDadosContatos(posicao);
        }
    }

//Limpa Campos
    public void limpaDados() {
        this.setCodigo("");
        this.setNome("");
        this.setEndereco("");
        this.setFone("");
        this.setCelular("");
        this.setObs("");
    }

//Obtem dados
    public void obterDadosContatos(int pos) {
        Contato contatoAtual=(Contato)vContatos.elementAt(pos);
        this.setCodigo(contatoAtual.getCodigo());
        this.setNome(contatoAtual.getNome());
        this.setEndereco(contatoAtual.getEndereco());
        this.setFone(contatoAtual.getFone());
        this.setCelular(contatoAtual.getCelular());
        this.setSexo(contatoAtual.getSexo());
        this.setObs(contatoAtual.getObs());
    }

//Fecha a janela
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    public void mostraAgenda(){
        janela.setVisible(true);
    }

    public static void main(String[] args) {
//Criação da Agenda
        Agenda agenda = new Agenda();
        agenda.mostraAgenda();
    }
}


























