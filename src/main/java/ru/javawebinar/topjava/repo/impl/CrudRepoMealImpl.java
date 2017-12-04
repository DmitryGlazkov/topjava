package ru.javawebinar.topjava.repo.impl;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repo.CrudRepoMeal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CrudRepoMealImpl implements CrudRepoMeal {
    private ConcurrentMap<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        repository.put(counter.decrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        repository.put(counter.decrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        repository.put(counter.decrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        repository.put(counter.decrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        repository.put(counter.decrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        repository.put(counter.decrementAndGet(), new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
    }

    public ConcurrentMap<Integer, Meal> getRepository() {
        return repository;
    }

    @Override
    public Meal create(Meal meal) {
        if (meal.getId() == null)
            meal.setId(counter.decrementAndGet());

        repository.put(meal.getId(), meal);
        return meal;
    }

    @Override
    public Meal read(Integer id) {
        return repository.get(id);
    }

    @Override
    public Meal update(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {
        repository.remove(id);
    }

    @Override
    public Collection<Meal> getAll() {
        return repository.values();
    }
}
