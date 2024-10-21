package models.ambiente;

import java.util.Random;
import models.elementos.Elemento;
import models.elementos.dinamicos.Abacate;
import models.elementos.dinamicos.Acerola;
import models.elementos.dinamicos.Amora;
import models.elementos.dinamicos.Coco;
import models.elementos.dinamicos.Goiaba;
import models.elementos.dinamicos.Laranja;
import models.elementos.dinamicos.Maracuja;
import models.elementos.dinamicos.Player;
import models.elementos.estaticos.Arvore;
import models.elementos.estaticos.Grama;
import models.elementos.estaticos.Pedra;

/**
 * Floresta representa uma matriz composta por elementos.
 */
public class Floresta {
  /**
   * ############ ATRIBUTOS ############
   * dimensao - A dimensão da floresta (número de linhas e colunas).
   * elementos - A matriz de elementos que compõem a floresta.
   * numPedras - O número de pedras existentes na floresta.
   */
  private int dimensao;
  private Elemento[][] elementos;
  private int numPedras;
  private int numLaranjeiras;
  private int numLaranjas;
  private int numGoiabeiras;
  private int numGoiabas;
  private int numCoqueiros;
  private int numCocos;
  private int numAmoreiras;
  private int numAmoras;
  private int numAceroleiras;
  private int numAcerolas;
  private int numAbacateiros;
  private int numAbacates;
  private int numMaracujas;
  private int numMaracujasTotais;
  private int chanceBichadas;
  private int capacidadeMochila;


  /**
   * ############ CONSTRUTOR ############
   * @param dimensao  a dimensão da floresta
   * @param numPedras o número de pedras na floresta
   */
  public Floresta(int dimensao, int numPedras, int numLaranjeiras, int numLaranjas, int numGoiabeiras, int numGoiabas, int numCoqueiros, int numCocos, int numAmoreiras,
   int numAmoras, int numAceroleiras, int numAcerolas, int numAbacateiros, int numAbacates, int numMaracujas, int numMaracujasTotais, int chanceBichadas, int capacidadeMochila) {
    this.numPedras = numPedras;
    this.dimensao = dimensao;
    this.numLaranjeiras = numLaranjeiras;
    this.numLaranjas = numLaranjas;
    this.numGoiabeiras = numGoiabeiras;
    this.numGoiabas = numGoiabas;
    this.numCoqueiros = numCoqueiros;
    this.numCocos = numCocos;
    this.numAmoreiras = numAmoreiras;
    this.numAmoras = numAmoras;
    this.numAceroleiras = numAceroleiras;
    this.numAcerolas = numAcerolas;
    this.numAbacateiros = numAbacateiros;
    this.numAbacates = numAbacates;
    this.numMaracujas = numMaracujas;
    this.numMaracujasTotais = numMaracujasTotais;
    this.chanceBichadas = chanceBichadas;
    this.capacidadeMochila = capacidadeMochila;
    this.elementos = new Elemento[dimensao][dimensao]; // Matriz c os elementos
    gerarFlorestaVazia();
    gerarPedras();
    gerarLaranjeiras();
    gerarLaranjas();
    gerarGoiabeiras();
    gerarGoiabas();
    gerarCoqueiros();
    gerarCocos();
    gerarAmoreiras();
    gerarAmoras();
    gerarAceroleiras();
    gerarAcerolas();
    gerarAbacateiros();
    gerarAbacates();
    gerarMaracujas();
    gerarPlayers();
  }

  /**
     * @author NakyR19 - Rafael
     * Gera a floresta sem outros elementos além de grama.
     */
  public void gerarFlorestaVazia() {
    for (int i = 0; i < getDimensao(); i++) {
      for (int j = 0; j < getDimensao(); j++) {
        elementos[i][j] = new Grama(i, j); // Cada posição está vazia (sem elementos)
      }
    }
  }

