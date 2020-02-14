package com.softserve.sort;

import com.softserve.entity.Route;

import java.util.List;
import java.util.TreeSet;

public class SortCity implements Distinct {
    @Override
    public TreeSet<String> uniqueCity(List<Route> routeList) {
        TreeSet<String> cityTreeSet = new TreeSet<>();
        for (Route route : routeList) {
            cityTreeSet.add(route.getFrom_Location());
            cityTreeSet.add(route.getTo_Location());
        }
        return cityTreeSet;
    }
}
