package com.reversecoder.canze.interfaces;

import java.util.HashMap;

import com.reversecoder.canze.actors.Field;

/**
 * Created by robertfisch on 15.11.2015.
 */
public interface VirtualFieldAction {
    double updateValue(HashMap<String,Field> dependantFields);
}