  /**
     * @author NakyR19 - Rafael
     * Gera pedras aleatoriamente na floresta.
     */
  public void gerarPedras() {
    Random gerador = new Random();
    int pedrasColocadas = 0;
    while (pedrasColocadas < numPedras) {
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if (elementos[x][y] instanceof Grama) {
        elementos[x][y] = new Pedra(x, y);
        pedrasColocadas++;
      }
    }

  }

  /**
     * @author redbdb - Gustavo Assunção
     * Gera laranjeiras aleatoriamente na floresta.
     */
  public void gerarLaranjeiras(){
    Random gerador = new Random();
    for(int i = 0; i < numLaranjeiras; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Arvore(x, y, "laranjeira", chanceBichadas);
        i++;
      }
    }
  }

  /**
     * @author redbdb - Gustavo Assunção
     * Gera laranjas aleatoriamente na floresta.
     */
  public void gerarLaranjas(){
    Random gerador = new Random();
    for(int i = 0; i < numLaranjas; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Laranja(x, y, chanceBichadas);
        i++;
      }
    }
  }

  /**
     * @author redbdb - Gustavo Assunção
     * Gera Goiabeiras aleatoriamente na floresta.
     */
  public void gerarGoiabeiras(){
    Random gerador = new Random();
    for(int i = 0; i < numGoiabeiras; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Arvore(x, y, "goiabeira", chanceBichadas);
        i++;
      }
    }
  }
  
  /**
     * @author redbdb - Gustavo Assunção
     * Gera Goiabas aleatoriamente na floresta.
     */
  public void gerarGoiabas(){
    Random gerador = new Random();
    for(int i = 0; i < numGoiabas; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Goiaba(x, y, chanceBichadas);
        i++;
      }
    }
  }
    
  /**
     * @author redbdb - Gustavo Assunção
     * Gera Coqueiros aleatoriamente na floresta.
     */
  public void gerarCoqueiros(){
    Random gerador = new Random();
    for(int i = 0; i < numCoqueiros; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Arvore(x, y, "coqueiro", chanceBichadas);
        i++;
      }
    }
  }
  
  /**
     * @author redbdb - Gustavo Assunção
     * Gera Cocos aleatoriamente na floresta.
     */
  public void gerarCocos(){
    Random gerador = new Random();
    for(int i = 0; i < numCocos; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Coco(x, y, chanceBichadas);
        i++;
      }
    }
  }

  /**
   * @author redbdb - Gustavo Assunção
   * Gera Amoreiras aleatoriamente na floresta.
   */
  public void gerarAmoreiras(){
    Random gerador = new Random();
    for(int i = 0; i < numAmoreiras; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Arvore(x, y, "amoreira", chanceBichadas);
        i++;
      }
    }
  }
  
  /**
     * @author redbdb - Gustavo Assunção
     * Gera Amoras aleatoriamente na floresta.
     */
  public void gerarAmoras(){
    Random gerador = new Random();
    for(int i = 0; i < numAmoras; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Amora(x, y, chanceBichadas);
        i++;
      }
    }
  }

  /**
   * @author redbdb - Gustavo Assunção
   * Gera Aceroleiras aleatoriamente na floresta.
   */
  public void gerarAceroleiras(){
    Random gerador = new Random();
    for(int i = 0; i < numAceroleiras; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Arvore(x, y, "aceroleira", chanceBichadas);
        i++;
      }
    }
  }
  
  /**
     * @author redbdb - Gustavo Assunção
     * Gera Acerolas aleatoriamente na floresta.
     */
  public void gerarAcerolas(){
    Random gerador = new Random();
    for(int i = 0; i < numAcerolas; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Acerola(x, y, chanceBichadas);
        i++;
      }
    }
  }

  /**
   * @author redbdb - Gustavo Assunção
   * Gera Abacateiros aleatoriamente na floresta.
   */
  public void gerarAbacateiros(){
    Random gerador = new Random();
    for(int i = 0; i < numAbacateiros; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Arvore(x, y, "abacateiro", chanceBichadas);
        i++;
      }
    }
  }
  
  /**
     * @author redbdb - Gustavo Assunção
     * Gera Abacates aleatoriamente na floresta.
     */
  public void gerarAbacates(){
    Random gerador = new Random();
    for(int i = 0; i < numAbacates; ){
      int x = gerador.nextInt(getDimensao());
      int y = gerador.nextInt(getDimensao());
      if(elementos[x][y] instanceof Grama){
        elementos[x][y] = new Abacate(x, y, chanceBichadas);
        i++;
      }
    }
  }

  /**
     * @author redbdb - Gustavo Assunção
     * Gera Maracujas aleatoriamente na floresta.
     */
    public void gerarMaracujas(){
      Random gerador = new Random();
      for(int i = 0; i < numMaracujas; ){
        int x = gerador.nextInt(getDimensao());
        int y = gerador.nextInt(getDimensao());
        if(elementos[x][y] instanceof Grama){
          elementos[x][y] = new Maracuja(x, y, chanceBichadas);
          i++;
        }
      }
    }

  /**
     * @author NakyR19 - Rafael
     * Gera os jogadores na floresta.
     */
    public void gerarPlayers() {
      Random gerador = new Random();
      int playerColocados = 0;
      String[] ids = {"p1", "p2"};
      
      while (playerColocados < 2) {
          int x = gerador.nextInt(6);
          int y = gerador.nextInt(6);
          if (elementos[x][y] instanceof Grama) {
              elementos[x][y] = new Player(x, y, ids[playerColocados], capacidadeMochila);
              System.out.println("Gerando jogador " + ids[playerColocados] + " na posição (" + x + ", " + y + ")");
              playerColocados++;
          }
      }


  }

  /**
 * Percorre a matriz afim de coletar o jogador presente na floresta.
 * @author NakyR19 - Rafael
 * @param id Id do jogador
 * @return o jogador presente na floresta, ou null se não houver jogador.
 */
