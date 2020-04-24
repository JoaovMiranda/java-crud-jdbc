# java-crud-jdbc

 Um simples exemplo de CRUD feito para Java JDBC e MySQL.
 
## Sobre  
 * Feito sob encomenda para atender a pesquisadores de mercado.  
 * Útil para agilizar atividades e tarefas diárias simples como salvar clientes.  

## Guia :clipboard:  

  * Para gerar um banco de dados compativel utilize a query:  
```sql
CREATE DATABASE cadastro;
USE cadastro;
CREATE TABLE usuario (
    id INT(20) NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    idade VARCHAR(255),
    genero VARCHAR(1),
    email VARCHAR(255),
    tel VARCHAR(255),
    classe VARCHAR(1),
    estadocivil VARCHAR(1),
    profissao VARCHAR(255),
    filhos VARCHAR(1),
    participacao VARCHAR(1),
    tipo VARCHAR(255),
    observacao VARCHAR(255),
    rg VARCHAR(255),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(255),
    rua VARCHAR(255),
    PRIMARY KEY (id)
);
```  

  * Os campos a serem salvos são:
    * Nome - Nome do cliente;
    * Idade - Data de nascimento do cliente (dd/MM/aaaa);  
    * Genero - Genero sexual do cliente (M ou F);
    * Email - Email do cliente (xxx@xxx.xxx);
    * Tel - Telefone do cliente ((##) #####-####);
    * Classe - Classe social do cliente (A,B,C ou D);  
    * Estadocivil - Estado civil do cliente (S,C,V);  
    * Profissao - Profissão do cliente;  
    * Filhos - Se o cliente tem ou não filhos (S ou N);  
    * Participacao - Se o cliente já participou de uma pesquisa de mercado (S ou N);  
    * Tipo - Especifica a pesquisa **se** o cliente participou;  
    * Rg - Registro geral do cliente (#.###-###);  
    * Bairro - Bairro em que reside o cliente;  
    * Cidade - Cidade em que reside o cliente;  
    * Estado - Estado em que reside o cliente;  
    * Rua - Rua em que reside o cliente;  
    * Observacao - Algum detalhe sobre o cliente;  
    
  * A aplicação tem função de adcionar, editar, visualizar e deletar usuarios.  
  
    ![Config](https://github.com/JoaovMiranda/java-crud-jdbc/blob/master/imgs/mainview.png)  
  
  * A busca filtra os clientes por sua classe social.  
  
    ![Config](https://github.com/JoaovMiranda/java-crud-jdbc/blob/master/imgs/detalhedview.png)
