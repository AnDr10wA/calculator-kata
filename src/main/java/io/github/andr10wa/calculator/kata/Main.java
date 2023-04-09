package io.github.andr10wa.calculator.kata;

import java.io.IOException;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        calc(input);


    }
    public static String calc(String input) {
        String[] line_input = input.split(" ");


        if (line_input.length == 3){
            if (Number.isArabic(line_input[0]) && Number.isArabic(line_input[2])){

                System.out.println(operand(line_input));

            }
            else if(Number.isRim(line_input[0]) && Number.isRim(line_input[2])){
                String get_a;
                String get_b;
                get_a = Number.valueOf(line_input[0]).getArabic();
                get_b = Number.valueOf(line_input[2]).getArabic();
                String[] arabic_line = {get_a, line_input[1], get_b};
                int result_arabic = operand(arabic_line);
                if (result_arabic<0){
                    try{

                        throw new NullPointerException();
                                            }
                    catch (NullPointerException e){
                        System.out.println("Результат работы с римскими цифрами не может быть отрицательным");
                    }
                }
                else {
                    System.out.println(Convert_to_rim(result_arabic));
                }


            }
            else try{
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Введены неверные данные");
                }
        }
        else
            try{
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Введены неверные данные");
            }




        return "I'm Calculator";
    };



    static int operand(String[] operator){
        int a = Integer.parseInt(operator[0]);
        int b = Integer.parseInt(operator[2]);
        int res = 0;
        if (a >= 0 && a<= 10 && b >= 0 && b <= 10) {

            switch (operator[1]) {
                case "+":
                    res = a + b;
                    break;

                case "-":
                    res = a - b;
                    break;
                case "*":
                    res = a * b;
                    break;

                case "/":
                    res = a / b;
                    break;

                default:
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Введен неверный оператор");
                    }


            }
        }
        else
            try{
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Числа больше 10 или меньше 0");
            }

        return res;
    }
    static String Convert_to_rim(int num ){
        String res;
        String str_num = Integer.toString(num);

        if (num  == 10){
            res = "X";
            return res;
        }
        if (num == 100){
            res = "C";
            return res;
        }
        if(num < 10){

            res = Number.findByName(str_num).toString();
            return res;

        }
        if (num>10){

            int dec = num/10%10;
                if(num%10 == 0){
                    res = Rim_number.findByName(str_num).toString();
                    return res;
                }
                else{
                    int dec_full = dec*10;
                    String str_dec = Integer.toString(dec_full);
                    String rim_dec = Rim_number.findByName(str_dec).toString();
                    int ost_dec = num%10;
                    String str_ost_des = Integer.toString(ost_dec);
                    String rim_ost_des =  Number.findByName(str_ost_des).toString();
                    return rim_dec+rim_ost_des;

                }

        }



    return "Диапазон не найден";
    }

}
