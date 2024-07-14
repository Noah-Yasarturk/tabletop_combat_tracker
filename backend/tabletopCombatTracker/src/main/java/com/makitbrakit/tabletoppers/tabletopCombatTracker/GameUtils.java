package com.makitbrakit.tabletoppers.tabletopCombatTracker;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameUtils {

    public static Set<String> creatureTypes = new HashSet<String>(){{
        add("Aberration");
        add("Beast");
        add("Celestial");
        add("Construct");
        add("Dragon");
        add("Elemental");
        add("Fey");
        add("Fiend");
        add("Giant");
        add("Humanoid");
        add("Monstrosity");
        add("Ooze");
        add("Plant");
        add("Undead");
    }};

    public static Map<Integer, Integer> abilityToModifierMap = Stream.of(new Integer[][] {
        {1, -5},
        {2, -4},
        {3, -4},
        {4, -3},
        {5, -3},
        {6, -2},
        {7, -2},
        {8, -1},
        {9, -1},
        {10, 0},
        {11, 0},
        {12, 1},
        {13, 1},
        {14, 2},
        {15, 2},
        {16, 3},
        {17, 3},
        {18, 4},
        {19, 4},
        {20, 5},
        {21, 5},
        {22, 6},
        {23, 6},
        {24, 7},
        {25, 7},
        {26, 8},
        {27, 8},
        {28, 9},
        {29, 9},
        {30, 10} 
    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
    
}
