import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import MapaPDS2.att;

import java.util.Date;
public class MapaPDS2 {
    public static void main(String[] args) throws ParseException, InterruptedException {
        boolean loop = false;
        Scanner s = new Scanner(System.in);
        ArrayList<att> vacinados = new ArrayList();
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("Quem está vacinando?: ");
        String enferm = s.nextLine();
        System.out.print("Qual seu CPF?: ");
        String cpf = s.nextLine();
        SimpleDateFormat formatodata = new SimpleDateFormat("dd/MM/yyyy");
        while(loop == false){
                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("[Enfermeiro(a) atual: " + enferm + "]");
                System.out.println("\n=====MENU PRINCIPAL=====");
                System.out.println("[1] - Vacinar Cidadão");
                System.out.println("[2] - Listar Cidadões vacinado");
                System.out.println("[3] - Sair");
                System.out.print("Por favor, escolha uma opção acima: "); 
                int e1 = s.nextInt();
                    switch(e1){
                        case 1:
                            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                            System.out.print("====Vacinando Cidadão====\n");
                            System.out.print("Insira o CPF: ");
                            String cpfc = s.next();
                            System.out.print("Insira o Nome: ");
                            String nomec = s.next();
      
                                System.out.print("Data da D1 - (> dd/mm/aaaa <): ");
                                    Date d1cf = formatodata.parse(s.next());
                                    String d1c = formatodata.format(d1cf);
                                
                                System.out.print("Data da D2 - (> dd/mm/aaaa <): ");
                                    Date d2cf = formatodata.parse(s.next());
                                    String d2c = formatodata.format(d2cf);

                                    System.out.print("Data da D3 - (> dd/mm/aaaa <): ");
                                    Date d3cf = formatodata.parse(s.next());
                                    String d3c = formatodata.format(d3cf);

                                    System.out.print("Data da D4 - (> dd/mm/aaaa <): ");
                                    Date d4cf = formatodata.parse(s.next());
                                    String d4c = formatodata.format(d4cf);

                                    MapaPDS2 myObject = new MapaPDS2();
                                    long meses1 = myObject.calendario(d1cf,d2cf);

                                    MapaPDS2 myObject2 = new MapaPDS2();
                                    long meses2 = myObject2.calendario(d2cf,d3cf);

                                    MapaPDS2 myObject3 = new MapaPDS2();
                                    long meses3 = myObject3.calendario(d3cf,d4cf);

                                    if(meses1 < 4){
                                        System.out.println("\nInfelizmente você não pode tomar outra dose.");
                                        System.out.println("Seu tempo entre a primeira e segunda dose é infeiror a 4 meses.");
                                        System.out.print("\nVoltando ao menu principal em 3 segundos...");
                                        Thread.sleep(3000);
                                        break;
                                    }else if (meses2 < 4){
                                        System.out.println("\nInfelizmente você não pode tomar outra dose.");
                                        System.out.println("Seu tempo entre a segunda e terceira dose é infeiror a 4 meses.");
                                        System.out.print("\nVoltando ao menu principal em 3 segundos...");
                                        Thread.sleep(3000);
                                        break;
                                    }else if (meses3 < 4){
                                        System.out.println("\nInfelizmente você não pode tomar outra dose.");
                                        System.out.println("Seu tempo entre a terceira e quarta dose é infeiror a 4 meses.");
                                        System.out.print("\nVoltando ao menu principal em 3 segundos...");
                                        Thread.sleep(3000);
                                        break;
                                    }
                                

                            att u = new att();
                            u.atribuirt1(cpfc);
                            u.atribuirt2(nomec);
                            u.atribuirt3(d1c);
                            u.atribuirt4(d2c);
                            u.atribuirt5(d3c);
                            u.atribuirt6(d4c);
                            vacinados.add(u);

                            System.out.println("Parabéns, o cidadão foi vacinado!");
                            System.out.print("Retornando ao menu principal...");
                                Thread.sleep(2000);
                            break;
                        case 2:
                        System.out.print("Lista de Vacinados:\n");
                        for (int i = 0; i < vacinados.size(); i++) {

                            att uTemp = vacinados.get(i);
                            System.out.print("==============================\n");
                            System.out.println("\tCPF: " + vacinados.get(i).pegarcpfc());
                            System.out.println("\tNome: " + vacinados.get(i).pegarnomec());
                            System.out.println("\tD1: " + vacinados.get(i).pegard1c());
                            System.out.println("\tD2: " + vacinados.get(i).pegard2c());
                            System.out.println("\tD3: " + vacinados.get(i).pegard3c());
                            System.out.println("\tD4: " + vacinados.get(i).pegard4c());
                            System.out.println("==============================\n");                            
                        }
                        System.out.print("Voltando ao menu principal em 3 segundos...");
                            Thread.sleep(3000);
                            break;
                        case 3:
                            System.out.print("...Saindo do sistema...\n");
                            loop = true;
                            System.exit(0);
                        default:
                            System.out.print("Por favor, escolha uma opção válida.");
                            break;
                    }
                    
                }
            
        }        

        public long calendario(Date one, Date two) {
            long diferente = (one.getTime()-two.getTime())/2628000000L;
            return Math.abs(diferente);
        }
    } 
    

