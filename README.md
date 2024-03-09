# Sistema de Mesclagem de Arquivos

O sistema de Mesclagem de Arquivos é uma utilidade baseada em Java projetada para mesclar múltiplos arquivos de texto em um único arquivo de saída. Ele aproveita o poder do multithreading para melhorar a eficiência do processo de mesclagem de arquivos. Este documento fornece uma visão geral abrangente do sistema, incluindo como configurá-lo, usá-lo e compreender sua estrutura.

## Visão Geral do Sistema

O sistema de Mesclagem de Arquivos consiste em uma classe principal (`MergeFilesWithThreads`) e uma classe auxiliar (`FileMerger`) que implementa a interface `Runnable`. A classe principal inicia o processo de mesclagem criando uma thread separada para cada arquivo de entrada, permitindo a leitura simultânea de vários arquivos e a escrita em um único arquivo de saída de maneira sincronizada. Esta abordagem não só acelera o processo de mesclagem, mas também mantém a integridade do arquivo de saída, prevenindo que operações de escrita concorrentes interfiram umas com as outras.

## Funcionalidades

- **Multithreading:** Utiliza múltiplas threads para ler de vários arquivos de entrada simultaneamente, melhorando a eficiência geral do processo de mesclagem de arquivos.
- **Escrita Sincronizada:** Garante que apenas uma thread por vez possa escrever no arquivo de saída, prevenindo corrupção de dados devido a escritas concorrentes.
- **Manipulação Dinâmica de Entrada:** Facilmente adaptável para trabalhar com qualquer número de arquivos de entrada, tornando-o versátil para vários casos de uso.

## Como Usar

1. **Prepare Seu Ambiente:** Certifique-se de ter o Java instalado no seu sistema. Este sistema foi desenvolvido e testado com Java SE 8 ou superior.

2. **Arquivos de Entrada:** Coloque todos os seus arquivos de texto de entrada (por exemplo, `frases1.txt`, `frases2.txt`, `frases3.txt`) em um diretório acessível ao programa.

3. **Compile o Código:** Abra um terminal ou prompt de comando no diretório contendo seus arquivos `.java` e compile-os usando o compilador Java:
    ```
    javac MergeFilesWithThreads.java
    ```

4. **Execute o Programa:** Execute o código compilado com o interpretador Java:
    ```
    java MergeFilesWithThreads
    ```
    Isso iniciará o processo de mesclagem de arquivos, criando uma thread para cada arquivo de entrada especificado no array `filePaths` dentro do método `main`.

5. **Verifique a Saída:** Após a conclusão, um novo arquivo (`todasFrases.txt`) contendo o conteúdo mesclado de todos os arquivos de entrada será gerado.

## Estrutura do Sistema

- **FileMerger (Implementação de `Runnable`):** Esta classe é responsável pela funcionalidade central de ler de um arquivo de entrada e escrever seu conteúdo no arquivo de saída. Ela implementa a interface `Runnable` do Java, permitindo que instâncias dela sejam executadas por threads.

- **Método de Escrita Sincronizada:** Um método sincronizado (`writeToFileSynchronized`) garante que apenas uma thread possa escrever no arquivo de saída por vez, prevenindo potencial corrupção de dados.

- **Classe Principal (MergeFilesWithThreads):** O ponto de entrada do sistema, que inicializa e começa uma thread para cada arquivo de entrada especificado.

## Requisitos

- Java SE 8 ou superior.

## Conclusão

O sistema de Mesclagem de Arquivos oferece uma solução robusta e eficiente para mesclar vários arquivos de texto em um único arquivo, aproveitando os recursos de concorrência do Java. Seu design permite fácil adaptação e escalabilidade para acomodar números variáveis de arquivos de entrada, tornando-o uma ferramenta valiosa para uma ampla gama de tarefas de processamento de dados.
