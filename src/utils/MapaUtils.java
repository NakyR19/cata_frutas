package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * classe que lê o arquivo mapa e pega informações necessárias.
 * 
 * @author NakyR19 - Rafael
 */
public class MapaUtils {

    /**
     * le dimensões do mapa
     * 
     * @param arquivoMapa  o arquivo que contém informações do mapa
     * @return              dimensão do mapa, -1 em caso de erro    
     * 
     * @author NakyR19 - Rafael
     */
    public int lerDimensaoDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("dimensao")) {
                    // A linha tem o formato: "dimensao <valor>"
                    String[] partes = linha.split(" ");
                    if (partes.length == 2) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 em caso de erro
    }

    /**
     * Função para ler a o número de Pedras do mapa a partir do arquivo.
     * 
     * @author NakyR19 - Rafael
     * @param arquivoMapa O arquivo que contém o mapa.
     * @return A dimensão do mapa.
     * @throws IOException Se ocorrer um erro ao ler o arquivo.
     */
    public int lerNumPedrasDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("pedras")) {
                    // A linha tem o formato: "dimensao <valor>"
                    String[] partes = linha.split(" ");
                    if (partes.length == 2) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 em caso de erro
    }

    /**
    * Lê o número de laranjeiras do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das laranjeiras.
    * @return O número de laranjeiras encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author  Gustavo Assunção
    */
    public int lerNumLaranjeirasDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("laranja")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de laranjas do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das laranjas.
    * @return O número de laranjas encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumLaranjas(File arquivoMapa){
        try(BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("laranja")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3){
                        return Integer.parseInt(partes[2]);
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de goiabeiras do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das goiabeiras.
    * @return O número de goiabeiras encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumGoiabeirasDoMapa(File arquivoMapa){
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("goiaba")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de goiabas do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das goiabas.
    * @return O número de goiabas encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumGoiabasDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("goiaba")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[2]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de coqueiros do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das coqueiros.
    * @return O número de coqueiros encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumCoqueirosDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("coco")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de coco do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das coco.
    * @return O número de coco encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumCocosDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("coco")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[2]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de amoreiras do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das amoreiras.
    * @return O número de amoreiras encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumAmoreirasDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("amora")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de Amoras do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das Amoras.
    * @return O número de Amoras encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumAmorasDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("amora")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[2]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de Aceroleiras do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das aceroleiras.
    * @return O número de aceroleiras encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumAceroleirasDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("acerola")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de acerolas do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das acerolas.
    * @return O número de acerolas encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumAcerolasDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("acerola")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[2]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de abacateiros do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das abacateiros.
    * @return O número de abacateiros encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumAbacateirosDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("abacate")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de abacates do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das abacates.
    * @return O número de abacates encontrado no mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumAbacatesDoMapa(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("abacate")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[2]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê a chance das frutas serem bichadas a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações
    * @return A chance em porcentagem das frutas estarem bichadas, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerChanceBichadas(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("bichadas")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
    * Lê o número de Maracujas no chao do mapa a partir de um arquivo.
    *
    * @param arquivoMapa O arquivo que contém o mapa com as informações das Maracujas.
    * @return O número de Maracujas encontrado no chao do mapa, ou -1 se ocorrer um erro ou se o formato estiver incorreto.
    * @author Gustavo Assunção
    */
    public int lerNumMaracujas(File arquivoMapa){
        try(BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("maracuja")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3){
                        return Integer.parseInt(partes[2]);
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Le a capacidade da mochila apartir de um arquivo
     * 
     * @param arquivoMapa o arquivo que foi lido
     * @return  capacidade da mochila, -1 em caso de erro;
     * 
     * @author NakyR19 - Rafael
     */
    public int lerCapacidadeMochila(File arquivoMapa) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.startsWith("mochila")) {
                    // A linha tem o formato: "dimensao <valor>"
                    String[] partes = linha.split(" ");
                    if (partes.length == 2) {
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1; // Retorna -1 em caso de erro
    }

    /**
     * Le o numero de maracujas totais apartir de um arquivo mapa
     * 
     * @param arquivoMapa   o arquivo que foi lido
     * @return              quantidade de maracujas totais,-1 em caso de erro;
     */
    public int lerNumMaracujasTotais(File arquivoMapa){
        try(BufferedReader br = new BufferedReader(new FileReader(arquivoMapa))){
            String linha;
            while((linha = br.readLine()) != null) {
                if(linha.startsWith("maracuja")){
                    String[] partes = linha.split(" ");
                    if(partes.length == 3){
                        return Integer.parseInt(partes[1]);
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return -1;
    }
}
