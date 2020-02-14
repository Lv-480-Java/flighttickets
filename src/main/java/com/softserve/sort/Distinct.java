package com.softserve.sort;

import com.softserve.entity.Route;

import java.util.List;
import java.util.TreeSet;

public interface Distinct {
    TreeSet<String> uniqueCity(List<Route> routeList);
}
