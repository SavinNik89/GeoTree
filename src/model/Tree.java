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
        Person human1 = new Person("Ivan", "Ivanov", 30, GenderType.MALE);
        Person human2 = new Person("Vasiliy", "Ivanov", 50, GenderType.MALE);
        Person human3 = new Person("Natasha", "Ivanova", 50, GenderType.FEMALE);
        Person human4 = new Person("Ylia", "Ivanova", 25, GenderType.FEMALE);
        Person human5 = new Person("Petr", "Ivanov", 15, GenderType.MALE);
        Person human6 = new Person("Mihail", "Ivanov", 10, GenderType.MALE);



        Relation relation1 = new Relation(human2, human1, RelationType.FATHER, RelationType.SUN);
        Relation relation2 = new Relation(human1, human2, RelationType.SUN, RelationType.FATHER);
        Relation relation3 = new Relation(human3, human1, RelationType.MOTHER, RelationType.SUN);
        Relation relation4 = new Relation(human1, human3, RelationType.SUN, RelationType.MOTHER);
        Relation relation5 = new Relation(human3, human4, RelationType.MOTHER, RelationType.DAUGHTER);
        Relation relation6 = new Relation(human4, human3, RelationType.DAUGHTER, RelationType.MOTHER);
        Relation relation7 = new Relation(human2, human4, RelationType.FATHER, RelationType.DAUGHTER);
        Relation relation8 = new Relation(human4, human2, RelationType.DAUGHTER, RelationType.FATHER);
        Relation relation9 = new Relation(human2, human5, RelationType.FATHER, RelationType.SUN);
        Relation relation10 = new Relation(human5, human2, RelationType.SUN, RelationType.FATHER);
        Relation relation11 = new Relation(human3, human5, RelationType.MOTHER, RelationType.SUN);
        Relation relation12 = new Relation(human5, human3, RelationType.SUN, RelationType.MOTHER);
        Relation relation13 = new Relation(human6, human1, RelationType.SUN, RelationType.FATHER);

        Research listRelations = new Research();
        listRelations.allRelation.addAll(List.of(relation1, relation2, relation3,relation4,
                relation5, relation6, relation7, relation8, relation9, relation10,relation11,
                relation12, relation13));

        /*
         *Для поиска в метод printNearRelatives необходимо передать firstName и secondNаme человека
         * родственников которого необходимо найти. На данный момент метод может искать всех детей,
         * родителей, братьев и сестер, дедушек и бабушек.
         * Тип искомых родственников задается четвертым аргументом FindTypeRelation
         */

        printNearRelatives(listRelations, "Ivan", "Ivanov", FindTypeRelation.BROTHERSANDSISTERS);

    }






}
