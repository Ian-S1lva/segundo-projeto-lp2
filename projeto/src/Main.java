
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args) throws ListaPendenteException, ListaVaziaException {

        /* ===================================================================================================
        *      -TESTE REMOVER PRODUTOS: executa teste que cria todos os produtos antes de iniciar o programa *
        *       e exibe seus ingredientes                                                                    *
        *      -TESTE CRIAR PRODUTOS: teste que cria todos os produtos antes de iniciar o programa           *
        *        e remove todos seus ingredientes e exibe o resultado                                        *
        * ================================================================================================== * 
        *           <<<<VARIÁVEIS PARA CONFIGURAÇÃO DE TESTES (0 = não executa; 1 = executa)>>>>             *
        =================================================================================================== */
        /**/                                                                                              /**/
        /**/    int rodarTesteCriarProdutos = 1;                                                          /**/
        /**/    int rodarTesteRemoverProdutos = 1;                                                        /**/
        /**/                                                                                              /**/
        /* ================================================================================================= */

        //roda testes antes de executar main, se selecionado
        if(rodarTesteCriarProdutos == 1){
            testeCriarProdutos();        
        }

        //roda testes antes de executar main, se selecionado
        if(rodarTesteRemoverProdutos == 1){
            testeRemoverProdutos();
        }        

        //main
        Caixa caixa = new Caixa();
        int id = 0;        
        int vaifechar = 0;
        while (true){
            System.out.print("\n===== Bem-vindo(a)! =====\n");
            System.out.print("[1] Cadastrar pedido\n[2] Entregar pedido\n[3] Pedidos pendentes\n[4] Verificar saldo do caixa\n[5] Fechar o caixa\n=========================\n");
            Scanner sc = new Scanner(System.in);

            int opc;

            while(true){
                try{
                    System.out.print("Opção: ");
                    opc = sc.nextInt();

                    if(opc < 1 || opc > 5){
                        System.out.print("Opção inválida\n");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e){
                    System.out.print("Inserção inválida\n");
                    sc.nextLine();
                }
            }

            int opc2 = 0;
            int opc3 = 0;
            int opc4 = 0;

            switch (opc){
                case 1:
                    ArrayList <Produtos> produtosPedidoAtual = new ArrayList<>();
                    System.out.print("\n=========================\nNome do pedido(n para cancelar): ");
                    String nome = sc.next();
                    if(Objects.equals(nome, "n")){
                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                        break;
                    }

                    System.out.print("\n=========================\nAdicione produtos ao carrinho:\n");
                    while(true){
                        System.out.print("\n=========================\n[1] Hamburguer (simples/ duplo/ triplo)\n[2] Croc (simples/ parmegiana/ americano)\n[3] X-salada\n[4] X-egg bacon burguer\n[5] Burguer americano(simples/ duplo/ triplo)\n[6] Box-combo\n[7] Sorvete (chocolate/ misto/ creme)\n[8] Porções (Batata/ Filé de frango empanado)\n[9] Bebida\n[10] Concluir\n[11] Cancelar pedido\n\n=========================\n");

                        while (true){
                            try{
                                System.out.print("Opção: ");
                                opc2 = sc.nextInt();
                                if(opc2 < 1 || opc2 > 11){
                                    System.out.print("Opção inválida\n");
                                    continue;
                                }
                                break;
                            } catch (InputMismatchException e){
                                System.out.print("Inserção inválida\n");
                                sc.nextLine();
                            }
                        }
                        if(opc2 == 11){
                            produtosPedidoAtual.clear();
                            System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                            break;
                        }
                        if(opc2 == 10){
                            System.out.print("\n=========================\nPedido concluído! Aguarde a entrega...\n=========================\n");
                            break;
                        }
                        switch (opc2){
                            case 1://hamburguer
                                System.out.print("\n=========================\n[1] Simples\n[2] Duplo\n[3] Triplo\n[4] Cancelar\n=========================\n");

                                while(true){
                                    try{
                                        System.out.print("Opção: ");
                                        opc3 = sc.nextInt();

                                        if(opc3 < 1 || opc3 > 4){
                                            System.out.print("Opção inválida\n");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e){
                                        System.out.print("Inserção inválida\n");
                                        sc.nextLine();
                                    }
                                }
                                if(opc3 == 4){
                                    break;
                                }
                                if(simpDuplTrip(produtosPedidoAtual, opc3) == 1){
                                    System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                    break;
                                }
                                break;
                            case 2://Croc

                                System.out.print("\n=========================\n[1] Simples\n[2] Parmegiana\n[3] Americano\n[4] Cancelar\n=========================\n");

                                while(true){
                                    try{
                                        System.out.print("Opção: ");
                                        opc3 = sc.nextInt();

                                        if(opc3 < 1 || opc3 > 4){
                                            System.out.print("Opção inválida\n");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e){
                                        System.out.print("Inserção inválida\n");
                                        sc.nextLine();
                                    }
                                }
                                if(opc3 == 4){
                                    System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                    break;
                                }
                                if(simpParmAmer(produtosPedidoAtual,opc3) == 1){
                                    System.out.print("\n=========================\nPedido cancelado\n=========================\n");
                                    break;
                                }
                                break;
                            case 3: //X-Salada
                                if(montaXsalada(produtosPedidoAtual) == 1){
                                    System.out.print("\n=========================\nPedido cancelado\n=========================\n");
                                    break;
                                }
                                break;
                            case 4://X-egg bacon burguer
                                if(montaXegg(produtosPedidoAtual) == 1){
                                    System.out.print("\n=========================\nPedido cancelado\n=========================\n");
                                    break;
                                } else {
                                    System.out.print("\n=========================\nX-egg bacon burguer adicionado ao carrinho!\n=========================\n");
                                    break;
                                }
                            case 5://Burguer Americano

                                System.out.print("\n=========================\n[1] Simples\n[2] Duplo\n[3] Triplo\n[4] Cancelar\n=========================\n");

                                while(true){
                                    try{
                                        System.out.print("Opção: ");
                                        opc3 = sc.nextInt();

                                        if(opc3 < 1 || opc3 > 4){
                                            System.out.print("Opção inválida\n");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e){
                                        System.out.print("Inserção inválida\n");
                                        sc.nextLine();
                                    }
                                }
                                if(opc3 == 4){
                                    System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                    break;
                                }
                                if(burSimpDuplTrip(produtosPedidoAtual, opc3) == 1){
                                    System.out.print("\n=========================\nPedido cancelado\n=========================\n");
                                    break;
                                }
                                break;
                            case 6:
                                //Box Combo
                                ArrayList<Produtos> box = new ArrayList<>();
                                
                                System.out.print("\n=========================\nHamburguer 1:\n[1] Hamburguer (simples/ duplo/ triplo)\n[2] Croc (simples/ parmegiana/ americano)\n[3] X-salada\n[4] X-egg bacon burguer\n[5] Burguer americano (simples/ duplo/ triplo)\n[6] Vazio\n[7] Cancelar Pedido\n\n=========================\n");

                                while (true) {
                                    try {
                                        System.out.print("Opção: ");
                                        opc3 = sc.nextInt();
                                        if (opc3 < 1 || opc3 > 7) {
                                            System.out.print("Opção inválida\n");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.print("Inserção inválida\n");
                                        sc.nextLine();
                                    }
                                }
                                if(opc3 == 7){
                                    System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                    break;
                                }
                                
                                if(opc3 == 1){
                                    System.out.print("\n=========================\n[1] Simples\n[2] Duplo\n[3] Triplo\n[4] Cancelar Pedido\n=========================\n");
                                    
                                    while (true) {
                                        try {
                                            System.out.print("Opção: ");
                                            opc4 = sc.nextInt();
                                            if (opc4 < 1 || opc4 > 4) {
                                                System.out.print("Opção inválida\n");
                                                continue;
                                            }
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.print("Inserção inválida\n");
                                            sc.nextLine();
                                        }
                                    }
                                    if(opc4 == 4){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                    if(simpDuplTrip(box, opc4) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                } else if(opc3 == 2) {
                                    System.out.print("\n=========================\n1] Simples\n[2] Parmegiana\n[3] Americano\n[4] Cancelar pedido\n=========================\n");

                                    while (true) {
                                        try {
                                            System.out.print("Opção: ");
                                            opc4 = sc.nextInt();
                                            if (opc4 < 1 || opc4 > 4) {
                                                System.out.print("Opção inválida\n");
                                                continue;
                                            }
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.print("Inserção inválida\n");
                                            sc.nextLine();
                                        }
                                    }
                                    if(opc4 == 4){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                    if(simpParmAmer(box, opc4) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                } else if(opc3 == 3){
                                    if(montaXsalada(box) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                } else if (opc3 == 4){
                                    if(montaXegg(box) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                } else if (opc3 == 5){
                                    System.out.print("\n=========================\n[1] Simples\n[2] Duplo\n[3] Triplo\n[4] Cancelar Pedido\n=========================\n");

                                    while (true) {
                                        try {
                                            System.out.print("Opção: ");
                                            opc4 = sc.nextInt();
                                            if (opc4 < 1 || opc4 > 4) {
                                                System.out.print("Opção inválida\n");
                                                continue;
                                            }
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.print("Inserção inválida\n");
                                            sc.nextLine();
                                        }
                                    }
                                    if(opc4 == 4){
                                        System.out.print("\n=========================\nPedido Cancelado!\n=========================\n");
                                        break;
                                    }
                                    if(burSimpDuplTrip(box, opc4) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                    }
                                } else {
                                   System.out.print("Sem hamburguer 1\n");
                                }
                                //hamburguer 2
                                System.out.print("\n=========================\nHamburguer 2:\n[1] Hamburguer (simples/ duplo/ triplo)\n[2] Croc (simples/ parmegiana/ americano)\n[3] X-salada\n[4] X-egg bacon burguer\n[5] Burguer americano (simples/ duplo/ triplo)\n[6] Vazio\n[7] Cancelar Pedido\n\n=========================\n");

                                while (true) {
                                    try {
                                        System.out.print("Opção: ");
                                        opc3 = sc.nextInt();
                                        if (opc3 < 1 || opc3 > 7) {
                                            System.out.print("Opção inválida\n");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.print("Inserção inválida\n");
                                        sc.nextLine();
                                    }
                                }
                                if(opc3 == 7){
                                    System.out.print("\n=========================\nPedido cancelado\n=========================\n");
                                    break;
                                }

                                if(opc3 == 1){
                                    System.out.print("\n=========================\n[1] Simples\n[2] Duplo\n[3] Triplo\n[4] Cancelar\n=========================\n");

                                    while (true) {
                                        try {
                                            System.out.print("Opção: ");
                                            opc4 = sc.nextInt();
                                            if (opc4 < 1 || opc4 > 4) {
                                                System.out.print("Opção inválida\n");
                                                continue;
                                            }
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.print("Inserção inválida\n");
                                            sc.nextLine();
                                        }
                                    }
                                    if(opc4 == 4){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                    if(simpDuplTrip(box, opc4) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                } else if(opc3 == 2) {
                                    System.out.print("\n=========================\n[1] Simples\n[2] Parmegiana\n[3] Americano\n[4] Cancelar Pedido\n=========================\n");

                                    while (true) {
                                        try {
                                            System.out.print("Opção: ");
                                            opc4 = sc.nextInt();
                                            if (opc4 < 1 || opc4 > 4) {
                                                System.out.print("Opção inválida\n");
                                                continue;
                                            }
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.print("Inserção inválida\n");
                                            sc.nextLine();
                                        }
                                    }
                                    if(opc4 == 4){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                    if (simpParmAmer(box, opc4) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                } else if(opc3 == 3){
                                    if(montaXsalada(box) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                } else if (opc3 == 4){
                                    if(montaXegg(box) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                } else if (opc3 == 5){
                                    System.out.print("\n=========================\n[1] Simples\n[2] Duplo\n[3] Triplo\n[4] Cancelar Pedido\n=========================\n");

                                    while (true) {
                                        try {
                                            System.out.print("Opção: ");
                                            opc4 = sc.nextInt();
                                            if (opc4 < 1 || opc4 > 4) {
                                                System.out.print("Opção inválida\n");
                                                continue;
                                            }
                                            break;
                                        } catch (InputMismatchException e) {
                                            System.out.print("Inserção inválida\n");
                                            sc.nextLine();
                                        }
                                    }
                                    if(opc4 == 4){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                    if(burSimpDuplTrip(box, opc4) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                } else {
                                    System.out.print("Sem hamburguer 2\n");
                                }

                                //bebida 1
                                System.out.print("\n=========================\n[1] Refrigerante (refil/lata)\n[2] Sucos (laranja/dell vale)\n[3] Chá gelado\n[4] Água (mineral/ com gás/ saborizada)\n[5] Vazio\n[6] Cancelar Pedido\n\n=========================\n");

                                while (true) {
                                    try {
                                        System.out.print("Opção: ");
                                        opc3 = sc.nextInt();
                                        if (opc3 < 1 || opc3 > 6) {
                                            System.out.print("Opção inválida\n");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.print("Inserção inválida\n");
                                        sc.nextLine();
                                    }
                                }
                                if(opc3 == 6){
                                    System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                    break;
                                }

                                if(opc3 == 5){
                                    System.out.print("Sem bebida 1\n");
                                } else {
                                    if(bebidaOpc(box, opc3) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                }

                                //bebida 2

                                System.out.print("\n=========================\n[1] Refrigerante (refil/lata)\n[2] Sucos (laranja/dell vale)\n[3] Chá gelado\n[4] Água (mineral/ com gás/ saborizada)\n[5] Vazio\n[6] Cancelar pedido\n\n=========================\n");

                                while (true) {
                                    try {
                                        System.out.print("Opção: ");
                                        opc3 = sc.nextInt();
                                        if (opc3 < 1 || opc3 > 6) {
                                            System.out.print("Opção inválida\n");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.print("Inserção inválida\n");
                                        sc.nextLine();
                                    }
                                }
                                if(opc3 == 6){
                                    System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                    break;
                                }
                                if(opc3 == 5){
                                    System.out.print("Sem bebida 2\n");
                                } else {
                                    if(bebidaOpc(box, opc3) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                }

                                //sorvete
                                System.out.print("\n=========================\nAdicionar sorvete?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

                                while (true) {
                                    try {
                                        System.out.print("Opção: ");
                                        opc3 = sc.nextInt();
                                        if (opc3 < 1 || opc3 > 3) {
                                            System.out.print("Opção inválida\n");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.print("Inserção inválida\n");
                                        sc.nextLine();
                                    }
                                }
                                if(opc3 == 3){
                                    System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                    break;
                                }
                                if(opc3 == 1){
                                    if(montaSorvete(box) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                } else {
                                    System.out.print("Sem sorvete\n");
                                }

                                //porcoes
                                System.out.print("\n=========================\n[1] Batata Frita\n[2] Filé de frango empanado\n[3] Vazio\n[4] Cancelar pedido\n=========================\n");

                                while (true) {
                                    try {
                                        System.out.print("Opção: ");
                                        opc3 = sc.nextInt();
                                        if (opc3 < 1 || opc3 > 4) {
                                            System.out.print("Opção inválida\n");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.print("Inserção inválida\n");
                                        sc.nextLine();
                                    }
                                }
                                if(opc3 == 4){
                                    System.out.print("\n=========================\nPedido cancelado\n=========================\n");
                                    break;
                                }
                                if(opc3 == 3){
                                    System.out.print("Sem porções\n");
                                } else {
                                    batataFile(box, opc3);
                                }

                                //se lista de produtos estiver vazia, lançar execption e cancelar o box no pedido
                                //se nao:
                                Box boxtotal = new Box(box);
                                try{
                                    Verificador a = new Verificador();
                                    a.verificaLista(box);
                                }catch(ListaVaziaException e){
                                    System.out.print(e.getMessage());
                                    break;
                                }
                                produtosPedidoAtual.add(boxtotal);
                                break;
                                //implementa montagem do combo a partir do que da pra colocar
                            case 7://Sorvete
                                if(montaSorvete(produtosPedidoAtual) == 1){
                                    System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                    break;
                                }
                                break;
                            case 8://batata frita
                                System.out.print("\n=========================\n[1] Batata frita\n[2] Filé de frango empanado\n[3] Cancelar pedido\n=========================\n");

                                while (true) {
                                    try {
                                        System.out.print("Opção: ");
                                        opc3 = sc.nextInt();

                                        if (opc3 < 1 || opc3 > 3) {
                                            System.out.print("Opção inválida\n");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.print("Inserção inválida\n");
                                        sc.nextLine();
                                    }
                                }
                                if(opc3 == 3){
                                    System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                    break;
                                }
                                batataFile(produtosPedidoAtual, opc3);
                                break;
                            case 9://bebidas
                                System.out.print("\n=========================\n[1] Refrigerante (refil/lata)\n[2] Sucos (laranja/dell vale)\n[3] Chá gelado\n[4] Água(mineral/ com gás/ saborizada)\n[5] Cancelar pedido\n\n=========================\n");

                                while (true) {
                                    try {
                                        System.out.print("Opção: ");
                                        opc3 = sc.nextInt();

                                        if (opc3 < 1 || opc3 > 5) {
                                            System.out.print("Opção inválida\n");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.print("Inserção inválida\n");
                                        sc.nextLine();
                                    }
                                }

                                if(opc3 == 5){
                                    System.out.print("\n=========================\nPedido canceldo!\n=========================\n");
                                    break;
                                } else {
                                    if(bebidaOpc(produtosPedidoAtual, opc3) == 1){
                                        System.out.print("\n=========================\nPedido cancelado!\n=========================\n");
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                    try {
                        Verificador e = new Verificador();
                        e.verificaLista(produtosPedidoAtual);
                    }catch (ListaVaziaException e){
                        System.out.print(e.getMessage()+"\nPedido cancelado!\n=========================\n");
                        break;
                    }
                    id++;
                    Pedido pedidoatual = new Pedido(id, nome, produtosPedidoAtual);
                    caixa.getPedidos().add(pedidoatual);
                    break;
                case 2:
                    while(true){
                        if(caixa.getPedidos().isEmpty()){
                            System.out.print("\n=========================\nLista de pedidos vazia, adicione um pedido!\n=========================\n");
                            break;
                        }

                        while (true) {
                            try {
                                System.out.print("\n=========================\nID do pedido pronto: ");
                                opc2 = sc.nextInt();

                                if (opc2 < 1) {
                                    System.out.print("Opção inválida/Pedido inexistente\n");
                                    continue;
                                }
                                break;
                            } catch (InputMismatchException e) {
                                System.out.print("Inserção inválida\n");
                                sc.nextLine();
                            }
                        }

                        if(caixa.getPedidos().get(0).getId() < opc2){
                            System.out.print("O pedido "+caixa.getPedidos().get(0).getId()+" de "+caixa.getPedidos().get(0).getNome()+" precisa ser entregue antes de pedidos posteriores\n");
                            break;
                        } else if(caixa.getPedidos().get(0).getId() > opc2){
                            System.out.print("O pedido de id "+opc2+" já foi entregue.\n");
                            break;
                        } else {
                            caixa.addAoValorTotal(caixa.getPedidos().get(0));
                            caixa.getPedidos().remove(0);
                            System.out.print("\n=========================\nPedido do ID: "+opc2+" foi entregue!\n=========================\n");
                            break;
                        }
                    }
                    break;
                    //remove pedido da lista de pedidos pendentes e add saldo ao caixa
                case 3:
                    System.out.print("\n=========================\nPedidos pendentes:\n");
                    caixa.exibePedidosTeste();
                    System.out.print("\n=========================\n");
                    break;
                    //exibe tabela com pedidos pendentes
                case 4:
                    System.out.print("\n=========================\nSaldo atual do caixa: "+caixa.getValorTotal()+"\n=========================\n");
                    break;
                case 5:
                    System.out.print("\n=========================\nPreparando para fechamendo de caixa...\n");
                    try{
                        Verificador s = new Verificador();
                        s.verificaPedidosPendentes(caixa.getPedidos());
                    } catch (ListaPendenteException s){
                        System.out.print(s.getMessage()+"\n=========================\n");
                        break;
                    }
                    System.out.print("\nValor final: "+caixa.getValorTotal()+"\n");
                    System.out.print("\nFechamento concluído!\n=========================\n");
                    vaifechar = 1;
                    break;

            }
            if(vaifechar == 1){
                break;
            }
        } 
    }
    static void testeCriarProdutos(){

        Scanner sc = new Scanner(System.in);
        System.out.print("\n === Executando teste Criar Produtos === \n");
        System.out.print("\nDigite qualquer coisa para prosseguir.\n");
        sc.nextLine();  

        Caixa caixaTeste = new Caixa();
        ArrayList <Produtos> PedidoTeste = new ArrayList<>();

        PedidoTeste.add(new HamburguerSimples(1));
        PedidoTeste.add(new HamburguerSimples(2));
        PedidoTeste.add(new HamburguerDuplo(1));
        PedidoTeste.add(new HamburguerDuplo(2));
        PedidoTeste.add(new HamburguerTriplo());
        PedidoTeste.add(new CrocSimples());
        PedidoTeste.add(new CrocParmegiana());
        PedidoTeste.add(new CrocAmericano());
        PedidoTeste.add(new xSalada());
        PedidoTeste.add(new XeggBaconBurguer());
        PedidoTeste.add(new BurguerAmericano());
        PedidoTeste.add(new BurguerAmericanoDuplo());
        PedidoTeste.add(new BurguerAmericanoTriplo());
        PedidoTeste.add(new Sorvete(1));
        PedidoTeste.add(new Sorvete(2));
        PedidoTeste.add(new Sorvete(3));
        PedidoTeste.add(new BatataFrita());
        PedidoTeste.add(new FileFrangoEmpanado());
        PedidoTeste.add(new Agua(3));
        PedidoTeste.add(new Agua(2));
        PedidoTeste.add(new Agua(1));
        PedidoTeste.add(new BebidaRefrigeranteLata(1));
        PedidoTeste.add(new BebidaRefrigeranteRefil(5));
        PedidoTeste.add(new ChaGelado(1));
        PedidoTeste.add(new Suco(3));

        Pedido PedidoComTudo = new Pedido(1, "ian", PedidoTeste);

        caixaTeste.getPedidos().add(PedidoComTudo);
        caixaTeste.exibePedidosTeste();

        System.out.print("\nTeste finalizado\nDigite qualquer coisa para prosseguir\n");
        sc.nextLine();

    }
    static void testeRemoverProdutos(){

        Scanner sc = new Scanner(System.in);
        System.out.print("\n === Executando teste Remover Produtos === \n");
        System.out.print("\nDigite qualquer coisa para prosseguir.\n");
        sc.nextLine();       

        Caixa caixaTeste = new Caixa();
        ArrayList <Produtos> PedidoTeste = new ArrayList<>();

        Hamburguer hamburguer1 = new HamburguerSimples(1);
        Hamburguer hamburguer2 = new HamburguerSimples(2);
        HamburguerDuplo hamburguerduplo1 = new HamburguerDuplo(1);        
        HamburguerDuplo hamburguerduplo2 = new HamburguerDuplo(2);
        HamburguerTriplo hamburguertriplo = new HamburguerTriplo();
        CrocSimples crocsimples = new CrocSimples();
        CrocParmegiana crocparmegiana = new CrocParmegiana();
        CrocAmericano crocamericano = new CrocAmericano();
        xSalada xsalada = new xSalada();
        XeggBaconBurguer xbb = new XeggBaconBurguer();
        BurguerAmericano burgueramericano = new BurguerAmericano();
        BurguerAmericanoDuplo burgueramericanoduplo = new BurguerAmericanoDuplo();
        BurguerAmericanoTriplo burgueramericanotriplo = new BurguerAmericanoTriplo();

        for(int opc1 = 1; opc1 < 20; opc1++) {
                //hamburguer simples de frango
                // System.out.print("Qual ingrediente deseja remover?\n[1] Hamburguer\n[2] Pão\n[3] Salada\n[4] Molho\n[5] Ovo\n[6] Queijo\n[7] Frango\n[8] Pronto\n");
                while(true) {
                    if(opc1 < 1 || opc1 > 8) {
                        //
                        break;
                    }
                    if(opc1 == 8) {
                        break;
                    } else if(opc1 == 7) {
                        hamburguer1.remove(Ingredientes.values()[opc1]);
                    } else {
                        hamburguer1.remove(Ingredientes.values()[opc1 - 1]);
                    }
                    break;
                }
                //hamburguer simples de carne
                /*// System.out.print("Qual ingrediente deseja remover?\n[1] Hamburguer\n" +
                        "[2] Pão\n[3] Salada\n[4] Molho\n[5] Ovo\n[6] Queijo\n [7] Carne\n[8] Pronto\n");*/
                while(true) {
                    if(opc1 < 1 || opc1 > 8) {
                        break;
                    }
                    if(opc1 == 8) {
                        break;
                    } else {
                        hamburguer2.remove(Ingredientes.values()[opc1 - 1]);
                    }
                    break;
                }
                //hamburguer duplo de frango
                /*// System.out.print("Qual ingrediente deseja remover?\n[1] Hamburguer 1\n" +
                    "[2] Pão\n[3] Salada\n[4] Molho\n[5] Ovo\n[6] Queijo\n[7] Frango\n[8] Salsicha\n[9] Hamburguer 2\n[10] Pronto\n");*/
                while(true) {
                    if(opc1 < 1 || opc1 > 10) {
                        break;
                    }
                    if(opc1 == 10) {
                        break;
                    } else if(opc1 == 7 || opc1 == 8 || opc1 == 9) {
                        hamburguerduplo1.remove(Ingredientes.values()[opc1]);
                    } else {
                        hamburguerduplo1.remove(Ingredientes.values()[opc1 - 1]);
                    }
                    break;
                }
                //hamburguer duplo de carne
                /*
                        // System.out.print("Qual ingrediente deseja remover?\n[1] Hamburguer 1\n" +
                                "[2] Pão\n[3] Salada\n[4] Molho\n[5] Ovo\n[6] Queijo\n[7] Carne\n[8] Salsicha\n[9] Hamburguer 2\n[10] Pronto\n");
                */
                while(true) {
                    if(opc1 < 1 || opc1 > 10) {
                        break;
                    }
                    if(opc1 == 10) {
                        break;
                    } else if(opc1 == 8 || opc1 == 9) {
                        hamburguerduplo2.remove(Ingredientes.values()[opc1]);
                    } else {
                        hamburguerduplo2.remove(Ingredientes.values()[opc1 - 1]);
                    }
                    break;
                }
                //hamburguer triplo
                /*
                // System.out.print("Qual ingrediente deseja remover?\n[1] Hamburguer 1\n" +
                        "[2] Pão\n[3] Salada\n[4] Molho\n[5] Ovo\n[6] Queijo\n[7] Carne\n[8] Frango\n" +
                        "[9] Salsicha\n[10] Hamburguer 2\n [11] Hamburguer 3\n[12] Salada 2\n [13] Pronto\n");
                */
                while(true) {
                    if(opc1 < 1 || opc1 > 13) {
                        break;
                    }
                    if(opc1 == 13) {
                        break;
                    } else {
                        hamburguertriplo.remove(Ingredientes.values()[opc1 - 1]);
                    }
                    break;
                }
                //Croc simples
                /*
                                // System.out.print("Qual ingrediente deseja remover?\n[1] Pão\n[2]Frango Empanado\n" +
                                        "[3] Salada\n[4] Maionese\n[5] Queijo\n[6] Pronto\n");
                */
                while(true) {
                    if(opc1 < 1 || opc1 > 6) {
                        break;
                    }
                    if(opc1 == 6) {
                        break;
                    } else {
                        crocsimples.remove(IngredientesCroc.values()[opc1 - 1]);
                    }
                    break;
                }
                //croc parmegiana
                // System.out.print("Qual ingrediente deseja remover?\n[1] Pão\n" +
                //            "[2] Frango empanado\n[3] Salada\n[4] Maionese\n[5] Queijo\n[6] Molho de tomate\n[7] Tomate (adicional)\n[8] Pronto");
    
                while(true) {
                    if(opc1 < 1 || opc1 > 8) {
                        break;
                    }
                    //remocao
                    if(opc1 == 8) {
                        break;
                    } else {
                        crocparmegiana.remove(IngredientesCroc.values()[opc1 - 1]);
                    }
                    break;
                }
                //Croc americano
                // System.out.print("Qual ingrediente deseja remover?\n[1] Pão\n[2] Frango Empanado\n" +
                //        "[3] Salada\n[4] Maionese\n[5] Queijo\n[6] Salada americana\n[7] Cebola\n[8] Molho defumado\n[9] Pronto\n");
                while(true) {
                    if(opc1 < 1 || opc1 > 9) {
                        break;
                    }
                    //remocao
                    if(opc1 == 9) {
                        break;
                    } else if(opc1 == 6 || opc1 == 7 || opc1 == 8) {
                        crocamericano.remove(IngredientesCroc.values()[opc1 + 1]);
                    } else {
                        crocamericano.remove(IngredientesCroc.values()[opc1 - 1]);
                    }
                    break;
                }
                //X salada
                // System.out.print("Qual ingrediente deseja remover?\n");
                // System.out.print("[1] Pão\n[2] Hamburguer\n[3] Queijo Mussarela\n[4] Tomate\n[5] Alface\n[6] Maionese\n [7] Pronto\n");
                while(true) {
                    if(opc1 < 1 || opc1 > 7) {
                        break;
                    }
                    //remocao
                    if(opc1 == 7) {
                        break;
                    } else {
                        xsalada.remove(IngredientesXSalada.values()[opc1 - 1]);
                        // System.out.print("Ingrediente removido.\n");
                    }
                    break;
                }
                //X egg Bacon burguer
                // System.out.print("Qual ingrediente deseja remover?\n[1] Hamburguer\n" +
                //        "[2] Cheddar\n[3] Ovo\n[4] Bacon\n[5] Maionese\n[6] Pão\n[7] Pronto");
                while(true) {
                    if(opc1 < 1 || opc1 > 7) {
                        break;
                    }
                    //remocao
                    if(opc1 == 7) {
                        break;
                    } else {
                        xbb.remove(IngredientesXBB.values()[opc1 - 1]);
                    }
                    break;
                }
                //Americano simples
                // System.out.print("Qual ingrediente deseja remover?\n[1] Pão\n[2] Hamburguer\n" +
                //        "[3] Salada Americana\n[4] Cebola Picada\n[5] Molho Defumado\n[6] Maionese\n[7] Pronto\n");
                while(true) {
                    if(opc1 < 1 || opc1 > 7) {
                        break;
                    }
                    //remocao
                    if(opc1 == 7) {
                        break;
                    } else {
                        burgueramericano.remove(IngredientesBurguerAmericano.values()[opc1 - 1]);
                        // System.out.print("Ingrediente removido.\n");
                    }
                    break;
                }
                //americano duplo
                // System.out.print("Qual ingrediente deseja remover?\n[1] Pão\n[2] Hamburguer\n" +
                //        "[3] Salada Americana\n[4] Cebola Picada\n[5] Molho Defumado\n[6] Maionese\n[7] Hamburguer 2\n[8] Pronto\n");
                while(true) {
                    if(opc1 < 1 || opc1 > 8) {
                        break;
                    }
                    //remocao
                    if(opc1 == 8) {
                        break;
                    } else {
                        burgueramericanoduplo.remove(IngredientesBurguerAmericano.values()[opc1 - 1]);
                        // System.out.print("Ingrediente removido.\n");
                    }
                    break;
                }
                //americano triplo
                // System.out.print("Qual ingrediente deseja remover?\n[1] Pão\n[2] Hamburguer\n" +
                //        "[3] Salada Americana\n[4] Cebola Picada\n[5] Molho Defumado\n[6] Maionese\n" +
                //        "[7] Hamburguer 2\n[8] Hamburguer 3\n[9] Pronto\n");
                while(true) {
                    if(opc1 < 1 || opc1 > 9) {
                        break;
                    }
                    //remocao
                    if(opc1 == 9) {
                        break;
                    } else {
                        burgueramericanotriplo.remove(IngredientesBurguerAmericano.values()[opc1 - 1]);
                        // System.out.print("Ingrediente removido.\n");
                    }
                    break;
                }    
            //loop            
        }

        PedidoTeste.add(hamburguer1);
        PedidoTeste.add(hamburguer2);
        PedidoTeste.add(hamburguerduplo1);
        PedidoTeste.add(hamburguerduplo2);
        PedidoTeste.add(hamburguertriplo);
        PedidoTeste.add(crocsimples);
        PedidoTeste.add(crocparmegiana);
        PedidoTeste.add(crocamericano);
        PedidoTeste.add(xsalada);
        PedidoTeste.add(xbb);
        PedidoTeste.add(burgueramericano);
        PedidoTeste.add(burgueramericanoduplo);
        PedidoTeste.add(burgueramericanotriplo);

        Pedido PedidoComNada = new Pedido(1, "ian", PedidoTeste);

        caixaTeste.getPedidos().add(PedidoComNada);
        caixaTeste.exibePedidosTeste();
        
        System.out.print("\nTeste finalizado\nDigite qualquer coisa para prosseguir\n");
        sc.nextLine();
    }
    static int montaHambSimp(ArrayList<Produtos> produtos, int i){
        Scanner sc = new Scanner(System.in);
        int opc, opc1;

        if (i == 1) {//hamburguer simples de frango
            Hamburguer hamburguer = new HamburguerSimples(i);

            System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Concluir\n[3] Cancelar pedido\n=========================\n");

            while (true) {
                try {
                    System.out.print("Opção: ");
                    opc = sc.nextInt();

                    if (opc < 1 || opc > 3) {
                        System.out.print("Opção inválida\n");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Inserção inválida\n");
                    sc.nextLine();
                }
            }
            if(opc == 3){
                return 1;
            }
            if (opc == 1) {
                while (true) {
                    System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Hamburguer\n[2] Pão\n[3] Salada\n" +
                            "[4] Molho\n[5] Ovo\n[6] Queijo\n[7] Frango\n[8] Pronto\n[9] Cancelar pedido\n=========================\n");

                    while (true) {
                        try {
                            System.out.print("Opção: ");
                            opc1 = sc.nextInt();

                            if (opc1 < 1 || opc1 > 9) {
                                System.out.print("Opção inválida\n");
                                continue;
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.print("Inserção inválida\n");
                            sc.nextLine();
                        }
                    }
                    if(opc1 == 9){
                        return 1;
                    }
                    if (opc1 == 8) {
                        break;
                    } else if (opc1 == 7) {
                        hamburguer.remove(Ingredientes.values()[opc1]);
                    } else {
                        hamburguer.remove(Ingredientes.values()[opc1 - 1]);
                    }
                }
            }

            produtos.add(hamburguer);
            System.out.print("\n=========================\nHamburguer simples adicionado ao carrinho!\n=========================\n");
            return 0;
        }

        if (i == 2) {//hamburguer simples de carne
            Hamburguer hamburguer = new HamburguerSimples(i);

            System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Concluir\n[3] Cancelar pedido\n=========================\n");

            while (true) {
                try {
                    System.out.print("Opção: ");
                    opc = sc.nextInt();

                    if (opc < 1 || opc > 3) {
                        System.out.print("Opção inválida\n");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Inserção inválida\n");
                    sc.nextLine();
                }
            }
            if(opc == 3){
                return 1;
            }
            if (opc == 1) {
                while (true) {
                    System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Hamburguer\n" +
                            "[2] Pão\n[3] Salada\n[4] Molho\n[5] Ovo\n[6] Queijo\n[7] Carne\n[8] Pronto\n[9] Cancelar pedido\n=========================\n");

                    while (true) {
                        try {
                            System.out.print("Opção: ");
                            opc1 = sc.nextInt();

                            if (opc1 < 1 || opc1 > 9) {
                                System.out.print("Opção inválida\n");
                                continue;
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.print("Inserção inválida\n");
                            sc.nextLine();
                        }
                    }
                    if(opc1 == 9){
                        return 1;
                    }
                    if (opc1 == 8) {
                        break;
                    } else {
                        hamburguer.remove(Ingredientes.values()[opc1 - 1]);
                    }
                }
            }

            produtos.add(hamburguer);
            System.out.print("\n=========================\nHamburguer simples adicionado ao carrinho!\n=========================\n");
            return 0;
        }
        return 1;
    }
    static int montaHambDupl(ArrayList<Produtos> produtos, int i){
        Scanner sc = new Scanner(System.in);
        int opc, opc1;

        if (i == 1) {//hamburguer duplo de frango
            HamburguerDuplo hamburguerDuplo = new HamburguerDuplo(i);

            System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

            while (true) {
                try {
                    System.out.print("Opção: ");
                    opc = sc.nextInt();

                    if (opc < 1 || opc > 3) {
                        System.out.print("Opção inválida\n");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Inserção inválida\n");
                    sc.nextLine();
                }
            }
            if(opc == 3){
                return 1;
            }
            if (opc == 1) {


                while (true) {
                    System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Hamburguer 1\n[2] Pão\n[3] Salada\n[4] Molho\n[5] Ovo\n[6] Queijo\n[7] Frango\n[8] Salsicha\n[9] Hamburguer 2\n[10] Pronto\n[11] Cancelar pedido\n\n=========================\n");

                    while (true) {
                        try {
                            System.out.print("Opção: ");
                            opc1 = sc.nextInt();

                            if (opc1 < 1 || opc1 > 11) {
                                System.out.print("Opção inválida\n");
                                continue;
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.print("Inserção inválida\n");
                            sc.nextLine();
                        }
                    }
                    if(opc1 == 11){
                        return 1;
                    }
                    if (opc1 == 10) {
                        break;
                    } else if (opc1 == 7 || opc1 == 8 || opc1 == 9) {
                        hamburguerDuplo.remove(Ingredientes.values()[opc1]);
                    } else {
                        hamburguerDuplo.remove(Ingredientes.values()[opc1 - 1]);
                    }
                }

            }
            produtos.add(hamburguerDuplo);
            System.out.print("\n=========================\nHamburguer duplo adicionado ao carrinho!\n=========================\n");
            return 0;
        }

        if (i == 2) {//hamburguer duplo de carne
            HamburguerDuplo hamburguerDuplo = new HamburguerDuplo(i);

            System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

            while (true) {
                try {
                    System.out.print("Opção: ");
                    opc = sc.nextInt();

                    if (opc < 1 || opc > 3) {
                        System.out.print("Opção inválida\n");
                        continue;
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Inserção inválida\n");
                    sc.nextLine();
                }
            }
            if(opc == 3){
                return 1;
            }
            if (opc == 1) {


                while (true) {
                    System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Hamburguer 1\n" +
                            "[2] Pão\n[3] Salada\n[4] Molho\n[5] Ovo\n[6] Queijo\n[7] Carne\n[8] Salsicha\n[9] Hamburguer 2\n[10] Pronto\n[11] Cancelar pedido\n=========================\n");

                    while (true) {
                        try {
                            System.out.print("Opção: ");
                            opc1 = sc.nextInt();

                            if (opc1 < 1 || opc1 > 11) {
                                System.out.print("Opção inválida\n");
                                continue;
                            }
                            break;
                        } catch (InputMismatchException e) {
                            System.out.print("Inserção inválida\n");
                            sc.nextLine();
                        }
                    }
                    if(opc1 == 11){
                        return 1;
                    }
                    if (opc1 == 10) {
                        break;
                    } else if (opc1 == 8 || opc1 == 9) {
                        hamburguerDuplo.remove(Ingredientes.values()[opc1]);
                    } else {
                        hamburguerDuplo.remove(Ingredientes.values()[opc1 - 1]);
                    }
                }

            }
            produtos.add(hamburguerDuplo);
            System.out.print("\n=========================\nHamburguer duplo adicionado ao carrinho!\n=========================\n");
            return 0;
        }
        return 1;
    }
    static int montaHambTrip(ArrayList<Produtos> produtos){
        int opc, opc1;
        Scanner sc = new Scanner(System.in);

        HamburguerTriplo hamburguerTriplo = new HamburguerTriplo();

        System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();

                if (opc < 1 || opc > 3) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 3){
            return 1;
        }
        if (opc == 1) {

            while (true) {
                System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Hamburguer 1\n[2] Pão\n[3] Salada\n[4] Molho\n[5] Ovo\n[6] Queijo\n[7] Carne\n[8] Frango\n[9] Salsicha\n[10] Hamburguer 2\n[11] Hamburguer 3\n[12] Salada 2\n[13] Pronto\n[14] Cancelar pedido\n\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc1 = sc.nextInt();

                        if (opc1 < 1 || opc1 > 14) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc1 == 14){
                    return 1;
                }
                if (opc1 == 13) {
                    break;
                } else {
                    hamburguerTriplo.remove(Ingredientes.values()[opc1 - 1]);
                }
            }
        }
        produtos.add(hamburguerTriplo);
        System.out.print("\n=========================\nHamburguer triplo adicionado ao carrinho!\n=========================\n");
        return 0;
    }

    static int montaCrocSimp(ArrayList<Produtos> produtos){
        int opc, opc1;
        Scanner sc = new Scanner(System.in);

        CrocSimples croc = new CrocSimples();

        //lista ingredientes e chama função pra remover
        System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();

                if (opc < 1 || opc > 3) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 3){
            return 1;
        }
        if (opc == 1) {


            while (true) {
                System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Pão\n[2] Frango Empanado\n[3] Salada\n[4] Maionese\n[5] Queijo\n[6] Pronto\n[7] Cancelar pedido\n\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc1 = sc.nextInt();

                        if (opc1 < 1 || opc1 > 7) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc1 == 7){
                    return 1;
                }
                if (opc1 == 6) {
                    break;
                } else {
                    croc.remove(IngredientesCroc.values()[opc1 - 1]);
                }
            }

        }
        produtos.add(croc);
        return 0;
    }
    static int montaCrocParm(ArrayList<Produtos> produtos){
        int opc, opc1;
        Scanner sc = new Scanner(System.in);

        CrocParmegiana parmegiana = new CrocParmegiana();

        //lista ingredientes e chama função pra remover
        System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();

                if (opc < 1 || opc > 3) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 3){
            return 1;
        }
        if (opc == 1) {


            while (true) {
                System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Pão\n" +
                        "[2] Frango empanado\n[3] Salada\n[4] Maionese\n[5] Queijo\n[6] Molho de tomate\n[7] Tomate (adicional)\n[8] Pronto\n[9] Cancelar pedido\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc1 = sc.nextInt();

                        if (opc1 < 1 || opc1 > 9) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc1 == 9){
                    return 1;
                }
                if (opc1 == 8) {
                    break;
                } else {
                    parmegiana.remove(IngredientesCroc.values()[opc1 - 1]);
                }
            }

        }
        produtos.add(parmegiana);
        return 0;
    }
    static int montaCrocAmer(ArrayList<Produtos> produtos){
        int opc, opc1;
        Scanner sc = new Scanner(System.in);

        CrocAmericano americano = new CrocAmericano();

        //lista ingredientes e chama função pra remover
        System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();

                if (opc < 1 || opc > 3) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 3){
            return 1;
        }
        if (opc == 1) {


            while (true) {
                System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Pão\n[2] Frango Empanado\n" +
                        "[3] Salada\n[4] Maionese\n[5] Queijo\n[6] Salada americana\n[7] Cebola\n[8] Molho defumado\n[9] Pronto\n[10] Cancelar pedido\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc1 = sc.nextInt();

                        if (opc1 < 1 || opc1 > 10) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc1 == 10){
                    return 1;
                }
                if (opc1 == 9) {
                    break;
                } else if (opc1 == 6 || opc1 == 7 || opc1 == 8) {
                    americano.remove(IngredientesCroc.values()[opc1 + 1]);
                } else {
                    americano.remove(IngredientesCroc.values()[opc1 - 1]);
                }
            }

        }
        produtos.add(americano);
        return 0;
    }

    static int montaXsalada(ArrayList<Produtos> produtos){
        int opc, opc1;
        Scanner sc = new Scanner(System.in);

        xSalada Xsalada = new xSalada();

        System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();

                if (opc < 1 || opc > 3) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 3){
            return  1;
        }
        if (opc == 1) {

            while (true) {

                System.out.print("\n=========================\nQual ingrediente deseja remover?\n");
                System.out.print("[1] Pão\n[2] Hamburguer\n[3] Queijo Mussarela\n[4] Tomate\n[5] Alface\n[6] Maionese\n[7] Pronto\n[8] Cancelar pedido\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc1 = sc.nextInt();

                        if (opc1 < 1 || opc1 > 8) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc1 == 8){
                    return 1;
                }
                if (opc1 == 7) {
                    break;
                } else {
                    Xsalada.remove(IngredientesXSalada.values()[opc1 - 1]);
                    System.out.print("Ingrediente removido.\n");
                }
            }
        }

        produtos.add(Xsalada);
        System.out.print("\n=========================\nX-Salada adicionado ao carrinho!\n=========================\n");
        return 0;
    }

    static int montaXegg(ArrayList<Produtos> produtos){
        int opc, opc1;
        Scanner sc = new Scanner(System.in);

        XeggBaconBurguer x_egg = new XeggBaconBurguer();

        //lista ingredientes e chama função pra remover
        System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();

                if (opc < 1 || opc > 3) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 3){
            return 1;
        }
        if (opc == 1) {
            while (true) {
                System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Hamburguer\n" +
                        "[2] Cheddar\n[3] Ovo\n[4] Bacon\n[5] Maionese\n[6] Pão\n[7] Pronto\n[8] Cancelar pedido\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc1 = sc.nextInt();

                        if (opc1 < 1 || opc1 > 8) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc1 == 8){
                    return 1;
                }
                if (opc1 == 7) {
                    break;
                } else {
                    x_egg.remove(IngredientesXBB.values()[opc1 - 1]);
                }
            }

        }
        produtos.add(x_egg);
        return 0;
    }

    static int montaAmerSimp(ArrayList<Produtos> produtos){
        int opc, opc1;
        Scanner sc = new Scanner(System.in);

        BurguerAmericano americanoSimples = new BurguerAmericano();

        System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();
                if (opc < 1 || opc > 3) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 3){
            return 1;
        }
        if (opc == 1) {
            while (true) {
                System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Pão\n[2] Hamburguer\n[3] Salada Americana\n[4] Cebola Picada\n[5] Molho Defumado\n[6] Maionese\n[7] Pronto\n[8] Cancelar pedido\n\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc1 = sc.nextInt();
                        if (opc1 < 1 || opc1 > 8) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc1 == 8){
                    return 1;
                }
                if (opc1 == 7) {
                    break;
                } else {
                    americanoSimples.remove(IngredientesBurguerAmericano.values()[opc1 - 1]);
                    System.out.print("Ingrediente removido.\n");
                }
            }
        }
        produtos.add(americanoSimples);
        System.out.print("\n=========================\nBurguer Americano Simples adicionado ao carrinho!\n=========================\n");
        return 0;
    }
    static int montaAmerDupl(ArrayList<Produtos> produtos){
        int opc, opc1;
        Scanner sc = new Scanner(System.in);

        BurguerAmericanoDuplo americanoDuplo = new BurguerAmericanoDuplo();

        System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();
                if (opc < 1 || opc > 3) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 3){
            return 1;
        }
        if (opc == 1) {
            while (true) {

                System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Pão\n[2] Hamburguer\n" +
                        "[3] Salada Americana\n[4] Cebola Picada\n[5] Molho Defumado\n[6] Maionese\n[7] Hamburguer 2\n[8] Pronto\n[9] Cancelar pedido\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc1 = sc.nextInt();
                        if (opc1 < 1 || opc1 > 9) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc1 == 9){
                    return 1;
                }
                if (opc1 == 8) {
                    break;
                } else {

                    americanoDuplo.remove(IngredientesBurguerAmericano.values()[opc1 - 1]);
                    System.out.print("Ingrediente removido.\n");
                }
            }
        }
        produtos.add(americanoDuplo);
        System.out.print("\n=========================\nBurguer Americano Duplo adicionado ao carrinho!\n=========================\n");
        return 0;
    }
    static int montaAmerTrip(ArrayList<Produtos> produtos){
        int opc, opc1;
        Scanner sc = new Scanner(System.in);

        BurguerAmericanoTriplo americanoTriplo = new BurguerAmericanoTriplo();

        System.out.print("\n=========================\nDeseja remover algum ingrediente?\n[1] Sim\n[2] Não\n[3] Cancelar pedido\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();
                if (opc < 1 || opc > 3) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 3){
            return 1;
        }
        if (opc == 1) {
            while (true) {

                System.out.print("\n=========================\nQual ingrediente deseja remover?\n[1] Pão\n[2] Hamburguer\n" +
                        "[3] Salada Americana\n[4] Cebola Picada\n[5] Molho Defumado\n[6] Maionese\n" +
                        "[7] Hamburguer 2\n[8] Hamburguer 3\n[9] Pronto\n[10] Cancelar pedido\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc1 = sc.nextInt();
                        if (opc1 < 1 || opc1 > 10) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc1 == 10){
                    return 1;
                }
                if (opc1 == 9) {
                    break;
                } else {
                    americanoTriplo.remove(IngredientesBurguerAmericano.values()[opc1 - 1]);
                    System.out.print("Ingrediente removido.\n");
                }
            }
        }
        produtos.add(americanoTriplo);
        System.out.print("\n=========================\nBurguer Americano Triplo adicionado ao carrinho!\n=========================\n");
        return 0;
    }

    static int montaSorvete(ArrayList<Produtos> produtos){
        int opc;
        Scanner sc = new Scanner(System.in);

        System.out.print("\n=========================\n[1] Chocolate\n[2] Creme\n[3] Misto\n[4] Cancelar pedido\n=========================\n");

        // validando
        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();

                if (opc < 1 || opc > 4) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 4){
            return 1;
        }
        Sorvete sorvete = new Sorvete(opc);
        produtos.add(sorvete);
        System.out.print("\n=========================\nSorvete adicionado ao carrinho!\n=========================\n");
        return 0;
    }

    static void montaBatata(ArrayList<Produtos> produtos){
        BatataFrita batata = new BatataFrita();
        produtos.add(batata);
        System.out.print("\n=========================\nBatata Frita adicionada ao carrinho!\n=========================\n");
    }
    static void montaFile(ArrayList<Produtos> produtos){
        FileFrangoEmpanado file = new FileFrangoEmpanado();
        produtos.add(file);
        System.out.print("\n=========================\nFilé de Frango Empanado adicionado ao carrinho!\n=========================\n");
    }

    static int montaRefri(ArrayList<Produtos> produtos, int i){
        Scanner sc = new Scanner(System.in);
        int opc;

        switch (i) {
            case 1://refil
                System.out.print("\n=========================\n[1] Fanta uva\n[2] Fanta Laranja\n[3] Guaraná\n[4] Coca-cola\n[5] Pepsi\n[6] Cancelar pedido\n=========================\n");

                while (true){
                    try {
                        System.out.print("Opção: ");
                        opc = sc.nextInt();

                        if (opc < 1 || opc > 6){
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e){
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc == 6){
                    return 1;
                }
                BebidaRefrigeranteRefil refil = new BebidaRefrigeranteRefil(opc);

                produtos.add(refil);

                System.out.print("\n=========================\nRefrigerante Refil adicionado ao carrinho!\n=========================\n");
                return 0;
            case 2: //refri lata
                System.out.print("\n=========================\n[1] Fanta uva\n[2] Fanta Laranja\n[3] Guaraná\n[4] Coca-cola\n[5] Pepsi\n[6] Cancelar pedido\n=========================\n");

                while (true){
                    try {
                        System.out.print("Opção: ");
                        opc = sc.nextInt();

                        if (opc < 1 || opc > 6){
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e){
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc == 6){
                    return 1;
                }
                BebidaRefrigeranteLata lata = new BebidaRefrigeranteLata(opc);

                produtos.add(lata);

                System.out.print("\n=========================\nRefrigerante lata adicionado ao carrinho!\n=========================\n");
                return 0;
        }
        return 1;
    }

    static int montaSuco(ArrayList<Produtos> produtos){
        Scanner sc = new Scanner(System.in);
        int opc;

        System.out.print("\n=========================\n[1] Suco de laranja natural\n[2] Dell Vale Uva\n[3] Dell Vale Laranja)\n[4] Cancelar pedido\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();

                if (opc < 1 || opc > 4) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 4){
            return 1;
        }

        Suco suco = new Suco(opc);
        produtos.add(suco);
        System.out.print("\n=========================\nSuco adicionado ao carrinho!\n=========================\n");
        return 0;
    }

    static int montaChaGel(ArrayList<Produtos> produtos){
        Scanner sc = new Scanner(System.in);
        int opc;

        System.out.print("\n=========================\n[1] Pessego\n[2] Limão com abacaxi e hortelã\n[3] Maçã\n[4] Maracujá com maçã\n[5] Amora com hortelã\n[6] Cancelar pedido\n\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();

                if (opc < 1 || opc > 5) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }

        ChaGelado cha = new ChaGelado(opc);
        produtos.add(cha);
        System.out.print("\n=========================\nChá Gelado adicionado ao carrinho!\n=========================\n");
        return 0;
    }

    static int montaAgua(ArrayList<Produtos> produtos){
        Scanner sc = new Scanner(System.in);
        int opc;

        System.out.print("\n=========================\n[1] Água mineral\n[2] Água com gás\n[3] Água saborizada (limão)\n[4] Cancelar pedido\n=========================\n");

        while (true) {
            try {
                System.out.print("Opção: ");
                opc = sc.nextInt();

                if (opc < 1 || opc > 4) {
                    System.out.print("Opção inválida\n");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.print("Inserção inválida\n");
                sc.nextLine();
            }
        }
        if(opc == 4){
            return 1;
        }
        Agua agua = new Agua(opc);
        produtos.add(agua);
        System.out.print("\n=========================\nÁgua adicionada ao carrinho!\n=========================\n");
        return 0;
    }

    static int simpDuplTrip(ArrayList<Produtos> produtos, int i){
        int opc;
        Scanner sc = new Scanner(System.in);

        switch (i) {
            case 1://hamburguer simples
                System.out.print("\n=========================\n[1] Frango\n[2] Carne\n[3] Cancelar pedido\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc = sc.nextInt();

                        if (opc < 1 || opc > 3) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc == 3){
                    return 1;
                }
                if (montaHambSimp(produtos, opc) == 1){
                    return 1;
                } else {
                    return 0;
                }
            case 2://hamburguer duplo
                System.out.print("\n=========================\n[1] Frango\n[2] Carne\n[3] Cancelar pedido\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc = sc.nextInt();

                        if (opc < 1 || opc > 3) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc == 3){
                    return 1;
                }
                if(montaHambDupl(produtos, opc) == 1){
                    return 1;
                } else {
                    return 0;
                }
            case 3: //hamburguer Triplo
                if(montaHambTrip(produtos) == 1){
                    return 1;
                } else {
                    return 0;
                }
        }
        return 1;
    }

    static int simpParmAmer(ArrayList<Produtos> produtos, int i){
        switch (i) {
            case 1: //Croc simples
                if(montaCrocSimp(produtos) == 1){
                    return 1;
                } else {
                    System.out.print("\n=========================\nCroc Simples adicionado ao carrinho!\n=========================\n");
                    return 0;
                }
            case 2://Croc parmegiana
                if(montaCrocParm(produtos) == 1){
                    return 1;
                } else {
                    System.out.print("\n=========================\nCroc parmegiana adicionado ao carrinho!\n=========================\n");
                    return 0;
                }
            case 3: //Croc americano
                if(montaCrocAmer(produtos) == 1){
                    return 1;
                } else {
                    System.out.print("\n=========================\nCroc Americano adicionado ao carrinho!\n=========================\n");
                    return 0;
                }
        }
        return 1;
    }

    static int burSimpDuplTrip(ArrayList<Produtos> produtos, int i){
        switch (i) {
            case 1: //burguer americano simples
                if(montaAmerSimp(produtos) == 1){
                    return 1;
                } else {
                    return 0;
                }
            case 2: //burguer americano duplo
                if(montaAmerDupl(produtos) == 1){
                    return 1;
                } else{
                    return 0;
                }
            case 3: //burguer americano triplo
                if(montaAmerTrip(produtos) == 1){
                    return 1;
                } else {
                    return 0;
                }
        }
        return 1;
    }

    static void batataFile(ArrayList<Produtos> produtos, int i){
        switch (i) {
            case 1://batata
                montaBatata(produtos);
                break;
            case 2://filé
                montaFile(produtos);
                break;
        }
    }

    static int bebidaOpc(ArrayList<Produtos> produtos, int i) {
        Scanner sc = new Scanner(System.in);
        int opc;

        switch (i) {
            case 1: //refri
                System.out.print("\n=========================\n[1] Refil\n[2] Lata\n[3] Cancelar pedido\n=========================\n");

                while (true) {
                    try {
                        System.out.print("Opção: ");
                        opc = sc.nextInt();

                        if (opc < 1 || opc > 3) {
                            System.out.print("Opção inválida\n");
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.print("Inserção inválida\n");
                        sc.nextLine();
                    }
                }
                if(opc == 3){
                    return 1;
                }
                if(montaRefri(produtos, opc) == 1){
                    return 1;
                } else {
                    return 0;
                }
            case 2: //sucos
                if(montaSuco(produtos) == 1){
                    return 1;
                } else {
                    return 0;
                }
            case 3://chá gelado
                if(montaChaGel(produtos) == 1){
                    return 1;
                } else {
                    return 0;
                }
            case 4:
                if(montaAgua(produtos) == 1){
                    return 1;
                } else {
                    return 0;
                }
        }
        return 1;
    }
}






