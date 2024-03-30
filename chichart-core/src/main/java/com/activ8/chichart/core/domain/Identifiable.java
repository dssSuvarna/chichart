package com.activ8.chichart.core.domain;

import java.io.*;

public interface Identifiable<T extends Serializable> {
    T getId();
}
