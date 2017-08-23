# ArchitectJava
Some answers for a java architect

## Questão 1
Fiz a opção de utilizar o google kubernetes devido as inumeras features que ele possui como orchestration , autoScale, ExposeApi, Replication dentre outras.

Na parte  direita fiz um desenho de arquitetura da estrutura do google kurbenetes para se ter uma visão de maneira macro como o kubernetes funciona.

Sendo assim na parte da esquerda  fiz o desenho da solução.

- Arquitetura Open-Source
- Escalável
- Solução que pode tanto rodar em serviços cloud como on premise

![Resposta Questão 1](/img/question_one.png)

## Questão 2
A solucação mais simples para esse problema foi a virtualização da aplicação XPTO e utilizaremos um loadBalancer nginx para que tudo continue atendendo de maneira transparente para a aplicação com baixo impacto de ajustes. Tambem utilizaremos o puppet para se caso o volume vier a aumentar podemos criar uma nova vm para que a loja continue atendendo normal em caso de pico de vendas. Podemoriamos tambem customizar a aplicação ou otimizar para que ela processa mais de 5000 por hora , contudo precisariamos de mais informações da aplicação XPTO

- Arquitetura Open-Source
- Escalável
- Solução que pode tanto rodar em serviços cloud como on premise
- Facil utilização e rapida implantação

![Resposta Questão 2](/img/question_two.png)

## Questão 3
- que é Micro Serviço?

  Micro servico nada mais é do que um componente que tem baixo acoplamento e pode ser executado sem depender de ninguem e presenta alguma parte do negocio.
- Porque devemos utilizar?

  a grande vantagem do micro serviço é fugir das aplicações monoliticas e poder escalar pontos especificos da aplicação, sem ter a necessidade de escalar a aplicação toda.
  
- Quais São os Prós e Contras ?

### Pros
1. Os Micro serviços criam flexibilidade quando se trata de escolher a ferramenta ou tecnologia que se quer usar na resolução de problemas.

2. Os Micro serviços podem lidar com o varias versoes de código. A integração pode ser um desafio especialmente quando temos que consumir uma aplica;áo de um terceiro. O risco de romper as integrações diminui quando os Micro serviços são usados pois são muito adaptáveis.
 
3. Os Micro serviços são escaláveis, eles podem ser usados para dividir sistemas que permitem conjuntos de habilidades mais definidos.
 
4. Micro serviços ajudam a isolar os ecossitemas da empresa. Ao usar Micro serviços, sua equipe pode ter as ferramentas necessárias para ajustar uma demanda emergencial mesmo que isso não seja uma boa pratica.

### Contras

1. Mais trabalho de integração. Os Micro serviços pode causar trabalho adicional porque a integração de serviços entre si e outras tecnologias leva tempo. Você precisa ter cuidado para não sobrecarregar e quebrar os Micro serviços.

2. Desdobramento, desenvolvimento. A implantação de vários serviços é mais desafiadora do que a implantação de um único serviço.
 
1. Complexidade cognitiva. Pode tornar quase impossível rastrear o log ou emitir dados de rastreamento entre os limites do serviço. A complexidade da rede tem o potencial para atrapalhar pois o time de network tem que estar bem alinhada com o time de dev.

###  Problema do CEP
o problema do S.E.P é facilmente resolvido com uma apigateway , para ter um unico ponto de entrada para aplicações. Podemos fazer tambem um serviço rest que ira checar a base de cep em memoria utilizando o REDIS , e com isso teremos uma baixa latencia e um serviço e não ira consumir muitos recursos.


## Questão 4

- que é Latência de REDE? 

podemos ter varias definições como, é o tempo que um pacote leva de um ponto a outro até voltar. Porem tambem ele é atribuido ao atraso ou maior tempo de resposta de algum serviço.

- Qual estratégia deve ser implementada para diminuir essa latência?

Podemos fazer varios ajustes como:


1. fazer um tunnig de rede como colocar o database na mesma vlan
2. remover firewall ou qualquer outra coisa que possa estar aumentando o tempo de resposta
3. criar uma infra só para a geração de relatorios
4. criar um banco d+1 para geração de relatorios
5. utlizar uma outra solução para geração de relatorios.


## Questão 5
Com todos os canais de venda utilizando o mesmo serviço para cuidar do estoque, retorno e devolução o problema sera revolvido, tambem utilizaremos um container no kubernetes para se for necessario podemos escalar e toda a orquestração fica por conta do kubernetes.

No desenho de arquitetura abaixo exemplifiquei isso.

![Resposta Questão 5](/img/question_five.png)

## Questão 6
criei uma class para resolver o problema.

```
package com.randomk;

import java.util.regex.Pattern;

public class Main {

    public static final String regex = "([aeiou][bcdfghjklmnpqrstvwxz][aeiou])";


    public static void main(String[] args) {

        String stream = "aAbBABacafe";

        if (checkString(stream)){
            System.out.println("encontrou");

        } else {

            System.out.println("nao encontrou");
        }



    }

    public static boolean checkString(String arg) {
        return Pattern.compile(regex).matcher(arg).find();
    }
}
```

## Questão 7
O modelo cliente-servidor é uma estrutura de aplicação distribuída que divide tarefas ou cargas de trabalho entre os provedores de um recurso ou serviço, chamados servidores e solicitadores de serviço, chamados clientes.

No desenho abaixo detalho a comunição entre um servidor web e um client. tambem detalho o conteudo dentro da requisição.
![Resposta Questão 7](/img/question_seven.png)