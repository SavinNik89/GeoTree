package relation;

import model.Person;

public class Relation {
    Person definedPerson;
    Person inRelationToPerson;
    RelationType directRelationType;
    RelationType reverseRelationType;


    public Relation(Person definedPerson, Person inRelationToPerson, RelationType directRelationType, RelationType reverseRelationType) {
        this.definedPerson = definedPerson;
        this.inRelationToPerson = inRelationToPerson;
        this.directRelationType = directRelationType;
        this.reverseRelationType = reverseRelationType;
    }

    @Override
    public String toString() {
        return '{' + definedPerson.getFirstName() + ' ' +
                definedPerson.getSecondName() + ' ' +
                directRelationType + " of " +
                inRelationToPerson.getFirstName() + ' ' +
                inRelationToPerson.getSecondName() + '}' + "and" +
                '{' + inRelationToPerson.getFirstName() + ' ' +
                inRelationToPerson.getSecondName() + ' ' +
                reverseRelationType + " of " +
                definedPerson.getFirstName() + ' ' +
                definedPerson.getSecondName() + '}' + '\n';
    }
}
