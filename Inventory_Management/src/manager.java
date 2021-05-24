import java.awt.*;
import java.io.*;
import java.util.*;

public class manager {

    static Scanner sc = new Scanner(System.in);
    static BufferedReader br;
    static BufferedWriter bw;

    private static void searchProduct() throws IOException {

        System.out.println();
        System.out.println("-------< Select table >-------");
        System.out.println("1. product");
        System.out.println("2. sample");
        System.out.println("------------------------------");

        System.out.print("Which table would you like to see? : ");
        int table = sc.nextInt();
        sc.nextLine();
        System.out.println();

        //파일내용 출력
        if (table == 1) {
            System.out.println("< product table >");
            br = new BufferedReader(new FileReader("C:\\Users\\icsy9\\IdeaProjects\\management_system\\product.txt"));
            String line = null;
            while ((line = br.readLine()) != null)
                System.out.println(line);
        } else {
            System.out.println("< sample table >");
            br = new BufferedReader(new FileReader("C:\\Users\\icsy9\\IdeaProjects\\management_system\\sample.txt"));
            String line = null;
            while ((line = br.readLine()) != null)
                System.out.println(line);
        }

    }

    private static void modifyProduct() throws IOException {
        System.out.println();
        System.out.println("-------< Select table >-------");
        System.out.println("1. product");
        System.out.println("2. sample");
        System.out.println("------------------------------");

        System.out.print("Which table would you like to modify? : ");
        int modify_table = sc.nextInt();
        sc.nextLine();
        System.out.println();

        if (modify_table == 1)
            Desktop.getDesktop().edit(new File("C:\\Users\\icsy9\\IdeaProjects\\management_system\\product.txt"));
        else
            Desktop.getDesktop().edit(new File("C:\\Users\\icsy9\\IdeaProjects\\management_system\\sample.txt"));

    }

    private static void productOrder() throws IOException {
        //파일에 입력
        System.out.print("Enter your order form name : ");
        //주문서 이름 입력받기 Ex)order_1이라는 주문서 이름
        String txt_name = sc.nextLine();

        //order_1이라는 text파일이 생성
        //텍스트 파일이 생기는 경로
        bw = new BufferedWriter(new FileWriter("C:\\Users\\icsy9\\IdeaProjects\\management_system\\" + txt_name + ".txt"));

        System.out.println("Please write down what you want to order.");
        System.out.println("Ex) Product name / number of product / brand name ");
        //입력받은 내용이 텍스트 파일에 저장됨
        String item = sc.nextLine();
        bw.write(item);
        bw.newLine();

        bw.close();
        System.out.println("Your order has been received.");
    }

    private static void productCancel() throws IOException {

        System.out.print("Enter your order form name : ");
        //주문 취소할 파일 이름 입력받기
        String delete_filename = sc.nextLine();
        File deleteFile = new File("C:\\Users\\icsy9\\IdeaProjects\\management_system\\" + delete_filename + ".txt");

        //파일이 존재한다면
        if (deleteFile.exists()) {
        //주문서 삭제
            deleteFile.delete();
        }
        //파일이 존재하지 않는다면 에러메세지 출력
        else
            System.out.println("Order does not exist.");

        System.out.println("Your order has been canceled.");
    }

    public static void main(String[] args) throws IOException {

        System.out.println("This is inventory management system.");
        System.out.print("Please enter you name : ");
        String name = sc.nextLine();

        System.out.println();
        System.out.println("HI, " + name);
        System.out.println("Please look at the menu below and enter the number of the menu you want.");

        //메뉴 선택
        System.out.println();
        System.out.println("==================== Menu ====================");
        System.out.println("1. Add Item");
        System.out.println("2. Modify Item's quantity");
        System.out.println("3. Product order ");
        System.out.println("4. Product cancellation");
        System.out.println("5. Quit");
        System.out.println("===============================================");

        //원하는 메뉴 입력 받기
        System.out.print("Enter the number : ");
        int menuSelect = sc.nextInt();
        sc.nextLine();

        while (menuSelect != 5) {
            //1번 선택시 searchProduct 실행
            if (menuSelect == 1) {
                searchProduct();
                System.out.println();
            }
            //2번 선택시 modifyProduct 실행
            else if (menuSelect == 2) {
                modifyProduct();
                //메세지 출력
                System.out.println("The contents of the text file have been modified.");
                System.out.println();
            }
            //3번 선택시 productOrder 실행
            else if (menuSelect == 3) {
                productOrder();
                System.out.println();
            } else if (menuSelect == 4) {
                productCancel();
                System.out.println();
            } else if (menuSelect == 5)
                break;

            System.out.println("==================== Menu ====================");
            System.out.println("1. Add Item");
            System.out.println("2. Modify Item's quantity");
            System.out.println("3. Product order ");
            System.out.println("4. Product cancellation");
            System.out.println("5. Quit");
            System.out.println("===============================================");
            System.out.println();
            System.out.print("Enter the number : ");
            menuSelect = sc.nextInt();
            sc.nextLine();
        }
        sc.close();
    }

}