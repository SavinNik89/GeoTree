package relation;

import model.GenderType;
import model.Person;

import java.util.*;

public class Research {
    public List<Relation> allRelation = new ArrayList<>();


    /** Возвращает коллекцию, содержащую данные об искомых родственниках, где ключ - это данные о человеке,
     * а значение - тип родственной связи
     */
    private HashMap<Person, RelationType> findNearRelatives (String firstName, String secondName, FindTypeRelation findTypeRelation) {
        HashMap<Person, RelationType> result = new HashMap<>();
        for (Relation relation : allRelation) {
            if (relation.definedPerson.getFirstName().equals(firstName) &&
                    relation.definedPerson.getSecondName().equals(secondName)) {
                if (findTypeRelation == FindTypeRelation.CHILDREN) {
                    if (relation.directRelationType == RelationType.FATHER || relation.directRelationType == RelationType.MOTHER) {
                        result.put(relation.inRelationToPerson, relation.reverseRelationType);
                    }
                }
                if (findTypeRelation == FindTypeRelation.PARENTS) {
                    if (relation.directRelationType == RelationType.SON || relation.directRelationType == RelationType.DAUGHTER) {
                        result.put(relation.inRelationToPerson, relation.reverseRelationType);
                    }
                }
                if (findTypeRelation == FindTypeRelation.BROTHERSANDSISTERS) {
                    if (relation.directRelationType == RelationType.SON || relation.directRelationType == RelationType.DAUGHTER) {
                        HashMap <Person, RelationType> temp = findNearRelatives(relation.inRelationToPerson.getFirstName(),
                                relation.inRelationToPerson.getSecondName(), FindTypeRelation.CHILDREN);
                        for (HashMap.Entry<Person, RelationType> recordTemp : temp.entrySet()) {
                            if (recordTemp.getKey().getFirstName() == firstName &&
                                    recordTemp.getKey().getSecondName() == secondName) {
                                continue;
                            } else {
                                if (recordTemp.getKey().getGender() == GenderType.MALE) {
                                    result.put(recordTemp.getKey(), RelationType.BROTHER);
                                } else {
                                    result.put(recordTemp.getKey(), RelationType.SISTER);
                                }
                            }
                        }
                    }
                }

                if (findTypeRelation == FindTypeRelation.GRANDPARENTS) {
                    if (relation.directRelationType == RelationType.SON || relation.directRelationType == RelationType.DAUGHTER) {
                        HashMap <Person, RelationType> temp = findNearRelatives(relation.inRelationToPerson.getFirstName(),
                                relation.inRelationToPerson.getSecondName(), FindTypeRelation.PARENTS);
                        for (HashMap.Entry<Person, RelationType> recordTemp : temp.entrySet()) {
                                if (recordTemp.getKey().getGender() == GenderType.MALE) {
                                    result.put(recordTemp.getKey(), RelationType.GRANDFATHER);
                                } else {
                                    result.put(recordTemp.getKey(), RelationType.GRANDMOTHER);
                                }
                        }
                    }
                }

                if (findTypeRelation == FindTypeRelation.COUSINS) {
                    if (relation.directRelationType == RelationType.SON || relation.directRelationType == RelationType.DAUGHTER) {
                        HashMap <Person, RelationType> temp1 = findNearRelatives(relation.inRelationToPerson.getFirstName(),
                                relation.inRelationToPerson.getSecondName(), FindTypeRelation.BROTHERSANDSISTERS);
                        HashMap <Person, RelationType> temp2 = new HashMap<>();
                        for (HashMap.Entry<Person, RelationType> recordTemp1 : temp1.entrySet()) {
                            HashMap <Person, RelationType> temp3 = findNearRelatives(recordTemp1.getKey().getFirstName(),
                                    recordTemp1.getKey().getSecondName(), FindTypeRelation.CHILDREN);
                            temp2.putAll(temp3);
                        }
                        for (HashMap.Entry<Person, RelationType> recordTemp2 : temp2.entrySet()) {
                            result.put(recordTemp2.getKey(), RelationType.COUSIN);
                        }
                    }
                }
            }
        }
        return result;
    }

    /** Выводит в консоль список искомых родственников
     */
    public static void printNearRelatives (Research relatives, String firstName, String secondName, FindTypeRelation findTypeRelation) {
        int i = 1;
        HashMap<Person, RelationType> relativesMap = relatives.findNearRelatives(firstName, secondName, findTypeRelation);
        System.out.println("List of " + findTypeRelation + " for " + firstName + ' ' + secondName + ':');
        for (HashMap.Entry<Person, RelationType> relation : relativesMap.entrySet()) {
            System.out.printf("%d. %s - %s;\n", i, relation.getKey(), relation.getValue());
            i++;
        }
    }



}
