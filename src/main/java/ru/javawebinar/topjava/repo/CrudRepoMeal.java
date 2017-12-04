package ru.javawebinar.topjava.repo;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface CrudRepoMeal {
    Meal create(Meal meal);

    Meal read(Integer id);

    Meal update(Integer id);

    void delete(Integer id);

    Collection<Meal> getAll();
}
