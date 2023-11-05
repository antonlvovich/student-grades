package org.example.criterion;

import org.example.entity.Person;

@FunctionalInterface
public interface IGroupCriterion<T> {
    T getGroup(Person person);
}