public Player getPlayer(String id) {
  for (int i = 0; i < dimensao; i++) {
      for (int j = 0; j < dimensao; j++) {
          if (elementos[i][j] instanceof Player) {
              Player player = (Player) elementos[i][j];
              if (player.getId().equals(id)) {
                  return player;
              }
          }
      }
  }
  return null; 
}
  
  /**
   * Verifica se há uma colisão na posição especificada.
   * @author NakyR19 - Rafael
   * @param x a coordenada x da posição a ser verificada.
   * @param y a coordenada y da posição a ser verificada.
   * @return true se houver uma colisão, false caso contrário.
   */
  public boolean isCollision(int x, int y) {
    // Verifica se a posição está dentro dos limites
    if (x < 0 || x >= dimensao || y < 0 || y >= dimensao) {
      return true; // Fora dos limites é considerado uma colisão
    }
    // Verifica se a posição está ocupada por um elemento Pedra
    return (elementos[x][y] instanceof Pedra);
  }

  /**
   * Seta um piso de coordenadas (x,y) como grama
   * @author NakyR19 - Rafael
   * @param x coordenada
   * @param y coordenada
   */
  public void setTileAsGrama(int x, int y) {
    elementos[x][y] = new Grama(x, y);
  }
  public int getCapacidadeMochila() {
    return capacidadeMochila;
  }

  public void setCapacidadeMochila(int capacidadeMochila) {
    this.capacidadeMochila = capacidadeMochila;
  }
  public int getDimensao() {
    return dimensao;
  }

  public void setDimensao(int d) {
    this.dimensao = d;
  }

  public Elemento[][] getElementos() {
    return elementos;
  }

  public void setElementos(Elemento[][] e) {
    this.elementos = e;
  }

  public int getNumMaracujasTotais(){
    return numMaracujasTotais;
  }

  public int getNumMaracujas(){
    return numMaracujas;
  }

  public int getChanceBichadas(){
    return this.chanceBichadas;
  }
}
