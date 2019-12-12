

package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Persons persons;

    public static void main(final String[] args) throws IOException,ClassNotFoundException {
        persons = new Persons(5);

        persons.add(new Person("Иванов Иван Иванович", "г.Одесса, ул.филатова 5", 5000, 12,1));
        persons.add(new Person("Валенский Перт Максимович", "г.Одесса, вул.Говорова 2", 6000, 6,2));
        persons.add(new Person("Арешкин Денис Игоревич", "г.Одесса, вул.Говорова 11А", 6000, 6,3));
        persons.add(new Person("Пупкин Василий Дмитреевич", "г.Одесса, вул.Черняховского 7Б", 15000, 16,4));
        persons.add(new Person("Зиеров Александр Романович", "г.Одесса, вул.Дерибасовская 34", 6000, 6,5));

        SAVEPersons savePersons = new SAVEPersons();
        savePersons.start();
        Menu();
    }

    public static void BackUp(){
        BackUp backUp = new BackUp("Persons.bcp",persons);
        backUp.start();
    }

    public static void Menu() throws IOException, ClassNotFoundException {
        int menuNumber;
        Scanner scanner = new Scanner(System.in);
        Serialization serialization = new Serialization("D://Persons.txt");
        while (true) {
            System.out.println("Выберите требуемый пункт: " +
                    "\n1) Выдача сведений о каждом из вкладчиков по фамилии: " +
                    "\n2) Выдача сведений о вкладчиках, вклад которых превышает заданную сумму: " +
                    "\n3) Выдача сведений о вкладчиках, у которых срок договора свыше 12 месяцев: " +
                    "\n4) Удаление записей о вкладчиках с заданной фамилией: " +
                    "\n5) Просмотр полного списка: " +
                    "\n6) Запись" +
                    "\n7) Считать" +
                    "\n8) Удаление списка " +
                    "\n9) Выход" +
                    "\n Введите нужный пункт и нажмите Enter:");
            boolean isCorrectly = false;
            String tempMenuNumber="";
            while (!isCorrectly) {
                tempMenuNumber = scanner.next();
                scanner.nextLine();
                if(tempMenuNumber.matches("[1-8,0]{1}")){
                    isCorrectly=true;
                }
                else {
                    System.out.println("Введите корректное значение: ");
                }
            }
            menuNumber = Integer.parseInt(tempMenuNumber);
            switch (menuNumber){
                case 1: {
                    isCorrectly = false;
                    while (!isCorrectly){
                        System.out.println("Введите фамилию клиента: ");
                        String Surname = scanner.next();
                        if (Surname.matches("[А-Я][а-я]{4,}")){
                            System.out.println(persons.getDataByFullName(Surname));
                            isCorrectly=true;
                        }
                        else {
                            System.out.println("Фамилия введена не правильно!");
                        }
                    }
                }break;

                case 2: {
                    isCorrectly= false; {
                        String price;
                        System.out.println("Введите сумму вклада: ");
                        price = scanner.next();
                        if (price.matches("[0-100000]")){
                            System.out.println(persons.getDataByPrice(price));
                            isCorrectly = true;
                        }
                        else {
                            System.out.println("Превышение заданной суммы, введите другое значение!");
                        }
                    }
                }
                case 3:{
                    int mounth;
                    System.out.println("Введите число из условия: ");
                    mounth = Integer.parseInt(scanner.next());
                    System.out.println(persons.getDataByMounth(mounth));
                }break;

                case 4:{
                    isCorrectly = false;
                    while (!isCorrectly){
                        System.out.println("Введите фамилию клиента: ");
                        String Surname = scanner.next();
                        if (Surname.matches("[А-Я][а-я]{4,}")){
                            System.out.println(persons.remove(Surname));
                            isCorrectly=true;
                        }
                        else {
                            System.out.println("Фамилия введена не правильно!");
                        }
                    }
                }break;

                case 5:
                {System.out.println(persons.print());}break;

                case 6:{
                    System.out.println(serialization.Serialization(persons));
                }break;
                case 7:{
                    System.out.println(serialization.Deserialization(persons));
                } break;
                case 8: { persons.list.clear();}
                case 9: System.exit(0);break;
                default:System.out.println("Введите номер из списка!"); menuNumber=0;

            }
        }
    }
}