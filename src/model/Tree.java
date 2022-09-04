package model;

import relation.FindTypeRelation;
import relation.Relation;
import relation.RelationType;
import relation.Research;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static relation.Research.printNearRelatives;


public class Tree {


    public static void main(String[] args) {

        Person human1 = new Person("Vasiliy", "Ivanov", 50, GenderType.MALE);
        Person human2 = new Person("Natasha", "Ivanova", 50, GenderType.FEMALE);
        Person human3 = new Person("Ivan", "Ivanov", 30, GenderType.MALE);
        Person human4 = new Person("Ylia", "Ivanova", 25, GenderType.FEMALE);
        Person human5 = new Person("Petr", "Ivanov", 15, GenderType.MALE);
        Person human6 = new Person("Dima", "Petrov", 30, GenderType.MALE);
        Person human7 = new Person("Lena", "Petrova", 25, GenderType.FEMALE);
        Person human8 = new Person("Mihail", "Petrov", 10, GenderType.MALE);
        Person human9 = new Person("Taniya", "Petrova", 10, GenderType.FEMALE);


//family #1
        Relation relation1 = new Relation(human1, human3, RelationType.FATHER, RelationType.SON);
        Relation relation2 = new Relation(human2, human3, RelationType.MOTHER, RelationType.SON);
        Relation relation5 = new Relation(human1, human7, RelationType.FATHER, RelationType.DAUGHTER);
        Relation relation6 = new Relation(human2, human7, RelationType.MOTHER, RelationType.DAUGHTER);
        Relation relation11 = new Relation(human3, human1, RelationType.SON, RelationType.FATHER);
        Relation relation12 = new Relation(human3, human2, RelationType.SON, RelationType.MOTHER);
        Relation relation15 = new Relation(human7, human1, RelationType.DAUGHTER, RelationType.FATHER);
        Relation relation16 = new Relation(human7, human2, RelationType.DAUGHTER, RelationType.MOTHER);
//family #2
        Relation relation3 = new Relation(human3, human5, RelationType.FATHER, RelationType.SON);
        Relation relation4 = new Relation(human4, human5, RelationType.MOTHER, RelationType.SON);
        Relation relation13 = new Relation(human5, human3, RelationType.SON, RelationType.FATHER);
        Relation relation14 = new Relation(human5, human4, RelationType.SON, RelationType.MOTHER);
//family #3
        Relation relation7 = new Relation(human6, human8, RelationType.FATHER, RelationType.SON);
        Relation relation8 = new Relation(human7, human8, RelationType.MOTHER, RelationType.SON);
        Relation relation9 = new Relation(human6, human9, RelationType.FATHER, RelationType.DAUGHTER);
        Relation relation10 = new Relation(human7, human9, RelationType.MOTHER, RelationType.DAUGHTER);
        Relation relation17 = new Relation(human8, human6, RelationType.SON, RelationType.FATHER);
        Relation relation18 = new Relation(human8, human7, RelationType.SON, RelationType.MOTHER);
        Relation relation19 = new Relation(human9, human6, RelationType.DAUGHTER, RelationType.FATHER);
        Relation relation20 = new Relation(human9, human7, RelationType.DAUGHTER, RelationType.MOTHER);



        Research listRelations = new Research();
        listRelations.allRelation.addAll(List.of(relation1, relation2, relation3,relation4,
                relation5, relation6, relation7, relation8, relation9, relation10, relation11,
                relation12, relation13, relation14, relation15, relation16,relation17, relation18,
                relation19, relation20));

        /*
         *Для поиска в метод printNearRelatives необходимо передать firstName и secondNаme человека
         * родственников которого необходимо найти. На данный момент метод может искать всех детей,
         * родителей, братьев и сестер, дедушек и бабушек.
         * Тип искомых родственников задается четвертым аргументом FindTypeRelation
         */

        printNearRelatives(listRelations, "Petr", "Ivanov", FindTypeRelation.COUSINS);

    }






}
