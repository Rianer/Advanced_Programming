package com.jdbc.dao;

import com.jdbc.models.Capital;

public interface CapitalDAO {
    public int addCapital(Capital capital);

    public Capital getCapital(String capitalName);

    public Capital getCapital(int id);
}
