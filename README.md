## (ANTIGO - MODIFICAR)
## Sobre o programa 
Simulação de atendimento e caixa para uma lanchonete fast-food. Pelo menu principal é possível simular a criação de um pedido, selecionando opções de comidas e seus ingredientes, visualizar os pedidos pendentes, entregar um pedido e acompanhar o saldo do caixa. Cada opção selecionada leva para seu próprio menu, onde o usuário insere um nome ou um número para fazer as ações desejadas. As informações sobre a execução do programa são impressas por via terminal.
## Diagrama UML
![diagrama UML](img/UML.png)
O diagrama em boa qualidade pode ser visualizado em /img/UML.png
Ele tem 23 classes, com 06 heranças distintas no total (06 classes pai diferentes).
## Compilação e execução do código

Passo-a-passo:

    1. verifique se você está na pasta /projeto-lp2/ , se você estiver em /projeto/ pode apenas dar cd ..
    
    2. você pode compilar o código utilizando o comando "make" do Makefile
    
    3. execute o código digitando "make test"
    
## Uso
0. Menu principal
    - ao iniciar o programa exibe um menu com 05 opções principais
    -     [1] Cadastrar pedido
          [2] Entregar pedido
          [3] Pedidos pendentes
          [4] Verificar saldo do caixa
          [5] Fechar o caixa
    - você pode digitar o número da opção que deseja no terminal e apertar "Enter" para selecionar a opção.
1. Cadastrar pedido
    - será solicitado que você insira o nome de quem está fez o pedido 
    - um menu com todas as opções de produtos será exibido
    -     [1] Hamburguer (simples/ duplo/ triplo)
          [2] Croc (simples/ parmegiana/ americano)
          [3] X-salada
          [4] X-egg bacon burguer
          [5] Burguer americano(simples/ duplo/ triplo)
          [6] Box-combo
          [7] Sorvete (chocolate/ misto/ creme)
          [8] Porções (Batata/ Filé de frango empanado)
          [9] Bebida
          [10] Sair
    - você pode selecionar uma opção de 1 à 9 para ser redirecionado a um menu de seleção de ingredientes / sabor (caso essas opções estejam disponíveis para esse produto)
    - para voltar a tela principal digite 10. Seu produto será finalizado e enviado para ser feito.
2. Entregar pedido
    - um menu com a mensagem "ID do pedido pronto:" você deve digitar o número desse ID e o pedido correspondente será entregue, sendo removido da lista de "Pedidos pendentes" e inserindo seu valor no caixa.
    - os IDs dos produtos pode ser visualizadoem "[3] Pedidos pendentes".
3. Pedidos pendentes
   - uma lista com todos os pedidos pendentes é exibida.
   - cada pedido pendente contém o nome do cliente, o ID do pedido, o preço do pedido e as informações sobre os produtos que foram pedidos.
   - após exibir a lista de pedidos retorna autoaticamente para o menu principal.
4. Verificar saldo do caixa
   - o saldo do caixa em reais é exibido
   - retorna automaticamente para o menu principal.
5. Fechar o caixa
   - uma mensagem indicando que o caixa está se preparando para fechar é exibida.
   - o caixa verifica se não há pedidos pendentes.
   - se não houver nenhum pedido pendente o saldo total do caixa é exibido e o programa fecha automaticamente.
   - o caixa não fecha se houver algum pedido pendente.
## Auto-teste
O programa tem 02 funções, que podem ser encontradas na Main, que testam o comportamento das classes para propósitos de manutenção e correção de erros. Por padrão ficam desativadas, as instruções para uso estão no código nas linhas 11-23 da Main.
