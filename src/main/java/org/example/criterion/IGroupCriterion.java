package org.example.criterion;

import org.example.entity.Person;

public interface IGroupCriterion<T> {
    T getGroup(Person person);
}
